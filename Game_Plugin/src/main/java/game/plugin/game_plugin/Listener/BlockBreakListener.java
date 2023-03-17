package game.plugin.game_plugin.Listener;

import org.bukkit.block.Block;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    public static boolean controlBreak = false;
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(controlBreak == true) {
            if(event.getBlock() instanceof Fire){
                event.setCancelled(false);
            } else {
                event.setCancelled(true);
            }
        }
    }

}
