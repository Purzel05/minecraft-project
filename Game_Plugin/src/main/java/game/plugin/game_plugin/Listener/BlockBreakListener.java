package game.plugin.game_plugin.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    public static boolean controlBreak = true;
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(controlBreak == true && !event.getBlock().getType().equals(Material.FIRE)) {
                event.setCancelled(true);
        }
    }
}
