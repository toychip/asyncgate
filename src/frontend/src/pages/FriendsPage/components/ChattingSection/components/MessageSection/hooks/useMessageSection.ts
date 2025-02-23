import { useEffect, useRef, useState } from 'react';

const useMessageSection = () => {
  const [chatInput, setChatInput] = useState<string>('');
  const textareaRef = useRef<HTMLTextAreaElement>(null);

  const handleTextareaChange = (value: string) => {
    setChatInput(value);
  };

  const handleKeyDown = (event: React.KeyboardEvent<HTMLTextAreaElement>) => {
    if (event.key === 'Enter' && !event.shiftKey) {
      event.preventDefault(); // 기본 줄바꿈 동작 방지
      if (chatInput.trim().length > 0) {
        console.log('메시지 전송:', chatInput);
        setChatInput('');
      }
    }
  };

  // 키보드 입력 시 textarea로 포커스 이동
  useEffect(() => {
    const handleGlobalKeyPress = (event: KeyboardEvent) => {
      if (document.activeElement !== textareaRef.current) {
        textareaRef.current?.focus();
      }
    };

    document.addEventListener('keydown', handleGlobalKeyPress);
    return () => {
      document.removeEventListener('keydown', handleGlobalKeyPress);
    };
  }, []);

  return {
    chatInput,
    textareaRef,
    handleTextareaChange,
    handleKeyDown,
  };
};

export default useMessageSection;
