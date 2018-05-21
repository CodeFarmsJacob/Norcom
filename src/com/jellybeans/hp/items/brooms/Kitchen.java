package com.jellybeans.hp.items.brooms;

import com.jellybeans.hp.main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.omg.PortableInterceptor.ACTIVE;
import static com.jellybeans.hp.main.flyingPlayers;
import java.util.ArrayList;

public class Kitchen implements Listener {
    public ItemStack kitchenBroom = new ItemStack(Material.STICK, 1);
    public ItemMeta kMeta = kitchenBroom.getItemMeta();

    public void grantBroom(Player player) {
        kMeta.setDisplayName(ChatColor.GOLD + "Kitchen Broom");
        ArrayList<String> kLore = new ArrayList<String>();
        kLore.add("The typical everyday wizarding broom");
        kMeta.setLore(kLore);
        kMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        kitchenBroom.setItemMeta(kMeta);
        player.getInventory().addItem(kitchenBroom);




    }




    public static int getDistance(Entity e){
        Location loc = e.getLocation().clone();
        double y = loc.getBlockY();
        int distance = 0;
        for (double i = y; i >= 0; i--){
            loc.setY(i);
            if(loc.getBlock().getType().isSolid())break;
            distance++;
        }
        return distance;
    }

    @EventHandler
    public void KitchenMotions(PlayerInteractEvent event) {
        Player player = event.getPlayer();


        if (player.getInventory().getItemInMainHand().hasItemMeta() && !(player.getInventory().getItemInMainHand().equals(Material.AIR)) && player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Kitchen Broom")) {




                if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {

                    flyingPlayers.remove(player.getUniqueId());
                    flyingPlayers.put(player.getUniqueId(), "flying");

                    new BukkitRunnable() {


                        public void run() {
                            if (player.getInventory().getItemInMainHand().hasItemMeta() && !(player.getInventory().getItemInMainHand().equals(Material.AIR)) && player.getInventory().getItemInMainHand() != null) {

                                if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Kitchen Broom")) {
                                    if (flyingPlayers.containsKey(player.getUniqueId())) {
                                        player.setVelocity(player.getLocation().getDirection().normalize().multiply(0.3));

                                        if (player.isSneaking() || flyingPlayers.get(player.getUniqueId()).equalsIgnoreCase("hovering")) {
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

                                }

                                else {
                                    player.sendMessage("2");
                                    this.cancel();
                                }

                            }
                            else {
                                player.sendMessage(player.getInventory().getItemInMainHand().toString());
                                this.cancel();
                            }





                    }


                    }.runTaskTimer(main.getPlugin(main.class), 0,1);




                }
                if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_AIR)) {

                    flyingPlayers.remove(player.getUniqueId());
                    flyingPlayers.put(player.getUniqueId(), "hovering");


                    new BukkitRunnable() {

                        public void run() {

                            player.setVelocity(new Vector(0,0,0));

                            if(flyingPlayers.get(player.getUniqueId()).equalsIgnoreCase("flying") || player.isSneaking()) {
                                int distance = getDistance(player);

                                if(distance <= 5) {
                                    player.setFallDistance(-200);
                                }

                                if(distance < 10 && distance > 5) {
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
        }

    }

}