package me.dangkhanh.pikacore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerMoveEvent implements Listener {

    @EventHandler
    public void onMove(org.bukkit.event.player.PlayerMoveEvent e){
        Player p = e.getPlayer();
        e.setCancelled(!p.hasPermission("core.move"));
    }
}
