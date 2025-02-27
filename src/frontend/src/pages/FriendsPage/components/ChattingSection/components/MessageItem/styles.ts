import styled from 'styled-components';

import { BodyMediumText, BodyRegularText, SmallText } from '@/styles/Typography';

export const MessageItem = styled.li`
  position: relative;
  display: flex;
  width: 100%;
  margin-bottom: 1.6rem;
`;

export const MessageContentContainer = styled.div`
  width: 100%;
  padding-right: 1.6rem;
  padding-left: calc(4rem + 1.6rem + 1.6rem);
`;

export const MessageToolbar = styled.div`
  position: absolute;
  top: -1rem;
  right: 0;

  display: flex;
  gap: 8px;

  padding: 6px 8px;
  border-radius: 6px;

  opacity: 0.9;
  background: ${({ theme }) => theme.colors.dark[600]};
  box-shadow: 0 2px 5px rgb(0 0 0 / 20%);
`;

export const IconButton = styled.button`
  cursor: pointer;
  border: none;
  color: ${({ theme }) => theme.colors.dark[300]};
  background: none;

  &:hover {
    color: ${({ theme }) => theme.colors.white};
  }
`;

export const SentUserProfileImage = styled.img`
  cursor: pointer;

  position: absolute;
  left: 1.6rem;

  overflow: hidden;

  width: 4rem;
  height: 4rem;
  margin-top: 0.275rem;
  border-radius: 50%;

  background-color: ${({ theme }) => theme.colors.dark[300]};
`;

export const MessageTitle = styled.div`
  display: flex;
  gap: 1rem;
  align-items: flex-end;
`;

export const EditTextareaWrapper = styled.div`
  width: 100%;
`;

export const SentUserName = styled(BodyMediumText)`
  overflow: hidden;

  max-width: 50%;

  line-height: 1.8rem;
  color: ${({ theme }) => theme.colors.white};
  text-overflow: ellipsis;
  white-space: nowrap;
`;

export const SentDateTime = styled(SmallText)`
  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const MessageContent = styled(BodyRegularText)`
  color: ${({ theme }) => theme.colors.white};
`;

export const ModifiedMark = styled(SmallText)`
  margin-left: 0.5rem;
  color: ${({ theme }) => theme.colors.dark[300]};
`;
