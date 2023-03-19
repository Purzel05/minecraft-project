package game.plugin.game_plugin.Listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerRightClickListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getClickedBlock().getType() == Material.ARMOR_STAND) {
                event.setCancelled(true);
            }
        }

        ItemStack Flint_and_Steel = new ItemStack(Material.FLINT_AND_STEEL, 1);
        ItemMeta itemMeta = Flint_and_Steel.getItemMeta();
        if (itemMeta instanceof Damageable){
            ((Damageable)itemMeta).setDamage(61);
        }
        Flint_and_Steel.setItemMeta(itemMeta);

        ItemStack[] armorBerserk = new ItemStack[4];
        armorBerserk[0] = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        armorBerserk[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        armorBerserk[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        armorBerserk[3] = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemStack weaponBerserk = new ItemStack(Material.IRON_AXE, 1);
        ItemStack shield = new ItemStack(Material.SHIELD, 1);
        ItemStack food = new ItemStack(Material.COOKED_BEEF, 32);

        ItemStack[] armorArcher = new ItemStack[4];
        armorArcher[0] = new ItemStack(Material.LEATHER_BOOTS, 1);
        armorArcher[1] = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        armorArcher[2] = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        armorArcher[3] = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemStack meeleWeapon = new ItemStack(Material.WOODEN_SWORD, 1);

        if (player.getItemInHand().getType() == Material.GRAY_DYE && player.getItemInHand() != null) {
            player.getInventory().clear();
            player.getInventory().setArmorContents(armorBerserk);
            player.getInventory().setItem(0, weaponBerserk);
            player.getInventory().setItemInOffHand(shield);
            player.getInventory().setItem(2, food);
            player.getInventory().setItem(1, Flint_and_Steel);
        }
        if (player.getItemInHand().getType() == Material.LIME_DYE && player.getItemInHand() != null) {
            player.getInventory().clear();
            player.getInventory().setArmorContents(armorArcher);
            player.getInventory().setItem(20, arrows);
            player.getInventory().setItem(3, food);
            player.getInventory().setItem(1, bow);
            player.getInventory().setItem(0, meeleWeapon);
            player.getInventory().setItem(2, Flint_and_Steel);
        }
    }
}
