package game.plugin.game_plugin.scoreboard;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class TestScoreboard extends scorboardbuilder{

    public TestScoreboard(Player player) {
        super(player, "  §5§[Killcounter  ");
    }

    @Override
    public void createScoreboard() {
     setScore(player.getAddress().getHostName(),0);
    }




    @Override
    public void update() {

    }
}
