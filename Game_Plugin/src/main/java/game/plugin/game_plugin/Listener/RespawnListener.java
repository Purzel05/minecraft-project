package game.plugin.game_plugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

import java.net.DatagramPacket;

public class RespawnListener implements Listener {

    public static Plugin plugin;
    public void Event (Plugin plugin){
        this.plugin = plugin;
    }

    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location respawnLocation = new Location(Bukkit.getWorld("world"), -392.5, 16, -13.5);
        player.teleport(respawnLocation);
    }

    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {

            @Override
            public void run() {
             
            }
        },20);


    }

}

