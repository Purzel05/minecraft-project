package game.plugin.game_plugin.Listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEntityListener implements Listener {
    @EventHandler
    public void onArmorstandManipulate(PlayerArmorStandManipulateEvent event) {
        if (BlockBreakListener.controlBreak == true && BlockPlaceListener.controlPlace == true) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        Entity interactedEntity = event.getRightClicked();

        if(interactedEntity.getType().equals(EntityType.GLOW_ITEM_FRAME) || interactedEntity.getType().equals(EntityType.ITEM_FRAME)) {
            if(BlockBreakListener.controlBreak == true) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Block clickedBlock = event.getClickedBlock();

            if (clickedBlock.getType().equals(Material.CHEST) || clickedBlock.getType().equals(Material.BREWING_STAND) || clickedBlock.getType().equals(Material.BARREL)) {

                if (BlockBreakListener.controlBreak == true && BlockPlaceListener.controlPlace == true) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onHangingBreak(HangingBreakByEntityEvent event) {
        Entity brokenHanging = event.getEntity();
        if(BlockBreakListener.controlBreak == true) {
            event.setCancelled(true);
        }
    }
}
