package com.jellybeans.hp.spells;

import com.jellybeans.hp.main;
import net.minecraft.server.v1_12_R1.EnumParticle;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

import static com.jellybeans.hp.main.blockingPlayers;
import static java.lang.Thread.sleep;

public class avadaKadavara implements Listener {
    Plugin plugin = main.getPlugin(main.class);
    public HashMap<UUID, String> spalls = main.spalls;

    @EventHandler
    public void listenforDeathCurse(AsyncPlayerChatEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {

            if(event.getMessage().equalsIgnoreCase("avada kedavra") && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {



                spalls.remove(event.getPlayer().getUniqueId());
                spalls.put(event.getPlayer().getUniqueId(), "avada kedavra");


            }
        }

    }



    @EventHandler
    public void listenForClickDeathCurse(PlayerInteractEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand() != null) {

            if(spalls.containsKey(event.getPlayer().getUniqueId()) && spalls.get(event.getPlayer().getUniqueId()) == "avada kedavra") {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {


                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 100, 500);
                    event.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Avada Kedavra");
                    spalls.remove(event.getPlayer().getUniqueId());

                    Player player = event.getPlayer();
                    Location start = player.getEyeLocation();
                    Vector increase = start.getDirection();


                    THE_LOOP:
                    for (double counter = 0; counter <= 25; counter+=1) {
                        try {
                            sleep(50);
                        }catch (InterruptedException execptionForUrMOM) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "[Wand] There is too much good in you, fight it!");
                        }
                        Location point = start.add(increase);

                        player.getLocation().getWorld().spawnParticle(Particle.REDSTONE, point.getX(), point.getY(), point.getZ(), 0, 0.001, 1,0 , 10);

                        if(player.getWorld().getBlockAt(point).getType().equals(Material.BARRIER)) {


                            break THE_LOOP;
                        }

                        for(Entity e : point.getChunk().getEntities()) {

                            if(e.getLocation().distance(point) < 1.5) {
                                if(!e.equals(player)) {


                                    if(e instanceof Player) {

                                        if(((Player) e).isBlocking()) {

                                            break THE_LOOP;

                                        }

                                    }

                                    if (e instanceof Damageable) {



                                        if(e instanceof Player) {
                                            if (blockingPlayers.containsKey(e.getUniqueId())) {
                                                if (blockingPlayers.get(e.getUniqueId()).equalsIgnoreCase("protego")) {
                                                    break THE_LOOP;
                                                }
                                            }
                                        }
                                            ((Damageable) e).damage(100000000);
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

