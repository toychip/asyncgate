import { useRef, useState } from 'react';
import { BsFillPlusCircleFill } from 'react-icons/bs';
import { IoClose } from 'react-icons/io5';
import { MdEmojiEmotions } from 'react-icons/md';

import ChatTextarea from '../ChatTextarea';
import MessageItem from '../MessageItem';

import useChat from './hooks/useChat';
import useChatTextarea from './hooks/useChatTextarea';
import * as S from './styles';

interface MessageSectionProps {
  channelId: string;
}

const MessageSection = ({ channelId }: MessageSectionProps) => {
  const { messages, sendMessage } = useChat({ channelId });

  // TODO: 이전 채팅 기록 불러오는 로직 추가 예정
  const { chatInput, textareaRef, handleTextareaChange, handleKeyDown } = useChatTextarea({
    sendMessage,
  });
  const [selectedFile, setSelectedFile] = useState<File | null>(null);

  const fileInputRef = useRef<HTMLInputElement>(null);

  const handleFileAttachButtonClick = () => {
    fileInputRef.current?.click();
  };

  const handleFileChange = async (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;

    console.log('선택한 파일:', file);
    setSelectedFile(file);

    // 파일 업로드 로직
  };

  const handleFileRemove = () => {
    setSelectedFile(null);
    if (fileInputRef.current) {
      fileInputRef.current.value = '';
    }
  };

  return (
    <S.MessageSection>
      <S.MessageContainer>
        <S.MessageItemList>
          {messages.map((message, index) => (
            <MessageItem
              key={`${index}_${message.content}`}
              sentUserProfileUrl={message.profileImage}
              sentUserName={message.name}
              sentDateTime={'날짜 시간'}
              messageContent={message.content}
              isModified={false}
            />
          ))}
        </S.MessageItemList>
      </S.MessageContainer>
      <S.BottomBarWrapper>
        {selectedFile && (
          <S.FilePreview>
            <S.FileName>{selectedFile.name}</S.FileName>
            <S.FileRemoveButton onClick={handleFileRemove}>
              <IoClose size={20} />
            </S.FileRemoveButton>
          </S.FilePreview>
        )}
        <S.BottomBarContainer>
          <S.AttachButton onClick={handleFileAttachButtonClick}>
            <BsFillPlusCircleFill size={22} />
          </S.AttachButton>
          <S.FileAttachInput ref={fileInputRef} type="file" id="fileAttach" onChange={handleFileChange} />
          <ChatTextarea
            ref={textareaRef}
            value={chatInput}
            placeholder="메시지 보내기"
            handleChange={(e) => handleTextareaChange(e.target.value)}
            handleKeyDown={handleKeyDown}
          />
          <S.ToolBarContainer>
            <S.IconWrapper>
              <MdEmojiEmotions size={24} />
            </S.IconWrapper>
          </S.ToolBarContainer>
        </S.BottomBarContainer>
      </S.BottomBarWrapper>
    </S.MessageSection>
  );
};

export default MessageSection;
