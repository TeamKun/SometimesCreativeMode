package net.kunmc.lab.sometimescreativemode.util;

import org.bukkit.Bukkit;

public class MessageUtil {
    public static void sendAll(String messages) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(messages);
        });
    }
}
