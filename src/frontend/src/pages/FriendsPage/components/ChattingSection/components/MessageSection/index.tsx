import { BsFillPlusCircleFill } from 'react-icons/bs';
import { MdEmojiEmotions } from 'react-icons/md';

import useMessageSection from './hooks/useMessageSection';
import * as S from './styles';

const MessageSection = () => {
  const { chatInput, textareaRef, handleTextareaChange, handleKeyDown } = useMessageSection();

  return (
    <S.MessageSection>
      <S.MessageContainer></S.MessageContainer>
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
