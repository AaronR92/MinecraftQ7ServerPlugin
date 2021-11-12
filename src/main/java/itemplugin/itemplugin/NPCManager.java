package itemplugin.itemplugin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.util.UUIDTypeAdapter;
import itemplugin.itemplugin.Main;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NPCManager {

/*    private Location location;
    private String name;
    private GameProfile gameProfile;
    private EntityPlayer entityPlayer;
    private String texture;
    private String signature;

    public NPC(Location location, String name, String texture, String signature) {
        this.location = location;
        this.name = name;
        this.texture = texture;
        this.signature = signature;
    }

    public void Spawn() {
        MinecraftServer minecraftServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer worldServer = ((CraftWorld) location.getWorld()).getHandle();

        this.gameProfile = new GameProfile(UUID.randomUUID(), ChatColor.RED + "" + ChatColor.BOLD + "Knight");
        this.gameProfile.getProperties().put("textures", new Property(texture, signature));
    }
*/

/*    public void createNetherNPC(Player player, String npcName) {

        Location location = player.getLocation();

        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) player.getWorld()).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), ChatColor.RED + "Узник ада");

        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld));
        Player npcPlayer = npc.getBukkitEntity().getPlayer();
        npcPlayer.setPlayerListName("Nether npc");
        //npcName.equalsIgnoreCase("Узник ада");
        //npcName = "Узник ада";

        npc.setLocation(location.getX(), location.getY(), location.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());

        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256 / 360)));
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));

    }*/

    private static List<EntityPlayer> NPC = new ArrayList<EntityPlayer>();

    private Main plugin = Main.getInstance();

    public static void createNPCKnight1(Player player) {
        Main plugin = Main.getInstance();

        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Bukkit.getWorld(player.getWorld().getName())).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), ChatColor.RED + "Knight");
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, new PlayerInteractManager(world));


        npc.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(),
                player.getLocation().getYaw(), player.getLocation().getPitch());
        npc.getDataWatcher().set(new DataWatcherObject<>(16, DataWatcherRegistry.a), (byte)127);

        //Changing Skin
        String value = plugin.getConfig().getString("TextureKnight1");
        String signature = plugin.getConfig().getString("SignatureKnight1");
        gameProfile.getProperties().put("textures", new Property("textures", value, signature));

        addNPCPacket(npc);
        NPC.add(npc);
    }

    public static void createNPCTravellerGuide1(Player player) {
        Main plugin = Main.getInstance();

        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Bukkit.getWorld(player.getWorld().getName())).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), ChatColor.DARK_GREEN + "Путешественник");
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, new PlayerInteractManager(world));

        npc.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(),
                player.getLocation().getYaw(), player.getLocation().getPitch());
        npc.getDataWatcher().set(new DataWatcherObject<>(16, DataWatcherRegistry.a), (byte)127);

        //Changing Skin
        String value = plugin.getConfig().getString("TextureTraveller");
        String signature = plugin.getConfig().getString("SignatureTraveller");
        gameProfile.getProperties().put("textures", new Property("textures", value, signature));

        addNPCPacket(npc);
        NPC.add(npc);
    }

    public static void createNPCKraresWizard(Player player) {
        Main plugin = Main.getInstance();

        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Bukkit.getWorld(player.getWorld().getName())).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), ChatColor.DARK_GREEN + "Wizard");
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, new PlayerInteractManager(world));

        npc.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(),
                player.getLocation().getYaw(), player.getLocation().getPitch());
        npc.getDataWatcher().set(new DataWatcherObject<>(16, DataWatcherRegistry.a), (byte) 127);


        String value = new String(Base64.encodeBase64(("{\"timestamp\" : 1636916551322,\"profileId\" : \"f1553ca2934d47f5993bda76e3c9a259\",\"profileName\" : \"Snowie92\",\"signatureRequired\" : true,\"textures\":{\"SKIN\" : {\"url\" : \"https://i.n-mc.co/14d89bdec08d5797.png\"}}}}").getBytes()));
        String signature = "uqMtXiGMxO+mCFVjv12cWBiioYbGCy6VjXLgZiWMfjs3nqCNrGjXSRfzRHcUQtyODYNrdHp+tOXIqrx7pNp19vEZOHSEaQ5o3yL7BsSYrhNGcA3lBulM9ntGLhIx8vysV+jUGVDiDoMQ4E3Yb/ZBS95o+oNUWQEJ+muTaG4WqrTyqWSNuYFVxBgFpEhhOyF6wV1uTFe0QgG2u8SGjm4EVZ0zvmCpluHCNnaYG2HyN1qYeHlTXwz8Miv1fTkmTKFVF91AsfvjNxn0/1t64XfCkpYtDF7OElVdbhf8eCCJvWZYzJ1/uDdxjJZddLbfQya5XJ5t/avBrLlicAfqPnv69WFQeCkHZTneKgUATQqByYkyWQh2nF/soLD8aFvoATkYty+aIzw9EYCGcuuu5LTvoc6cP/2WdGqwrvJWA1TbI5/R0wTY+NTcBkYroTVnv3apvLqmvAwbK6V1stGm8fC7H4DxGZE20pAqFSbyCQgAD+iPLPqT8CSonD7cA3hndXrkWHOl52NhtExSasC00zr0EDEzo4HqXUKkv7LjcrSVPpCawJYGfHDwFQp+W7M0m6kHLU0a4bYguNlJUUaYIfNNPuGFBJgTdHAtGdLkn/jbYm+Flrhzpff/QUrE2iMMR66X26u2u2K+4QDAj+na6jA7BxKd8OTUpyx+X+xvZzVzYXg=";

        gameProfile.getProperties().put("textures", new Property("textures", value, signature));

        /*try {
            HttpsURLConnection connection = (HttpsURLConnection) new URL(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", UUIDTypeAdapter.fromUUID(gameProfile.getId()))).openConnection();
            if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                String reply = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
                String skin = reply.split("\"value\":\"")[1].split("\"")[0];
                String signature = reply.split("\"signature\":\"")[1].split("\"")[0];
                gameProfile.getProperties().put("textures", new Property("textures", skin, signature));
                return true;
            } else {
                System.out.println("Connection could not be opened (Response code " + connection.getResponseCode() + ", " + connection.getResponseMessage() + ")");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }*/
    }

    /*public static void changeSkinKnight(GameProfile profile) {
        Main plugin = Main.getInstance();

        String texture = plugin.getConfig().getString("TextureKnight1");
        String signature = plugin.getConfig().getString("SignatureKnight1");
        profile.getProperties().put("textures", new Property("textures",texture,signature));
    }

    private static String[] getSkin(Player player, String name) {
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            String uuid = new JsonParser().parse(reader).getAsJsonObject().get("id").getAsString();

            URL url2 = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");
            InputStreamReader reader2 = new InputStreamReader(url2.openStream());
            JsonObject property = new JsonParser().parse(reader2).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();
            String texture = property.get("value").getAsString();
            String signature = property.get("signature").getAsString();

            return new String[] {texture, signature};

            /*
             * player:
             *    properties:
             *        texture: asdwdgrgsfdgfd
             *        signature: sadasdsadafwsf
             */

/*        } catch (Exception e) {
            EntityPlayer p = ((CraftPlayer) player).getHandle();
            GameProfile profile = p.getProfile();
            Property property = profile.getProperties().get("textures").iterator().next();
            String texture = property.getValue();
            String signature = property.getSignature();
            return new String[] {texture, signature};
        }
    }*/

    public static void addNPCPacket(EntityPlayer npc) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256 / 360)));
            connection.sendPacket(new PacketPlayOutEntityMetadata(npc.getId(), npc.getDataWatcher(), true));
            //connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
        }
    }

    public static void addJoinPacket(Player player) {
        for (EntityPlayer npc : NPC) {
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256 / 360)));
            //connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
        }
    }

    public static List<EntityPlayer> getNPCs() {
        return NPC;
    }
}