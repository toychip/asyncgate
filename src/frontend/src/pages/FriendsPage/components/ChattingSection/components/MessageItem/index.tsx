import { useEffect, useState } from 'react';
import { FiEdit2, FiTrash2 } from 'react-icons/fi';

import ChatTextarea from '../ChatTextarea';
import useChatTextarea from '../MessageSection/hooks/useChatTextarea';

import * as S from './styles';

// 실제 디스코드에서 시각적으로 보여지는 데이터
// 이후 변경될 수 있음
export interface MessageItemProps {
  sentUserProfileUrl: string;
  sentUserName: string;
  sentDateTime: string;
  messageContent: string;
  isModified: boolean;
}

const MessageItem = ({
  sentUserProfileUrl,
  sentUserName,
  sentDateTime,
  messageContent,
  isModified,
}: MessageItemProps) => {
  const [isHovered, setIsHovered] = useState(false);
  const [isEditing, setIsEditing] = useState(false);

  const handleEditSubmit = () => {
    setIsEditing(false);
    console.log('수정한 메시지:', chatInput);
  };

  const handleCancelEdit = () => {
    setIsEditing(false);
  };

  const handleEditButtonClick = () => {
    setIsEditing(true);
  };

  const { chatInput, textareaRef, handleTextareaChange, handleKeyDown } = useChatTextarea({
    initialValue: messageContent,
    cancelEdit: handleCancelEdit,
    sendMessage: handleEditSubmit,
  });

  useEffect(() => {
    if (isEditing) {
      setTimeout(() => textareaRef.current?.focus(), 0);
    }
  }, [isEditing]);

  return (
    <S.MessageItem onMouseEnter={() => setIsHovered(true)} onMouseLeave={() => setIsHovered(false)}>
      {isHovered && (
        <S.MessageToolbar>
          <S.IconButton onClick={handleEditButtonClick}>
            <FiEdit2 size={16} />
          </S.IconButton>
          <S.IconButton onClick={() => console.log('삭제하기')}>
            <FiTrash2 size={16} />
          </S.IconButton>
        </S.MessageToolbar>
      )}

      <S.MessageContentContainer>
        <S.SentUserProfileImage src={sentUserProfileUrl} alt="" />
        <S.MessageTitle>
          <S.SentUserName>{sentUserName}</S.SentUserName>
          <S.SentDateTime>{sentDateTime}</S.SentDateTime>
        </S.MessageTitle>
        {isEditing ? (
          <S.EditTextareaWrapper>
            <ChatTextarea
              ref={textareaRef}
              value={chatInput}
              handleChange={(e) => handleTextareaChange(e.target.value)}
              handleKeyDown={handleKeyDown}
            />
          </S.EditTextareaWrapper>
        ) : (
          <S.MessageContent>
            {messageContent}
            {isModified && <S.ModifiedMark>(수정됨)</S.ModifiedMark>}
          </S.MessageContent>
        )}
      </S.MessageContentContainer>
    </S.MessageItem>
  );
};

export default MessageItem;
