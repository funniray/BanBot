package net.minesplash.banbot;

import me.confuser.banmanager.events.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BanListener implements Listener {

    public long minute = 60;
    public long hour = 3600;
    public long day = 86400;
    public long month = day * 30;

    public String toTime(long created, long t) {
        if (t == 0) {
            return "permanent";
        }
        Long length = t-created;
        if (length/month > 1) {
            return String.format("%.2f months", (float) length/month);
        } else if (length/day > 1) {
            return String.format("%.2f days", (float) length/day);
        } else if (length/hour > 1) {
            return String.format("%.2f hours", (float) length/hour);
        } else {
            return String.format("%.2f minutes", (float) length/minute);
        }
    }

    @EventHandler
    public void onIPBan(IpBannedEvent e) {
        String time = toTime(e.getBan().getCreated() ,e.getBan().getExpires());
        BanBot.instance.bot.logAction("IPBan", time, e.getBan().getReason(),
                e.getBan().getIp()+"", e.getBan().getActor().getName());
    }

    @EventHandler
    public void onIPUnban(IpUnbanEvent e) {
        if (e.getBan().hasExpired())
            return;
        String time = toTime(e.getBan().getCreated() ,e.getBan().getExpires());
        BanBot.instance.bot.logAction("IPUnban", null, null,
                e.getBan().getIp()+"", e.getBan().getActor().getName());
    }

    @EventHandler
    public void onBan(PlayerBannedEvent e) {
        String time = toTime(e.getBan().getCreated() ,e.getBan().getExpires());
        BanBot.instance.bot.logAction("Ban", time, e.getBan().getReason(),
                e.getBan().getPlayer().getName(), e.getBan().getActor().getName());
    }

    @EventHandler
    public void onUnban(PlayerUnbanEvent e) {
        if (e.getBan().hasExpired())
            return;
        BanBot.instance.bot.logAction("Unban", null, null,
                e.getBan().getPlayer().getName(), e.getBan().getActor().getName());
    }

    @EventHandler
    public void onMute(PlayerMutedEvent e) {
        String time = toTime(e.getMute().getCreated() ,e.getMute().getExpires());
        BanBot.instance.bot.logAction("Mute", time, e.getMute().getReason(),
                e.getMute().getPlayer().getName(), e.getMute().getActor().getName());
    }

    @EventHandler
    public void onUnmute(PlayerUnmuteEvent e) {
        if (e.getMute().hasExpired())
            return;
        BanBot.instance.bot.logAction("Unmute", null, null,
                e.getMute().getPlayer().getName(), e.getMute().getActor().getName());
    }

    @EventHandler
    public void onWarn(PlayerWarnedEvent e) {
        String time = toTime(e.getWarning().getCreated() ,e.getWarning().getExpires());
        BanBot.instance.bot.logAction("Warn", time, e.getWarning().getReason(),
                e.getWarning().getPlayer().getName(), e.getWarning().getActor().getName());
    }
}
