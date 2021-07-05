package net.kunmc.lab.sometimescreativemode.game;

import net.kunmc.lab.sometimescreativemode.util.DecorationConst;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Collection;

public class logic {
    /**
     * スペクテイター以外のプレイヤーのゲームモードを切り替える
     * */
    static void changeGameMode(GameMode gamemode) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if(!player.getGameMode().equals(GameMode.SPECTATOR)) {
                player.setGameMode(gamemode);
            }
        });
    }

    /**
     * アクションバーをセットする
     * */
    static void setActionBar(String message) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendActionBar(message);
        });
    }

    /**
     * アクションバーをクリアする
     * */
    static void clearActionBar() {
        setActionBar(" ");
    }

    /**
     * カウントダウン処理
     * */
    static void countDown(int count) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendTitle(String.valueOf(count),null,5,15,5);

        });
    }

    /**
     * プレイヤー全員に音を再生する
     * */
    static void playSound(Sound sound) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.getLocation().getWorld().playSound(player.getLocation(), sound,0.05F,1);
        });
    }
}
