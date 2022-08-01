package net.benjamin.lordos.command;

import net.benjamin.lordos.util.ItemManger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveTeleportSwordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("op")) {
                if (command.getName().equalsIgnoreCase("giveteleportsword")){
                    player.getInventory().addItem(ItemManger.TeleportSword);
                }
                if(command.getName().equalsIgnoreCase("givethrowingaxe")) {
                    player.getInventory().addItem(ItemManger.ThrowingAxe);
                }
            }
            else {
                sender.sendMessage("You are not allowed to use this command");
            }
            return true;
        }
        else {
            sender.sendMessage("Only players can use that command");
            return true;
        }
    }
}

