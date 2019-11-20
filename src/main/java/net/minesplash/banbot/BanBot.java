package net.minesplash.banbot;

import org.bukkit.plugin.java.JavaPlugin;

public final class BanBot extends JavaPlugin {

    public static BanBot instance;
    public DiscordBot bot;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        getServer().getScheduler().runTaskAsynchronously(this, ()->{
            this.bot = new DiscordBot(getConfig().getString("discord-token"),getConfig().getString("discord-channel"));
            getServer().getPluginManager().registerEvents(new BanListener(), this);
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.bot.disconnect();
    }
}
