package me.lionelv.commandspractice2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// /repeat bob is really cool
// ["bob", "is", "really", "cool"]
// args[0] - "bob"
// args[1] - "is"

public class RepeatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;

            if (strings.length == 0){
                p.sendMessage("You didn't provide any args yaa stooopid");
                p.sendMessage("Example: /repeat <insert message here>");
            }
            else {
                for (String string : strings) {
                    String wordtosend = string;
                    p.sendMessage("Message: " + wordtosend);
                }

            }
        }



        return true;
    }
}
