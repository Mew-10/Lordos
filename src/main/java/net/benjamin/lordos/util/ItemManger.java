package net.benjamin.lordos.util;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemManger {
    public static ItemStack TeleportSword;
    public static ItemStack ThrowingAxe;

    public static void init(){
        createTeleportSword();
        createThrowingAxe();
    }


    private static void createTeleportSword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Teleport Sword");
        List<String> lore = new ArrayList();
        lore.add("§5EPIC");
        lore.add("§7This sword has teleport powers.");
        lore.add("§6Item Ability (Right Click):");
        lore.add("§fTeleport 8 blocks ahead");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage",
                25.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed",
                0.05, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
        item.setItemMeta(meta);
        TeleportSword = item;
    }
    private static void createThrowingAxe() {
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Throwing Axe");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+70");
        lore.add("");
        lore.add("§6Item Ability: Throw §eRIGHT CLICK");
        lore.add("§7Throw your axe and deal");
        lore.add("§c1,000 §7damage.");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 70.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(meta);
        ThrowingAxe = item;
    }

}
