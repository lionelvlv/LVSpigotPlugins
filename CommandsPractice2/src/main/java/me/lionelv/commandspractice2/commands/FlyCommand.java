package me.lionelv.commandspractice2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {
            if (p.hasPermission("lv.command.fly")) {
                if (strings.length == 0){
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.RED + "Flying disabled.");
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.GREEN + "Flying enabled.");
                    }
            }
                else {
                    String playerName = strings[0];
                    Player target = Bukkit.getPlayerExact(playerName);
                    if (target == null){
                        p.sendMessage("This player is not online.");
                    }
                    else {
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.RED + "Flying disabled.");
                            p.sendMessage(target.getDisplayName() + " has disabled flying.");
                        } else {
                            target.setAllowFlight(true);
                            target.sendMessage(ChatColor.GREEN + "Flying enabled.");
                            p.sendMessage(target.getDisplayName() + " has enabled flying.");
                        }
                    }
                }
        }
            else {
                p.sendMessage("You do not have permission to fly!");
            }
        }

        return true;
    }
}
