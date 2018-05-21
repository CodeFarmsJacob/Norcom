package com.jellybeans.hp.spells;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.jellybeans.hp.main.spalls;
import static java.lang.Thread.sleep;

public class homenumRevelio implements Listener {




@EventHandler
    public void listenForhomenumRevelio(AsyncPlayerChatEvent event) {


    if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {

        if(event.getMessage().equalsIgnoreCase("homenum revelio") && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {



            spalls.remove(event.getPlayer().getUniqueId());
            spalls.put(event.getPlayer().getUniqueId(), "homenum revelio");


        }
    }
}

@EventHandler
    public void listenForCastHomenumRevelio(PlayerInteractEvent event) {

    if(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {

        if(spalls.containsKey(event.getPlayer().getUniqueId()) && spalls.get(event.getPlayer().getUniqueId()) == "homenum revelio") {
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {
                event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Homenum Revelio");
                spalls.remove(event.getPlayer().getUniqueId());

                for(Entity e : event.getPlayer().getNearbyEntities(30,30,30)) {

                    if(e instanceof Player) {

                        e.setGlowing(true);

                    }

                }
                try {
                    sleep(1000);

                    for(Entity e : event.getPlayer().getNearbyEntities(30,30,30)) {

                        if(e instanceof Player) {

                            e.setGlowing(false);

                        }

                    }


                }catch (InterruptedException exeptionForINTERUPTIONSSSSSSS) {

                    Bukkit.broadcastMessage(ChatColor.RED + "ERROR, could not sleep for homenum revelio for: " + ChatColor.GOLD + "" + ChatColor.ITALIC + event.getPlayer());

                }
            }
        }





    }

}

}
