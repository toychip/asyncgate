import { create } from 'zustand';
import { persist } from 'zustand/middleware';

import { ChannelType } from '@/types/guilds';

interface GuildChannelInfo {
  id: string;
  name: string;
  type: ChannelType;
}

interface DMChannelInfo {
  id: string;
  name: string;
  type: ChannelType;
}

interface ChannelState {
  selectedChannel: GuildChannelInfo | null;
  selectedDMChannel: DMChannelInfo | null;
  setSelectedChannel: (channel: GuildChannelInfo) => void;
  setSelectedDMChannel: (channel: DMChannelInfo) => void;
}

export const useChannelInfoStore = create<ChannelState>()(
  persist(
    (set) => ({
      selectedChannel: null,
      selectedDMChannel: null,
      setSelectedChannel: (channel) => set({ selectedChannel: channel }),
      setSelectedDMChannel: (channel) => set({ selectedDMChannel: channel }),
    }),
    {
      name: 'channelInfo',
    },
  ),
);
