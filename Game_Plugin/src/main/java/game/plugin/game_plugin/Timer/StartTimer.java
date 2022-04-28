package game.plugin.game_plugin.Timer;

import java.util.Timer;
import java.util.TimerTask;


public class StartTimer {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            int zeit = 0;
            @Override
            public void run() {

                zeit++;
                System.out.println(zeit);

                if (zeit == 10){
                    timer.cancel();

                }

            }
        },1000, 1000);


    }

}
