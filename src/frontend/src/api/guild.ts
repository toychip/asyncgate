import { endPoint } from '@/constants/endPoint';
import { CreateGuildRequest, CreateGuildResponse, GetGuildsResponse } from '@/types/guilds';
import { tokenAxios } from '@/utils/axios';

export const createGuild = async (data: CreateGuildRequest) => {
  const formData = new FormData();
  formData.append('name', data.name);

  if (data.profileImage) {
    formData.append('profileImage', data.profileImage);
  }

  formData.append('isPrivate', String(data.isPrivate));

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
