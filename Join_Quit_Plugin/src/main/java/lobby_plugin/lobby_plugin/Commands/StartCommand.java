package lobby_plugin.lobby_plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin game_Plugin = Bukkit.getPluginManager().getPlugin("Game_Plugin");
        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

        if(lobby_Plugin.isEnabled()) {
            Bukkit.getPluginManager().enablePlugin(game_Plugin);
        }

        return false;
    }
}
