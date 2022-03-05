package me.dangkhanh.pikacore.events;

import me.dangkhanh.pikacore.Pikacore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class BombEvent implements Listener {
    private Pikacore plugin = Pikacore.getPlugin(Pikacore.class);
    @EventHandler
    public void onGrenadeLaunch(PlayerInteractEvent e){

        ItemStack item = e.getItem();
        Player p = e.getPlayer();
        Action act = e.getAction();
        Location loc = p.getLocation();
        loc.setY(loc.getY() + 1);

        if(item == null){
            return;
        }

        if(act.equals(Action.RIGHT_CLICK_AIR) || act.equals(Action.RIGHT_CLICK_BLOCK)){
            if(item.getType().equals(Material.BIRCH_BUTTON)){
                item.setAmount(item.getAmount() - 1);
                ItemStack bomb = new ItemStack(item.getType(), 1);
                Entity drop = loc.getWorld().dropItemNaturally(loc, bomb);
                Location bombloc = drop.getLocation();
                drop.setVelocity(loc.getDirection().multiply(2));
                new BukkitRunnable(){

                    @Override
                    public void run() {
                        loc.getWorld().createExplosion(bombloc, 10, true);
                    }
                }.runTaskLater(plugin, 40);
            }
        }
    }
}
