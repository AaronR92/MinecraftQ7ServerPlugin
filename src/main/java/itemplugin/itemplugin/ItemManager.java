package itemplugin.itemplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemManager {

    public static ItemStack BarbaranAxe;

    public static void init() {
        createBarbarianAxe();
    }

    private static void createBarbarianAxe() {
        ItemStack item = new ItemStack(Material.GOLDEN_AXE,1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Топор варвара");
        meta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Урон: " + ChatColor.RED + "18");
        lore.add(ChatColor.GRAY + "Скорость атаки: " + ChatColor.RED + "1.4");
        lore.add(ChatColor.GOLD + "Неразрушимый");
        lore.add("");
        lore.add(ChatColor.GOLD + "Способность предмета: Дровосек");
        lore.add(ChatColor.GRAY + "Урон по некоторым врагам удвоен");
        lore.add(ChatColor.GRAY + "Зомби: " + ChatColor.RED + "100%");
        lore.add(ChatColor.GRAY + "Скелеты: " + ChatColor.RED + "100%");
        lore.add("");
        meta.setLore(lore);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 17, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier attackSpeed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 1.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeed);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(1001);

        item.setItemMeta(meta);
        BarbaranAxe = item;
    }
}
