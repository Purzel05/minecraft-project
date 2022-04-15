package lobby_plugin.lobby_plugin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodChangeListener implements Listener {

    @EventHandler

    public void onFoodChange(FoodLevelChangeEvent event) {

        Player foodChangedPlayer = (Player) event.getEntity();
        event.setCancelled(true);

    }

}
