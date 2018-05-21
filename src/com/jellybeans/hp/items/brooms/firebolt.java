package com.jellybeans.hp.items.brooms;

import com.jellybeans.hp.main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;

import static com.jellybeans.hp.main.flyingPlayerSpeed;
import static com.jellybeans.hp.main.flyingPlayers;

public class firebolt implements Listener {
    public ItemStack firebolt = new ItemStack(Material.STICK, 1);
    public ItemMeta fireboltMeta = firebolt.getItemMeta();

    public void grantBroom(Player player) {
        fireboltMeta.setDisplayName(ChatColor.RED + "" + ChatColor.ITALIC + "Fire Bolt");
        ArrayList<String> kLore = new ArrayList<String>();
        kLore.add("The fastest broom around!");
        fireboltMeta.setLore(kLore);
        fireboltMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        firebolt.setItemMeta(fireboltMeta);
        player.getInventory().addItem(firebolt);


    }


    public static int getDistance(Entity e) {
        Location loc = e.getLocation().clone();
        double y = loc.getBlockY();
        int distance = 0;
        for (double i = y; i >= 0; i--) {
            loc.setY(i);
            if (loc.getBlock().getType().isSolid()) break;
            distance++;
        }
        return distance;
    }

    @EventHandler
    public void FireboltMotions(PlayerInteractEvent event) {
        Player player = event.getPlayer();


        if (player.getInventory().getItemInMainHand().hasItemMeta() && !(player.getInventory().getItemInMainHand().equals(Material.AIR)) && player.getInventory().getItemInMainHand() != null && !(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(null))) {

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.ITALIC + "Fire Bolt")) {


                if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {


                    if (flyingPlayerSpeed.containsKey(player.getUniqueId())) {
                        if (flyingPlayerSpeed.get(player.getUniqueId()).equalsIgnoreCase("1")) {

                            flyingPlayerSpeed.remove(player.getUniqueId());
                            flyingPlayerSpeed.put(player.getUniqueId(), "2");
                            return;
                        }

                        if (flyingPlayerSpeed.get(player.getUniqueId()).equalsIgnoreCase("2")) {

                            flyingPlayerSpeed.remove(player.getUniqueId());
                            flyingPlayerSpeed.put(player.getUniqueId(), "1");

                        }
                    } else {


                        flyingPlayerSpeed.remove(player.getUniqueId());
                        flyingPlayerSpeed.put(player.getUniqueId(), "1");
                    }
                    flyingPlayers.remove(player.getUniqueId());
                    flyingPlayers.put(player.getUniqueId(), "flying");

                    new BukkitRunnable() {


                        public void run() {
                            if (player.getInventory().getItemInMainHand().hasItemMeta() && !(player.getInventory().getItemInMainHand().equals(Material.AIR)) && player.getInventory().getItemInMainHand() != null) {

                                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.ITALIC + "Fire Bolt")) {

                                    if (flyingPlayerSpeed.containsKey(player.getUniqueId())) {
                                        if (flyingPlayerSpeed.get(player.getUniqueId()).equalsIgnoreCase("1")) {
                                            player.setVelocity(player.getLocation().getDirection().normalize().multiply(0.5));
                                        }
                                        if (flyingPlayerSpeed.get(player.getUniqueId()).equalsIgnoreCase("2")) {
                                            player.setVelocity(player.getLocation().getDirection().normalize().multiply(8));
                                        }
                                    }

                                    if (flyingPlayerSpeed.containsKey(player.getUniqueId())) {

                                        if (flyingPlayerSpeed.get(player.getUniqueId()).equals("hovering")) {
                                            int distance = getDistance(player);

                                            if (distance < 5) {
                                                player.setFallDistance(-200);
                                            }
                                            if (distance < 10 && distance > 5) {
                                                player.setFallDistance(-100);
                                            }
                                            this.cancel();
                                        }
                                    }


                                    if (player.isSneaking()) {
                                        int distance = getDistance(player);

                                        if (distance < 5) {
                                            player.setFallDistance(-200);
                                        }
                                        if (distance < 10 && distance > 5) {
                                            player.setFallDistance(-100);
                                        }
                                        this.cancel();
                                    }
                                } else {
                                    this.cancel();
                                }
                            } else {
                                this.cancel();
                            }
                        }


                    }.

                            runTaskTimer(main.getPlugin(main.class), 0, 1);


                }


                    if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_AIR)) {

                        flyingPlayers.remove(player.getUniqueId());
                        flyingPlayers.put(player.getUniqueId(), "hovering");


                        new BukkitRunnable() {

                            public void run() {

                                player.setVelocity(new Vector(0, 0, 0));

                                if (flyingPlayers.get(player.getUniqueId()).equalsIgnoreCase("flying") || player.isSneaking()) {
                                    int distance = getDistance(player);

                                    if (distance <= 5) {
                                        player.setFallDistance(-200);
                                    }

                                    if (distance < 10 && distance > 5) {
                                        player.setFallDistance(-100);
                                    }
                                    this.cancel();
                                }

                            }

                        }.runTaskTimer(main.getPlugin(main.class), 0, 1);


                    }

                }


            }
        }



    @EventHandler
    public void BroomOnDeath(PlayerDeathEvent event) {

        if (event.getEntity() instanceof Player) {
            Player player = event.getEntity();

            flyingPlayers.remove(player.getUniqueId());
            flyingPlayerSpeed.remove(player.getUniqueId());

        }
    }

}