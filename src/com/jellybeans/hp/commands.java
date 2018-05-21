package com.jellybeans.hp;

import com.jellybeans.hp.items.books.MomsBookOfSpells00;
import com.jellybeans.hp.items.brooms.Kitchen;
import com.jellybeans.hp.items.brooms.firebolt;
import com.jellybeans.hp.items.getInvisCload;
import com.jellybeans.hp.items.getWand;
import net.minecraft.server.v1_12_R1.CommandExecute;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class commands extends CommandExecute implements Listener, CommandExecutor {

    public String cmd1 = "giveS";
    public String cmd2 = "tier";
    public String cmd3 = "spawn";

    @Override
    public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args) {

        if(sender instanceof Player) {










            if(cmd.getName().equalsIgnoreCase(cmd1)) {

                if(args[0].equalsIgnoreCase("MomsBook")) {
                    Player plr = Bukkit.getServer().getPlayer(args[1]);
                    String realName = plr.getName();
                    new MomsBookOfSpells00().grantBook(plr);
                    Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " " + ChatColor.RED + "Gave WAND to " + ChatColor.AQUA  + realName);
                }

                if(args[0].equalsIgnoreCase("wand")){

                    getWand yep = new getWand();
                    Player plr = Bukkit.getServer().getPlayer(args[1]);
                    String realName = plr.getName();
                    yep.grantWand(plr);
                    Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " " + ChatColor.RED + "Gave WAND to " + ChatColor.AQUA  + realName);

                }

                if(args[0].equalsIgnoreCase("invisibilitycloak")) {

                    getInvisCload get = new getInvisCload();
                    get.grantInvisCload(Bukkit.getServer().getPlayer(args[1]));
                    String rlNm = Bukkit.getServer().getPlayer(args[1]).getName();
                    Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " " + ChatColor.RED + "Gave Invisibility Cloak to " + ChatColor.AQUA + rlNm);


                }

                if(args[0].equalsIgnoreCase("kitchen")) {

                    Kitchen kitchen = new Kitchen();
                    Player plr = Bukkit.getPlayer(args[1]);
                    String Rplr = plr.getDisplayName();
                    kitchen.grantBroom(plr);
                    Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " " + ChatColor.RED + "Gave KITCHEN BROOM to " + ChatColor.AQUA  + Rplr);
                }

                if(args[0].equalsIgnoreCase("firebolt")) {

                    firebolt firebolt = new firebolt();
                    Player plr = Bukkit.getPlayer(args[1]);
                    String Rplr = plr.getDisplayName();
                    firebolt.grantBroom(plr);
                    Bukkit.broadcastMessage(ChatColor.GOLD + ((Player) sender).getDisplayName() + " " + ChatColor.RED + "Gave FIREBOLT to " + ChatColor.AQUA + Rplr);

                }








            }








        }

        if(cmd.getName().equalsIgnoreCase(cmd3)) {
            Bukkit.getServer().getConsoleSender().sendMessage("yumm");
            Player player = (Player) sender;
            sender.sendMessage(ChatColor.GOLD + "Teleporting to spawn...");
            player.teleport(new Location(player.getWorld(), 393, 63, 397));

        return true;


        }

        else {

            sender.sendMessage(ChatColor.RED + "ERROR, you cannot cast these spells from the console.");

        }

     return true;
    }



}
