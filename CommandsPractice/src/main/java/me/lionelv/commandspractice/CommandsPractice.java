package me.lionelv.commandspractice;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandsPractice extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    //Start of example command

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /die - kills the player
        if (command.getName().equalsIgnoreCase("die")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage(ChatColor.RED + "Goodbye cruel world.");
            }
        } else if (sender instanceof ConsoleCommandSender || sender instanceof BlockCommandSender) {
            System.out.println("You can only run this command in game");
            
        }

        return super.onCommand(sender, command, label, args);
    }


    //End

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
