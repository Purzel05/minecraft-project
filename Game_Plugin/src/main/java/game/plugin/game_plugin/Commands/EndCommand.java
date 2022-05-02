package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.Listener.JoinListener;
import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

public class EndCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

        if(!lobby_Plugin.isEnabled()) {
            Bukkit.getPluginManager().enablePlugin(lobby_Plugin);
            Bukkit.getLogger().fine("Lobby_Plugin wird aktiviert.");
            sender.sendMessage(ChatColor.DARK_PURPLE + "Lobby_Plugin wird aktiviert!");
        }

        Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 0, 0.5);

        for(Player p : Bukkit.getOnlinePlayers()) {

            p.setGameMode(GameMode.SURVIVAL);
            p.teleport(spawn);
            p.getInventory().clear();

        }

        return false;
    }

}
