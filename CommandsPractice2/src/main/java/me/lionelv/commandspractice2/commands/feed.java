package me.lionelv.commandspractice2.commands;

import org.bukkit.Bukkit;
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
                if (strings.length == 0){
                    if (p.getFoodLevel() < 20) {
                        p.setFoodLevel(20);
                        p.sendMessage(ChatColor.YELLOW + "Bon appetit!");
                    } else {
                        p.sendMessage(ChatColor.RED + "You're full!");

                    }
            }
                else {
                    String playerName = strings[0];
                    Player target = Bukkit.getPlayerExact(playerName);
                    if (target == null) {
                        p.sendMessage("This command is disabled");
                    }
                    else {
                        if (target.getFoodLevel() < 20) {
                            target.setFoodLevel(20);
                            target.sendMessage(ChatColor.YELLOW + "Bon appetit!");
                            p.sendMessage(target + " has been fed.");
                        } else {
                            target.sendMessage(ChatColor.RED + "You're full!");
                            p.sendMessage(target + " already has full hunger.");

                        }
                    }
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
