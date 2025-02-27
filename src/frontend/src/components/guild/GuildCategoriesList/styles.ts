import styled from 'styled-components';

export const CategoriesList = styled.div`
  display: flex;
  flex-direction: column;
  gap: 2rem;

  margin-top: 1.5rem;
  padding: 0 1.6rem;

  color: ${({ theme }) => theme.colors.dark[300]};
`;

export const Category = styled.div`
  display: flex;
  flex-direction: column;
`;

export const CategoryName = styled.div`
  cursor: pointer;

  display: flex;
  align-items: center;
  justify-content: space-between;

  width: 100%;

  svg {
    color: ${({ theme }) => theme.colors.dark[300]};
  }

  &:hover {
    * {
      color: ${({ theme }) => theme.colors.white};
    }
  }
`;

export const Channels = styled.div`
  display: flex;
  flex-direction: column;
  gap: 0.1rem;
  margin-top: 0.6rem;
`;

export const ChannelName = styled.div<{ $isSelected: boolean }>`
  cursor: pointer;

  display: flex;
  gap: 0.5rem;
  align-items: center;

  height: 3.2rem;
  padding-left: 1rem;
  border-radius: 0.4rem;

  color: ${({ theme, $isSelected }) => $isSelected && theme.colors.white};

  background-color: ${({ theme, $isSelected }) => $isSelected && theme.colors.dark[500]};

  &:hover {
    background-color: ${({ theme }) => theme.colors.dark[500]};
  }
`;
