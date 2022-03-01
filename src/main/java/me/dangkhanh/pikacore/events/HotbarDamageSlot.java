package me.dangkhanh.pikacore.events;

import me.dangkhanh.pikacore.Pikacore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HotbarDamageSlot implements Listener {
    private Pikacore plugin = Pikacore.getInstance();
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            if (p.getInventory().getHeldItemSlot() != plugin.getConfig().getInt("slot")) {
                e.setCancelled(true);
            }
        }
    }
}
