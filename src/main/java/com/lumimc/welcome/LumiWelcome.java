package com.lumimc.welcome;

import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Color;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class LumiWelcome extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("LumiWelcome ENABLED!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        // Send welcome message
        event.getPlayer().sendMessage(
                "---------------------------------------"
        );

        event.getPlayer().sendMessage(
                "Welcome to LumiMC (" +
                event.getPlayer().getName() +
                ") we hope you enjoy your stay here!"
        );

        event.getPlayer().sendMessage(
                "---------------------------------------"
        );

        // Get player's location
        Location location = event.getPlayer().getLocation();

        // Spawn 3 fireworks
        for (int i = 0; i < 3; i++) {

            Firework firework = location.getWorld().spawn(
                    location,
                    Firework.class
            );

            FireworkMeta meta = firework.getFireworkMeta();

            meta.setPower(1);

            meta.addEffect(
                    FireworkEffect.builder()
                            .with(FireworkEffect.Type.BALL_LARGE)
                            .withColor(Color.AQUA)
                            .withFade(Color.WHITE)
                            .flicker(true)
                            .trail(true)
                            .build()
            );

            firework.setFireworkMeta(meta);
        }
    }
}
