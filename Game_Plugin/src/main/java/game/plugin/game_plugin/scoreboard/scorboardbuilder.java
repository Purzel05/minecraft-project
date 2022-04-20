package game.plugin.game_plugin.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public abstract class scorboardbuilder {
    protected final Scoreboard scoreboard;
    protected final Objective objective;
  protected final Player player;

    public scorboardbuilder(Player player, String displayName) {
        this.player = player;

        if(player.getScoreboard().equals(Bukkit.getScoreboardManager().getMainScoreboard())){
            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());


        }


        this.scoreboard = player.getScoreboard();

        if(this.scoreboard.getObjective("display")!= null){
            this.scoreboard.getObjective("display").unregister();

        }

        this.objective = this.scoreboard.registerNewObjective("display","dummy","Killcounter");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);


        createScoreboard();

    }

    public abstract void createScoreboard();



    public abstract void update();




    public void setDisplayName(String displayName){
        this.objective.setDisplayName(displayName);

    }

    public void setScore(int content, int score){

        this.objective.getScore(String.valueOf(content)).setScore(score);

    }

    public void setContent(int content) {

        this.scoreboard.getScores(String.valueOf(content));

    }

    public void removeScore(int content){
        this.scoreboard.resetScores(String.valueOf(content));

    }

}
