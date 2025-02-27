import { useRef, useState } from 'react';

interface UseChatTextareaProps {
  initialValue?: string;
  // globalFocusTarget?: 'messageSection' | 'messageItem';
  cancelEdit?: () => void;
  sendMessage: (value: string) => void;
}

const useChatTextarea = ({ initialValue = '', cancelEdit, sendMessage }: UseChatTextareaProps) => {
  const [chatInput, setChatInput] = useState<string>(initialValue);
  const textareaRef = useRef<HTMLTextAreaElement>(null);

  const handleTextareaChange = (value: string) => {
    setChatInput(value);
  };

  const handleKeyDown = (event: React.KeyboardEvent<HTMLTextAreaElement>) => {
    // 활성화된 요소가 textarea인지 확인
    if (document.activeElement !== textareaRef.current) return;
    if (event.key === 'Enter' && !event.shiftKey) {
      event.preventDefault(); // 기본 줄바꿈 동작 방지
      if (chatInput.trim().length > 0) {
        sendMessage(chatInput);
        setChatInput('');
      }
      return;
    }

    if (event.key === 'Escape' && cancelEdit) {
      event.preventDefault(); // 기본 동작 방지
      cancelEdit();
    }
  };

  return {
    chatInput,
    textareaRef,
    handleTextareaChange,
    handleKeyDown,
  };
};

export default useChatTextarea;
