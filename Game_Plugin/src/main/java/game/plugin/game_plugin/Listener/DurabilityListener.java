package game.plugin.game_plugin.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class DurabilityListener implements Listener {

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {

        event.setCancelled(true);

    }
}
