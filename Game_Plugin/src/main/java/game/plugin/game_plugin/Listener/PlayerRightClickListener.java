package game.plugin.game_plugin.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRightClickListener implements Listener {
    ItemStack berserk = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        ItemStack[] armorBerserk = new ItemStack[4];
        armorBerserk[0] = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        armorBerserk[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        armorBerserk[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        armorBerserk[3] = new ItemStack(Material.CHAINMAIL_HELMET, 1);

        if(player.getInventory().getItemInMainHand() == berserk){
            player.getInventory().remove(Material.CHAINMAIL_CHESTPLATE);
            player.getInventory().setArmorContents(armorBerserk);
        }
    }

}
