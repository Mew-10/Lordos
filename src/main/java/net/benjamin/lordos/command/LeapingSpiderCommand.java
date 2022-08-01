package net.benjamin.lordos.command;

import net.benjamin.lordos.util.LeapingSpider;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeapingSpiderCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                if(cmd.getName().equalsIgnoreCase("leapingspider")){
                    LeapingSpider.createLeapingSpider(player.getLocation());
                }
            }
            else{
                player.sendMessage("No");
            }
            return true;
        }
        else{
            sender.sendMessage("Only players no you");
            return true;
        }
    }
}
