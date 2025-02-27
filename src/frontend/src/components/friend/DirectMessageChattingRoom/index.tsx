import { BiHash } from 'react-icons/bi';
import { FaInbox } from 'react-icons/fa';

import MessageSection from '@/pages/FriendsPage/components/ChattingSection/components/MessageSection';
import { useChannelInfoStore } from '@/stores/channelInfo';

import * as S from './styles';

// 디스코드에서는 채널 타입 아이콘 대신 상대방 프로필 사진이 뜸
// 우선은 프로필 사진 자리에 아이콘 배치
const DirectMessageChattingRoom = () => {
  const { selectedDMChannel } = useChannelInfoStore();
  if (!selectedDMChannel) return null;

  return (
    <>
      <S.ChattingHeader>
        <S.ChannelInfo>
          <S.ChannelImage>
            <BiHash size={28} />
          </S.ChannelImage>
          <S.ChannelTitle>{selectedDMChannel.name}</S.ChannelTitle>
        </S.ChannelInfo>
        <S.ToolBar>
          <S.IconWrapper>
            <FaInbox size={24} />
          </S.IconWrapper>
        </S.ToolBar>
      </S.ChattingHeader>
      <MessageSection channelId={selectedDMChannel.id} />
    </>
  );
};

export default DirectMessageChattingRoom;
