package lobby_plugin.lobby_plugin;

import lobby_plugin.lobby_plugin.Commands.DeezCommand;
import lobby_plugin.lobby_plugin.Commands.ZeviBuildCommand;
import lobby_plugin.lobby_plugin.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {

        listenerRegistration();
        commandRegistration();

    }

    @Override
    public void onDisable() {



    }

    public void listenerRegistration() {

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new FoodChangeListener(),this);
        pluginManager.registerEvents(new PlayerMoveListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new BlockPlaceListener(),this);
        pluginManager.registerEvents(new LeoIsADeppeloperListener(),this);

    }

    public void commandRegistration() {

        getCommand("deez").setExecutor(new DeezCommand());
        getCommand("zevibuild").setExecutor(new ZeviBuildCommand());

    }

}
