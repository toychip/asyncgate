import { Client, Frame } from '@stomp/stompjs';
import { useEffect, useRef, useState } from 'react';

import { ChatMessage } from './useChat';

interface UseStompClientProps {
  channelId: string;
}

const useStompClient = ({ channelId }: UseStompClientProps) => {
  const [isConnected, setIsConnected] = useState(false);
  const clientRef = useRef<Client | null>(null);

  const VITE_CHATTING_WS_URL = import.meta.env.VITE_CHATTING_WS_URL;
  const VITE_TOKEN = import.meta.env.VITE_TOKEN;

  useEffect(() => {
    const client = new Client({
      webSocketFactory: () => new WebSocket(VITE_CHATTING_WS_URL, ['v10.stomp', VITE_TOKEN]),
      connectHeaders: { Authorization: `Bearer ${VITE_TOKEN}` },
      debug: (msg) => console.log('STOMP DEBUG:', msg),
      reconnectDelay: 5000,
      heartbeatIncoming: 10000,
      heartbeatOutgoing: 10000,

      onConnect: (frame: Frame) => {
        console.log('✅ STOMP 연결 성공!', frame);

        // 연결 성공 시 subscribe
        client.subscribe(`/topic/direct-message/${channelId}`, (message) => {
          const parsedMessage: ChatMessage = JSON.parse(message.body);
          // setMessages((prev) => [...prev, parsedMessage]);
          console.log('📩 받은 메시지:', parsedMessage);
        });

        setIsConnected(true);
      },

      onWebSocketError: (error: Error) => {
        console.log('WebSocket 에러', error);
      },

      onStompError: (frame) => {
        console.error('❌ STOMP 오류 발생!', frame);
      },
    });

    client.activate();
    clientRef.current = client;

    return () => {
      if (client.connected) {
        console.log('🚪 WebSocket 연결 해제 요청');

        // 토큰을 담아 명시적으로 diconnect 요청
        client.publish({
          destination: '/disconnect',
          body: JSON.stringify({ message: 'DISCONNECT 요청' }),
          headers: { Authorization: `Bearer ${VITE_TOKEN}` },
        });

        console.log('📤 DISCONNECT 프레임 전송 완료!');
      }

      client.deactivate();
      clientRef.current = null;
      setIsConnected(false);
      console.log('✅ WebSocket 연결 해제됨');
    };
  }, []);

  return { client: clientRef.current, isConnected };
};

export default useStompClient;
