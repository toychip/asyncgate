import Modal from '@/components/common/Modal';
import useModalStore from '@/stores/modalStore';

import useDeleteFriend from './hooks/useDeleteFriend';
import * as S from './styles';

interface DeleteFriendConfirmModalProps {
  friendId: string;
  friendNickname: string;
}

const DeleteFriendConfirmModal = ({ friendId, friendNickname }: DeleteFriendConfirmModalProps) => {
  const { closeAllModal } = useModalStore();
  const { deleteFriend, isPending } = useDeleteFriend();

  return (
    <Modal name="withFooter">
      <Modal.Content>
        <S.ConfirmText>
          정말 <strong>{friendNickname}</strong> 님을 친구에서 삭제하시겠어요?
        </S.ConfirmText>
      </Modal.Content>
      <S.ModalButtonContainer>
        <S.CancelButton onClick={closeAllModal}>취소</S.CancelButton>
        <S.DeleteButton disabled={isPending} $isPending={isPending} onClick={() => deleteFriend(friendId)}>
          친구 삭제하기
        </S.DeleteButton>
      </S.ModalButtonContainer>
    </Modal>
  );
};

export default DeleteFriendConfirmModal;
