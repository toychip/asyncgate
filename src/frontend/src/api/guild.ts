import { endPoint } from '@/constants/endPoint';
import { CreateGuildRequest, CreateGuildResponse, GetGuildsResponse } from '@/types/guilds';
import { tokenAxios } from '@/utils/axios';
import { convertFormData } from '@/utils/convertFormData';

export const createGuild = async (data: CreateGuildRequest) => {
  const formData = convertFormData(data);

  return await tokenAxios.post<CreateGuildResponse>(endPoint.guilds.CREATE_GUILD, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
};

export const getGuilds = async () => {
  const { data } = await tokenAxios.get<GetGuildsResponse>(endPoint.guilds.GET_GUILDS);
  return data.result.responses;
};
