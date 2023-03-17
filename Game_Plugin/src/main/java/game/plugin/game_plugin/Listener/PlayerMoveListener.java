package game.plugin.game_plugin.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    public static boolean controlMove = false;

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(controlMove == true) {
            event.setCancelled(true);
        }
    }

}
