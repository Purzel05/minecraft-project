package game.plugin.game_plugin.scoreboard;

import org.bukkit.entity.Player;

public class KillcounterScoreboard extends AbstractScoreboard {
    private int Kills;
    private int content = 0;

    public KillcounterScoreboard(Player player) {
        super(player, "  Killcounter  ");
        Kills = 0;

        run();
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
  @Override
    public void run(){
      setScore(String.valueOf(content),0);//switch case

      Kills++;
      if(Kills >= 2){
          Kills = 0;
      }
    }
    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
}


