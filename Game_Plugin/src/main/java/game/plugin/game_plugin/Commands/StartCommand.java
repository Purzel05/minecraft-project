package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.Listener.PlayerMoveListener;
import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class StartCommand implements CommandExecutor{

    public static Map<UUID, KillcounterScoreboard> scoreboards = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

            if(lobby_Plugin.isEnabled()) {
                Bukkit.getPluginManager().disablePlugin(lobby_Plugin);
                Bukkit.getLogger().fine("Lobby_Plugin wird deaktiviert.");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Lobby_Plugin wird deaktiviert!");
            }

            PlayerMoveListener.control = true;

        for(Player p : Bukkit.getOnlinePlayers()) {
                scoreboards.put(p.getUniqueId(), new KillcounterScoreboard(p));
        }

        Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                int time = 11;
                @Override
                public void run() {
                    time--;
                    Bukkit.broadcastMessage(ChatColor.AQUA + String.valueOf(time));

                    if (time == 1) {
                        timer.cancel();
                        Bukkit.broadcastMessage(ChatColor.RED + "Start");
                        PlayerMoveListener.control = false;
                        time = 11;
                    }
                }
            }, 1000, 1000);



        Location loc1 = new Location(Bukkit.getWorld("world"), -341.5, 9, -23.5);
        Location loc2 = new Location(Bukkit.getWorld("world"), -374.5, 11, -31.5);
        Location loc3 = new Location(Bukkit.getWorld("world"), -382.5, 11, 6.5);
        Location loc4 = new Location(Bukkit.getWorld("world"), -359.5, 12, 27.5);
        Location loc5 = new Location(Bukkit.getWorld("world"), -333.5, 12, 20.5);
        Location loc6 = new Location(Bukkit.getWorld("world"), -318.5, 14, -0.5);

        ItemStack[] armor = new ItemStack[4];
        armor[0] = new ItemStack(Material.IRON_BOOTS,1);
        armor[1] = new ItemStack(Material.IRON_LEGGINGS,1);
        armor[2] = new ItemStack(Material.IRON_CHESTPLATE, 1);
        armor[3] = new ItemStack(Material.IRON_HELMET,1);

        ItemStack mainWeapon = new ItemStack(Material.IRON_SWORD,1);
        ItemStack Bow = new ItemStack(Material.BOW, 1);
        ItemStack Arrows = new ItemStack(Material.ARROW,32);
        ItemStack Steaks = new ItemStack(Material.COOKED_BEEF, 32);
        ItemStack Flint_and_Steel = new ItemStack(Material.FLINT_AND_STEEL, 1);
        ItemMeta itemMeta = Flint_and_Steel.getItemMeta();
        if (itemMeta instanceof Damageable){
            ((Damageable)itemMeta).setDamage(61);
        }
        Flint_and_Steel.setItemMeta(itemMeta);

        Location[] spawnLocations = new Location[6];
        spawnLocations[0] = loc1;
        spawnLocations[1] = loc2;
        spawnLocations[2] = loc3;
        spawnLocations[3] = loc4;
        spawnLocations[4] = loc5;
        spawnLocations[5] = loc6;

        Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
        int num = 0;

        for(Player p : Bukkit.getOnlinePlayers()) {
            players[num] = p;
            players[num].getInventory().clear();
            players[num].teleport(spawnLocations[num]);
            players[num].getInventory().setArmorContents(armor);
            players[num].getInventory().setItem(0,mainWeapon);
            players[num].getInventory().setItem(1,Bow);
            players[num].getInventory().setItem(20,Arrows);
            players[num].getInventory().setItem(2, Steaks);
            players[num].getInventory().setItem(7,Flint_and_Steel);
            players[num].setGameMode(GameMode.SURVIVAL);
            players[num].setHealth(20);
            players[num].setFoodLevel(20);
            players[num].getActivePotionEffects().clear();
            if(!players[num].getName().equalsIgnoreCase("Porzl2k5")){
                players[num].setOp(false);
            }else {
                players[num].setOp(true);
            }
            num++;
        }

        return false;
    }
}
