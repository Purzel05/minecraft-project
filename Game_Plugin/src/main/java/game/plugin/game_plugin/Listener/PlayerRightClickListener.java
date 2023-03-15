package game.plugin.game_plugin.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRightClickListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        ItemStack[] armorBerserk = new ItemStack[4];
        armorBerserk[0] = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        armorBerserk[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        armorBerserk[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        armorBerserk[3] = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemStack weaponBerserk = new ItemStack(Material.IRON_AXE, 1);

        ItemStack[] armorArcher = new ItemStack[4];
        armorArcher[0] = new ItemStack(Material.LEATHER_BOOTS, 1);
        armorArcher[1] = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        armorArcher[2] = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        armorArcher[3] = new ItemStack(Material.LEATHER_HELMET, 1);

        if (player.getItemInHand().getType() == Material.GRAY_DYE && player.getItemInHand() != null) {
            player.getInventory().clear();
            player.getInventory().setArmorContents(armorBerserk);
            player.getInventory().setItem(0, weaponBerserk);
        }
        if (player.getItemInHand().getType() == Material.LIME_DYE && player.getItemInHand() != null) {
            player.getInventory().clear();
            player.getInventory().setArmorContents(armorArcher);
        }
    }
}
