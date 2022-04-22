package game.plugin.game_plugin.scoreboard;
import org.bukkit.entity.Player;

public class TestScoreboard extends ScoarboardBuilder {

    public TestScoreboard(Player player) {

        super(player, "  §5§[Killcounter  ");

    }

    @Override
    public void createScoreboard() {

        setScore("Deine Mom",0);

     }


     @Override
    public void update() {

    }

}


