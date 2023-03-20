package game.plugin.game_plugin.Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class PlayerInteractEntityListener implements Listener {
    @EventHandler
    public void onArmorstandManipulate(PlayerArmorStandManipulateEvent event) {
        event.setCancelled(true);
    }

}
