package me.lionelv.commandspractice2.commands;

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
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "Godmode disabled.");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "Godmode enabled");
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
