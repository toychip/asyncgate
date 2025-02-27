import styled from 'styled-components';

import { TitleText2 } from '@/styles/Typography';

export const FriendTitle = styled.div`
  display: flex;
  align-items: center;

  height: 4.8rem;
  padding: 1.2rem 1.6rem;
  border-bottom: 0.1rem solid ${({ theme }) => theme.colors.dark[500]};

  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const TitleName = styled(TitleText2)`
  color: ${({ theme }) => theme.colors.dark[300]};
`;
