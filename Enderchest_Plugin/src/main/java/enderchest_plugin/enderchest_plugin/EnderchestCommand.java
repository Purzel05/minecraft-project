package enderchest_plugin.enderchest_plugin;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import utils.Config;
import java.io.IOException;

public class EnderchestCommand implements CommandExecutor {
    private Inventory inventory;

    public EnderchestCommand() {

        int slots = 27;

        if (Config.contains("command.enderchest.slots")){
            slots = (int) Config.get("command.enderchest.slots");
        }else {
            try {
                Config.set("command.enderchest.slots", 27);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        this.inventory = Bukkit.createInventory(null,slots,"§6Enderchest");



    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player) {
            Player player = ((Player) sender);
            player.openInventory(inventory);
        } else {
            sender.sendMessage("Leo stinkt");
        }
        return false;
    }

}
