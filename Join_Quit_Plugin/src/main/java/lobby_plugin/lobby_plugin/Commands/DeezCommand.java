package lobby_plugin.lobby_plugin.Commands;

import lobby_plugin.lobby_plugin.listener.PlayerMoveListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeezCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player playerSender = (Player) sender;

        if (playerSender.getName().equalsIgnoreCase("Porzl2k5")) {

               if (PlayerMoveListener.deez == false) {

                    PlayerMoveListener.deez = true;

               }
               else {

                    PlayerMoveListener.deez = false;

               }
            }
            else {

                playerSender.sendMessage(ChatColor.RED + "Das darf nur der Leo!");

            }

            return false;

    }
}
