package me.lionelv.commandspractice2;

import me.lionelv.commandspractice2.commands.GodCommand;
import me.lionelv.commandspractice2.commands.feed;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandsPractice2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new feed());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
