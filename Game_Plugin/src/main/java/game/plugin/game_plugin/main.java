package game.plugin.game_plugin;

import game.plugin.game_plugin.Commands.WarpCommand;
import game.plugin.game_plugin.Listener.HashMap;
import game.plugin.game_plugin.Listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

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
        getCommand("end").setExecutor(new HashMap());

    }

    private void listenerRegistrations(){

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new HashMap(), this);

    }
}
