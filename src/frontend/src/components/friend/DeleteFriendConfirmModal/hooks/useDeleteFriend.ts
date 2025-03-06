import { useMutation, useQueryClient } from '@tanstack/react-query';

import { deleteFriend } from '@/api/friends';

const useDeleteFriend = () => {
  const queryClient = useQueryClient();

  const deleteFriendMutation = useMutation({
    mutationFn: (friendId: string) => deleteFriend({ friendId }),
    mutationKey: ['deleteFriend'],
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['friendsList'] });
    },
    onError: (error) => {
      console.error('친구 삭제 실패', error);
    },
  });

  const deleteFriendMutate = (friendId: string) => {
    deleteFriendMutation.mutate(friendId);
  };

  return { deleteFriend: deleteFriendMutate, isPending: deleteFriendMutation.isPending };
};

export default useDeleteFriend;
