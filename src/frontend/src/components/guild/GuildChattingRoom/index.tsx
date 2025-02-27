import { BiHash } from 'react-icons/bi';
import { BsFillMicFill, BsFillPeopleFill } from 'react-icons/bs';
import { FaInbox } from 'react-icons/fa';

import MessageSection from '@/pages/FriendsPage/components/ChattingSection/components/MessageSection';
import { useChannelInfoStore } from '@/stores/channelInfo';

import * as S from './styles';

const GuildChattingRoom = () => {
  const { selectedChannel } = useChannelInfoStore();
  if (!selectedChannel) return null;

  const renderChannelIcon = () => {
    if (selectedChannel.type === 'TEXT') return <BiHash size={28} />;
    if (selectedChannel.type === 'VOICE') return <BsFillMicFill size={28} />;
  };

  return (
    <>
      <S.ChattingHeader>
        <S.ChannelInfo>
          <S.ChannelIcon>{renderChannelIcon()}</S.ChannelIcon>
          <S.ChannelTitle>{selectedChannel.name}</S.ChannelTitle>
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
      <MessageSection channelId={selectedChannel.id} />
    </>
  );
};

export default GuildChattingRoom;
