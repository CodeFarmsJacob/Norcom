package com.jellybeans.hp.items;

import com.jellybeans.hp.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class getInvisCload  implements Listener {

    public ItemStack cloak = new ItemStack(Material.LEATHER_CHESTPLATE);
    public ItemMeta mCloak = cloak.getItemMeta();
    private Plugin plugin = main.getPlugin(main.class);

    public void grantInvisCload(Player player) {

        mCloak.setDisplayName(ChatColor.GRAY + "Invisibility Cloak");
        ArrayList<String> lCloak = new ArrayList<String>();
        lCloak.add(ChatColor.BLACK + "An invisibile cloak, charmed by");
        lCloak.add(ChatColor.AQUA + player.getName());
        mCloak.setLore(lCloak);
        mCloak.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        cloak.setItemMeta(mCloak);
        player.getInventory().addItem(cloak);

    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {


        Player player = event.getPlayer();


        if (event.isSneaking() && !(player.getInventory().equals(null))) {

            if (player.getInventory().getChestplate() != null && !(player.getInventory().getChestplate().equals(Material.AIR))) {

                if (player.getInventory().getChestplate().hasItemMeta()) {

                    String testM = player.getInventory().getChestplate().getItemMeta().getDisplayName();

                    if (testM.equalsIgnoreCase(ChatColor.GRAY + "Invisibility Cloak")) {


                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {

                            p.hidePlayer(player);

                        }

                        player.sendMessage(ChatColor.BLACK + "" + ChatColor.ITALIC + "You are now cloaked");


                    }


                }
            }


            if (!event.isSneaking()) {

                if (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().hasItemMeta()) {

                    String testM = player.getInventory().getChestplate().getItemMeta().getDisplayName();
                    if (testM.equalsIgnoreCase(ChatColor.GRAY + "Invisibility Cloak")) {


                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {

                            p.showPlayer(player);

                        }

                        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You are now visible");


                    }
                }

            }

        }

    }


}
