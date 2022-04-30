package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class StartCommand implements CommandExecutor {

    public static Map<UUID, KillcounterScoreboard> scoreboards = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

            if(lobby_Plugin.isEnabled()) {
                Bukkit.getPluginManager().disablePlugin(lobby_Plugin);
                Bukkit.getLogger().fine("Lobby_Plugin wird deaktiviert.");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Lobby_Plugin wird deaktiviert!");
            }

        for(Player p : Bukkit.getOnlinePlayers()) {
            scoreboards.put(p.getUniqueId(), new KillcounterScoreboard(p));
        }

        Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                int time = 10;
                @Override
                public void run() {
                    time--;
                    Bukkit.broadcastMessage(ChatColor.AQUA + String.valueOf(time));

                    if (time == 1) {
                        timer.cancel();
                        Bukkit.broadcastMessage(ChatColor.RED + "Start");
                        time = 10;
                    }
                }
            }, 1000, 1000);

        Location loc1 = new Location(Bukkit.getWorld("world"), -341.5, 9, -23.5);
        Location loc2 = new Location(Bukkit.getWorld("world"), -374.5, 11, -31.5);
        Location loc3 = new Location(Bukkit.getWorld("world"), -382.5, 11, 6.5);
        Location loc4 = new Location(Bukkit.getWorld("world"), -359.5, 12, 27.5);
        Location loc5 = new Location(Bukkit.getWorld("world"), -333.5, 12, 20.5);
        Location loc6 = new Location(Bukkit.getWorld("world"), -318.5, 14, -0.5);

        Player[] players = new Player[6];
        int num = 0;

        for(Player p : Bukkit.getOnlinePlayers()) {
            players[num] = p;
            num++;
        }

        players[0].teleport(loc1);
        players[1].teleport(loc2);
        players[2].teleport(loc3);
        players[3].teleport(loc4);
        players[4].teleport(loc5);
        players[5].teleport(loc6);

        return false;
    }
}
