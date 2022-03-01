package me.dangkhanh.pikacore.commands;

import me.dangkhanh.pikacore.Pikacore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSlotCommand implements CommandExecutor {
    private Pikacore plugin = Pikacore.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
           if(args.length > 0){
               plugin.getConfig().set("slot",Integer.parseInt(args[0]));
               plugin.saveConfig();
               p.sendMessage("Successfully set new damageable slot to " + args[0]);
           }else{
               p.sendMessage("You must specify an arg.");
           }
        }else{
            System.out.println("You must be a player to execute this command");
        }
        return true;
    }
}
