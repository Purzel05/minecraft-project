package game.plugin.game_plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player executor = (Player) sender;


        Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 0, 0.5);


        if(args.length == 0) {

            executor.sendMessage(ChatColor.YELLOW + "Benutze /warp <location>");

        } else if (args.length == 1) {

            switch (args[0]) {

                case "spawn": executor.teleport(spawn); break;
                default: executor.sendMessage(ChatColor.YELLOW + "Ungültiger Warppunkt."); break;

            }

        }

        return false;
    }
}
