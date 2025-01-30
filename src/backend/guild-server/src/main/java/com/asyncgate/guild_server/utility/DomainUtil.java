package com.asyncgate.guild_server.utility;

import com.asyncgate.guild_server.domain.Category;
import com.asyncgate.guild_server.domain.Guild;
import com.asyncgate.guild_server.domain.GuildMember;
import com.asyncgate.guild_server.entity.CategoryEntity;
import com.asyncgate.guild_server.entity.GuildEntity;
import com.asyncgate.guild_server.entity.GuildMemberEntity;

public class DomainUtil {

    public static class GuildMapper {
        public static GuildEntity toEntity(final Guild guild) {
            return GuildEntity.builder()
                    .id(guild.getId())
                    .name(guild.getName())
                    .isPrivate(guild.isPrivate())
                    .build();
        }

        public static Guild toDomain(final GuildEntity entity) {
            return Guild.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .isPrivate(entity.isPrivate())
                    .build();
        }
    }

    public static class GuildMemberMapper {
        public static GuildMemberEntity toEntity(final GuildMember guildMember) {
            return GuildMemberEntity.builder()
                    .id(guildMember.getId())
                    .userId(guildMember.getUserId())
                    .guildId(guildMember.getGuildId())
                    .guildRole(guildMember.getGuildRole())
                    .build();
        }

        public static GuildMember toDomain(final GuildMemberEntity entity) {
            return GuildMember.builder()
                    .id(entity.getId())
                    .userId(entity.getUserId())
                    .guildId(entity.getGuildId())
                    .guildRole(entity.getGuildRole())
                    .build();
        }
    }

    public static class CategoryMapper {
        public static CategoryEntity toEntity(final Category category) {
            return CategoryEntity.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .isPrivate(category.isPrivate())
                    .guildId(category.getGuildId())
                    .build();
        }
    }
}
