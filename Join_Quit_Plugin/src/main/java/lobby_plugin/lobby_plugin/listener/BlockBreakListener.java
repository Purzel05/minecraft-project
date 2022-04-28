package lobby_plugin.lobby_plugin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    public static boolean zeviCommand2 = true;

    @EventHandler

    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if(zeviCommand2 == false) {

            if (player.getName().equalsIgnoreCase("The_Maximalus")) {

                event.setCancelled(true);

            }

        }

    }

}
