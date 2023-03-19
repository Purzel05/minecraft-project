package game.plugin.game_plugin.Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener {
    @EventHandler
    public void onArmorstandInteract(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.ARMOR_STAND){
            event.setCancelled(true);
        }
    }

}
