import { useQuery } from '@tanstack/react-query';
import { useState } from 'react';
import { TbChevronDown, TbX } from 'react-icons/tb';

import { getGuild } from '@/api/guild';
import { GuildResultData } from '@/types/guilds';

import * as S from './styles';

interface GuildCategoriesProps {
  guildId: string;
}

const GuildCategories = ({ guildId }: GuildCategoriesProps) => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  const { data } = useQuery<GuildResultData>({ queryKey: ['server-info'], queryFn: () => getGuild(guildId) });

  const toggleDown = () => {
    setIsDropdownOpen((prev) => !prev);
  };

  return (
    <S.GuildCategories>
      <S.GuildTitle>
        <S.GuildName>{data?.guild.name}</S.GuildName>
        {isDropdownOpen ? <TbX size={24} onClick={toggleDown} /> : <TbChevronDown size={24} onClick={toggleDown} />}
      </S.GuildTitle>

      {isDropdownOpen && (
        <S.DropDown>
          <S.DropDownItem>
            <S.DropDownItemText>서버 설정</S.DropDownItemText>
          </S.DropDownItem>
          <S.DropDownItem>
            <S.DropDownItemText>초대하기</S.DropDownItemText>
          </S.DropDownItem>
          <S.DropDownItem>
            <S.DropDownItemText>서버 나가기</S.DropDownItemText>
          </S.DropDownItem>
        </S.DropDown>
      )}
    </S.GuildCategories>
  );
};

export default GuildCategories;
