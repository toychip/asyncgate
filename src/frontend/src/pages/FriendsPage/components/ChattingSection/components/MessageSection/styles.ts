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
  position: relative;
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

export const FileAttachInput = styled.input`
  display: none;
`;

export const FilePreview = styled.div`
  position: absolute;
  bottom: 7rem;

  display: flex;
  align-items: center;
  justify-content: space-between;

  margin-bottom: 0.5rem;
  padding: 0.8rem 1.2rem;
  border-radius: 0.6rem;

  background-color: ${({ theme }) => theme.colors.dark[500]};
`;

export const FileName = styled.span`
  font-size: 1.4rem;
  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const FileRemoveButton = styled.button`
  cursor: pointer;

  margin-left: 1rem;
  border: none;

  color: ${({ theme }) => theme.colors.dark[400]};

  background: none;

  &:hover {
    color: ${({ theme }) => theme.colors.dark[300]};
  }
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
