package com.jellybeans.hp.spells;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static com.jellybeans.hp.main.*;

public class nonVerbal implements Listener {

    @EventHandler
    public void nonverbalListener(PlayerDropItemEvent event) {

        if (event.getItemDrop().getItemStack().hasItemMeta() && event.getItemDrop().getItemStack().getItemMeta().getDisplayName() != null) {
            ItemStack blackT = new ItemStack(Material.BLACK_GLAZED_TERRACOTTA, 1);
            ItemMeta MblackT = blackT.getItemMeta();
            MblackT.setDisplayName(ChatColor.BLACK + "1");
            blackT.setItemMeta(MblackT);

            ItemStack redT = new ItemStack(Material.RED_GLAZED_TERRACOTTA, 2);
            ItemMeta MredT = blackT.getItemMeta();
            MredT.setDisplayName(ChatColor.RED + "2");
           redT.setItemMeta(MredT);

            Player player = event.getPlayer();
            Inventory inv = event.getPlayer().getInventory();
            if (nonVerbalCasters.containsKey(player.getUniqueId())) {
                if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Wand") && nonVerbalCasters.get(player.getUniqueId()).equals("casting")) {
                    event.setCancelled(true);
                    player.sendMessage("trying");

                    if (slotOneNV.containsKey(player.getUniqueId())) {
                      //  inv.getItem(0).setType(slotOneNV.get(player.getUniqueId()).getType());
                        inv.setItem(0, slotOneNV.get(player.getUniqueId()));

                        nonVerbalCasters.remove(player.getUniqueId());

                        if(slotOneMeta.containsKey(player.getUniqueId())) {
                            inv.getItem(0).setItemMeta(slotOneMeta.get(player.getUniqueId()));
                        }

                    }
                }
            }


                if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Wand") && event.getPlayer().isSneaking()) {
                    event.setCancelled(true);

                    event.getPlayer().sendMessage("nope");
                    int wandPlace = player.getInventory().getHeldItemSlot();
                    if (!(wandPlace == 0)) {
                        slotOneNV.remove(player.getUniqueId());
                        slotOneNV.put(player.getUniqueId(), inv.getItem(0));
                        player.sendMessage("not in slot 1");
                        slotOneMeta.remove(player.getUniqueId());
                        slotOneMeta.put(player.getUniqueId(), inv.getItem(0).getItemMeta());
                    }
                    if (!(wandPlace == 1)) {
                        slotTwoNV.remove(player.getUniqueId());
                        slotTwoNV.put(player.getUniqueId(), inv.getItem(1));


                        slotTwoMeta.remove(player.getUniqueId());
                        slotTwoMeta.put(player.getUniqueId(), inv.getItem(1).getItemMeta());
                    }
                    if (!(wandPlace == 2)) {
                        slotThreeNV.remove(player.getUniqueId());
                        slotThreeNV.put(player.getUniqueId(), inv.getItem(2));

                        slotThreeMeta.remove(player.getUniqueId());
                        slotThreeMeta.put(player.getUniqueId(), inv.getItem(2).getItemMeta());
                    }
                    if (!(wandPlace == 3)) {
                        slotFourNV.remove(player.getUniqueId());
                        slotFourNV.put(player.getUniqueId(), inv.getItem(3));

                        slotFourMeta.remove(player.getUniqueId());
                        slotFourMeta.put(player.getUniqueId(), inv.getItem(3).getItemMeta());
                    }
                    if (!(wandPlace == 4)) {
                        slotFiveNV.remove(player.getUniqueId());
                        slotFiveNV.put(player.getUniqueId(), inv.getItem(4));

                        slotFiveMeta.remove(player.getUniqueId());
                        slotFiveMeta.put(player.getUniqueId(), inv.getItem(4).getItemMeta());
                    }
                    if (!(wandPlace == 5)) {
                        slotSixNV.remove(player.getUniqueId());
                        slotSixNV.put(player.getUniqueId(), inv.getItem(5));

                        slotSixMeta.remove(player.getUniqueId());
                        slotSixMeta.put(player.getUniqueId(), inv.getItem(5).getItemMeta());

                    }
                    if (!(wandPlace == 6)) {
                        slotSevenNV.remove(player.getUniqueId());
                        slotSevenNV.put(player.getUniqueId(), inv.getItem(6));

                        slotSevenMeta.remove(player.getUniqueId());
                        slotSevenMeta.put(player.getUniqueId(), inv.getItem(6).getItemMeta());
                    }
                    if (!(wandPlace == 7)) {
                        slotEightNV.remove(player.getUniqueId());
                        slotEightNV.put(player.getUniqueId(), inv.getItem(7));

                        slotEightMeta.remove(player.getUniqueId());
                        slotEightMeta.put(player.getUniqueId(), inv.getItem(7).getItemMeta());
                    }
                    if (!(wandPlace == 8)) {
                        slotNineNV.remove(player.getUniqueId());
                        slotNineNV.put(player.getUniqueId(), inv.getItem(8));

                        slotNineMeta.remove(player.getUniqueId());
                        slotNineMeta.put(player.getUniqueId(), inv.getItem(8).getItemMeta());
                    }

                    if (!(wandPlace == 0)) {
                        inv.setItem(0, blackT);
                    }

                    nonVerbalCasters.remove(player.getUniqueId());
                    nonVerbalCasters.put(player.getUniqueId(), "casting");

                }


            }
        }

    }

