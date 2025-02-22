import { useQuery } from '@tanstack/react-query';
import { TbChevronDown, TbX } from 'react-icons/tb';

import { getGuild } from '@/api/guild';
import useDropdown from '@/hooks/useDropdown';
import { useGuildInfoStore } from '@/stores/guildInfo';
import { GuildResultData } from '@/types/guilds';

import * as S from './styles';

interface DropdownItem {
  id: string;
  text: string;
  onClick?: () => void;
}

const GuildCategories = () => {
  const { isOpened, dropdownRef, toggleDropdown } = useDropdown();
  const { guildId } = useGuildInfoStore();
  const { data } = useQuery<GuildResultData>({ queryKey: ['serverInfo', guildId], queryFn: () => getGuild(guildId) });

  const dropdownItems: DropdownItem[] = [
    {
      id: 'settings',
      text: '서버 설정',
      onClick: () => console.log('서버 설정 모달 열기'),
    },
    {
      id: 'invite',
      text: '초대하기',
      onClick: () => console.log('초대하기 모달 열기'),
    },
    {
      id: 'createCategory',
      text: '카테고리 생성',
      onClick: () => console.log('카테고리 생성 모달 열기'),
    },
    {
      id: 'createChannel',
      text: '채널 생성',
      onClick: () => console.log('채널 생성 모달 열기'),
    },
    {
      id: 'leave',
      text: '서버 나가기',
      onClick: () => console.log('서버 나가기 모달 열기'),
    },
  ];

  return (
    <S.GuildCategories>
      {guildId && (
        <>
          <S.GuildTitle>
            <S.GuildName>{data?.guild.name}</S.GuildName>
            {isOpened ? (
              <TbX size={24} onClick={toggleDropdown} />
            ) : (
              <TbChevronDown size={24} onClick={toggleDropdown} />
            )}
          </S.GuildTitle>
          {isOpened && (
            <S.DropDown ref={dropdownRef}>
              {dropdownItems.map((item) => (
                <S.DropDownItem key={item.id} onClick={item.onClick}>
                  <S.DropDownItemText>{item.text}</S.DropDownItemText>
                </S.DropDownItem>
              ))}
            </S.DropDown>
          )}
        </>
      )}
    </S.GuildCategories>
  );
};

export default GuildCategories;
