import { ForwardedRef, forwardRef } from 'react';

import * as S from './styles';

interface ChatTextareaProps {
  value: string;
  handleChange: (e: React.ChangeEvent<HTMLTextAreaElement>) => void;
  handleKeyDown?: (e: React.KeyboardEvent<HTMLTextAreaElement>) => void;
  placeholder?: string;
}

const ChatTextarea = (
  { value, handleChange, handleKeyDown, placeholder }: ChatTextareaProps,
  ref: ForwardedRef<HTMLTextAreaElement>,
) => {
  return (
    <S.ChatTextarea
      ref={ref}
      value={value}
      onChange={handleChange}
      onKeyDown={handleKeyDown}
      placeholder={placeholder}
    />
  );
};

export default forwardRef<HTMLTextAreaElement, ChatTextareaProps>(ChatTextarea);
