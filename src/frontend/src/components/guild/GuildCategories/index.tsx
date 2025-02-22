import { useQuery } from '@tanstack/react-query';
import { TbChevronDown } from 'react-icons/tb';

import { getGuild } from '@/api/guild';
import { GuildResultData } from '@/types/guilds';

import * as S from './styles';

interface GuildCategoriesProps {
  guildId: string;
}

const GuildCategories = ({ guildId }: GuildCategoriesProps) => {
  const { data } = useQuery<GuildResultData>({ queryKey: ['server-info'], queryFn: () => getGuild(guildId) });

  return (
    <S.GuildCategories>
      <S.GuildTitle>
        <S.GuildName>{data?.guild.name}</S.GuildName>
        <TbChevronDown size={24} />
      </S.GuildTitle>
    </S.GuildCategories>
  );
};

export default GuildCategories;
