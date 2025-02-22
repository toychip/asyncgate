import GuildCategories from '@/components/guild/GuildCategories';
import { useGuildInfoStore } from '@/stores/guildInfo';

import GuildList from '../../components/guild/GuildList';

import * as S from './styles';

const FriendsPage = () => {
  const { guildId } = useGuildInfoStore();

  return (
    <S.FriendsPage>
      <S.ContentContainer>
        <GuildList />
        {guildId && <GuildCategories guildId={guildId} />}
      </S.ContentContainer>
    </S.FriendsPage>
  );
};

export default FriendsPage;
