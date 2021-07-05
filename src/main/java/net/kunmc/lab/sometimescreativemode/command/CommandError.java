package net.kunmc.lab.sometimescreativemode.command;

import net.kunmc.lab.sometimescreativemode.util.DecorationConst;

public class CommandError {

    /** エラー：存在しないコマンド */
    private static final String ERR_MSG_NOT_EXIST_SUBCOMMAND = "存在しないコマンドです";
    /** エラー：不正な引数 */
    private static final String ERR_MSG_ILLEGAL_ARGS = "引数が不正です";
    /** エラー：引数の不足 */
    private static final String ERR_MSG_ILLEGAL_ARGS_LENGTH = "引数が不足しています";



    /**
     * サブコマンドが存在するか判定する.
     * */
    static boolean existSubCommand(int argumentIndex) {
        if (CommandData.getCommand(CommandHandler.args[argumentIndex]) == null) {
            CommandHandler.commandSender.sendMessage(DecorationConst.RED + ERR_MSG_NOT_EXIST_SUBCOMMAND);
            return false;
        }
        return true;
    }

    /**
     * コマンドの組み合わせが正常か判定する.
     * */
    static boolean canCombine(CommandData from, CommandData to) {
        if (!CommandCombine.canCombine(from, to)) {
            CommandHandler.commandSender.sendMessage(DecorationConst.RED + ERR_MSG_ILLEGAL_ARGS);
            return false;
        }
        return true;
    }

    /**
     * 引数が足りているか判定する.
     * */
    static boolean isCorrectArgsLength(int number) {
        if (CommandHandler.args.length != number) {
            CommandHandler.commandSender.sendMessage(DecorationConst.RED + ERR_MSG_ILLEGAL_ARGS_LENGTH);
            return false;
        }
        return true;
    }
}
