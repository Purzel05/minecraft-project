package lobby_plugin.lobby_plugin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    public static boolean zeviCommand = true;
    @EventHandler
    public void onBlockBreak(BlockPlaceEvent event) {

        Player player = event.getPlayer();
        if(zeviCommand == false) {
            if (player.getName().equalsIgnoreCase("The_Maximalus")) {
                event.setCancelled(true);
            }
        }
    }
}
