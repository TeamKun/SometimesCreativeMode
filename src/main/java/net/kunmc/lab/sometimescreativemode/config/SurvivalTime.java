package net.kunmc.lab.sometimescreativemode.config;

public class SurvivalTime {
    private int value;

    SurvivalTime(int value) {
        if (value <= 0) {
            value = 1;
        }

        if (value > 1000) {
            value = 1000;
        }

        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
