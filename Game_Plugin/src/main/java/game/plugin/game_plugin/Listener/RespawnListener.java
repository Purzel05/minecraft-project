package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;

public class RespawnListener implements Listener {

    public Plugin plugin;
    public void Event(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
     Player player = event.getEntity();
        Location respawnLocation = new Location(Bukkit.getWorld("world"), -392.5, 16, -13.5);
        Bukkit.getScheduler().runTaskLater(this.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                player.spigot().respawn();
                player.teleport(respawnLocation);
            }
        },10);


    }

}
