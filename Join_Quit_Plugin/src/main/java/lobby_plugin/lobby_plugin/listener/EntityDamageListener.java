package lobby_plugin.lobby_plugin.listener;

import net.md_5.bungee.api.chat.hover.content.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler

    public void onDamage(EntityDamageEvent event) {

        if(event.getEntity() instanceof Player) {

            event.setCancelled(true);

        }

    }


}
