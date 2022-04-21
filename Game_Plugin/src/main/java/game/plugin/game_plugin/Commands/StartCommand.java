package game.plugin.game_plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class StartCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

        if(lobby_plugin.isEnabled()) {

            Bukkit.getPluginManager().disablePlugin(lobby_plugin);
            Bukkit.getLogger().fine("Lobby_Plugin wird deaktiviert.");

        }



        return false;
    }
}
