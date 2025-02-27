import { useState } from 'react';
import { FaInbox } from 'react-icons/fa';
import { MdPerson } from 'react-icons/md';

import AddFriendForm from '../AddFriendForm';
import FriendsList from '../FriendsList';
import PendingFriendsList from '../PendingFriendsList';

import * as S from './styles';

type NavBarMenu = 'all' | 'pending' | 'addFriend';

const FriendsManagement = () => {
  const [selectedMenu, setSelectedMenu] = useState<NavBarMenu>('all');

  const handleMenuClick = (value: NavBarMenu) => {
    setSelectedMenu(value);
  };

  return (
    <>
      <S.SectionHeader>
        <S.SectionInfo>
          <S.SectionIcon>
            <MdPerson size={28} />
          </S.SectionIcon>
          <S.SectionTitle>친구</S.SectionTitle>
          <S.Divider>|</S.Divider>
          <S.FriendNavBarWrapper>
            <S.MenuContainer>
              <S.MenuItem $isSelectedMenu={selectedMenu === 'all'} onClick={() => handleMenuClick('all')}>
                모두
              </S.MenuItem>
              <S.MenuItem $isSelectedMenu={selectedMenu === 'pending'} onClick={() => handleMenuClick('pending')}>
                대기 중
              </S.MenuItem>
              <S.MenuItem $isSelectedMenu={selectedMenu === 'addFriend'} onClick={() => handleMenuClick('addFriend')}>
                친구 추가하기
              </S.MenuItem>
            </S.MenuContainer>
          </S.FriendNavBarWrapper>
        </S.SectionInfo>
        <S.ToolBar>
          <S.IconWrapper>
            <FaInbox size={24} />
          </S.IconWrapper>
        </S.ToolBar>
      </S.SectionHeader>
      <S.SectionContentsWrapper>
        {selectedMenu === 'all' && <FriendsList />}
        {selectedMenu === 'pending' && <PendingFriendsList />}
        {selectedMenu === 'addFriend' && <AddFriendForm />}
      </S.SectionContentsWrapper>
    </>
  );
};

export default FriendsManagement;
