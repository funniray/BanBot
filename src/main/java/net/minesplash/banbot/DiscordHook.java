package net.minesplash.banbot;

import me.confuser.banmanager.data.PlayerData;
import net.minesplash.banbot.embed.EmbedBuilder;

import java.io.IOException;

public class DiscordHook {

    private String token;

    public DiscordHook(String token) {
        this.token = token;
    }

    public void logAction(String action, String duration, String reason, String target, PlayerData source, PlayerData td) {

        EmbedBuilder embed = new EmbedBuilder()
                .addField("Action", action, true)
                .addField("Player", target, true);

        if (duration != null)
            embed.addField("Duration", duration, true);

        if (reason != null)
            embed.addField("Reason", reason, false);

        if (td != null)
            embed.setThumbnail("https://crafatar.com/renders/body/"+td.getUUID()+".png", 270, 120);

        WebhookMessage message = new WebhookMessage();
        message.addEmbed(embed.build());
        message.setUsername(source.getName());

        if (source.getName().equalsIgnoreCase("console")) {
            message.setAvatar_url("https://crafatar.com/avatars/f78a4d8d-d51b-4b39-98a3-230f2de0c670");
        } else {
            message.setAvatar_url("https://crafatar.com/avatars/"+source.getUUID());
        }

        BanBot.instance.getServer().getScheduler().runTaskAsynchronously(BanBot.instance, ()->{
            try {
                message.send(this.token);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
