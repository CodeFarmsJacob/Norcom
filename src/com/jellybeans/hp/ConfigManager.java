package com.jellybeans.hp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private main plugin = main.getPlugin(main.class);

    public FileConfiguration plrConfig;
    public File playerFile;

    public void setup(){

        if(!plugin.getDataFolder().exists()) {

            plugin.getDataFolder().mkdir();


        }

        playerFile = new File(plugin.getDataFolder(), "spells.yml");

        if(!playerFile.exists()) {

            try{
                playerFile.createNewFile();


            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Could not create spells.yml file!!!");
            }

        }


        plrConfig = YamlConfiguration.loadConfiguration(playerFile);


    }

    public FileConfiguration getPlayers() {

        return plrConfig;

    }

    public void savePlayers() {

        try{

            plrConfig.save(playerFile);

        }catch (IOException e){
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Could not save spells.yml");
        }

    }

    public void reloadPlayers() {
        plrConfig = YamlConfiguration.loadConfiguration(playerFile);




    }

}
