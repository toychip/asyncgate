import { TbPlus } from 'react-icons/tb';

import { BodyMediumText, BodyRegularText } from '@/styles/Typography';
import { CategoryDataResult, ChannelResult } from '@/types/guilds';

import * as S from './styles';

interface CategoriesListProps {
  categories?: CategoryDataResult[];
  channels?: ChannelResult[];
}
const CategoriesList = ({ categories, channels }: CategoriesListProps) => {
  return (
    <S.CategoriesList>
      {categories?.map((category) => (
        <S.Category key={category.categoryId}>
          <S.CategoryName>
            <BodyMediumText>{category.name}</BodyMediumText>
            <TbPlus size={18} />
          </S.CategoryName>
          {channels
            ?.filter((channel) => category.categoryId === channel.categoryId)
            .map((channel) => (
              <S.Channels key={channel.channelId}>
                <BodyRegularText>{channel.name}</BodyRegularText>
              </S.Channels>
            ))}
        </S.Category>
      ))}
    </S.CategoriesList>
  );
};

export default CategoriesList;
