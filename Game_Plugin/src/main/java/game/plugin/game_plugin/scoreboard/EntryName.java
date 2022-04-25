package game.plugin.game_plugin.scoreboard;

import org.bukkit.ChatColor;

public enum EntryName {
    ENTRY_0(0, ChatColor.AQUA.toString()),
    ENTRY_1(1, ChatColor.DARK_AQUA.toString()),
    ENTRY_2(2, ChatColor.DARK_RED.toString()),
    ENTRY_3(3, ChatColor.BOLD.toString()),
    ENTRY_4(4, ChatColor.BLUE.toString()),
    ENTRY_5(5, ChatColor.DARK_GRAY.toString()),
    ENTRY_6(6, ChatColor.GREEN.toString()),
    ENTRY_7(7, ChatColor.GOLD.toString()),
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
