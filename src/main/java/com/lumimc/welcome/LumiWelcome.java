package com.lumimc.welcome;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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

        // Only run for players joining for the FIRST time
        if (!event.getPlayer().hasPlayedBefore()) {

            String playerName = event.getPlayer().getName();

            // Welcome message
            event.getPlayer().sendMessage(
                    Component.text("---------------------------------------")
                            .color(NamedTextColor.GOLD)
            );

            event.getPlayer().sendMessage(
                    Component.text("Welcome to LumiMC " + playerName +
                            " we hope you enjoy your stay here!")
                            .color(NamedTextColor.GOLD)
            );

            event.getPlayer().sendMessage(
                    Component.text("---------------------------------------")
                            .color(NamedTextColor.GOLD)
            );

            // Fireworks
            Location location = event.getPlayer().getLocation();

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
                                .withColor(Color.ORANGE)
                                .withFade(Color.YELLOW)
                                .flicker(true)
                                .trail(true)
                                .build()
                );

                firework.setFireworkMeta(meta);
            }
        }
    }
}
