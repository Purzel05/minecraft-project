package lobby_plugin.lobby_plugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler

    public void onDeath(PlayerDeathEvent event) {

        Player player = event.getEntity().getPlayer();
        event.setDeathMessage(ChatColor.GOLD + player.getName() + ChatColor.DARK_RED + " hats erwischt.");

    }

}
