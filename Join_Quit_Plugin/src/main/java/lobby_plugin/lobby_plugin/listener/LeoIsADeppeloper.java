package lobby_plugin.lobby_plugin.listener;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class LeoIsADeppeloper implements Listener{
    @EventHandler
    public void zensur (AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        String message = event.getMessage();

        List <String> blocked = new ArrayList<String>();
        blocked.add("Schleggamann stinkt");
        blocked.add("Emmanuel stinkt");
        blocked.add("Du stinkst");
        blocked.add("Emmanuel ist ein Lauch");
        blocked.add("Schleggamann ist ein Lauch");
        blocked.add("Du bist ein Lauch");


        for (String block : blocked){
            if(message.contains(block)){
                String replace = "";
                for (int t = 0;t < block.length(); t++){
                   replace = replace + "#";
                }
                String newMessage = message.replace(block,replace);
                event.setMessage(newMessage);
                player.sendMessage("Sowas solltest du nicht mehr über den tollen Schleggamann sagen");
            }

        }

        if (message.contains("Emmanuel")){
            event.setMessage("Der beste Developer");

        }
        if(message.contains("Leo" )){
            event.setMessage("Der Deppeloper");
        }

          }







}
