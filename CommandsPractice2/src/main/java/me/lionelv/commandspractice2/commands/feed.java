package me.lionelv.commandspractice2.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p) {
            if (p.hasPermission("lv.command.feed")) {
                if (p.getFoodLevel() < 20) {
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.YELLOW + "Bon appetit!");
                } else {
                    p.sendMessage(ChatColor.RED + "You're full!");

                }
            }
            else {
                p.sendMessage("You do not have permission to run this command!");
            }
        }
        else {
            System.out.println("This Command can only be used in-game!");
        }


        return true;
    }
}
