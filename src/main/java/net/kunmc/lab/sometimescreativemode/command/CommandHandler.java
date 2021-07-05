package net.kunmc.lab.sometimescreativemode.command;

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
            //TODO コンフィグ表示
            sender.sendMessage("コンフィグ表示");
            return true;
        }

        // config変更コマンド処理
        if (args.length >= 2 &&
                CommandError.existSubCommand(0) &&
                CommandError.existSubCommand(1) &&
                CommandError.canCombine(CommandData.getCommand(args[0]), CommandData.getCommand(args[1])) &&
                CommandError.isCorrectArgsLength(3)
        ) {
            //TODO コンフィグ変更
            sender.sendMessage("コンフィグ変更");
            return true;
        }

        return false;
    }
}
