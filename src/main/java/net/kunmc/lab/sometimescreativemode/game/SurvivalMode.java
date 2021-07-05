package net.kunmc.lab.sometimescreativemode.game;

import net.kunmc.lab.sometimescreativemode.config.Config;
import net.kunmc.lab.sometimescreativemode.config.SurvivalTime;
import net.kunmc.lab.sometimescreativemode.util.DecorationConst;
import net.kunmc.lab.sometimescreativemode.util.MessageUtil;
import org.bukkit.GameMode;
import org.bukkit.Sound;

public class SurvivalMode implements State {
    private static State INSTANCE;

    private SurvivalTime timeLimit;

    private SurvivalMode () {
        logic.changeGameMode(GameMode.SURVIVAL);
        this.timeLimit = Config.survivalTime();
        timeLimit.clear();
    }

    public static State initialize() {
        INSTANCE = new SurvivalMode();
        return INSTANCE;
    }

     public State execute() {
        logic.changeGameMode(GameMode.SURVIVAL);
        int timeLeft = timeLimit.timeLeft();

        if (1 <= timeLeft && timeLeft <= 5) {
            logic.clearActionBar();
            logic.countDown(timeLeft);
            logic.playSound(Sound.BLOCK_BELL_USE);
        }

        if (6 <= timeLeft ){
            logic.setActionBar("クリエイティブモードに切り替わるまで: " + timeLeft + "秒");

        }

        if (timeLimit.count()) {
            logic.playSound(Sound.BLOCK_ANVIL_PLACE);
            return CreativeMode.initialize();
        }

        return this;
    }
}
