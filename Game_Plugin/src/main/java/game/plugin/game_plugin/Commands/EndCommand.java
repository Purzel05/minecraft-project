package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
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
        Plugin game_Plugin = Bukkit.getPluginManager().getPlugin("Game_Plugin");

        if(!lobby_Plugin.isEnabled()) {
            Bukkit.getPluginManager().enablePlugin(lobby_Plugin);
            Bukkit.getLogger().fine("Lobby_Plugin wird aktiviert.");
            if(game_Plugin.isEnabled()) {
                Bukkit.getPluginManager().disablePlugin(game_Plugin);
                Bukkit.getLogger().fine("Game_Plugin wird deaktiviert.");
            }
        }

        return false;
    }

}
