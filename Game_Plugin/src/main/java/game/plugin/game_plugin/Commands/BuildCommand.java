package game.plugin.game_plugin.Commands;

import game.plugin.game_plugin.Listener.BlockBreakListener;
import game.plugin.game_plugin.Listener.BlockPlaceListener;
import game.plugin.game_plugin.Listener.PlayerInteractEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if(sender.isOp()) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.YELLOW + "Benutze /build <on/off/info>");
            } else if (args.length == 1) {
                switch (args[0]) {
                    case "on":
                        BlockPlaceListener.controlPlace = false;
                        BlockBreakListener.controlBreak = false;
                        for (Entity e : Bukkit.getWorld("world").getEntities()) {
                            if (e.getType().equals(EntityType.ITEM_FRAME) || e.getType().equals(EntityType.GLOW_ITEM_FRAME)) {
                                ItemFrame itemFrame = (ItemFrame) e;
                                itemFrame.setFixed(false);
                            }
                        }
                        sender.sendMessage(ChatColor.YELLOW + "Bauen ist jetzt aktiviert");
                        break;
                    case "off":
                        BlockPlaceListener.controlPlace = true;
                        BlockBreakListener.controlBreak = true;
                        for (Entity e : Bukkit.getWorld("world").getEntities()) {
                            if (e.getType().equals(EntityType.ITEM_FRAME) || e.getType().equals(EntityType.GLOW_ITEM_FRAME)) {
                                ItemFrame itemFrame = (ItemFrame) e;
                                itemFrame.setFixed(true);
                            }
                        }
                        sender.sendMessage(ChatColor.YELLOW + "Bauen ist jetzt deaktiviert");
                        break;
                    case "info":
                        if (BlockBreakListener.controlBreak == false && BlockPlaceListener.controlPlace == false) {
                            sender.sendMessage(ChatColor.YELLOW + "Bauen ist aktiviert");
                        } else if (BlockBreakListener.controlBreak == true && BlockPlaceListener.controlPlace == true) {
                            sender.sendMessage(ChatColor.YELLOW + "Bauen ist deaktiviert");
                        }
                        break;
                    default:
                        sender.sendMessage(ChatColor.YELLOW + "Benutze /build <on/off/info>");
                        break;
                }
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "Du bist kein Operator!");
        }
        return false;
    }
}
