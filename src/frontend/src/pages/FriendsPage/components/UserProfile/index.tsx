import { IoMicSharp, IoMicOffSharp } from 'react-icons/io5';
import { MdHeadset, MdHeadsetOff } from 'react-icons/md';
import { RiSettings5Fill } from 'react-icons/ri';

import useDropdown from '@/hooks/useDropdown';

import UserProfileTab from '../UserProfileTab';

import * as S from './styles';

interface UserProfileProps {
  userImageUrl: string;
  userName: string;
  isOnline: boolean;
  isMicOn: boolean;
  isHeadsetOn: boolean;
  handleMicToggle: () => void;
  handleHeadsetToggle: () => void;
}

// TODO: props로 받고 있는 정보들을 전역 상태 및 사용자 정보 요청으로 대체
const UserProfile = ({
  userImageUrl,
  userName,
  isOnline,
  isMicOn,
  isHeadsetOn,
  handleMicToggle,
  handleHeadsetToggle,
}: UserProfileProps) => {
  const { isOpened, dropdownRef, toggleDropdown } = useDropdown();

  return (
    <S.UserProfileContainer ref={dropdownRef}>
      <S.UserInfoContainer onClick={toggleDropdown}>
        <S.UserImage $userImageUrl={userImageUrl}>
          <S.UserStatusMark $isOnline={isOnline} />
        </S.UserImage>
        <S.UserInfo>
          <S.UserName>{userName}</S.UserName>
          <S.UserStatus>{isOnline ? '온라인' : '오프라인'}</S.UserStatus>
        </S.UserInfo>
      </S.UserInfoContainer>
      <S.ControlButtonContainer>
        <S.ControlButton onClick={handleMicToggle}>
          {isMicOn ? <IoMicSharp color="lightgray" size={20} /> : <IoMicOffSharp color="red" size={20} />}
        </S.ControlButton>
        <S.ControlButton onClick={handleHeadsetToggle}>
          {isHeadsetOn ? <MdHeadset color="lightgray" size={20} /> : <MdHeadsetOff color="red" size={20} />}
        </S.ControlButton>
        <S.ControlButton>
          <RiSettings5Fill color="lightgray" size={20} />
        </S.ControlButton>
      </S.ControlButtonContainer>
      {isOpened && <UserProfileTab />}
    </S.UserProfileContainer>
  );
};

export default UserProfile;
