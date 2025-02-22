export interface CreateGuildRequest {
  name: string;
  profileImage?: File | null;
  isPrivate?: boolean;
}

export interface GuildResult {
  guildId: string;
  name: string;
  isPrivate: boolean;
  profileImageUrl: string;
}

export interface CreateGuildResponse {
  httpStatus: number;
  message: string;
  time: string;
  result: GuildResult;
}

export interface GetGuildsResponse {
  httpStatus: number;
  message: string;
  time: string;
  result: {
    responses: GuildResponse[];
  };
}

export interface GuildResponse {
  guildId: string;
  name: string;
  profileImageUrl: string;
}

export interface GetGuildResponse {
  httpStatus: number;
  message: string;
  time: string;
  result: GuildResultData;
}

export interface GuildResultData {
  guild: GuildResult;
  categories: CategoryResult[];
  channels: ChannelResult[];
}

interface CategoryResult {
  categoryId: string;
  name: string;
  isPrivate: boolean;
}

interface ChannelResult {
  channelId: string;
  categoryId: string;
  name: string;
  topic: string;
  channelType: string;
  isPrivate: boolean;
}
