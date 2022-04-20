package game.plugin.game_plugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class HashMap extends JavaPlugin implements Listener, CommandExecutor {

    public java.util.HashMap<Player, Integer> hashMap = new java.util.HashMap<>();

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

                    int value = hashMap.get(event.getEntity());

                    hashMap.put((Player) event.getEntity(), value + 1);

                }
            }

        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin lobby_Plugin = Bukkit.getPluginManager().getPlugin("Lobby_Plugin");

        if(!lobby_Plugin.isEnabled()) {

            Bukkit.getPluginManager().enablePlugin(lobby_Plugin);

            Bukkit.getLogger().fine("Lobby_Plugin wird aktiviert.");

        }

        hashMap.put((Player) Bukkit.getOnlinePlayers(), 0);

        return false;
    }

}
