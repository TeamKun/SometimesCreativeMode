package net.kunmc.lab.sometimescreativemode.game;

import net.kunmc.lab.sometimescreativemode.config.Config;
import net.kunmc.lab.sometimescreativemode.config.CreativeTime;
import net.kunmc.lab.sometimescreativemode.util.DecorationConst;
import net.kunmc.lab.sometimescreativemode.util.MessageUtil;
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
        logic.changeGameMode(GameMode.CREATIVE);

        if (timeLimit.count()) {
            logic.clearActionBar();
            return SurvivalMode.initialize();
        }
        logic.setActionBar("残り" + (timeLimit.timeLeft() + 1)  + "秒");
        logic.playSound(Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON);

        return this;
    }
}
