package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;


public class RespawnListener implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        player.setHealth(20);
        player.setFoodLevel(20);
    }
    @EventHandler
    public void onDeath(EntityDeathEvent event){

        Location respawnLocation = new Location(Bukkit.getWorld("world"), -392.5, 16, -13.5);

        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class),new Runnable() {
                ItemStack arrows = new ItemStack(Material.ARROW, 32);
                @Override
                public void run() {
                    player.spigot().respawn();
                    player.teleport(respawnLocation);
                    player.getInventory().remove(Material.ARROW);
                    player.getInventory().setItem(20,arrows);
                }
            }, 20);
        }
    }
}

