package net.kunmc.lab.sometimescreativemode.command;

import java.util.Arrays;

public enum Data {
    MAIN("sometimescreative"),
    CONFIG("config"),
    CREATIVE_TIME("creative-time"),
    SURVIVAL_TIME("survival-time");

    private String commandName;

    Data(String commandName) {
        this.commandName = commandName;
    }

    /**
     * コマンド名を取得する.
     * */
    public String commandName() {
        return commandName;
    }

    /**
     * 入力された文字列からコマンドを引き当てる.
     * */
    public static Data getCommand(String commandName) {
        return Arrays.stream(Data.values())
                .filter(data -> data.commandName().equalsIgnoreCase(commandName))
                .findFirst()
                .orElse(null);
    }
}
