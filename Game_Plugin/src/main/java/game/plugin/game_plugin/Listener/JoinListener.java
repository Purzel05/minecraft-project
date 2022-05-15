package game.plugin.game_plugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.AQUA + "Sei gegrüßt " + ChatColor.YELLOW + player.getName() + ChatColor.AQUA + "!");
        Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 0, 0.5);
        player.teleport(spawn);
        player.getInventory().clear();
        event.setJoinMessage("");
        player.setFoodLevel(20);
        player.setHealth(20);

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(!p.getName().equalsIgnoreCase(player.getName())) {
                p.sendMessage(ChatColor.BLUE + "Wir grüßen " + ChatColor.GREEN + player.getName() + ChatColor.BLUE + " auf dem Server!");
            }
        }

    }

}

