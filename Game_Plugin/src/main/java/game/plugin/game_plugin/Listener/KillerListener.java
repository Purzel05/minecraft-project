package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Commands.StartCommand;
import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

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

                    ItemStack Arrows = new ItemStack(Material.ARROW, +5);
                    killerPlayer.getInventory().setItem(20,Arrows);

                    KillcounterScoreboard killerScoarboard = StartCommand.scoreboards.get(killerPlayer.getUniqueId());

                    killerScoarboard.killUpdate();

                }
            }

        }

    }

}
