package me.lionelv.commandspractice2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Player;

public class FartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player p){
            if (p.hasPermission("lv.command.fart")){
            if(strings.length == 0){
                p.sendMessage(ChatColor.RED + "You just farted on yourself. nastyyy hoe");
                p.setHealth(0);
                p.playSound(p.getLocation(), Sound.ENTITY_GHAST_DEATH, 10.0f, 1.0f);
            }
            else {
                String playerName = strings[0];
                Player target = Bukkit.getServer().getPlayerExact(playerName);
                if(target == null){
                    p.sendMessage("This player is not online.");
                }
                else {
                    target.sendMessage(ChatColor.RED + "you got farted on by " + p.getDisplayName());
                    target.setHealth(0);
                    p.sendMessage(ChatColor.GREEN + "you farted on " + target.getDisplayName());
                    target.playSound(target.getLocation(), Sound.ENTITY_GHAST_DEATH, 10.0f, 1.0f);
                }
            }
            }
            else {
                p.sendMessage("You do not have permission to fart :(");
            }
        }


        return true;
    }
}
