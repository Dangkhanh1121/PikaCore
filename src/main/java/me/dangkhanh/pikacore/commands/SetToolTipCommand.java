package me.dangkhanh.pikacore.commands;

import me.dangkhanh.pikacore.Pikacore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SetToolTipCommand implements CommandExecutor {

    private Pikacore plugin = Pikacore.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;
            ItemStack item = p.getInventory().getItemInMainHand();
            ItemMeta itemMeta = item.getItemMeta();

            if(args.length == 4) {

                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                itemMeta.setDisplayName(plugin.getConfig().getString("offset") + ChatColor.WHITE + args[0] + plugin.getConfig().getString("offset"));
                ArrayList<String> lore = new ArrayList<>();

                lore.add(plugin.getConfig().getString("offset") + ChatColor.WHITE + args[1] + plugin.getConfig().getString("offset"));
                for(int i=1;i<=plugin.getConfig().getInt("middle");i++){
                    lore.add(plugin.getConfig().getString("offset") + ChatColor.WHITE + args[2] + plugin.getConfig().getString("offset"));
                }
                lore.add(plugin.getConfig().getString("offset") + ChatColor.WHITE + args[3] + plugin.getConfig().getString("offset"));
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);

                p.getInventory().setItemInMainHand(item);

            }else{
                p.sendMessage("Usage: /settooltip <header> <middle_header> <middle> <bottom>");
            }

        }else{
            System.out.println("You must be a player to execute this command");
        }

        return true;
    }
}
