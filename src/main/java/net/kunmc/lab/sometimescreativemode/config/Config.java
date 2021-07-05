package net.kunmc.lab.sometimescreativemode.config;

import net.kunmc.lab.sometimescreativemode.SometimesCreativeMode;
import net.kunmc.lab.sometimescreativemode.util.DecorationConst;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;

public class Config {

    static FileConfiguration config;

    /** サバイバルモードの時間 */
    private static SurvivalTime survivalTime;

    /** クリエイティブモードの時間 */
    private static CreativeTime creativeTime;

    /**
     * コンフィグをロードする
     * */
    public static void loadConfig() {
        SometimesCreativeMode.plugin.saveDefaultConfig();

        //　コンフィグファイルを取得
        config = SometimesCreativeMode.plugin.getConfig();

        survivalTime = new SurvivalTime(config.getInt("survivalTime"));
        creativeTime = new CreativeTime(config.getInt("creativeTime"));
    }

    /**
     * コンフィグを表示する
     * */
    public static void show(CommandSender sender) {

        sender.sendMessage(DecorationConst.GREEN + "=============現在の設定=============");
        sender.sendMessage(DecorationConst.GREEN + "サバイバルモードの時間: " + survivalTime.value() + "秒");
        sender.sendMessage(DecorationConst.GREEN + "クリエイティブモードの時間: " + creativeTime.value() + "秒");
        sender.sendMessage(DecorationConst.GREEN + "==================================");
    }

    /**********
     * getter *
     **********/

    public static SurvivalTime survivalTime() {
        return survivalTime;
    }

    public static CreativeTime creativeTime() {
        return creativeTime;
    }

    /**********
     * setter *
     **********/

    /**
     * コマンドでサバイバルモードの時間
     **/
    public static void setSurvivalTime(CommandSender sender, String arg) {
        try {

            int value = Integer.parseInt(arg);
            survivalTime = new SurvivalTime(value);

            sender.sendMessage(DecorationConst.GREEN + "サバイバルモードの時間を" + survivalTime.value() + "秒に設定しました");
            saveChange("survivalTime", value);

        } catch (NumberFormatException e) {
            sender.sendMessage(DecorationConst.RED + "引数が不正です");
        }
    }

    /**
     * コマンドでクリエイティブモードの時間
     **/
    public static void setCreativeTime(CommandSender sender, String arg) {
        try {
            int value = Integer.parseInt(arg);
            creativeTime = new CreativeTime(value);
            sender.sendMessage(DecorationConst.GREEN + "クリエイティブモードの時間を" + creativeTime.value() + "秒に設定しました");
            saveChange("creativeTime", value);
        } catch (NumberFormatException e) {
            sender.sendMessage(DecorationConst.RED + "引数が不正です");
        }
    }

    /**
     * 設定値をymlに保存する
     * */
    private static void saveChange(String path, int value) {
        //　コンフィグファイルを取得
        config = SometimesCreativeMode.plugin.getConfig();
        config.set(path, value);
    }
}
