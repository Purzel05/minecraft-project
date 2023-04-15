package game.plugin.game_plugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.Set;

public class FreezeCommand implements CommandExecutor {
    public static Set<String> frozenPlayers = new HashSet<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp()) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GOLD + "Du musst einen Spieler spezifizieren!");
            } else if (args.length == 1) {
                if(args[0] != null) {
                    frozenPlayers.add(args[0]);
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "Du bist kein Operator!");
        }
        return false;
    }
}