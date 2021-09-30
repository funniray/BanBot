package com.funniray.banbot;


import com.funniray.lbwd.datatypes.Ban;
import com.funniray.lbwd.events.BanEvent;
import com.funniray.lbwd.events.UnbanEvent;

public class BanListener {

    public long minute = 60;
    public long hour = 3600;
    public long day = 86400;
    public long month = day * 30;

    public String toTime(double created, double t) {
        if (t == -1) {
            return "permanent";
        }
        double length = t-created;
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
    public void onBan(BanEvent e) {
        Ban ban = e.getBan();
        String time = toTime(ban.getTime() ,ban.getUntil());
        BanBot.instance.bot.logAction(e.getNode(), time,ban.getReason(),
                ban.getName(), ban.getBannedByName());
    }

    public void onUnban(UnbanEvent e) {
        Ban ban = e.getBan();
        String time = toTime(ban.getTime() ,ban.getUntil());
        BanBot.instance.bot.logAction("Un"+e.getNode(), null, null,
                ban.getName(), ban.getBannedByName());
    }
}
