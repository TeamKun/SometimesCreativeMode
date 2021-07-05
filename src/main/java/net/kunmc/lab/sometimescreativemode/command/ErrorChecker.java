package net.kunmc.lab.sometimescreativemode.command;

import net.kunmc.lab.sometimescreativemode.util.DecorationConst;

public class ErrorChecker {

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
        if (Data.getCommand(Handler.args[argumentIndex]) == null) {
            Handler.commandSender.sendMessage(DecorationConst.RED + ERR_MSG_NOT_EXIST_SUBCOMMAND);
            return false;
        }
        return true;
    }

    /**
     * コマンドの組み合わせが正常か判定する.
     * */
    static boolean canCombine(Data from, Data to) {
        if (!Combine.canCombine(from, to)) {
            Handler.commandSender.sendMessage(DecorationConst.RED + ERR_MSG_ILLEGAL_ARGS);
            return false;
        }
        return true;
    }

    /**
     * 引数が足りているか判定する.
     * */
    static boolean isCorrectArgsLength(int number) {
        if (Handler.args.length != number) {
            Handler.commandSender.sendMessage(DecorationConst.RED + ERR_MSG_ILLEGAL_ARGS_LENGTH);
            return false;
        }
        return true;
    }
}
