import styled from 'styled-components';

export const ChatTextarea = styled.textarea`
  resize: none;

  overflow-y: auto;
  flex-grow: 1;

  width: 100%;
  height: 4.4rem;
  max-height: 50vh;
  padding: 1.1rem 1rem;
  border: none;
  border-radius: 0.8rem;

  font-size: 1.6rem;
  font-weight: 400;
  color: ${({ theme }) => theme.colors.dark[300]};

  background-color: ${({ theme }) => theme.colors.dark[500]};
  outline: none;

  &::-webkit-scrollbar-thumb {
    border: 0.1rem solid ${({ theme }) => theme.colors.dark[600]};
    border-radius: 0.3rem;
    background: ${({ theme }) => theme.colors.dark[800]};
  }

  &::-webkit-scrollbar {
    width: 0.6rem;
  }
`;
