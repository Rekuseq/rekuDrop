package me.rekuseq.rekudrop.Events;

import me.rekuseq.rekudrop.RekuDrop;
import me.rekuseq.rekudrop.Utilies.Inventories;
import me.rekuseq.rekudrop.Utilies.StringUtilies;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class OnInventoryClickEvent implements Listener {
    private final RekuDrop plugin;

    public OnInventoryClickEvent(RekuDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getView().getTitle().equals(plugin.stringUtilies.translateColors(plugin.getConfig().getString("drop-inventory-title")))) {
                if (e.getCurrentItem() == null) {
                    return;
                }
                e.setCancelled(true);
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.stringUtilies.translateColors(plugin.getConfig().getString("cobblestone-name")))) {
                    p.closeInventory();
                    if(plugin.DropToggle.isOnList(p)){
                        plugin.DropToggle.removeFromList(p);
                    } else {
                        plugin.DropToggle.addToList(p);
                    }
                    plugin.inventories.openDropListInventory(p);
                }
            }
        }

    }
}
