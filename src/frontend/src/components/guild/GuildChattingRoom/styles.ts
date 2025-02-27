import styled from 'styled-components';

import { BodyMediumText } from '@/styles/Typography';

export const ChattingHeader = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  height: 4.8rem;
  padding: 0.8rem;
  border-bottom: 0.2rem solid ${({ theme }) => theme.colors.dark[700]};

  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const ChannelInfo = styled.div`
  display: flex;
  align-items: center;
`;

export const ChannelIcon = styled.div`
  margin: 0 0.8rem;
`;

export const ChannelTitle = styled(BodyMediumText)`
  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const ToolBar = styled.div`
  display: flex;
`;

export const IconWrapper = styled.div`
  cursor: pointer;
  margin: 0 0.8rem;
`;
