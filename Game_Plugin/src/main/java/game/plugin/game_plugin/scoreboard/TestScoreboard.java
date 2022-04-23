package game.plugin.game_plugin.scoreboard;

import org.bukkit.entity.Player;

public class TestScoreboard extends ScoarboardBuilder {
    private int content = 0;
    private Player killerPlayer;

    public TestScoreboard(Player player) {

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

}


