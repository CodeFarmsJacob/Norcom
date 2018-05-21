package com.jellybeans.hp.spells;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ascendio implements Listener{
public boolean shootThisAsc = false;

@EventHandler
    public void listenForAscendio(AsyncPlayerChatEvent event) {

    if(event.getMessage().equalsIgnoreCase("ascendio")) {

        shootThisAsc = true;

    }


}


@EventHandler
    public void AscendioOnClick(PlayerInteractEvent e) {
    Action action = e.getAction();
    Player player = e.getPlayer();
    if (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {

        if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta() && !(player.getInventory().getItemInMainHand().equals(Material.AIR))) {

        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand") && shootThisAsc) {


            e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Ascendio");

            e.getPlayer().playSound(player.getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 100, 100);

            e.getPlayer().setVelocity(player.getVelocity().add(new Vector(0,2,0)));
            shootThisAsc = false;
        }}

    }


}}




