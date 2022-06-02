package game.plugin.game_plugin.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    public static boolean controlPlace = true;
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(controlPlace == false){
            event.setCancelled(true);
        }
    }

}
