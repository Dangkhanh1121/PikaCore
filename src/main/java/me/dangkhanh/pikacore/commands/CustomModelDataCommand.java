package me.dangkhanh.pikacore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomModelDataCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            if(args.length != 0){
                Player p = (Player) sender;
                ItemStack item = new ItemStack(p.getEquipment().getItemInMainHand());
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setCustomModelData(Integer.parseInt(args[0]));
                item.setItemMeta(itemMeta);
                p.sendMessage("Set Custom Model to " + args[0]);
                p.getEquipment().setItemInMainHand(item);
            }
        }
        return true;

    }
}
