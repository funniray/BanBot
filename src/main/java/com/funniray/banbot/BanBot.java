package com.funniray.banbot;

import com.funniray.lbwd.events.BanEvent;
import com.funniray.lbwd.events.UnbanEvent;
import dev.waterdog.waterdogpe.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public final class BanBot extends Plugin {

    public static BanBot instance;
    public DiscordHook bot;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        createDefaultConfig();

        getProxy().getScheduler().scheduleAsync(()->{
            this.bot = new DiscordHook(getConfig().getString("hook-url"));
            getProxy().getEventManager().subscribe(BanEvent.class, new BanListener()::onBan);
            getProxy().getEventManager().subscribe(UnbanEvent.class, new BanListener()::onUnban);
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createDefaultConfig() {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();

        File file = new File(getDataFolder(), "config.yml");


        if (!file.exists()) {
            try (InputStream in = getResourceFile("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
