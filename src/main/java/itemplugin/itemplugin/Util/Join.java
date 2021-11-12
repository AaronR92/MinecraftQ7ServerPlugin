package itemplugin.itemplugin.Util;

import itemplugin.itemplugin.NPCManager;
import itemplugin.itemplugin.PacketReader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (NPCManager.getNPCs() == null)
            return;
        if (NPCManager.getNPCs().isEmpty())
            return;
        NPCManager.addJoinPacket(event.getPlayer());

        PacketReader reader = new PacketReader();
        reader.inject(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        PacketReader reader = new PacketReader();
        reader.uninject(event.getPlayer());
    }
}
