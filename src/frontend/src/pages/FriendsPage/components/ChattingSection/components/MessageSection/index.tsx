import { useEffect, useState } from 'react';
import { BsFillPlusCircleFill } from 'react-icons/bs';
import { MdEmojiEmotions } from 'react-icons/md';

import parseMessageDateTime from '@/utils/parseMessageDateTime';

import MessageItem, { MessageItemProps } from '../MessageItem';

import useMessageSection from './hooks/useMessageSection';
import * as S from './styles';

const date = new Date();

const MOCKDATA: MessageItemProps[] = [
  {
    sentUserProfileUrl: '',
    sentUserName: 'Fe',
    sentDateTime: parseMessageDateTime(date),
    messageContent: 'text message',
    isModified: false,
  },
];

const MessageSection = () => {
  const [messageList, setMessageList] = useState<MessageItemProps[]>(MOCKDATA);
  const { chatInput, textareaRef, handleTextareaChange, handleKeyDown } = useMessageSection();

  useEffect(() => {}, []);

  return (
    <S.MessageSection>
      <S.MessageContainer>
        <S.MessageItemList>
          {messageList.map((message) => (
            <MessageItem
              key={`${message.sentUserName}_${message.sentDateTime}`}
              sentUserProfileUrl={message.sentUserProfileUrl}
              sentUserName={message.sentUserName}
              sentDateTime={message.sentDateTime}
              messageContent={message.messageContent}
              isModified={message.isModified}
            />
          ))}
        </S.MessageItemList>
      </S.MessageContainer>
      <S.BottomBarWrapper>
        <S.BottomBarContainer>
          <S.AttachButton>
            <BsFillPlusCircleFill size={22} />
          </S.AttachButton>
          <S.ChatTextarea
            ref={textareaRef}
            autoFocus={true}
            value={chatInput}
            placeholder="메시지 보내기"
            onChange={(e) => handleTextareaChange(e.target.value)}
            onKeyDown={handleKeyDown}
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
