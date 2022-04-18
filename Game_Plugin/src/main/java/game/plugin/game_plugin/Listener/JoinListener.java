package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.scoreboard.TestScoreboard;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new TestScoreboard(player);


    }

    @EventHandler()
    public void onPlayerDeath( final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();
            EntityDamageEvent deathcause = player.getLastDamageCause();
            if (deathcause.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                Entity entity = (((EntityDamageByEntityEvent)deathcause).getDamager());



                if(entity instanceof Player){
                    Player killerPlayer = (Player)entity;
                    player.sendMessage("Du wurdest von " +killerPlayer.getName() + ( "getötet"));

                }
            }

        }

    }
}