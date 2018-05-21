package com.jellybeans.hp.spells;

import com.jellybeans.hp.ConfigManager;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;

import static com.jellybeans.hp.main.blockingPlayers;
import static com.jellybeans.hp.main.spalls;
import com.jellybeans.hp.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static java.lang.Thread.sleep;
import static org.bukkit.Bukkit.getOnlinePlayers;
import static org.bukkit.Bukkit.getPlayer;
import static org.bukkit.Bukkit.getServer;

public class incendio implements Listener{
    public Player player;


    public ConfigManager config = new ConfigManager();









        @EventHandler
        public void IncendioChatKeyword(AsyncPlayerChatEvent event) {
            player = event.getPlayer();

            if(event.getMessage().equalsIgnoreCase("incendio")) {


                spalls.remove(player.getUniqueId());
                spalls.put(player.getUniqueId(), "incendio");




            }

        }











        @EventHandler
    public void IncendioTouchBlock(BlockExplodeEvent e) {

            e.getBlock().setType(Material.FIRE);


        }



    @EventHandler
    public void listenForClickIncendio(PlayerInteractEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand() != null) {

            if(spalls.containsKey(event.getPlayer().getUniqueId()) && spalls.get(event.getPlayer().getUniqueId()) == "incendio") {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {


                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, 100, -50);
                    event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Incendio");
                    spalls.remove(event.getPlayer().getUniqueId());

                    Player player = event.getPlayer();
                    Location start = player.getEyeLocation();
                    Vector increase = start.getDirection();


                    THE_LOOP:
                    for (int counter = 0; counter < 25; counter++) {
                        Location point = start.add(increase);

                        player.spawnParticle(Particle.TOWN_AURA, point, 1);


                        if(!(point.getBlock().getType().equals(Material.AIR))) {


                            Block pointsIncendioSPOT = point.getBlock();

                                if(pointsIncendioSPOT.getType().isBurnable()) {
                                    try{sleep(1500);}catch (InterruptedException execption103037489734) {
                                        Bukkit.broadcastMessage(player.getDisplayName() + "Had issues with the timing of Incendio... ");
                                    }
                                    pointsIncendioSPOT.setType(Material.FIRE);
                                    break THE_LOOP;
                                }
                                if(pointsIncendioSPOT.getLocation().add(0,1,0).getBlock().getType().equals(Material.AIR)) {
                                    try{sleep(500);}catch (InterruptedException execption103037489734) {
                                        Bukkit.broadcastMessage(player.getDisplayName() + "Had issues with the timing of Incendio...(ladder)");
                                    }

                                    pointsIncendioSPOT.getLocation().add(0,1,0).getBlock().setType(Material.FIRE);
                                }





                            break THE_LOOP;
                        }

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


                                        ((Damageable) e).setFireTicks(100);
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
