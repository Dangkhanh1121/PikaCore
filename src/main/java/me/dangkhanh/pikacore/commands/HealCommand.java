package me.dangkhanh.pikacore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if(p.getHealth() == 20.0){
            p.sendMessage("Bạn đã đầy máu.");
        }else{
            p.setHealth(20.0);
            p.sendMessage("Hồi máu thành công.");
        }

        return true;
    }
}
