import * as S from './styles';

// TODO: API 문서에 맞게 수정 및 types 폴더로 이동
export interface Friend {
  name: string;
  profileImageUrl: string;
  isOnline: boolean;
}

// TODO: useQuery로 친구 리스트 요청
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
  {
    name: '친구3',
    profileImageUrl: '',
    isOnline: false,
  },
];

const FriendsList = () => {
  return (
    <S.FriendsList>
      {friends.map((friend, index) => (
        <S.FriendItem key={`${friend.name}_${index}`}>
          <S.FriendProfileImage $imageUrl={friend.profileImageUrl}>
            <S.FriendStatusMark $isOnline={friend.isOnline} />
          </S.FriendProfileImage>
          <S.FriendName>{friend.name}</S.FriendName>
        </S.FriendItem>
      ))}
    </S.FriendsList>
  );
};

export default FriendsList;
