package net.minesplash.banbot;

import net.minesplash.banbot.embed.EmbedBuilder;

import java.io.IOException;

public class DiscordHook {

    private String token;

    public DiscordHook(String token) {
        this.token = token;
    }

    public void logAction(String action, String duration, String reason, String target, String source) {

        EmbedBuilder embed = new EmbedBuilder()
                .addField("Action", action, true)
                .addField("Player", target, true)
                .setAuthor("Staff: "+source, null, null);

        if (duration != null)
            embed.addField("Duration", duration, true);

        if (reason != null)
            embed.addField("Reason", reason, false);

        WebhookMessage message = new WebhookMessage();
        message.addEmbed(embed.build());

        BanBot.instance.getServer().getScheduler().runTaskAsynchronously(BanBot.instance, ()->{
            try {
                message.send(this.token);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
