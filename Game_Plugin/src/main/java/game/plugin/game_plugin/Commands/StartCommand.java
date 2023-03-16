package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.Listener.BlockBreakListener;
import game.plugin.game_plugin.Listener.BlockPlaceListener;
import game.plugin.game_plugin.Listener.PlayerMoveListener;
import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import javax.swing.plaf.ButtonUI;
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

        BlockBreakListener.controlBreak = false;
        BlockPlaceListener.controlPlace = false;

        Location loc1 = new Location(Bukkit.getWorld("world"), 0.5, 68, -7.5);
        Location loc2 = new Location(Bukkit.getWorld("world"), 7.5, 68, -7.5);
        Location loc3 = new Location(Bukkit.getWorld("world"), 7.5, 68, 0.5);
        Location loc4 = new Location(Bukkit.getWorld("world"), 0.5, 68, 7.5);
        Location loc5 = new Location(Bukkit.getWorld("world"), -7.5, 68, 7.5);
        Location loc6 = new Location(Bukkit.getWorld("world"), -7.5, 68, 0.5);

        ItemStack berserkKit = new ItemStack(Material.GRAY_DYE, 1);
        ItemStack archerKit = new ItemStack(Material.LIME_DYE,1);

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
            players[num].getInventory().setItem(4, berserkKit);
            players[num].getInventory().setItem(0, archerKit);
            players[num].setGameMode(GameMode.SURVIVAL);
            players[num].setHealth(20);
            players[num].setFoodLevel(20);
            players[num].getActivePotionEffects().clear();
            if(!players[num].getName().equalsIgnoreCase("Porzl2k5") || !players[num].getName().equalsIgnoreCase("Schleggamann")){
                players[num].setOp(false);
            }else {
                players[num].setOp(true);
            }
            num++;
        }

        return false;
    }
}
