import useGuildCustomizeStep from './useGuildCustomizeStep';
import useGuildVisibilityStep from './useGuildVisibilityStep';

// 길드 생성 스텝들에서 사용되는 상태 중앙 관리화를 위한 훅입니다
const useCreateGuildData = () => {
  const guildVisibilityProps = useGuildVisibilityStep();
  const guildCustomProps = useGuildCustomizeStep();

  const customPropsWithVisibility = {
    ...guildCustomProps,
    guildVisibility: guildVisibilityProps.guildVisibility,
  };

  return {
    guildVisibilityProps,
    guildCustomProps: customPropsWithVisibility,
  };
};

export default useCreateGuildData;
