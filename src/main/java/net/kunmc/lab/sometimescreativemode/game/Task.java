package net.kunmc.lab.sometimescreativemode.game;

import org.bukkit.scheduler.BukkitRunnable;

public class Task extends BukkitRunnable {

    @Override
    public void run() {
        if (Manager.state == null) {
            return;
        }

        State state = Manager.state;
        Manager.state = state.execute();
    }
}
