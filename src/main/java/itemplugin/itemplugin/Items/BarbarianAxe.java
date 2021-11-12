package itemplugin.itemplugin.Items;

import itemplugin.itemplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BarbarianAxe implements Listener {

    Main plugin;

    public BarbarianAxe(Main plugin) {
        this.plugin = plugin;
    }

//    @EventHandler
//    public void onClick(InventoryClickEvent event) {
//        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().getLore() != null
//        && event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.GOLD + "Item Ability: Lumberjack")) {
//            String zombie = plugin.getConfig().getString("barbarianaxe.zombie");
//
//            ItemMeta meta = event.getCurrentItem().getItemMeta();
//            List<String> lore = new ArrayList<>(meta.getLore());
//
//            lore.set(6, ChatColor.GRAY + "Zombies: " + ChatColor.RED + zombie +"%");
//
//            meta.setLore(lore);
//            event.getCurrentItem().setItemMeta(meta);
//        }
//    }

    /*@EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        //if (!(event.getEntity() instanceof Player)) {
            //Player player = (Player) event.getDamager();
            Entity entity = (Entity) event.getDamager();
            if (player.getInventory().getItemInMainHand().hasItemMeta() &&
                    player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() &&
                    player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1001) {
                if (event.getEntity() instanceof Zombie) {
                    int zombie = plugin.getConfig().getInt("barbarianaxe.zombie");
                    event.setDamage(event.getDamage() + (event.getDamage() * zombie / 100));
                } else if (event.getEntity() instanceof Skeleton) {
                    int skeleton = plugin.getConfig().getInt("barbarianaxe.skeleton");
                    event.setDamage(event.getDamage() + (event.getDamage() * skeleton / 100));
                }
                player.sendMessage(String.valueOf(event.getDamage()));
            }
        //}
    }*/

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        //if (!(event.getEntity() instanceof Player)) {
        //Player player = (Player) event.getDamager();
        Entity entity = (Entity) event.getDamager();
        if (entity instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player.getInventory().getItemInMainHand().hasItemMeta() &&
                    player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() &&
                    player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1001) {
                if (event.getEntity() instanceof Zombie) {
                    int zombie = plugin.getConfig().getInt("barbarianaxe.zombie");
                    event.setDamage(event.getDamage() + (event.getDamage() * zombie / 100));
                } else if (event.getEntity() instanceof Skeleton) {
                    int skeleton = plugin.getConfig().getInt("barbarianaxe.skeleton");
                    event.setDamage(event.getDamage() + (event.getDamage() * skeleton / 100));
                }
                player.sendMessage("Сделано урона: " + String.valueOf(event.getDamage()));
            }
        }
    }
}
