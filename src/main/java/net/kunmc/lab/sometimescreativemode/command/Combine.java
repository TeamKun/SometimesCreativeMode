package net.kunmc.lab.sometimescreativemode.command;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Combine {
    private static Map<Data, Set<Data>> allowed;

    private static void createAllowMap() {
        // 許容されるコマンドの組み合わせをセット
        allowed = new HashMap<>();

        // 第一引数
        allowed.put(Data.MAIN, EnumSet.of(Data.CONFIG));

        // 第二引数
        allowed.put(Data.CONFIG, EnumSet.of(Data.CREATIVE_TIME, Data.SURVIVAL_TIME));
    }

    /**
     * コマンドの組み合わせが許容されているか判定する.
     * */
    static boolean canCombine(Data from, Data to) {
        createAllowMap();
        Set<Data> allowedCommands = allowed.get(from);
        if (!allowedCommands.contains(to)) {
            return false;
        }
        return true;
    }
}
