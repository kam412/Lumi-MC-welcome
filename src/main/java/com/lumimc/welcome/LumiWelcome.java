package com.lumimc.welcome;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LumiWelcome extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("LumiWelcome has been enabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();

        event.getPlayer().sendMessage(
                Component.text("---------------------------------------")
                        .color(NamedTextColor.GRAY)
        );

        event.getPlayer().sendMessage(
                Component.text("Welcome to LumiMC (" + playerName + ") we hope you enjoy your stay here!")
                        .color(NamedTextColor.AQUA)
        );

        event.getPlayer().sendMessage(
                Component.text("---------------------------------------")
                        .color(NamedTextColor.GRAY)
        );
    }
}
