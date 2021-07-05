package net.kunmc.lab.sometimescreativemode.game;

import net.kunmc.lab.sometimescreativemode.SometimesCreativeMode;
import net.kunmc.lab.sometimescreativemode.util.DecorationConst;
import net.kunmc.lab.sometimescreativemode.util.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;

public class Manager {

    /** ゲームタスク */
    static BukkitTask task;
    /** ゲームの状態 */
    static State state;

    /**
     * ゲームタスクを起動する
     * */
    public static void startTask() {
        task = new Task().runTaskTimer(SometimesCreativeMode.plugin, 0, 20);
    }
    /**
     * ゲームモードを切り替える
     * */
    public static void toggleState() {

        // 非実行時
        if (state == null) {
            state = SurvivalMode.initialize();
            MessageUtil.sendAll(DecorationConst.GREEN + "ゲームを開始しました");
            return;
        }

        state = null;
        MessageUtil.sendAll(DecorationConst.GREEN + "ゲームを終了しました");
        return;
    }

    /**
     * ゲームをリスタートする
     * */
    public static void restartGame() {
        if (state == null) {
            return;
        }
        state = SurvivalMode.initialize();
    }
}
