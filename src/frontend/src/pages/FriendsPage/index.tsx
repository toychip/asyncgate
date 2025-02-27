import CategorySection from '@/pages/FriendsPage/components/CategorySection';

import GuildList from '../../components/guild/GuildList';

import ChattingSection from './components/ChattingSection';
import * as S from './styles';

const FriendsPage = () => {
  return (
    <S.FriendsPage>
      <S.ContentContainer>
        <GuildList />
        <CategorySection />
        <ChattingSection />
      </S.ContentContainer>
    </S.FriendsPage>
  );
};

export default FriendsPage;
