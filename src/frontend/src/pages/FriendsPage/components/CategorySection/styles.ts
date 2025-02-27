import styled from 'styled-components';

export const CategorySectionContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 24rem;
  background-color: ${({ theme }) => theme.colors.dark[700]};
`;

export const CategoryItemWrapper = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
`;
