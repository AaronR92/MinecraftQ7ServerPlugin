package itemplugin.itemplugin.Util;

import itemplugin.itemplugin.NPCEvents.RightClickNPCTravellerGuide;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ClickNPC implements Listener {

    Timer timer = new Timer();

    String lang = "en";

    @EventHandler
    public void onClick(RightClickNPCTravellerGuide event) {
        Player player = event.getPlayer();
        String pName = event.getPlayer().getName();
        //Hashmap
        //Map<String, Long> cooldowns = new HashMap<String, Long>();

        //Adds player to cooldown hashmap
        //cooldowns.put(player.getName(), System.currentTimeMillis() + 10*1000);
        if (lang == "ru") {
            player.sendMessage(ChatColor.DARK_GREEN + "<Путешественник> " + ChatColor.RESET + "Приветствую тебя, паладин " + ChatColor.AQUA + ChatColor.ITALIC + pName + ChatColor.RESET +
                    "!");

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.DARK_GREEN + "<Путешественник> " + ChatColor.RESET + "Этот мир называется " + ChatColor.YELLOW + ChatColor.ITALIC + "Авиррул" +
                            ChatColor.RESET + " и ему грозит большая опасность!");
                }
            }, 3000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.DARK_GREEN + "<Путешественник> " + ChatColor.RESET + "Ты был призван сюда для защиты от злых демонов, желающих захватить власть!");
                }
            }, 6000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.DARK_GREEN + "<Путешественник> " + ChatColor.RESET + "Иди в замок и найди там " + ChatColor.DARK_GREEN + ChatColor.ITALIC + "Алдиса" +
                            ChatColor.RESET + ". Он расскажет где достать оружие и броню!");
                }
            }, 9500);

        } else if (lang == "en") {
            player.sendMessage(ChatColor.DARK_GREEN + "<Traveller> " + ChatColor.RESET + "Welcome paladin " + ChatColor.AQUA + ChatColor.ITALIC + pName + ChatColor.RESET +
                    "!");

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.DARK_GREEN + "<Traveller> " + ChatColor.RESET + "This world is called " + ChatColor.YELLOW + ChatColor.ITALIC + "Avirrul" +
                            ChatColor.RESET + " and it is on a big danger!");
                }
            }, 3000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.DARK_GREEN + "<Traveller> " + ChatColor.RESET + "Ты был призван сюда для защиты от злых демонов, желающих захватить власть!");
                }
            }, 6000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.sendMessage(ChatColor.DARK_GREEN + "<Traveller> " + ChatColor.RESET + "Иди в замок и найди там " + ChatColor.DARK_GREEN + ChatColor.ITALIC + "Алдиса" +
                            ChatColor.RESET + ". Он расскажет где достать оружие и броню!");
                }
            }, 9500);
        }
    }
}
