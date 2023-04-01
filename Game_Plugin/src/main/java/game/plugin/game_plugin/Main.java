package game.plugin.game_plugin;

import game.plugin.game_plugin.Commands.BuildCommand;
import game.plugin.game_plugin.Commands.EndCommand;
import game.plugin.game_plugin.Commands.StartCommand;
import game.plugin.game_plugin.Listener.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        commandRegistration();
        listenerRegistrations();
        for(Entity e : Bukkit.getWorld("world").getEntities()) {
            if(e instanceof ItemFrame) {
                ItemFrame itemFrame = (ItemFrame) e;
                itemFrame.setFixed(true);
            }
        }
    }
    @Override
    public void onDisable() {

    }
    public void commandRegistration() {
        getCommand("end").setExecutor(new EndCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("build").setExecutor(new BuildCommand());
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
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new PlayerInteractEntityListener(), this);
    }
}
