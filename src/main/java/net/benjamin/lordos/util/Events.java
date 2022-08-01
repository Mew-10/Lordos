package net.benjamin.lordos.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class Events implements Listener {

    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent e){
        e.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "Are You A Admin Or A Hacker");
    }
}

