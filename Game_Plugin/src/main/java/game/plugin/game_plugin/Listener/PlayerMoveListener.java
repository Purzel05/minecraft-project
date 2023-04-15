package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Commands.FreezeCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    public static boolean controlMove = false;
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player triggerPlayer = event.getPlayer();
        if(controlMove == true) {
            event.setCancelled(true);
        }
        if(FreezeCommand.frozenPlayers.contains(triggerPlayer.getName())) {
            Location partcilesSpawn = triggerPlayer.getLocation();
            World world = triggerPlayer.getWorld();
            event.setCancelled(true);
            world.spawnParticle(Particle.SNOWFLAKE, partcilesSpawn, 48);
        }
    }
}
