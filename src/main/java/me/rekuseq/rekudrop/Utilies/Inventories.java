package me.rekuseq.rekudrop.Utilies;

import me.rekuseq.rekudrop.RekuDrop;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;



public class Inventories {
    private final RekuDrop plugin;


    public Inventories(RekuDrop rekuDrop) {
        this.plugin = rekuDrop;
    }

    public void openDropListInventory(Player player){
        Inventory inventory = plugin.getServer().createInventory(
                player, 45,
                ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("drop-inventory-title")));


        ItemStack frame = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta frameMeta= frame.getItemMeta();
        frameMeta.setDisplayName(" ");
        frame.setItemMeta(frameMeta);
        for(int intFrame : new int[]{0,1,2,3,4,5,6,7,8,9,17,26,35,18,27,36,37,38,39,41,42,43,44}){
            inventory.setItem(intFrame, frame);
        }

        ItemStack coal = new ItemStack(Material.COAL);
        ItemMeta coalMeta = coal.getItemMeta();
        coalMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("coal-name")));
        List<String> coalLore = plugin.getConfig().getStringList("coal-lore");
        List<String> kolorCoalLore = new ArrayList<String>();
        for(String s : coalLore){
            kolorCoalLore.add(plugin.stringUtilies.translateColors(s));
        }
        coalMeta.setLore(kolorCoalLore);
        coal.setItemMeta(coalMeta);

        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta ironMeta = iron.getItemMeta();
        ironMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("iron-name")));
        List<String> ironLore = plugin.getConfig().getStringList("iron-lore");
        List<String> kolorIronLore = new ArrayList<String>();
        for(String s : ironLore){
            kolorIronLore.add(plugin.stringUtilies.translateColors(s));
        }
        ironMeta.setLore(kolorIronLore);
        iron.setItemMeta(ironMeta);

        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemMeta redstoneMeta = redstone.getItemMeta();
        redstoneMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("redstone-name")));
        List<String> redstoneLore = plugin.getConfig().getStringList("redstone-lore");
        List<String> kolorRedstoneLore = new ArrayList<String>();
        for(String s : redstoneLore){
            kolorRedstoneLore.add(plugin.stringUtilies.translateColors(s));
        }
        redstoneMeta.setLore(kolorRedstoneLore);
        redstone.setItemMeta(redstoneMeta);

        ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta lapisMeta = lapis.getItemMeta();
        lapisMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("lapis-name")));
        List<String> lapisLore = plugin.getConfig().getStringList("lapis-lore");
        List<String> kolorLapisLore = new ArrayList<String>();
        for(String s : lapisLore){
            kolorLapisLore.add(plugin.stringUtilies.translateColors(s));
        }
        lapisMeta.setLore(kolorLapisLore);
        lapis.setItemMeta(lapisMeta);

        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("gold-name")));
        List<String> goldLore = plugin.getConfig().getStringList("gold-lore");
        List<String> kolorGoldLore = new ArrayList<String>();
        for(String s : goldLore){
            kolorGoldLore.add(plugin.stringUtilies.translateColors(s));
        }
        goldMeta.setLore(kolorGoldLore);
        gold.setItemMeta(goldMeta);

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta diamondMeta = diamond.getItemMeta();
        diamondMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("diamond-name")));
        List<String> diamondLore = plugin.getConfig().getStringList("diamond-lore");
        List<String> kolorDiamondLore = new ArrayList<String>();
        for(String s : diamondLore){
            kolorDiamondLore.add(plugin.stringUtilies.translateColors(s));
        }
        diamondMeta.setLore(kolorDiamondLore);
        diamond.setItemMeta(diamondMeta);

        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta emeraldMeta = emerald.getItemMeta();
        emeraldMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("emerald-name")));
        List<String> emeraldLore = plugin.getConfig().getStringList("emerald-lore");
        List<String> kolorEmeraldLore = new ArrayList<String>();
        for(String s : emeraldLore){
            kolorEmeraldLore.add(plugin.stringUtilies.translateColors(s));
        }
        emeraldMeta.setLore(kolorEmeraldLore);
        emerald.setItemMeta(emeraldMeta);

        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);
        ItemMeta cobblestoneMeta = cobblestone.getItemMeta();

        List<String> cobblestoneLore = new ArrayList<>();
        cobblestoneLore.add(" ");
        boolean toggle = plugin.DropToggle.isOnList(player);
        if(toggle){
            cobblestoneLore.set(0,plugin.stringUtilies.translateColors(plugin.getConfig().getString("status") + plugin.getConfig().getString("wylaczony")));
        } else{
            cobblestoneLore.set(0,plugin.stringUtilies.translateColors(plugin.getConfig().getString("status") + plugin.getConfig().getString("wlaczony")));
        }

        cobblestoneMeta.setLore(cobblestoneLore);
        cobblestoneMeta.setDisplayName(plugin.stringUtilies.translateColors(plugin.getConfig().getString("cobblestone-name")));
        cobblestone.setItemMeta(cobblestoneMeta);

        inventory.setItem(19, coal);
        inventory.setItem(20, iron);
        inventory.setItem(21, redstone);
        inventory.setItem(22, lapis);
        inventory.setItem(23, gold);
        inventory.setItem(24, diamond);
        inventory.setItem(25, emerald);
        inventory.setItem(40, cobblestone);
        player.openInventory(inventory);
    }
}
