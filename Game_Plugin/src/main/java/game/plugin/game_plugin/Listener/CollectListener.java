package game.plugin.game_plugin.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;

public class CollectListener implements Listener {
    @EventHandler
    public void onCollect(PlayerPickupArrowEvent event) { event.setCancelled(true); }

}
