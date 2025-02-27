import { Friend } from '../FriendsList';

import * as S from './styles';

const friends: Friend[] = [
  {
    name: '친구1',
    profileImageUrl: '',
    isOnline: true,
  },
  {
    name: '친구2',
    profileImageUrl: '',
    isOnline: true,
  },
];

const PendingFriendsList = () => {
  // TODO: 받은 친구 및 보낸 친구 요청 리스트 보여주기
  // TODO: 받은 친구 요청인 경우 수락 및 거절 로직 구현
  // TODO: 보낸 친구 요청인 경우 요청 취소 로직 구현
  // 현재는 받은 친구 요청 UI만 구현

  const handleAcceptButtonClick = () => {
    console.log('친구 요청 수락');
  };

  const handleRejectButtonClick = () => {
    console.log('친구 요청 거절');
  };

  return (
    <S.FriendsList>
      <S.FriendCount>대기 중인 친구 - {friends.length}명</S.FriendCount>
      {friends.map((friend, index) => (
        <S.FriendItem key={`${friend.name}_${index}`}>
          <S.FriendInfoContainer>
            <S.FriendProfileImage $imageUrl={friend.profileImageUrl}>
              <S.FriendStatusMark $isOnline={friend.isOnline} />
            </S.FriendProfileImage>
            <S.FriendName>{friend.name}</S.FriendName>
          </S.FriendInfoContainer>
          <S.ButtonContainer>
            <S.AcceptButton onClick={handleAcceptButtonClick}>수락하기</S.AcceptButton>
            <S.RejectButton onClick={handleRejectButtonClick}>거절하기</S.RejectButton>
          </S.ButtonContainer>
        </S.FriendItem>
      ))}
    </S.FriendsList>
  );
};

export default PendingFriendsList;
