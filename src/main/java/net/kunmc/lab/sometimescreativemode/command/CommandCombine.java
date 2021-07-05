package net.kunmc.lab.sometimescreativemode.command;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandCombine {
    private static Map<CommandData, Set<CommandData>> allowed;

    private static void createAllowMap() {
        // 許容されるコマンドの組み合わせをセット
        allowed = new HashMap<>();

        // 第一引数
        allowed.put(CommandData.MAIN, EnumSet.of(CommandData.CONFIG));

        // 第二引数
        allowed.put(CommandData.CONFIG, EnumSet.of(CommandData.CREATIVE_TIME, CommandData.SURVIVAL_TIME));
    }

    /**
     * コマンドの組み合わせが許容されているか判定する.
     * */
    static boolean canCombine(CommandData from, CommandData to) {
        createAllowMap();
        Set<CommandData> allowedCommands = allowed.get(from);
        if (!allowedCommands.contains(to)) {
            return false;
        }
        return true;
    }
}
