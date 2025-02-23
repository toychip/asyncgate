import GuildCategories from '@/components/guild/GuildCategory';

import GuildList from '../../components/guild/GuildList';

import ChattingSection from './components/ChattingSection';
import * as S from './styles';

const FriendsPage = () => {
  return (
    <S.FriendsPage>
      <S.ContentContainer>
        <GuildList />
        <GuildCategories />
        <ChattingSection currentChannel={{ type: 'TEXT', title: '테스트 채널' }} />
      </S.ContentContainer>
    </S.FriendsPage>
  );
};

export default FriendsPage;
