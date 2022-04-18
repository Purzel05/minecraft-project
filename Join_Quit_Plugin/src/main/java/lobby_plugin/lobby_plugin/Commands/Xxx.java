package lobby_plugin.lobby_plugin.Commands;

import lobby_plugin.lobby_plugin.listener.PlayerMoveListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Xxx implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(PlayerMoveListener.deez == false) {

            PlayerMoveListener.deez = true;

        }
        else {

            PlayerMoveListener.deez = false;

        }

        return false;
    }
}
