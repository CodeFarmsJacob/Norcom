package com.jellybeans.hp.spells;

import com.jellybeans.hp.main;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import org.bukkit.util.Vector;

import java.util.*;

import static com.jellybeans.hp.main.blockingPlayers;


public class Sectumsempra implements Listener {
    Plugin plugin = main.getPlugin(main.class);
    public HashMap<UUID, String> spalls = main.spalls;

    @EventHandler
    public void listenforSectumsempra(AsyncPlayerChatEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {

        if(event.getMessage().equalsIgnoreCase("sectumsempra") && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {



                spalls.remove(event.getPlayer().getUniqueId());
                spalls.put(event.getPlayer().getUniqueId(), "sectumsempra");


            }
        }

    }



    @EventHandler
    public void listenForClickSectumsempra(PlayerInteractEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand() != null) {

            if(spalls.containsKey(event.getPlayer().getUniqueId()) && spalls.get(event.getPlayer().getUniqueId()) == "sectumsempra") {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {


                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 100, 50000);
                    event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Sectumsempra");
                    spalls.remove(event.getPlayer().getUniqueId());

                    Player player = event.getPlayer();
                    Location start = player.getEyeLocation();
                    Vector increase = start.getDirection();


                    THE_LOOP:
                    for (int counter = 0; counter < 25; counter++) {
                        Location point = start.add(increase);

                       player.spawnParticle(Particle.TOWN_AURA, point, 1);

                       for(Entity e : point.getChunk().getEntities()) {

                            if(e.getLocation().distance(point) < 2.0) {
                                if(!e.equals(player)) {

                                    if (e instanceof Damageable) {

                                        if(e instanceof Player) {
                                            if (blockingPlayers.containsKey(e.getUniqueId())) {
                                                if (blockingPlayers.get(e.getUniqueId()).equalsIgnoreCase("protego")) {
                                                    break THE_LOOP;
                                                }
                                            }
                                        }

                                        ((Damageable) e).damage(1);
                                        break THE_LOOP;

                                    }

                                }
                                }

                            }

                       }


                    }


                }
                }
            }







    }



