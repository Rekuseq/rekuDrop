package me.rekuseq.rekudrop;


import me.rekuseq.rekudrop.Commands.DropCommand;
import me.rekuseq.rekudrop.Enums.Message;
import me.rekuseq.rekudrop.Events.OnInventoryClickEvent;
import me.rekuseq.rekudrop.Events.OnBreakStone;
import me.rekuseq.rekudrop.Utilies.DropToggle;
import me.rekuseq.rekudrop.Utilies.Inventories;
import me.rekuseq.rekudrop.Utilies.StringUtilies;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RekuDrop extends JavaPlugin implements CommandExecutor, TabCompleter {
    public final DropToggle DropToggle;
    public final OnInventoryClickEvent onInventoryClickEvent;
    public final Inventories inventories;
    public final OnBreakStone onBreakStone;
    public final StringUtilies stringUtilies;
    public final ConfigManager configManager;


    public  RekuDrop(){
        this.DropToggle = new DropToggle();
        this.inventories = new Inventories(this);
        this.onBreakStone = new OnBreakStone(this);
        this.onInventoryClickEvent = new OnInventoryClickEvent(this);
        this.stringUtilies = new StringUtilies();
        this.configManager = new ConfigManager(this);
    }

    @Override
    public void onEnable() {
        configManager.loadConfig();
        registerEvents();
        getCommand("drop").setExecutor(new DropCommand(this));
        getCommand("rekudrop").setExecutor(this);

        Bukkit.getConsoleSender().sendMessage(Message.PLUGIN_NAME_PREFIX.toString() + Message.PLUGIN_ENABLE);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Message.PLUGIN_NAME_PREFIX.toString() + Message.PLUGIN_DISABLE);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       if(cmd.getName().equalsIgnoreCase("rekudrop") && args[0].equalsIgnoreCase("reload")){
           if(sender.isOp() || sender.hasPermission("rekudrop.reload")){
               sender.sendMessage(ChatColor.GRAY + "Starting reload...");
               HandlerList.unregisterAll(this);
               registerEvents();
               configManager.reloadConfig();
               sender.sendMessage(ChatColor.GREEN + "Reload complete");
           }
       }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(sender.isOp() || sender.hasPermission("rekudrop.reload")){
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("reload"), new ArrayList<>());
        }
        return super.onTabComplete(sender, command, alias, args);
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(onInventoryClickEvent, this);
        getServer().getPluginManager().registerEvents(onBreakStone, this);
    }
}
