package game.plugin.game_plugin.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    public static boolean control = false;

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(control == true) {
            event.setCancelled(true);
        }
    }

}
