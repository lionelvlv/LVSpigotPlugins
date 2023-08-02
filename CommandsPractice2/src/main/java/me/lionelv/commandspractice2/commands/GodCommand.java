package me.lionelv.commandspractice2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("lv.command.god")) {
                if (strings.length == 0) {
                    if (p.isInvulnerable()) {
                        p.setInvulnerable(false);
                        p.sendMessage(ChatColor.RED + "Godmode disabled.");
                    } else {
                        p.setInvulnerable(true);
                        p.sendMessage(ChatColor.GREEN + "Godmode enabled");
                    }
                }
                else {
                    String playerName = strings[0];
                    Player target = Bukkit.getPlayerExact(playerName);
                    if (target == null){
                        p.sendMessage("This player is not online.");
                    }
                    else {
                        if (target.isInvulnerable()){
                            target.setInvulnerable(false);
                            target.sendMessage(ChatColor.RED + "Godmode disabled.");
                            p.sendMessage(target.getDisplayName() + " disabled Godmode");
                        }
                        else {
                            target.setInvulnerable(true);
                            target.sendMessage(ChatColor.GREEN + "Godmode enabled");
                            p.sendMessage(target.getDisplayName() + " enabled Godmode");
                        }
                    }
                }

            }
            else {
                p.sendMessage("You do not have permission to run this command!");
            }
        }

        //prevents the command being printed back to us
        return true;
    }
}
