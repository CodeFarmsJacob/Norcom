package com.jellybeans.hp.spells;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import static com.jellybeans.hp.main.spalls;
public class lumosNox implements Listener{

    @EventHandler
    public void lumosNoxCheckChat(AsyncPlayerChatEvent e) {

        if(e.getMessage().equalsIgnoreCase("lumos")) {
           spalls.remove(e.getPlayer().getUniqueId());
           spalls.put(e.getPlayer().getUniqueId(), "lumos");



        }

        if(e.getMessage().equalsIgnoreCase("nox")) {

            spalls.remove(e.getPlayer().getUniqueId());
            spalls.put(e.getPlayer().getUniqueId(), "nox");

        }

    }

    @EventHandler
    public void OnCastLumos(PlayerInteractEvent e) {
        Action action = e.getAction();
        Player player = e.getPlayer();


        if (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta()) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {

                if(spalls.containsKey(e.getPlayer().getUniqueId()) && spalls.get(e.getPlayer().getUniqueId()) == "lumos") {
                e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Lumos");
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000, 0));
                e.getPlayer().playSound(player.getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 100, 50000);
                spalls.remove(e.getPlayer().getUniqueId());

            }}}


        if (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta()){
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Wand")) {

                if(spalls.containsKey(e.getPlayer().getUniqueId()) && spalls.get(e.getPlayer().getUniqueId()) == "nox") {


                e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Nox");
                e.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
                e.getPlayer().playSound(player.getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 100, -5);
               spalls.remove(e.getPlayer().getUniqueId());
            }


        }


    }}}}}
