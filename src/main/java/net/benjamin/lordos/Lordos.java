package net.benjamin.lordos;

import net.benjamin.lordos.command.GiveTeleportSwordCommand;
import net.benjamin.lordos.command.LeapingSpiderCommand;
import net.benjamin.lordos.util.Events;
import net.benjamin.lordos.util.ItemManger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lordos extends JavaPlugin {

    @Override
    public void onEnable() {

        NamespacedKey key = new NamespacedKey(this, "teleportsword");
        NamespacedKey keyt = new NamespacedKey(this, "throwingaxe");
        ShapedRecipe recipet = new ShapedRecipe(new ItemStack(ItemManger.ThrowingAxe));
        recipet.shape(
                " I ",
                " N ",
                " D ");
        recipet.setIngredient('I', Material.IRON_AXE);
        recipet.setIngredient('S', Material.NETHERITE_AXE);
        recipet.setIngredient('S', Material.DIAMOND_AXE);
        ShapedRecipe recipe = new ShapedRecipe(new ItemStack(ItemManger.TeleportSword));
        recipe.shape(
                " E ",
                " E ",
                " S ");
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
        Bukkit.addRecipe(recipet);

        Bukkit.getPluginManager().registerEvents(new Events(), this);
        System.out.println("Hey");
        getCommand("leapingspider").setExecutor(new LeapingSpiderCommand());
        getCommand("giveteleportsword").setExecutor(new GiveTeleportSwordCommand());
        getCommand("givethrowingaxe").setExecutor(new GiveTeleportSwordCommand());
        ItemManger.init();
    }

    @Override
    public void onDisable() {
    }
}
