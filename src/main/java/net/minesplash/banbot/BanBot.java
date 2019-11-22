package net.minesplash.banbot;

import org.bukkit.plugin.java.JavaPlugin;

public final class BanBot extends JavaPlugin {

    public static BanBot instance;
    public DiscordHook bot;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        getServer().getScheduler().runTaskAsynchronously(this, ()->{
            this.bot = new DiscordHook(getConfig().getString("discord-token"));
            getServer().getPluginManager().registerEvents(new BanListener(), this);
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
