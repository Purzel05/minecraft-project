package lobby_plugin.lobby_plugin;

import lobby_plugin.lobby_plugin.listener.JoinListener;
import lobby_plugin.lobby_plugin.listener.PlayerDeathListener;
import lobby_plugin.lobby_plugin.listener.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        listenerRegistration();

    }

    @Override
    public void onDisable() {



    }

    public void listenerRegistration() {

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new JoinListener(), this);

        pluginManager.registerEvents(new QuitListener(), this);

        pluginManager.registerEvents(new PlayerDeathListener(), this);
    }

}
