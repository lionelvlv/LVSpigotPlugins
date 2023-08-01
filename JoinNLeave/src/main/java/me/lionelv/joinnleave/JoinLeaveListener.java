package me.lionelv.joinnleave;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Random;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoined(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (player.hasPlayedBefore()) {
            String RandomJoinMessage = "";
            Random rand = new Random();
            int upperbound = 10;
            int rng = rand.nextInt(upperbound);
            // 0 - 9

            if (rng == 0) {
                RandomJoinMessage = " has spawned into the server. Game on!";
            } else if (rng == 1) {
                RandomJoinMessage = " has joined the party. Let the quest begin!";
            } else if (rng == 2) {
                RandomJoinMessage = " has entered the arena. Who's up for a challenge?";
            } else if (rng == 3) {
                RandomJoinMessage = " has joined the guild. Our ranks are stronger!";
            } else if (rng == 4) {
                RandomJoinMessage = " has landed on our map. New adventures await!";
            } else if (rng == 5) {
                RandomJoinMessage = " has been summoned. The magic intensifies!";
            } else if (rng == 6) {
                RandomJoinMessage = " has logged in. Our team power just leveled up!";
            } else if (rng == 7) {
                RandomJoinMessage = " has arrived. Time for the boss battle!";
            } else if (rng == 8) {
                RandomJoinMessage = " is in the game. Ready for some epic loot!";
            } else {
                RandomJoinMessage = " has joined the game.";
            }

            player.sendMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.YELLOW + RandomJoinMessage);
        } else if (! player.hasPlayedBefore()) {
            player.sendMessage(ChatColor.DARK_PURPLE + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has joined for the first time.");

        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.RED + player.getDisplayName() + ChatColor.DARK_RED + " has left.");
    }

}
