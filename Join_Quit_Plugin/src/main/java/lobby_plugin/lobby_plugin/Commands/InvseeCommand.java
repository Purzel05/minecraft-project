package lobby_plugin.lobby_plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp()) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GOLD + "Du musst einen Spieler spezifizieren!");
            } else if (args.length == 1) {
                String playerName = args[0];
                Player invseenPlayer = Bukkit.getServer().getPlayer(playerName);
                Player cmdSender = Bukkit.getServer().getPlayer(sender.getName());
                if(invseenPlayer != null) {
                    if(cmdSender != null) {
                        PlayerInventory invseenInv = invseenPlayer.getInventory();
                        cmdSender.openInventory(invseenInv);
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "Du bist kein Operator!");
        }
        return false;
    }
}
