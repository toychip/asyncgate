import styled from 'styled-components';

import { BodyMediumText } from '@/styles/Typography';

export const SectionHeader = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  height: 4.8rem;
  padding: 0.8rem;
  border-bottom: 0.2rem solid ${({ theme }) => theme.colors.dark[700]};

  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const SectionInfo = styled.div`
  display: flex;
  align-items: center;
`;

export const SectionIcon = styled.div`
  margin: 0 0.8rem;
`;

export const SectionTitle = styled(BodyMediumText)`
  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const Divider = styled.div`
  margin: 0 1rem;
  font-size: 2rem;
  font-weight: 400;
`;

export const FriendNavBarWrapper = styled.nav`
  display: flex;
`;

export const MenuContainer = styled.ul`
  display: flex;
  list-style: none;
`;

export const MenuItem = styled.li<{ $isSelectedMenu: boolean }>`
  cursor: pointer;

  margin: 0 0.7rem;
  padding: 1rem;
  border-radius: 0.4rem;

  font-size: 1.6rem;
  font-weight: 500;
  color: ${({ theme, $isSelectedMenu }) => ($isSelectedMenu ? theme.colors.white : theme.colors.dark[300])};
  text-decoration: none;

  background-color: ${({ theme, $isSelectedMenu }) => ($isSelectedMenu ? theme.colors.dark[500] : '')};

  &:hover {
    background-color: ${({ theme }) => theme.colors.dark[500]};
  }
`;

export const ToolBar = styled.div`
  display: flex;
`;

export const IconWrapper = styled.div`
  cursor: pointer;
  margin: 0 0.8rem;
`;

export const SectionContentsWrapper = styled.div`
  display: flex;
  width: 100%;
`;
