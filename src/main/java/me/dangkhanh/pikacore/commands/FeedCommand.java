package me.dangkhanh.pikacore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.getFoodLevel() == 20.0D) {
                p.sendMessage(ChatColor.RED + " " + ChatColor.ITALIC + "You aren't hungry yet :/");
            } else {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "Successfully feed");
            }
        }
        return true;
    }
}

