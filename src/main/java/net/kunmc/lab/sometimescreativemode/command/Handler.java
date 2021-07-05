package net.kunmc.lab.sometimescreativemode.command;

import net.kunmc.lab.sometimescreativemode.config.Config;
import net.kunmc.lab.sometimescreativemode.game.Manager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Handler implements CommandExecutor {
    /** コマンド送信者 */
    static CommandSender commandSender;
    /** 引数群 */
    static String[] args;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        commandSender = sender;
        this.args = args;

        // メインコマンド処理
        if (args.length == 0) {
            Manager.toggleState();
            return true;
        }

        // configコマンド処理
        if (args.length == 1 && ErrorChecker.existSubCommand(0)) {
            Config.show(sender);
            return true;
        }

        // config変更コマンド処理
        if (args.length >= 2 &&
                ErrorChecker.existSubCommand(0) &&
                ErrorChecker.existSubCommand(1) &&
                ErrorChecker.canCombine(Data.getCommand(args[0]), Data.getCommand(args[1])) &&
                ErrorChecker.isCorrectArgsLength(3)
        ) {
            switch (Data.getCommand(args[1])) {
                case SURVIVAL_TIME:
                    Config.setSurvivalTime(sender, args[2]);
                    Manager.restartGame();
                    break;
                case CREATIVE_TIME:
                    Config.setCreativeTime(sender, args[2]);
                    break;
            }
            return true;
        }
        return false;
    }
}
