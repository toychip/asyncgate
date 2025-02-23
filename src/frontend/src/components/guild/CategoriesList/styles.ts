import styled from 'styled-components';

export const CategoriesList = styled.div`
  display: flex;
  flex-direction: column;
  gap: 2rem;

  margin-top: 1.5rem;

  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const Category = styled.div`
  cursor: pointer;
  display: flex;
  justify-content: space-between;

  svg {
    color: ${({ theme }) => theme.colors.dark[300]};
  }
`;
