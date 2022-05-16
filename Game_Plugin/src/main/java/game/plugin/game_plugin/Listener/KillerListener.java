package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.Commands.StartCommand;
import game.plugin.game_plugin.scoreboard.KillcounterScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    public void onPlayerDeath( EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player killedPlayer = (Player) event.getEntity();
            EntityDamageEvent deathcause = killedPlayer.getLastDamageCause();

            if (deathcause.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                Entity killerEntity = (((EntityDamageByEntityEvent) deathcause).getDamager());

                if (killerEntity instanceof Player) {
                    Player killerPlayer = (Player) killerEntity;
                    killedPlayer.sendMessage("§5§l§[Du wurdest von " + killerPlayer.getName() + ("§5§l§[ und dem allmächtigem Schleggagott zerquetscht"));

                    ItemStack Arrows = new ItemStack(Material.ARROW, 32);
                    KillcounterScoreboard killerScoreboard = StartCommand.scoreboards.get(killerPlayer.getUniqueId());
                    killerScoreboard.killUpdate();
                    killerPlayer.setHealth(20);
                    killerPlayer.getInventory().remove(Material.ARROW);
                    killerPlayer.getInventory().setItem(20,Arrows);

                    if(killerScoreboard.getContent() == 10) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "end");
                        killerPlayer.sendMessage(ChatColor.GREEN + "Du hast gewonnen!");
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if(!p.getName().equalsIgnoreCase(killerPlayer.getName())) {
                                p.sendMessage(ChatColor.RED + killerPlayer.getName() + ChatColor.GREEN + " hat gewonnen!");
                            }
                        }
                    }
                }
            }
        }
    }
}
