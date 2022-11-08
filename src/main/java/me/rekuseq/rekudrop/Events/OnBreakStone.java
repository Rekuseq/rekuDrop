package me.rekuseq.rekudrop.Events;

import me.rekuseq.rekudrop.RekuDrop;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OnBreakStone implements Listener {
    private final RekuDrop plugin;

    private List<ItemStack> drops = new ArrayList<>();

    public OnBreakStone(RekuDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreakStoneEvent(BlockBreakEvent e) {
        if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        Block b = e.getBlock();
        Player p = e.getPlayer();
        setLoot(p, b);
        if (b.getType().equals(Material.STONE)) {
            e.setDropItems(false);
            Location loc = b.getLocation();
            for (ItemStack item : drops) {
                b.getWorld().dropItemNaturally(loc, item);
                giveExp(p);
            }
            drops.clear();
        }
    }
    private void giveExp(Player player) {
        if(player.getWorld() != null) {
            player.giveExp(1);
        }
    }


    public void setLoot(Player p, Block b) {
        Random random = new Random();
        int i = random.nextInt(100) + 1;
        boolean limitYLevel = plugin.getConfig().getBoolean("limit-y-level");
        if (!plugin.DropToggle.isOnList(p)) {
            drops.add(new ItemStack(Material.COBBLESTONE)); //100%
        }

        if(p.getItemOnCursor().getEnchantments().containsKey(Enchantment.LUCK)){
            if(p.getItemInUse().getEnchantmentLevel(Enchantment.LUCK) == 1)
                if (i == 6 || i == 74 || i == 26 || i == 58) {
                    if (isYCorrect(b.getY(), "diamond") && limitYLevel)
                        drops.add(new ItemStack(Material.DIAMOND)); //4%
                } else if (i == 8 || i == 66 || i == 34 || i ==92) {
                    if (isYCorrect(b.getY(), "emerald") && limitYLevel)
                        drops.add(new ItemStack(Material.EMERALD));// 4%
                } else if (i > 4 && i < 13) {
                    if (isYCorrect(b.getY(), "gold") && limitYLevel)
                        drops.add(new ItemStack(Material.GOLD_INGOT)); //9%
                } else if (i > 15 && i < 45) {
                    if (isYCorrect(b.getY(), "lapis") && limitYLevel)
                        drops.add(new ItemStack(Material.LAPIS_LAZULI)); //30%
                } else if (i > 40 && i < 70) {
                    if (isYCorrect(b.getY(), "redstone") && limitYLevel)
                        drops.add(new ItemStack(Material.REDSTONE)); //30%
                } else if (i > 70 && i < 95) {
                    if (isYCorrect(b.getY(), "iron") && limitYLevel)
                        drops.add(new ItemStack(Material.IRON_INGOT)); //25%
                } else if (i > 65 && i < 100) {
                    if (isYCorrect(b.getY(), "coal") && limitYLevel)
                        drops.add(new ItemStack(Material.COAL)); //35%
                }
            if(p.getItemOnCursor().getEnchantmentLevel(Enchantment.LUCK) == 2)
                if (i == 6 || i == 74 || i == 24 || i == 82 || i == 66 || i == 45) {
                    if (isYCorrect(b.getY(), "diamond") && limitYLevel)
                        drops.add(new ItemStack(Material.DIAMOND)); //6%
                } else if (i == 8 || i == 66 || i == 15 || i == 39 || i == 91 || i == 77) {
                    if (isYCorrect(b.getY(), "emerald") && limitYLevel)
                        drops.add(new ItemStack(Material.EMERALD));// 6%
                } else if (i > 13 && i < 25) {
                    if (isYCorrect(b.getY(), "gold") && limitYLevel)
                        drops.add(new ItemStack(Material.GOLD_INGOT)); //12%
                } else if (i > 5 && i < 45) {
                    if (isYCorrect(b.getY(), "lapis") && limitYLevel)
                        drops.add(new ItemStack(Material.LAPIS_LAZULI)); //40%
                } else if (i > 30 && i < 70) {
                    if (isYCorrect(b.getY(), "redstone") && limitYLevel)
                        drops.add(new ItemStack(Material.REDSTONE)); //40%
                } else if (i > 45 && i < 80) {
                    if (isYCorrect(b.getY(), "iron") && limitYLevel)
                        drops.add(new ItemStack(Material.IRON_INGOT)); //35%
                } else if (i > 55 && i < 100) {
                    if (isYCorrect(b.getY(), "coal") && limitYLevel)
                        drops.add(new ItemStack(Material.COAL)); //45%
                }
            if(p.getItemOnCursor().getEnchantmentLevel(Enchantment.LUCK) == 3)
                if (i > 22 && i < 34) {
                    if (isYCorrect(b.getY(), "diamond") && limitYLevel)
                        drops.add(new ItemStack(Material.DIAMOND)); //10%
                } else if (i > 28 && i < 40) {
                    if (isYCorrect(b.getY(), "emerald") && limitYLevel)
                        drops.add(new ItemStack(Material.EMERALD));// 10%
                } else if (i > 10 && i < 26) {
                    if (isYCorrect(b.getY(), "gold") && limitYLevel)
                        drops.add(new ItemStack(Material.GOLD_INGOT)); //15%
                } else if (i > 0 && i < 50) {
                    if (isYCorrect(b.getY(), "lapis") && limitYLevel)
                        drops.add(new ItemStack(Material.LAPIS_LAZULI)); //50%
                } else if (i > 30 && i < 80) {
                    if (isYCorrect(b.getY(), "redstone") && limitYLevel)
                        drops.add(new ItemStack(Material.REDSTONE)); //50%
                } else if (i > 40 && i < 85) {
                    if (isYCorrect(b.getY(), "iron") && limitYLevel)
                        drops.add(new ItemStack(Material.IRON_INGOT)); //45%
                } else if (i > 35 && i < 90) {
                    if (isYCorrect(b.getY(), "coal") && limitYLevel)
                        drops.add(new ItemStack(Material.COAL)); //55%
                }
        }else{
            if (i == 6 || i == 74) {
                if (isYCorrect(b.getY(), "diamond") && limitYLevel)
                    drops.add(new ItemStack(Material.DIAMOND)); //2%
            } else if (i == 8 || i == 66) {
                if (isYCorrect(b.getY(), "emerald") && limitYLevel)
                    drops.add(new ItemStack(Material.EMERALD));// 2%
            } else if (i > 5 && i < 12) {
                if (isYCorrect(b.getY(), "gold") && limitYLevel)
                    drops.add(new ItemStack(Material.GOLD_INGOT)); //7%
            } else if (i > 15 && i < 35) {
                if (isYCorrect(b.getY(), "lapis") && limitYLevel)
                    drops.add(new ItemStack(Material.LAPIS_LAZULI)); //20%
            } else if (i > 35 && i < 55) {
                if (isYCorrect(b.getY(), "redstone") && limitYLevel)
                    drops.add(new ItemStack(Material.REDSTONE)); //20%
            } else if (i > 60 && i < 75) {
                if (isYCorrect(b.getY(), "iron") && limitYLevel)
                    drops.add(new ItemStack(Material.IRON_INGOT)); //15%
            } else if (i > 75 && i < 100) {
                if (isYCorrect(b.getY(), "coal") && limitYLevel)
                    drops.add(new ItemStack(Material.COAL)); //25%
            }
        }
    }

    public boolean isYCorrect(int y, String material) {
        if (y <= plugin.getConfig().getInt(material + "-y-level")) {
            return true;
        }
        return false;
    }

}
