package me.lionelv.commandspractice2;

import me.lionelv.commandspractice2.commands.GodCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandsPractice2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("god").setExecutor(new GodCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
