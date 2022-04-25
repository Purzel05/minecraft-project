package lobby_plugin.lobby_plugin.Commands;

import lobby_plugin.lobby_plugin.listener.BlockBreakListener;
import lobby_plugin.lobby_plugin.listener.BlockPlaceListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ZeviBuildCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.getName() != "The_Maximalus") {

            if (BlockPlaceListener.zeviCommand == true) {

                BlockPlaceListener.zeviCommand = false;
                sender.sendMessage(ChatColor.RED + "Zevi baut jetzt nix mehr!");

            } else {

                BlockPlaceListener.zeviCommand = true;
                sender.sendMessage(ChatColor.RED + "Zevi darf wieder bauen!");

            }

            if (BlockBreakListener.zeviCommand2 == true) {

                BlockBreakListener.zeviCommand2 = false;

            } else {

                BlockBreakListener.zeviCommand2 = true;

            }

        } else {

            sender.sendMessage(ChatColor.DARK_AQUA + "Ne, ne, ne Zevi!");

        }

        return false;
    }
}
