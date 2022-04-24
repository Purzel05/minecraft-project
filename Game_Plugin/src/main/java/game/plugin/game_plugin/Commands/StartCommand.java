package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

            if(lobby_Plugin.isEnabled()) {

                Bukkit.getPluginManager().disablePlugin(lobby_Plugin);
                Bukkit.getLogger().fine("Lobby_Plugin wird deaktiviert.");

            }

        return false;
    }
}
