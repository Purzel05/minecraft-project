package game.plugin.game_plugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnfreezeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp()) {
            if(args.length == 0) {
                sender.sendMessage(ChatColor.GOLD + "Du musst einen Spieler spezifizieren!");
            }else if (args.length == 1) {
                if(args[0] != null) {
                    FreezeCommand.frozenPlayers.remove(args[0]);
                }
            }
        }else {
            sender.sendMessage(ChatColor.DARK_RED + "Du bist kein Operator!");
        }
        return false;
    }
}
