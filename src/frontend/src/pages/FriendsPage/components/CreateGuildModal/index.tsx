import { TbChevronRight } from 'react-icons/tb';

import Modal from '../../../../components/common/Modal';
import { CaptionText, SmallButtonText } from '../../../../styles/Typography';

import * as S from './styles';

interface CreateGuildModalProps {
  onNext: () => void;
}

const CreateGuildModal = ({ onNext }: CreateGuildModalProps) => {
  return (
    <S.CreateGuildModal>
      <Modal name="basic">
        <Modal.Header>
          <S.HeaderText>이 서버에 대해 더 자세히 말해주세요</S.HeaderText>
        </Modal.Header>
        <Modal.Content>
          <CaptionText>
            설정을 돕고자 질문을 드려요. 혹시 서버가 친구 몇 명만을 위한 서버인가요, 아니면 더 큰 커뮤니티를 위한
            서버인가요?
          </CaptionText>
        </Modal.Content>
        <S.CreateButtons onClick={onNext}>
          <S.CreatePrivateGuild>
            <SmallButtonText>나와 친구들을 위한 서버</SmallButtonText>
            <TbChevronRight size={24} />
          </S.CreatePrivateGuild>
          <S.CreatePublicGuild>
            <SmallButtonText>커뮤니티용 서버</SmallButtonText>
            <TbChevronRight size={24} />
          </S.CreatePublicGuild>
        </S.CreateButtons>
      </Modal>
    </S.CreateGuildModal>
  );
};

export default CreateGuildModal;
