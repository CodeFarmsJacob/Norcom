package com.jellybeans.hp;

import com.jellybeans.hp.items.brooms.Kitchen;
import com.jellybeans.hp.items.brooms.firebolt;
import com.jellybeans.hp.items.getInvisCload;
import com.jellybeans.hp.items.getWand;
import com.jellybeans.hp.spells.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.Hash;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;


public class main extends JavaPlugin {
private ConfigManager cfgm;
private commands commands = new commands();
public static HashMap<UUID, String> spalls = new HashMap<>();
public static HashMap<UUID, String> blockingPlayers = new HashMap<>();
public static HashMap<UUID, String> flyingPlayers = new HashMap<>();
public static HashMap<UUID, String> flyingPlayerSpeed = new HashMap<UUID, String>();
public static HashMap<UUID, ItemStack> slotOneNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotTwoNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotThreeNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotFourNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotFiveNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotSixNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotSevenNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotEightNV = new HashMap<>();
    public static HashMap<UUID, ItemStack> slotNineNV = new HashMap<>();


    public static HashMap<UUID, ItemMeta> slotOneMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotTwoMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotThreeMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotFourMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotFiveMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotSixMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotSevenMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotEightMeta = new HashMap<>();
    public static HashMap<UUID, ItemMeta> slotNineMeta = new HashMap<>();


    public static HashMap<UUID, String> nonVerbalCasters = new HashMap<>();
    public void onEnable() {
        loadConfigManager();
        loadConfig();
        getCommand(commands.cmd1).setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nHP enabled \n\n");
        getServer().getPluginManager().registerEvents(new events(), this);
        getServer().getPluginManager().registerEvents(new incendio(), this);
        getServer().getPluginManager().registerEvents(new getInvisCload(), this);
        getServer().getPluginManager().registerEvents(new lumosNox(), this);
        getServer().getPluginManager().registerEvents(new ascendio(), this);
        getServer().getPluginManager().registerEvents(new Sectumsempra(), this);
        getServer().getPluginManager().registerEvents(new apparate(), this);
        getServer().getPluginManager().registerEvents(new homenumRevelio(), this);
        getServer().getPluginManager().registerEvents(new avadaKadavara(), this);
        getServer().getPluginManager().registerEvents(new protego(), this);
        getServer().getPluginManager().registerEvents(new Kitchen(), this);
        getServer().getPluginManager().registerEvents(new firebolt(), this);
        getServer().getPluginManager().registerEvents(new Episkey(), this);
        getServer().getPluginManager().registerEvents(new confringo(), this);
        getServer().getPluginManager().registerEvents(new nonVerbal(), this);
        getServer().getPluginManager().registerEvents(new ignisTempestatibus(), this);
        getWand wand = new getWand();
        wand.wandRecipe();
    }

    public void onDisable() {

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nHP Disabled\n\n");

    }

    public void loadConfigManager() {

        cfgm = new ConfigManager();
        cfgm.setup();
        cfgm.savePlayers();
        cfgm.reloadPlayers();

    }

    public void loadConfig() {

        getConfig().options().copyDefaults(true);
        saveConfig();

    }

}
