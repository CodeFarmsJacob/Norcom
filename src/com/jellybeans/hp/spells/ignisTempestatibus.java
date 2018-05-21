package com.jellybeans.hp.spells;

import com.jellybeans.hp.ConfigManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import static com.jellybeans.hp.main.blockingPlayers;
import static com.jellybeans.hp.main.spalls;
import static java.lang.Thread.sleep;

public class ignisTempestatibus implements Listener {

    public Player player;


    public ConfigManager config = new ConfigManager();









    @EventHandler
    public void IgnisTChatKeyword(AsyncPlayerChatEvent event) {
        player = event.getPlayer();

        if(event.getMessage().equalsIgnoreCase("ignis tempestatibus")) {


            spalls.remove(player.getUniqueId());
            spalls.put(player.getUniqueId(), "ignis tempestatibus");




        }

    }















    @EventHandler
    public void listenForClickIgnisT(PlayerInteractEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand() != null) {

            if(spalls.containsKey(event.getPlayer().getUniqueId()) && spalls.get(event.getPlayer().getUniqueId()) == "ignis tempestatibus") {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {


                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, 100, -50);
                    event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Ignis Tempestatibus");
                    spalls.remove(event.getPlayer().getUniqueId());

                    Player player = event.getPlayer();
                    Location start = player.getEyeLocation();


                    THE_LOOP:
                    for (int counter = 0; counter < 45; counter++) {
                    player.setVelocity(new Vector(0,0,0));
                        try{sleep(50);}catch (InterruptedException adfkajsdfkljasdifjadklswfj) {

                        }

                        Vector increase = start.getDirection();

                        Location point = start.add(increase.multiply(2));

                        player.getLocation().getWorld().spawnParticle(Particle.FLAME, point, 200,2,2,2, 0);


                        if(!(point.getBlock().getType().equals(Material.AIR))) {


                            Block pointsIncendioSPOT = point.getBlock();

                            if(pointsIncendioSPOT.getType().isBurnable()) {

                                pointsIncendioSPOT.setType(Material.FIRE);

                            }
                            if(pointsIncendioSPOT.getLocation().add(0,1,0).getBlock().getType().equals(Material.AIR)) {


                                pointsIncendioSPOT.getLocation().add(0,1,0).getBlock().setType(Material.FIRE);
                            }






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
