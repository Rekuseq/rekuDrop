package me.rekuseq.rekudrop.Enums;

import org.bukkit.ChatColor;

public enum Message {
    PLUGIN_NAME_PREFIX("[rekuDrop] "),
    PLUGIN_ENABLE(ChatColor.GREEN + "Plugin enabling"),
    PLUGIN_DISABLE(ChatColor.RED + "Plugin disabling");


    private String defaultMessage;

    Message(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
