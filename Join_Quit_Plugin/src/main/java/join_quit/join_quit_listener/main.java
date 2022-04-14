package join_quit.join_quit_listener;

import join_quit.join_quit_listener.listener.JoinListener;
import join_quit.join_quit_listener.listener.QuitListener;
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
    }

}
