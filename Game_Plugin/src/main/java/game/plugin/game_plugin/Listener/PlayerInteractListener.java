package game.plugin.game_plugin.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().getType() == Material.CHAINMAIL_CHESTPLATE){
            giveBerserk(player);
        }
        else if (player.getInventory().getItemInMainHand().getType() == Material.BOW) {

        }
        else if (player.getInventory().getItemInMainHand().getType() == Material.LEATHER_CHESTPLATE){

        }
    }

    public void giveBerserk(Player p) {
        p.getInventory().clear();
        ItemStack[] armor = new ItemStack[4];
        armor[0] = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        armor[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        armor[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        armor[3] = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        p.getInventory().setArmorContents(armor);
        ItemStack axe = new ItemStack(Material.IRON_AXE, 1);
        ItemStack shield = new ItemStack(Material.SHIELD, 1);
        ItemStack food = new ItemStack(Material.COOKED_BEEF, 32);
        ItemStack strength = new ItemStack(Material.POTION, 1);
        PotionMeta potionMeta = (PotionMeta) strength.getItemMeta();
        potionMeta.setMainEffect(PotionEffectType.HARM);
        strength.setItemMeta(potionMeta);
        p.getInventory().setItem(0, axe);
        p.getInventory().setItemInOffHand(shield);
        p.getInventory().setItem(1, strength);
        p.getInventory().setItem(2, food);
    }

}
