import styled from 'styled-components';

import { BodyRegularText, TitleText2 } from '@/styles/Typography';

export const GuildTitle = styled.div`
  cursor: pointer;

  position: relative;

  display: flex;
  align-items: center;
  justify-content: space-between;

  height: 4.8rem;
  padding: 1.2rem 1.6rem;
  border-bottom: 0.1rem solid ${({ theme }) => theme.colors.dark[500]};

  svg {
    cursor: pointer;
    color: ${({ theme }) => theme.colors.dark[300]};
  }
`;

export const GuildName = styled(TitleText2)`
  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const DropDown = styled.div`
  position: absolute;
  z-index: 10;
  top: 6%;

  display: flex;
  flex-direction: column;
  gap: 1rem;

  width: 100%;
  max-width: 24rem;
  padding: 0.8rem 1rem;
  border-radius: 0.4rem;

  background-color: ${({ theme }) => theme.colors.black};
`;

export const DropDownItem = styled.div`
  cursor: pointer;
`;

export const DropDownItemText = styled(BodyRegularText)`
  color: ${({ theme }) => theme.colors.dark[300]};
`;
