package net.kunmc.lab.sometimescreativemode.command;

import java.util.Arrays;

public enum CommandData {
    MAIN("sometimescreative"),
    CONFIG("config"),
    CREATIVE_TIME("creative-time"),
    SURVIVAL_TIME("survival-time");

    private String commandName;

    CommandData(String commandName) {
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
    public static CommandData getCommand(String commandName) {
        return Arrays.stream(CommandData.values())
                .filter(data -> data.commandName().equalsIgnoreCase(commandName))
                .findFirst()
                .orElse(null);
    }
}
