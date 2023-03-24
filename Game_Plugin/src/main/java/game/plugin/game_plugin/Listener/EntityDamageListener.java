package game.plugin.game_plugin.Listener;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTameEvent;

public class EntityDamageListener implements Listener {
    public static boolean damageControl = true;
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player && damageControl == true) {
            event.setCancelled(true);
        }

        if (BlockBreakListener.controlBreak == true) {
            if (entity.getType().equals(EntityType.ARMOR_STAND)){
                event.setCancelled(true);
            }
        }
    }

}
