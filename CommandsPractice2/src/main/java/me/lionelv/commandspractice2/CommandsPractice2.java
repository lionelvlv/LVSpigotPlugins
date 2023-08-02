package me.lionelv.commandspractice2;

import me.lionelv.commandspractice2.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandsPractice2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new feed());
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("fart").setExecutor(new FartCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        //Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "LVCommands has finished loading!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "LVCommands has shutdown.");
    }
}
