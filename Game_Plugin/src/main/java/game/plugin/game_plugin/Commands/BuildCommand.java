package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.Listener.BlockBreakListener;
import game.plugin.game_plugin.Listener.BlockPlaceListener;
import game.plugin.game_plugin.Listener.PlayerInteractEntityListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Benutze /build <on/off>");
        } else if (args.length == 1) {
            switch (args[0]) {
                case "on":
                    BlockPlaceListener.controlPlace = false;
                    BlockBreakListener.controlBreak = false;
                break;
                case "off":
                    BlockPlaceListener.controlPlace = true;
                    BlockBreakListener.controlBreak = true;
                break;
                case "info":
                    if(BlockBreakListener.controlBreak == false && BlockPlaceListener.controlPlace == false) {
                        sender.sendMessage(ChatColor.YELLOW + "Bauen ist aktiviert");
                    } else if (BlockBreakListener.controlBreak == true && BlockPlaceListener.controlPlace == true) {
                        sender.sendMessage(ChatColor.YELLOW + "Bauen ist deaktiviert");
                    }
                break;
                default:
                    sender.sendMessage(ChatColor.YELLOW + "Benutze /build <on/off>");
                break;
            }
        }
        return false;
    }
}
