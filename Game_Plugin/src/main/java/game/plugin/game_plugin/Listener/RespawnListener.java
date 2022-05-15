package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


public class RespawnListener implements Listener {
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location respawnLocation = new Location(Bukkit.getWorld("world"), -392.5, 16, -13.5);
        player.teleport(respawnLocation);
        player.setHealth(20);
        player.setFoodLevel(20);
    }
    public void onDeath(EntityDeathEvent event){

        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class),new Runnable() {
                @Override
                public void run() {
                    player.spigot().respawn();
                }
            }, 20);
        }
    }
}

