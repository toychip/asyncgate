import { useState } from 'react';

import * as S from './styles';

export type ResultMessageType = 'success' | 'fail';

interface ResultMessage {
  type: ResultMessageType;
  content: string;
}

const AddFriendForm = () => {
  // TODO: 친구 검색 및 요청 보내기 로직 연동
  // TODO: 요청 보내기 결과에 따라 resultMessage를 설정하고 표시
  const [inputData, setInputData] = useState('');
  const [resultMessage, setResultMessage] = useState<ResultMessage | null>(null);

  const handleInputChange = (value: string) => {
    setInputData(value);
  };

  const handleSendRequestButtonClick = () => {
    console.log('친구 요청');
  };

  return (
    <S.AddFriendFormContainer>
      <S.FormTitle>친구 추가하기</S.FormTitle>
      <S.FormSubtitle>AsyncGate 이메일을 사용하여 친구를 추가할 수 있어요</S.FormSubtitle>
      <S.FriendSearchInputWrapper>
        <S.FriendSearchInput
          onChange={(e) => handleInputChange(e.target.value)}
          placeholder="AsyncGate 이메일을 사용하여 친구를 추가할 수 있어요."
        />
        <S.SendRequestButton $isDisabled={!inputData.trim()} onClick={handleSendRequestButtonClick}>
          친구 요청 보내기
        </S.SendRequestButton>
      </S.FriendSearchInputWrapper>
      {resultMessage && <S.ResultMessage $type={resultMessage.type}>{resultMessage.content}</S.ResultMessage>}
    </S.AddFriendFormContainer>
  );
};

export default AddFriendForm;
