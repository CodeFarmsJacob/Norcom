package com.jellybeans.hp.spells;


import com.jellybeans.hp.ConfigManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import static com.jellybeans.hp.main.blockingPlayers;
import static com.jellybeans.hp.main.spalls;
import static java.lang.Thread.sleep;

public class confringo implements Listener {
    public Player player;


    public ConfigManager config = new ConfigManager();









    @EventHandler
    public void ConfrignoChatKeyword(AsyncPlayerChatEvent event) {
        player = event.getPlayer();

        if(event.getMessage().equalsIgnoreCase("confringo")) {


            spalls.remove(player.getUniqueId());
            spalls.put(player.getUniqueId(), "confringo");




        }

    }















    @EventHandler
    public void listenForClickConfringo(PlayerInteractEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand() != null) {

            if(spalls.containsKey(event.getPlayer().getUniqueId()) && spalls.get(event.getPlayer().getUniqueId()) == "confringo") {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {


                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, 100, -50);
                    event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Confringo");
                    spalls.remove(event.getPlayer().getUniqueId());

                    Player player = event.getPlayer();

                    Location start = player.getEyeLocation();

                    THE_LOOP:
                    for (int counter = 0; counter < 45; counter++) {

                        Vector increase = start.getDirection();
                        Location point = start.add(increase);
                        try{sleep(50);}catch (InterruptedException execption103037489734) {
                            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD +"ERROR, PLEASE REPORT TO ADMIN");
                        }
                        player.getLocation().getWorld().spawnParticle(Particle.LAVA, point, 20,1,1,1, 0);


                        if(!(point.getBlock().getType().equals(Material.AIR))) {


                            Block pointsIncendioSPOT = point.getBlock();

                            if(pointsIncendioSPOT.getType().isBurnable()) {

                                pointsIncendioSPOT.setType(Material.FIRE);
                                break THE_LOOP;
                            }
                            if(pointsIncendioSPOT.getLocation().add(0,1,0).getBlock().getType().equals(Material.AIR)) {


                                pointsIncendioSPOT.getLocation().add(0,1,0).getBlock().setType(Material.FIRE);
                            }





                            break THE_LOOP;
                        }

                        for(Entity e : point.getChunk().getEntities()) {

                            if(e.getLocation().distance(point) < 3.0) {
                                if(!e.equals(player)) {

                                    if (e instanceof Damageable) {

                                        if(e instanceof Player) {
                                            if (blockingPlayers.containsKey(e.getUniqueId())) {
                                                if (blockingPlayers.get(e.getUniqueId()).equalsIgnoreCase("protego")) {
                                                    break THE_LOOP;
                                                }
                                            }
                                        }


                                        ((Damageable) e).setFireTicks(1000);
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

