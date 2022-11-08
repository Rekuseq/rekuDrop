package me.rekuseq.rekudrop.Utilies;

import org.bukkit.ChatColor;

public class StringUtilies {

    public String translateColors(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
