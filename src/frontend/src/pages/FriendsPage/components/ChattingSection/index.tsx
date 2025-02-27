import DirectMessageChattingRoom from '@/components/friend/DirectMessageChattingRoom';
import FriendsManagement from '@/components/friend/FriendsManagement';
import GuildChattingRoom from '@/components/guild/GuildChattingRoom';
import { useChannelInfoStore } from '@/stores/channelInfo';
import { useGuildInfoStore } from '@/stores/guildInfo';

import * as S from './styles';

const ChattingSection = () => {
  const { guildId } = useGuildInfoStore();
  const { selectedDMChannel } = useChannelInfoStore();

  const isGuildChattingDisplayed = !!guildId;
  const isFriendChattingDisplayed = !!(!guildId && selectedDMChannel);

  const component = {
    guildChat: <GuildChattingRoom />,
    directChat: <DirectMessageChattingRoom />,
    friendsManagement: <FriendsManagement />,
  };

  const currentView: keyof typeof component = isGuildChattingDisplayed
    ? 'guildChat'
    : isFriendChattingDisplayed
      ? 'directChat'
      : 'friendsManagement';

  return <S.ChattingSectionContainer>{component[currentView]}</S.ChattingSectionContainer>;
};

export default ChattingSection;
