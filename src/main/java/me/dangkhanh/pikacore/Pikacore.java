package me.dangkhanh.pikacore;

import me.dangkhanh.pikacore.commands.*;
import me.dangkhanh.pikacore.events.BombEvent;
import me.dangkhanh.pikacore.events.HotbarDamageSlot;
import me.dangkhanh.pikacore.events.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pikacore extends JavaPlugin {
    private static Pikacore instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(), this);
        getServer().getPluginManager().registerEvents(new HotbarDamageSlot(), this);
        getServer().getPluginManager().registerEvents(new BombEvent(), this);
        getCommand("settooltip").setExecutor(new SetToolTipCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("setslot").setExecutor(new SetSlotCommand());
        getCommand("setcustommodeldata").setExecutor(new CustomModelDataCommand());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Pikacore getInstance() {
        return instance;
    }
}
