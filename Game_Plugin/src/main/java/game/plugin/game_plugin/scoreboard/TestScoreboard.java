package game.plugin.game_plugin.scoreboard;
import org.bukkit.entity.Player;

public class TestScoreboard extends scorboardbuilder {
    public int content = 0;
    public TestScoreboard(Player player) {

        super(player, "  §5§[Killcounter  ");

    }

    @Override
    public void createScoreboard() {
        setScore(content,0);
     }


     @Override
    public void update() {
    }

}


