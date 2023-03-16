package game.plugin.game_plugin;

import game.plugin.game_plugin.Commands.EndCommand;
import game.plugin.game_plugin.Commands.StartCommand;
import game.plugin.game_plugin.Commands.WarpCommand;
import game.plugin.game_plugin.Listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        commandRegistration();
        listenerRegistrations();

    }

    @Override
    public void onDisable() {



    }

    public void commandRegistration() {

        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("end").setExecutor(new EndCommand());
        getCommand("start").setExecutor(new StartCommand());

    }

    private void listenerRegistrations(){

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new KillerListener(), this);
        pluginManager.registerEvents(new QuitListener(),this);
        pluginManager.registerEvents(new PlayerDeathListener(),this);
        pluginManager.registerEvents(new RespawnListener(),this);
        pluginManager.registerEvents(new PlayerMoveListener(),this);
        pluginManager.registerEvents(new ArrowCollectListener(),this);
        pluginManager.registerEvents(new DurabilityListener(),this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new BlockPlaceListener(),this);
        pluginManager.registerEvents(new PlayerRightClickListener(), this);

    }
}
