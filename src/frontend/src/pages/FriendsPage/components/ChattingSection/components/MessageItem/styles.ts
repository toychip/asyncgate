import styled from 'styled-components';

import { BodyMediumText, BodyRegularText, SmallText } from '@/styles/Typography';

export const MessageItem = styled.li`
  position: relative;
  display: flex;
  width: 100%;
  margin-bottom: 1.6rem;
`;

export const MessageContentContainer = styled.div`
  padding-left: calc(4rem + 1.6rem + 1.6rem);
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

export const SentUserName = styled(BodyMediumText)`
  overflow: hidden;

  max-width: 50%;

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
