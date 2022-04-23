package game.plugin.game_plugin.scoreboard;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class TestScoreboard extends ScoarboardBuilder implements Listener {
    private int content = 0;
    private Player killerPlayer;

    public TestScoreboard(Player player) {

        super(player, "  §5§[Killcounter  ");

    }
    @Override
    public void createScoreboard() {

        setScore(String.valueOf(content),0);

     }
     @Override
    public void update() {

    }

    @EventHandler
    public void onPlayerDeath(final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();
            EntityDamageEvent deathcause = player.getLastDamageCause();

            if (deathcause.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {

                Entity entity = (((EntityDamageByEntityEvent) deathcause).getDamager());

                if (entity instanceof Player) {

                    Player killerPlayer = (Player) entity;
                    player.sendMessage("§5§l§[Du wurdest von " + killerPlayer.getName() + ("§5§l§[ und dem allmächtigem Schleggagott zerquetscht"));

                    this.killerPlayer = event.getEntity().getKiller();

                    killUpdate();

                }
            }

        }

    }

    public void killUpdate() {

        this.content = content + 1;

        TestScoreboard killerScoarboard = new TestScoreboard(killerPlayer);

        killerScoarboard.setScore(String.valueOf(content), 0);

    }

}




