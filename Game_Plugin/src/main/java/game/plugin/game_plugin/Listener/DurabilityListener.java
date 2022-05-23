package game.plugin.game_plugin.Listener;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;


public class DurabilityListener implements Listener {
    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {

        Player player = event.getPlayer();
        Material eventTriggerItem = event.getItem().getType();

        if(eventTriggerItem == Material.FLINT_AND_STEEL) {
            event.setCancelled(false);
        }else {
            event.setCancelled(true);
        }

    }

}
