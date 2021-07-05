package net.kunmc.lab.sometimescreativemode.game;

import net.kunmc.lab.sometimescreativemode.config.Config;
import net.kunmc.lab.sometimescreativemode.config.CreativeTime;
import org.bukkit.GameMode;
import org.bukkit.Sound;

public class CreativeMode implements State {
    private static State INSTANCE;

    private CreativeTime timeLimit;

    private CreativeMode () {
        this.timeLimit = Config.creativeTime();
        timeLimit.clear();
    }

    public static State initialize() {
        INSTANCE = new CreativeMode();
        return INSTANCE;
    }

    public State execute() {
        Logic.changeGameMode(GameMode.CREATIVE);

        if (timeLimit.count()) {
            Logic.clearActionBar();
            return SurvivalMode.initialize();
        }

        Logic.setActionBar("残り" + (timeLimit.timeLeft() + 1)  + "秒");
        Logic.playSound(Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON);

        return this;
    }
}
