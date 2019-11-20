package net.minesplash.banbot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class DiscordBot {

    private JDA jda;
    private String logChannel;

    public DiscordBot (String token, String channel) {
        this.logChannel = channel;
        JDABuilder builder = new JDABuilder(token);

        // Disable parts of the cache
        builder.setDisabledCacheFlags(EnumSet.of(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE));
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.playing("Fortnite"));

        try {
            this.jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        this.jda.shutdownNow();
    }

    public void logAction(String action, String duration, String reason, String target, String source) {
        BanBot.instance.getServer().getScheduler().runTaskAsynchronously(BanBot.instance, ()->{
            MessageChannel channel = jda.getTextChannelById(this.logChannel);

            EmbedBuilder embed = new EmbedBuilder()
                    .addField("Action", action, true)
                    .addField("Player", target, true)
                    .setAuthor("Staff: "+source);

            if (duration != null)
                embed.addField("Duration", duration, true);

            if (reason != null)
                embed.addField("Reason", reason, false);


            channel.sendMessage(embed.build()).queue();
        });
    }
}
