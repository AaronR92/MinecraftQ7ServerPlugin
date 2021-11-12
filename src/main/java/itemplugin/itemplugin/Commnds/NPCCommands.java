package itemplugin.itemplugin.Commnds;

import itemplugin.itemplugin.NPCManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NPCCommands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("createNPCKnight")) {                            //new npc
            if (player.isOp()) {
                if (!(sender instanceof Player)) {
                    player.sendMessage("Only players can use this command!");
                    return true;
                }
                NPCManager.createNPCKnight1(player);
                player.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "KNIGHT CREATED");
            }else {
                player.sendMessage(ChatColor.RED + "Only Admins can use this command!");
            }
        }
        if (label.equalsIgnoreCase("createNPCTravellerGuide1")) {            //new npc
            if (player.isOp()) {
                if (!(sender instanceof Player)) {
                    player.sendMessage("Only players can use this command!");
                    return true;
                }
                NPCManager.createNPCTravellerGuide1(player);
                player.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "TRAVELLER CREATED");
            }else {
                player.sendMessage(ChatColor.RED + "Only Admins can use this command!");
            }
        }
        return false;
    }
}
