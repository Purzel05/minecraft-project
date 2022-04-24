package game.plugin.game_plugin.scoreboard;

import org.bukkit.ChatColor;

public enum EntryName {
    ENTRY_0(0, ChatColor.AQUA.toString()),
    ENTRY_1(0, ChatColor.DARK_AQUA.toString()),
    ENTRY_2(0, ChatColor.DARK_RED.toString()),
    ENTRY_3(0, ChatColor.BOLD.toString()),
    ENTRY_4(0, ChatColor.BLUE.toString()),
    ENTRY_5(0, ChatColor.DARK_GRAY.toString()),
    ENTRY_6(0, ChatColor.GREEN.toString()),
    ENTRY_7(0, ChatColor.GOLD.toString()),
    ENTRY_8(0, ChatColor.YELLOW.toString()),
    ;

    private final int entry;
   private final String entryName;

    EntryName(int entry, String entryName) {
        this.entry = entry;
        this.entryName = entryName;
    }

    public int getEntry() {
        return entry;
    }

    public String getEntryName() {
        return entryName;
    }
}
