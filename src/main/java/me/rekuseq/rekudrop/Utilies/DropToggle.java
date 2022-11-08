package me.rekuseq.rekudrop.Utilies;

import org.bukkit.entity.Player;
import java.util.HashSet;


public class DropToggle {
    private HashSet<Player> list = new HashSet<>();

    public void addToList(Player p){
        list.add(p);
    }

    public void removeFromList(Player p){
        list.remove(p);
    }

    public boolean isOnList(Player p){
        if(list.contains(p)){
            return true;
        } else {
            return false;
        }
    }
}
