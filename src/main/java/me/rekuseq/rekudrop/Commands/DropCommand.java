package me.rekuseq.rekudrop.Commands;

import me.rekuseq.rekudrop.RekuDrop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class DropCommand implements CommandExecutor {
    private final RekuDrop plugin;

    public DropCommand(RekuDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                //OTWARCIE MENU DROPOW
                plugin.inventories.openDropListInventory(p);
            }
        }

        return false;
    }
}
