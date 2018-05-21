package com.jellybeans.hp.spells;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class apparate implements Listener {


    public void apparate1(Player player, String apparateTo) {

        String locationP = apparateTo;

        String locationR = locationP.replaceFirst("apparate ", "");


        for (Player online : Bukkit.getOnlinePlayers()) {

            if (locationR.equalsIgnoreCase(online.getDisplayName())) {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Apparate");
                player.teleport(online);

            }

        }


    }

    @EventHandler
    public void listenForApparate(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta()) {

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Wand")) {

                if (event.getMessage().toLowerCase().startsWith("apparate")) {

                    if (event.getMessage().equalsIgnoreCase("apparate spawn")) {

                        player.teleport(new Location(player.getWorld(), 393, 63, 397));


                        return;
                    }
                        String apparateTo = event.getMessage().toLowerCase();

                        apparate doIHaveTo = new apparate();

                        doIHaveTo.apparate1(player, apparateTo);

                    }

            }

        }

    }
}
