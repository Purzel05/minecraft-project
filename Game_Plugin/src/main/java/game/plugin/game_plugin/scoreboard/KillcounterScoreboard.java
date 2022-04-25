package game.plugin.game_plugin.scoreboard;

import org.bukkit.entity.Player;

public class KillcounterScoreboard extends AbstractScoreboard {
    private int socialId;
    private int content = 0;

    public KillcounterScoreboard(Player player) {
        super(player, "  §5§[Killcounter  ");
        socialId = 0;

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
      switch (socialId){
          case 0: setScore(String.valueOf(content), 0);
              break;
          case 1: setScore(String.valueOf(content), 0);
              break;

      }
      socialId++;
      if(socialId >= 2){
          socialId = 0;
      }
    }
}


