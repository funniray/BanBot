package com.funniray.banbot;

import com.funniray.banbot.embed.EmbedBuilder;

import java.io.IOException;

public class DiscordHook {

    private String token;

    public DiscordHook(String token) {
        this.token = token;
    }

    public void logAction(String action, String duration, String reason, String target, String source) {

        EmbedBuilder embed = new EmbedBuilder()
                .addField("Action", action, true)
                .addField("Player", target, true);

        if (duration != null)
            embed.addField("Duration", duration, true);

        if (reason != null)
            embed.addField("Reason", reason, false);

        WebhookMessage message = new WebhookMessage();
        message.addEmbed(embed.build());
        message.setUsername(source);

        if (source.equalsIgnoreCase("console")) {
            message.setAvatar_url("https://crafatar.com/avatars/f78a4d8d-d51b-4b39-98a3-230f2de0c670");
        }

        BanBot.instance.getProxy().getScheduler().scheduleAsync(()->{
            try {
                message.send(this.token);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
