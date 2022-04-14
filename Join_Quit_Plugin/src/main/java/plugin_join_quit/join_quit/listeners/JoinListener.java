package plugin_join_quit.join_quit.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.sendMessage("&b Na du Lappen");
        event.setJoinMessage("&d Ein Lappen is erschienen");

    }

}
