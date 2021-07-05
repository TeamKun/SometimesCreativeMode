package net.kunmc.lab.sometimescreativemode;

import net.kunmc.lab.sometimescreativemode.command.Data;
import net.kunmc.lab.sometimescreativemode.command.Handler;
import net.kunmc.lab.sometimescreativemode.command.TabComplete;
import net.kunmc.lab.sometimescreativemode.config.Config;
import net.kunmc.lab.sometimescreativemode.game.Manager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SometimesCreativeMode extends JavaPlugin {

    /** プラグインオブジェクト */
    public static SometimesCreativeMode plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // コンフィグ
        Config.loadConfig();

        // コマンド
        getCommand(Data.MAIN.commandName()).setExecutor(new Handler());
        getCommand(Data.MAIN.commandName()).setTabCompleter(new TabComplete());

        // タスク
        Manager.startTask();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
