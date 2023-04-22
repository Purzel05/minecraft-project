package lobby_plugin.lobby_plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class WarpCommand implements CommandExecutor {
    public static HashMap<String, Location> warpPoints = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length == 1) {
                String senderName = sender.getName();
                Player cmdSender = Bukkit.getPlayer(senderName);
                if (command.getName().equalsIgnoreCase("createwarp")) {
                    if(sender.isOp()){
                        if (warpPoints.containsKey(args[0])) {
                            sender.sendMessage(ChatColor.GREEN + "Dieser Warppunkt existiert schon!");
                        }else {
                            warpPoints.put(args[0], cmdSender.getLocation());
                            sender.sendMessage(ChatColor.GREEN + "Warppunkt erfolgreich erstellt!");
                        }
                    }else {
                        sender.sendMessage(ChatColor.DARK_RED + "Du bist kein Operator!");
                    }
                }
                if(command.getName().equalsIgnoreCase("warp")){
                    if(warpPoints.containsKey(args[0])) {
                        cmdSender.teleport(warpPoints.get(args[0]));
                    }else {
                        sender.sendMessage(ChatColor.GREEN + "Dieser Warppunkt existiert nicht!");
                    }
                }
                if(command.getName().equalsIgnoreCase("deletewarp")) {
                    if(sender.isOp()) {
                        if(warpPoints.containsKey(args[0])) {
                            warpPoints.remove(args[0]);
                            sender.sendMessage(ChatColor.GREEN + "Du hast den Warppunkt " + args[0] + " erfolgreich gelöscht!");
                        }else {
                            sender.sendMessage(ChatColor.GREEN + "Dieser Warppunkt existiert nicht!");
                        }
                    }else {
                        sender.sendMessage(ChatColor.DARK_RED + "Du bist kein Operator!");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.YELLOW + "Spezifiziere EINEN Warppunkt!");
            }
        return false;
    }
}
