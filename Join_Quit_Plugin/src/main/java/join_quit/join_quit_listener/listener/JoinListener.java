package join_quit.join_quit_listener.listener;

import org.bukkit.ChatColor;
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

    }

}
