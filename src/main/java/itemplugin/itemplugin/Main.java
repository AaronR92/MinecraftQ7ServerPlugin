package itemplugin.itemplugin;

import itemplugin.itemplugin.Commnds.Commands;
import itemplugin.itemplugin.Commnds.NPCCommands;
import itemplugin.itemplugin.Items.BarbarianAxe;
import itemplugin.itemplugin.Util.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;

    public NPCManager npcManager;

    public static Main getInstance() {
        return instance;
    }

    private void setInstance (Main instance) {
        this.instance = instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("\nItemplugin has enabled\n");

        setInstance(this);

        //NPC
        this.getCommand("createNPCKnight").setExecutor(new NPCCommands());
        this.getCommand("createNPCTravellerGuide1").setExecutor(new NPCCommands());
        this.getCommand("createNPCKraresWizard").setExecutor(new NPCCommands());
        this.getServer().getPluginManager().registerEvents(new Join(), this);
        this.getServer().getPluginManager().registerEvents(new ClickNPC(), this);
        if (!Bukkit.getOnlinePlayers().isEmpty())                   //If people still on the server we are making sure we send packets, to enable clicking npc
            for (Player player : Bukkit.getOnlinePlayers()) {
                PacketReader reader = new PacketReader();
                reader.inject(player);
            }

        ItemManager.init();

        // Events
        getServer().getPluginManager().registerEvents(new EventManager(), instance);

        // Item commands
        this.getCommand("givebarbarianaxe").setExecutor(new Commands());

        // Items
        this.getServer().getPluginManager().registerEvents(new BarbarianAxe(this), this);

        //Config
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("\nItemplugin has disabled\n");

        //NPC
        for (Player player : Bukkit.getOnlinePlayers()) {
            PacketReader reader = new PacketReader();
            reader.uninject(player);
        }
    }

    //Работает, но смысла нет т.к. используется NPCCommands
    /*public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("createnpc")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            Player player = (Player) sender;
            /*if (args.length == 0) {
                NPCManager.createNPCKnight1(player, player.getName());
                player.sendMessage("KNIGHT CREATED");
                return true;
            }
            NPCManager.createNPCKnight1(player);
            player.sendMessage("KNIGHT CREATED");
            return true;
        }
        return false;
    }
    */
}
