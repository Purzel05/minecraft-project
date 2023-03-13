package game.plugin.game_plugin.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    public static boolean controlBreak = true;
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(controlBreak == false){
            event.setCancelled(true);
        }
    }

}
