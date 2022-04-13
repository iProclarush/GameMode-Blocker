package me.iproclarush.gamemodeblocker;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameModeBlocker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().broadcastMessage(ChatColor.GREEN + "GameMode Blocker v1.0.0 Loaded - Created by iProclarush");
    }

    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent event){
        Player p = event.getPlayer();

        if(p.getGameMode().equals(GameMode.CREATIVE))
        {
            p.sendMessage(ChatColor.RED + "[GameModeBlocker]" + ChatColor.YELLOW + " Creative mode has been disabled on this server, you have been changed to survival.");
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
        }
    }

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent event){

        Player p = event.getPlayer();

        if(p.getGameMode().equals(GameMode.SURVIVAL)){
            p.sendMessage(ChatColor.RED + "[GameModeBlocker]" + ChatColor.YELLOW + " GameMode changing has been disabled.");
            event.setCancelled(true);
        }else{
            p.setGameMode(GameMode.SURVIVAL);
        }
    }
}
