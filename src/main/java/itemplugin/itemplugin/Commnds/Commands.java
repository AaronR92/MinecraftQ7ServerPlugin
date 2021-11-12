package itemplugin.itemplugin.Commnds;

import itemplugin.itemplugin.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command");
            return true;
        }else {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (cmd.getName().equalsIgnoreCase("givebarbarianaxe")) {
                    //player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.BarbaranAxe);
                    player.getInventory().setItem(0, ItemManager.BarbaranAxe);
                }
                else {
                    sender.sendMessage("You are not allowed to use this command");
                }
            }
            return true;
        }
    }
}
