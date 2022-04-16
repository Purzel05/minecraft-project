package game.plugin.game_plugin;

import game.plugin.game_plugin.Commands.EndCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        commandRegistration();

    }

    @Override
    public void onDisable() {



    }

    public void commandRegistration() {

        getCommand("end").setExecutor(new EndCommand());

    }

}
