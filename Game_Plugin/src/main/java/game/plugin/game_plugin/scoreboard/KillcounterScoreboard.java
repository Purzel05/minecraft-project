package game.plugin.game_plugin.scoreboard;

import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.nio.Buffer;

public class KillcounterScoreboard extends AbstractScoreboard {
    private int content = 0;

    public KillcounterScoreboard(Player player) {
        super(player, "  §5§[Killcounter  ");
    }

    @Override
    public void createScoreboard() {
        setScore(String.valueOf(content), 0);
    }

    public void killUpdate() {
        content = content + 1;
        setScore(String.valueOf(content), 0);
    }

    @Override
    public void update() {

    }

    private void run(){
    }
}


