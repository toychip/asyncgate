import { TbPlus } from 'react-icons/tb';

import { BodyMediumText } from '@/styles/Typography';
import { CategoryDataResult, ChannelResult } from '@/types/guilds';

import * as S from './styles';

interface CategoriesListProps {
  categories?: CategoryDataResult[];
  channels?: ChannelResult[];
}
const CategoriesList = ({ categories, channels }: CategoriesListProps) => {
  console.log(categories);
  console.log(channels);

  return (
    <S.CategoriesList>
      {categories?.map((category) => (
        <S.Category key={category.categoryId}>
          <BodyMediumText>{category.name}</BodyMediumText>
          <TbPlus size={18} />
        </S.Category>
      ))}
    </S.CategoriesList>
  );
};

export default CategoriesList;
