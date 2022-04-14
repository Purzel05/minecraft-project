package lobby_plugin.lobby_plugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler

    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.sendMessage(ChatColor.AQUA + "Sei gegrüßt " + ChatColor.YELLOW + player.getName() + ChatColor.AQUA + "!");
        event.setJoinMessage(ChatColor.BLUE + "Wir grüßen " + ChatColor.GREEN + player.getName() + ChatColor.BLUE + " auf dem Server!");

        Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 0, 0.5);
        player.teleport(spawn);
    }

}
