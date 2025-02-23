import { BiHash } from 'react-icons/bi';
import { BsFillMicFill, BsFillPeopleFill } from 'react-icons/bs';
import { FaInbox } from 'react-icons/fa';

import MessageSection from './components/MessageSection';
import * as S from './styles';
// PR 머지 시 types/guilds의 타입으로 수정
type ChannelType = 'TEXT' | 'VOICE' | null;

interface ChannelInfo {
  type: ChannelType;
  title: string;
}

interface ChattingSectionProps {
  currentChannel: ChannelInfo;
}

const ChattingSection = ({ currentChannel }: ChattingSectionProps) => {
  const renderChannelIcon = () => {
    if (currentChannel.type === 'TEXT') return <BiHash size={28} />;
    if (currentChannel.type === 'VOICE') return <BsFillMicFill size={28} />;
  };

  return (
    <S.ChattingSectionContainer>
      <S.ChattingHeader>
        <S.ChannelInfo>
          <S.ChannelIcon>{renderChannelIcon()}</S.ChannelIcon>
          <S.ChannelTitle>{currentChannel.title}</S.ChannelTitle>
        </S.ChannelInfo>
        <S.ToolBar>
          <S.IconWrapper>
            <BsFillPeopleFill size={24} />
          </S.IconWrapper>
          <S.IconWrapper>
            <FaInbox size={24} />
          </S.IconWrapper>
        </S.ToolBar>
      </S.ChattingHeader>
      <MessageSection />
    </S.ChattingSectionContainer>
  );
};

export default ChattingSection;
