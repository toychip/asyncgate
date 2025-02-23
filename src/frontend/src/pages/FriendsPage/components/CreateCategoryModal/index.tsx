import { useState } from 'react';
import { BiSolidLock } from 'react-icons/bi';

import Modal from '@/components/common/Modal';
import Toggle from '@/components/common/Toggle';
import { BodyMediumText, ChipText, TitleText2 } from '@/styles/Typography';

import * as S from './styles';

const CreateCategoryModal = () => {
  const [isPublicCategory, setIsPublicCategory] = useState(false);
  const [categoryName, setCategoryName] = useState('');

  const handleCategoryNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const newName = event.target.value;

    if (newName.length !== 0) setCategoryName(newName);
  };

  return (
    <Modal name="withFooter">
      <Modal.Header>
        <TitleText2>카테고리 만들기</TitleText2>
      </Modal.Header>
      <Modal.Content>
        <ChipText>카테고리 이름</ChipText>
        <S.CategoryNameInput
          onChange={handleCategoryNameChange}
          value={categoryName}
          placeholder="서버이름을 입력해주세요"
        />
        <S.PrivateSetting>
          <S.SettingText>
            <BiSolidLock size={24} />
            <BodyMediumText>비공개 카테고리</BodyMediumText>
          </S.SettingText>
          <Toggle isOn={isPublicCategory} onToggle={() => setIsPublicCategory(!isPublicCategory)} />
        </S.PrivateSetting>
        <S.CategoryInfoText>
          카테고리를 비공개로 만들면 선택한 멤버들과 역할만 이 카테고리를 볼 수 있어요. 이 설정은 이 카테고리에 동기화된
          채널들에도 자동으로 적용돼요.
        </S.CategoryInfoText>
      </Modal.Content>
      <S.FooterContainer>
        <S.CancelButton>취소</S.CancelButton>
        <S.CreateButton>카테고리 만들기</S.CreateButton>
      </S.FooterContainer>
    </Modal>
  );
};

export default CreateCategoryModal;
