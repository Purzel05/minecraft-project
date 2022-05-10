package game.plugin.game_plugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerDeathListener implements Listener {

    public Plugin plugin;
    public void Event(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        Player player = event.getEntity().getPlayer();

        player.spigot().respawn();

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getName() != player.getName()) {
                p.sendMessage(ChatColor.GOLD + event.getEntity().getPlayer().getName() + ChatColor.DARK_RED + " hats erwischt");
            }
        }
    }
}
