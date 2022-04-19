package game.plugin.game_plugin.Listener;

import game.plugin.game_plugin.scoreboard.TestScoreboard;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new TestScoreboard(player);


    }

}
