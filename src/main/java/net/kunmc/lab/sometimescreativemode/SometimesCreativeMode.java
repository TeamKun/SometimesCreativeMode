package net.kunmc.lab.sometimescreativemode;

import net.kunmc.lab.sometimescreativemode.command.CommandData;
import net.kunmc.lab.sometimescreativemode.command.CommandHandler;
import net.kunmc.lab.sometimescreativemode.command.TabComplete;
import net.kunmc.lab.sometimescreativemode.config.Config;
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
        getCommand(CommandData.MAIN.commandName()).setExecutor(new CommandHandler());
        getCommand(CommandData.MAIN.commandName()).setTabCompleter(new TabComplete());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
