package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.Listener.BlockBreakListener;
import game.plugin.game_plugin.Listener.BlockPlaceListener;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class EndCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

        if(!lobby_Plugin.isEnabled()) {
            Bukkit.getPluginManager().enablePlugin(lobby_Plugin);
            Bukkit.getLogger().fine("Lobby_Plugin wird aktiviert.");
            sender.sendMessage(ChatColor.DARK_PURPLE + "Lobby_Plugin wird aktiviert!");
        }

        Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 0, 0.5);

        World world = Bukkit.getWorld("world");
        List<Entity> entityList = world.getEntities();

        for(Entity i : entityList) {
            if(i.getType() == EntityType.DROPPED_ITEM) {
                i.remove();
            }
        }

        BlockBreakListener.controlBreak = true;
        BlockPlaceListener.controlPlace = true;

        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setGameMode(GameMode.SURVIVAL);
            p.teleport(spawn);
            p.getInventory().clear();
            p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
            p.setHealth(20);
            p.setFoodLevel(20);
            if(p.isOp() == false){
                p.setOp(true);
            }
        }

        return false;
    }

}
