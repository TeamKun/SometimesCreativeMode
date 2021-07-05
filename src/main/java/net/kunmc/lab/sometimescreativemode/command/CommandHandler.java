package net.kunmc.lab.sometimescreativemode.command;

import net.kunmc.lab.sometimescreativemode.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandHandler implements CommandExecutor {
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
            //TODO　ゲーム実行状態を切り替える
            sender.sendMessage("ゲーム切替");
            return true;
        }

        // configコマンド処理
        if (args.length == 1 && CommandError.existSubCommand(0)) {
            Config.show(sender);
            return true;
        }

        // config変更コマンド処理
        if (args.length >= 2 &&
                CommandError.existSubCommand(0) &&
                CommandError.existSubCommand(1) &&
                CommandError.canCombine(CommandData.getCommand(args[0]), CommandData.getCommand(args[1])) &&
                CommandError.isCorrectArgsLength(3)
        ) {
            switch (CommandData.getCommand(args[1])) {
                case SURVIVAL_TIME:
                    Config.setSurvivalTime(sender, args[2]);
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
