package game.plugin.game_plugin.Listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillerListener implements Listener {
    @EventHandler()
    public void onPlayerDeath(final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();
            EntityDamageEvent deathcause = player.getLastDamageCause();
            if (deathcause.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                Entity entity = (((EntityDamageByEntityEvent) deathcause).getDamager());


                if (entity instanceof Player) {
                    Player killerPlayer = (Player) entity;
                    player.sendMessage("§5§l§[Du wurdest von " + killerPlayer.getName() + ("§5§l§[ und dem allmächtigem Schleggagott zerquetscht"));


                }
            }

        }

    }
}

