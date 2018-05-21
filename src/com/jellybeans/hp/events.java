package com.jellybeans.hp;

import com.jellybeans.hp.items.books.MomsBookOfSpells00;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.jellybeans.hp.spells.*;
import org.bukkit.event.player.PlayerJoinEvent;
import com.jellybeans.hp.items.getWand;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class events implements Listener{
        ConfigManager config = new ConfigManager();
        private boolean needaCast = false;
        private boolean needaListenClamor = false;
        @EventHandler
        public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
            Player player = event.getPlayer();
             main plugin = main.getPlugin(main.class);

            player.setFlySpeed((float)0.1);

            if(player.hasPlayedBefore()) {

                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Everyone Welcome Back "+ ChatColor.AQUA + player.getDisplayName());

            }


            if(!(player.hasPlayedBefore())) {

                try {
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Welcome to the Norcom Network" + ChatColor.RED + "!" + ChatColor.GOLD + "!" + ChatColor.AQUA + "!");
                    config.setup();
                    config.plrConfig.set(player.getUniqueId().toString(), player.getUniqueId());
                    config.plrConfig.set(player.getUniqueId().toString() + ".stats.level", 1);
                    config.plrConfig.set(player.getUniqueId().toString() + ".stats.levelCasts", 0);
                    config.plrConfig.set(player.getUniqueId().toString() + ".spells.incendio.velocity", 1.00);
                    config.plrConfig.set(player.getUniqueId().toString() + ".spells.incendio.damage", 0.00);
                    config.savePlayers();

                    event.setJoinMessage(ChatColor.BLUE + "EVERYONE welcome " + player.getDisplayName() + " to the server!!!");




                  new getWand().grantWand(player);
                    new MomsBookOfSpells00().grantBook(player);

                }
                catch (Exception e) {

                    Bukkit.getServer().broadcastMessage(ChatColor.RED + "ERROR " + ChatColor.GOLD + player.getDisplayName() + ChatColor.RED + ": Could not load the onJoin Function. Helpers please initiate the player." + ChatColor.GRAY + e.toString());

                }
            }

        }





        @EventHandler
        public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);

            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Everyone say goodbye to " + ChatColor.RED + "" + ChatColor.ITALIC + event.getPlayer().getDisplayName());


        }


        @EventHandler
        public void onPlayerChat(AsyncPlayerChatEvent event) {
            event.setCancelled(true);
            Player player = event.getPlayer();







            if(event.getMessage().toLowerCase().contains("occultos exitus")) {
                for (int counter = 0; counter < 45; counter++) {
                    try{sleep(50);}catch(Exception elakjdfklajsdifnsdjhduif) {}

                    Location start = player.getEyeLocation();
                    Vector increase = start.getDirection();
                    Location point = start.add(increase);


                    player.getLocation().getWorld().spawnParticle(Particle.FIREWORKS_SPARK, point, 100, 1, 1, 1, 0);



                }
                player.teleport(new Location(player.getLocation().getWorld(),391,63,381));
                for (int counter = 0; counter < 30; counter++) {
                    try{sleep(25);}catch(Exception elakjdfklajsdifnsdjhduif) {}

                    Location start = player.getEyeLocation();
                    Vector increase = start.getDirection();
                    Location point = start.add(increase);


                    player.getLocation().getWorld().spawnParticle(Particle.FIREWORKS_SPARK, point, 100, 1, 1, 1, 0);



                }
            }

            if(event.getMessage().toLowerCase().contains("occultos ostium")) {

                for (int counter = 0; counter < 45; counter++) {
                    try{sleep(50);}catch(Exception elakjdfklajsdifnsdjhduif) {}

                    Location start = player.getEyeLocation();
                    Vector increase = start.getDirection();
                    Location point = start.add(increase);


                    player.getLocation().getWorld().spawnParticle(Particle.FIREWORKS_SPARK, point, 100, 1, 1, 1, 0);



                }
                player.teleport(new Location(player.getLocation().getWorld(), 393, 63, 398));

                for (int counter = 0; counter < 5; counter++) {
                    try{sleep(25);}catch(Exception elakjdfklajsdifnsdjhduif) {}

                    Location start = player.getEyeLocation();
                    Vector increase = start.getDirection();
                    Location point = start.add(increase);


                    player.getLocation().getWorld().spawnParticle(Particle.FIREWORKS_SPARK, point, 100, 1, 1, 1, 1);



                }
            }
            if(event.getMessage().startsWith("%")) {

                String realMessage = event.getMessage().toLowerCase().replaceFirst("%", "");
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "[Global]" + " "+ChatColor.WHITE + "<" + player.getDisplayName() + ">" + " " + realMessage);

                return;

            }


            if(event.getMessage().startsWith(",")) {

                String realMessage = event.getMessage().replaceFirst(",", "");


                player.sendMessage(ChatColor.DARK_GRAY + "[Whisper]" + " "+ChatColor.GRAY +  "<" + player.getDisplayName() + ">" + ChatColor.ITALIC +  " " + realMessage);
                for(Entity e : player.getNearbyEntities(4,4,4)) {

                    if(e instanceof Player) {

                        e.sendMessage(ChatColor.DARK_GRAY + "[Whisper]" + " "+ChatColor.GRAY +  "<" + player.getDisplayName() + ">" + ChatColor.ITALIC +  " " + realMessage);

                    }

                }




                return;

            }


            player.sendMessage(ChatColor.GRAY+"[Region]"+" "+ChatColor.WHITE+'<'+player.getName()+'>'+" "+event.getMessage());
            for(Entity e : player.getNearbyEntities(50,50,50)) {

                if(e instanceof Player) {

                    e.sendMessage(ChatColor.GRAY+"[Region]"+" "+ChatColor.WHITE+'<'+player.getName()+'>'+" "+event.getMessage());

                }

            }








               }




}
