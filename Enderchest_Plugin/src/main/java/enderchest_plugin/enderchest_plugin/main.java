package enderchest_plugin.enderchest_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import utils.Config;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
      new Config();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void commandRegistration(){
        getCommand("enderchest").setExecutor(new EnderchestCommand());


    }
}
