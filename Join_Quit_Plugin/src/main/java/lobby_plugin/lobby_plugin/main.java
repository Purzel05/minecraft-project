package lobby_plugin.lobby_plugin;

import lobby_plugin.lobby_plugin.Commands.DeezCommand;
import lobby_plugin.lobby_plugin.Commands.StartCommand;
import lobby_plugin.lobby_plugin.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

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

        pluginManager.registerEvents(new JoinListener(), this);

        pluginManager.registerEvents(new QuitListener(), this);

        pluginManager.registerEvents(new PlayerDeathListener(), this);

        pluginManager.registerEvents(new EntityDamageListener(), this);

        pluginManager.registerEvents(new FoodChangeListener(),this);

        pluginManager.registerEvents(new PlayerMoveListener(), this);
    }

    public void commandRegistration() {

        getCommand("start").setExecutor(new StartCommand());

        getCommand("deez").setExecutor(new DeezCommand());

    }

}
