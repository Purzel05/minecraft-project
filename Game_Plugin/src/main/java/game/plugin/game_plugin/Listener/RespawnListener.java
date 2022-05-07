package game.plugin.game_plugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {

    public void onRespawn(PlayerRespawnEvent event) {

        Player player = event.getPlayer();
        Location respawnLocation = new Location(Bukkit.getWorld("world"), -392.5, 16, -13.5);
        player.teleport(respawnLocation);

    }

}
