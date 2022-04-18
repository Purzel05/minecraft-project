package lobby_plugin.lobby_plugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    public static boolean deez = false;

    @EventHandler
    public void onJump(PlayerMoveEvent event) {

        if(deez == true) {

            Player player = event.getPlayer();

            if (player.getName().equalsIgnoreCase("Porzl2k5")) {

                player.sendMessage(ChatColor.DARK_RED + "Deez nuts");

            }

        }

    }



}
