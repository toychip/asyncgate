import styled from 'styled-components';

import { TitleText2 } from '@/styles/Typography';

export const GuildCategories = styled.div`
  width: 24rem;
  padding: 1.6rem 1rem;
  background-color: ${({ theme }) => theme.colors.dark[700]};
`;

export const GuildTitle = styled.div`
  display: flex;
  justify-content: space-between;

  svg {
    cursor: pointer;
    color: ${({ theme }) => theme.colors.dark[300]};
  }
`;

export const GuildName = styled(TitleText2)`
  color: ${({ theme }) => theme.colors.dark[300]};
`;
