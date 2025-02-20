import { useState } from 'react';

const useGuildVisibilityStep = () => {
  const [guildVisibility, setGuildVisibility] = useState<boolean | null>(null);

  const handleVisibilityChange = (visibility: boolean) => {
    setGuildVisibility(visibility);
  };

  return { guildVisibility, handleVisibilityChange };
};

export default useGuildVisibilityStep;
