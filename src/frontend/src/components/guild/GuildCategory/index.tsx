import { useGuildInfoStore } from '@/stores/guildInfo';

import GuildItem from '../GuildItem';

import * as S from './styles';

const GuildCategories = () => {
  const { guildId } = useGuildInfoStore();
  return <S.GuildCategories>{guildId && <GuildItem />}</S.GuildCategories>;
};

export default GuildCategories;
