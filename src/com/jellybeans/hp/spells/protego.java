package com.jellybeans.hp.spells;

import com.jellybeans.hp.main;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import static com.jellybeans.hp.main.blockingPlayers;
import static java.lang.Thread.sleep;

public class protego implements Listener {

    Plugin plugin = main.getPlugin(main.class);
    public HashMap<UUID, String> spalls = main.spalls;

    @EventHandler
    public void listenForProtego(AsyncPlayerChatEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {

            if(event.getMessage().equalsIgnoreCase("protego") && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {



                spalls.remove(event.getPlayer().getUniqueId());
                spalls.put(event.getPlayer().getUniqueId(), "protego");


            }
        }

    }



    @EventHandler
    public void listenForShiftProtego(PlayerToggleSneakEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand() != null) {

            if(spalls.containsKey(event.getPlayer().getUniqueId()) && spalls.get(event.getPlayer().getUniqueId()) == "protego") {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {


                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 100, 500);





                    if(event.isSneaking()) {
                        Player player = event.getPlayer();

                        event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Protego");
                        blockingPlayers.remove(player.getUniqueId());
                        blockingPlayers.put(player.getUniqueId(), "protego");

                            }

                            if(!(event.isSneaking())) {

                                    blockingPlayers.remove(event.getPlayer().getUniqueId());

                                spalls.remove(event.getPlayer().getUniqueId());
                            }


                        }


                    }


                }
            }
        }






