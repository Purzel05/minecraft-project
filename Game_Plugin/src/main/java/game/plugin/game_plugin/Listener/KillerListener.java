package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Commands.StartCommand;
import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.projectiles.ProjectileSource;

public class KillerListener implements Listener {
    @EventHandler
    public void onPlayerDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player killedPlayer = (Player) event.getEntity();
            EntityDamageEvent deathcause = killedPlayer.getLastDamageCause();
            if(deathcause != null) {
                if (deathcause.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || deathcause.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                    EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) deathcause;
                    Entity killerEntity = killedPlayer.getKiller();
                    if (killerEntity instanceof Projectile) {
                        ProjectileSource projectileSender = ((Projectile) killerEntity).getShooter();
                        if (projectileSender instanceof Player) {
                            killerEntity = (Player) projectileSender;
                        }
                    }
                    if (killerEntity != null) {
                        Player killerPlayer = (Player) killerEntity;
                        killedPlayer.sendMessage("§5§l§[Du wurdest von " + killerPlayer.getName() + ("§5§l§[ und dem allmächtigem Schleggagott zerquetscht"));
                        KillcounterScoreboard killerScoreboard = StartCommand.scoreboards.get(killerPlayer.getUniqueId());
                        killerScoreboard.killUpdate();
                        killerPlayer.setHealth(20);
                        if (killerScoreboard.getContent() == 10) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "end");
                            killerPlayer.sendMessage(ChatColor.GREEN + "Du hast gewonnen!");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                if (!p.getName().equalsIgnoreCase(killerPlayer.getName())) {
                                    p.sendMessage(ChatColor.RED + killerPlayer.getName() + ChatColor.GREEN + " hat gewonnen!");
                                }
                            }
                        }
                        Bukkit.broadcastMessage("3");
                    }
                    Bukkit.broadcastMessage("2");
                }
                Bukkit.broadcastMessage("1");
            }
            Bukkit.broadcastMessage("0");
        }
    }
}
