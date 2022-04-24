package game.plugin.game_plugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler

    public void onDeath(PlayerDeathEvent event) {

        Player player = event.getEntity().getPlayer();

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getName() != player.getName()) {
                p.sendMessage(ChatColor.GOLD + event.getEntity().getPlayer().getName() + ChatColor.DARK_RED + " hats erwischt");
            }
        }

    }

}
