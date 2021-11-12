package itemplugin.itemplugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPhysicsEvent;

public class EventManager extends Object implements Listener {

    @EventHandler
    public void onGrow(BlockGrowEvent e) {
        if (e.getBlock().getType() == Material.WHEAT_SEEDS) {
            e.setCancelled(true);
        }
        if (e.getBlock().getType() == Material.WHEAT) {
            e.setCancelled(true);
        }
        if (e.getBlock().getType() == Material.POTATO) {
            e.setCancelled(true);
        }
        if (e.getBlock().getType() == Material.CARROT) {
            e.setCancelled(true);
        }
        if (e.getBlock().getType() == Material.CACTUS) {
            e.setCancelled(true);
        }
        if (e.getBlock().getType() == Material.SUGAR_CANE) {
            e.setCancelled(true);
        }
        if (e.getBlock().getType() == Material.VINE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPhysicsChange(BlockPhysicsEvent e) {
        if (e.getBlock().getType() == Material.VINE
                || e.getBlock().getType() == Material.CACTUS
                || e.getBlock().getType() == Material.SUGAR_CANE
                || e.getBlock().getType() == Material.WHEAT) {
            e.setCancelled(true);
        }
        if (e.getChangedType() == Material.DIRT) {
            e.setCancelled(true);
        }
    }
}

