package net.kunmc.lab.sometimescreativemode.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TabComplete implements TabCompleter {
    private static String[] arguments;

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        arguments = args;

        switch (args.length) {
            case 1:
                return firstArgs();
            case 2:
                return secondArgs();
            case 3:
                return thirdArgs();
        }
        return new ArrayList<>();
    }

    /**
     * 第1引数の補完
     */
    private List<String> firstArgs() {
        return Stream.of(
                Data.CONFIG.commandName())
                .filter(e -> e.startsWith(arguments[0]))
                .collect(Collectors.toList());
    }

    /**
     * 第2引数の補完
     */
    private List<String> secondArgs() {
        if (!arguments[0].equals(Data.CONFIG.commandName())) {
            return new ArrayList<>();
        }

        return Stream.of(
                Data.CREATIVE_TIME.commandName(),
                Data.SURVIVAL_TIME.commandName())
                .filter(e -> e.startsWith(arguments[1]))
                .collect(Collectors.toList());
    }

    /**
     * 第3引数の補完
     */
    private List<String> thirdArgs() {
        if (arguments[1].equalsIgnoreCase(Data.CREATIVE_TIME.commandName()) ||
                arguments[1].equalsIgnoreCase(Data.SURVIVAL_TIME.commandName())) {
            return Collections.singletonList("<秒数>");
        }

        return new ArrayList<>();
    }
}
