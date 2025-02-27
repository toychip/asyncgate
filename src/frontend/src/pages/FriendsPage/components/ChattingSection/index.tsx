import DirectMessageChattingRoom from '@/components/friend/DirectMessageChattingRoom';
import FriendsManagement from '@/components/friend/FriendsManagement';
import GuildChattingRoom from '@/components/guild/GuildChattingRoom';
import { useChannelInfoStore } from '@/stores/channelInfo';
import { useGuildInfoStore } from '@/stores/guildInfo';

import * as S from './styles';

type ChattingSectionView = 'guildChat' | 'directChat' | 'friendsManagement';

const ChattingSection = () => {
  const { guildId } = useGuildInfoStore();
  const { selectedDMChannel } = useChannelInfoStore();

  const component = {
    guildChat: <GuildChattingRoom />,
    directChat: <DirectMessageChattingRoom />,
    friendsManagement: <FriendsManagement />,
  };

  const getCurrentView = (): ChattingSectionView => {
    if (guildId) return 'guildChat';
    if (selectedDMChannel) return 'directChat';
    return 'friendsManagement';
  };

  return <S.ChattingSectionContainer>{component[getCurrentView()]}</S.ChattingSectionContainer>;
};

export default ChattingSection;
