import styled from 'styled-components';

export const MessageSection = styled.section`
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  height: 100%;
`;

export const MessageContainer = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  justify-content: flex-end;
`;

export const MessageItemList = styled.ol`
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  height: 100%;
`;

export const BottomBarWrapper = styled.div`
  width: 100%;
  padding: 0 1.6rem;
  background-color: ${({ theme }) => theme.colors.dark[600]};
`;

export const BottomBarContainer = styled.div`
  display: flex;
  align-items: flex-start;

  margin-bottom: 2.4rem;
  border-radius: 0.8rem;

  background-color: ${({ theme }) => theme.colors.dark[500]};
`;

export const AttachButton = styled.button`
  height: 4.4rem;
  padding: 1rem 1.6rem;
  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const ChatTextarea = styled.textarea`
  resize: none;

  overflow-y: auto;
  flex-grow: 1;

  height: 4.4rem;
  max-height: 50vh;
  padding: 1.1rem 1rem 1.1rem 0;
  border: none;

  font-size: 1.6rem;
  font-weight: 400;
  color: ${({ theme }) => theme.colors.dark[300]};

  background-color: ${({ theme }) => theme.colors.dark[500]};
  outline: none;
`;

export const ToolBarContainer = styled.div`
  display: flex;
  align-items: center;

  height: 4.4rem;
  padding-right: 0.4rem;

  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const IconWrapper = styled.div`
  cursor: pointer;

  display: flex;
  align-items: center;
  justify-content: center;

  width: 4rem;
`;
