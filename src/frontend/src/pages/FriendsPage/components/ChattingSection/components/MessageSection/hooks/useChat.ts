import { useEffect, useState } from 'react';

import useStompClient from './useStompClient';

export interface ChatMessage {
  channelId: string;
  profileImage: string;
  name: string;
  content: string;
}

interface UseChatProps {
  channelId: string;
}

const useChat = ({ channelId }: UseChatProps) => {
  const { client, isConnected } = useStompClient({ channelId });
  const [messages, setMessages] = useState<ChatMessage[]>([]);

  const VITE_TOKEN = import.meta.env.VITE_TOKEN;

  useEffect(() => {
    if (!client || !isConnected) return;

    console.log(`✅ 채팅 구독 시작: /topic/direct-message/${channelId}`);

    // 채널 구독
    const subscription = client.subscribe(`/topic/direct-message/${channelId}`, (message) => {
      const parsedMessage: ChatMessage = JSON.parse(message.body);
      setMessages((prev) => [...prev, parsedMessage]);
      console.log('📩 받은 메시지:', parsedMessage);
    });

    return () => {
      if (client.connected) {
        console.log('연결 해제 요청');
        // 토큰을 담아 명시적으로 diconnect 요청
        client.publish({
          destination: '/disconnect',
          body: JSON.stringify({ message: 'DISCONNECT 요청' }),
          headers: { Authorization: `Bearer ${VITE_TOKEN}` },
        });

        console.log('📤 DISCONNECT 프레임 전송 완료!');
      }

      subscription.unsubscribe();
      console.log(`🚪 채팅 구독 해제: /topic/direct-message/${channelId}`);
    };
  }, [client, isConnected, channelId]);

  // 메시지 전송
  const sendMessage = (content: string) => {
    if (!client?.connected) {
      console.error('❌ STOMP 연결이 끊어져서 메시지를 전송할 수 없습니다.');
      return;
    }

    const message: ChatMessage = {
      channelId,
      profileImage: 'https://asyncgate5.s3.ap-northeast-2.amazonaws.com/user/default_profile.png',
      name: '철민',
      content,
    };

    client.publish({
      destination: '/kafka/chat/direct/send-message',
      body: JSON.stringify(message),
      headers: { Authorization: `Bearer ${VITE_TOKEN}` },
    });

    console.log(`📤 메시지 전송 완료: ${content}`);
  };

  return { messages, sendMessage };
};

export default useChat;
