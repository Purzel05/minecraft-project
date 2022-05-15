package lobby_plugin.lobby_plugin.listener;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class PlayerMoveListener implements Listener {
    public static boolean deez = false;
    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        if(deez == true) {
            String cmdExecutor = "Porzl2k5";
            Player player = event.getPlayer();
            if (player.getName().equalsIgnoreCase("Schleggamann")) {
                player.sendMessage(ChatColor.DARK_RED + "Deez nuts");
            }
        }
    }
}
