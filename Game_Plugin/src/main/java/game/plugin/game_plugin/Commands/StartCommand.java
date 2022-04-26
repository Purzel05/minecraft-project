package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StartCommand implements CommandExecutor {

    public static Map<UUID, KillcounterScoreboard> scoreboards = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

            if(lobby_Plugin.isEnabled()) {

                Bukkit.getPluginManager().disablePlugin(lobby_Plugin);
                Bukkit.getLogger().fine("Lobby_Plugin wird deaktiviert.");

            }

        for(Player p : Bukkit.getOnlinePlayers()) {

            scoreboards.put(p.getUniqueId(), new KillcounterScoreboard(p));

        }

        Location loc1 = new Location(Bukkit.getWorld("world"), -341.5, 9, -23.5);
        Location loc2 = new Location(Bukkit.getWorld("world"), -374.5, 11, -31.5);
        Location loc3 = new Location(Bukkit.getWorld("world"), -382.5, 11, 6.5);
        Location loc4 = new Location(Bukkit.getWorld("world"), -359.5, 12, 27.5);
        Location loc5 = new Location(Bukkit.getWorld("world"), -333.5, 12, 20.5);
        Location loc6 = new Location(Bukkit.getWorld("world"), -318.5, 14, -0.5);

        return false;
    }
}
