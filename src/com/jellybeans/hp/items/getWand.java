package com.jellybeans.hp.items;

import com.jellybeans.hp.main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;


import java.util.ArrayList;

public class getWand {

    public ItemStack wand = new ItemStack(Material.STICK, 1);
    public ItemMeta wMeta = wand.getItemMeta();
    private Plugin plugin = main.getPlugin(main.class);
    public void grantWand(Player player) {

        wMeta.setDisplayName(ChatColor.DARK_PURPLE + "Wand");
        ArrayList<String> wLore = new ArrayList<String>();
        wLore.add(ChatColor.AQUA + player.getName() + "'s Wand");
        wMeta.setLore(wLore);
        wMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        wand.setItemMeta(wMeta);
        player.getInventory().addItem(wand);

    }

    public void wandRecipe() {

        wMeta.setDisplayName(ChatColor.DARK_PURPLE + "Wand");
        ArrayList<String> wLore = new ArrayList<String>();
        wLore.add(ChatColor.AQUA + "A magical wand, not yet claimed");
        wMeta.setLore(wLore);
        wMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        wand.setItemMeta(wMeta);
        ShapedRecipe wRecipe = new ShapedRecipe(new NamespacedKey(plugin, "wand"), wand);
        wRecipe.shape(" $ "," # "," $ ");
        wRecipe.setIngredient('$', Material.STICK);
        wRecipe.setIngredient('#', Material.FEATHER);

        plugin.getServer().addRecipe(wRecipe);


    }


}
