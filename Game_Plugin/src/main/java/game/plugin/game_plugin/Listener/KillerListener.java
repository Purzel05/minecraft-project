package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Commands.StartCommand;
import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillerListener implements Listener {

    @EventHandler
    public void onPlayerDeath(final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {

            Player killedPlayer = (Player) event.getEntity();
            EntityDamageEvent deathcause = killedPlayer.getLastDamageCause();

            if (deathcause.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {

                Entity killerEntity = (((EntityDamageByEntityEvent) deathcause).getDamager());

                if (killerEntity instanceof Player) {

                    Player killerPlayer = (Player) killerEntity;
                    killedPlayer.sendMessage("§5§l§[Du wurdest von " + killerPlayer.getName() + ("§5§l§[ und dem allmächtigem Schleggagott zerquetscht"));

                    KillcounterScoreboard killerScoreboard = StartCommand.scoreboards.get(killerPlayer.getUniqueId());

                    killerScoreboard.killUpdate();

                    if(killerScoreboard.getContent() == 10) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "end");
                    }
                }
            }

        }

    }

}
