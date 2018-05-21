package com.jellybeans.hp.items.books;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

public class MomsBookOfSpells00 {

    ItemStack momSpells = new ItemStack(Material.WRITTEN_BOOK);

    BookMeta momSpellsM = (BookMeta) momSpells.getItemMeta();

            public void grantBook(Player player) {

                momSpellsM.setAuthor(ChatColor.ITALIC + "Mom xoxo");
                momSpellsM.setDisplayName(ChatColor.RED + "A list of spells from Mom");
                momSpellsM.setTitle(ChatColor.RED + "A list of spells from Mom");

                ArrayList<String> pages = new ArrayList<String>();

                pages.add(ChatColor.LIGHT_PURPLE + "Clamor \n" + ChatColor.BLACK + "The shouting spell. To cast, hold you wand, say, \"Clamor\". Left click, to cast. The next words that come out of your mouth will be screamed for all to hear.");
                momSpellsM.setPages(pages);
                momSpells.setItemMeta(momSpellsM);
                player.getInventory().addItem(momSpells);


            }

}
