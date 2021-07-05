package net.kunmc.lab.sometimescreativemode.config;

public class CreativeTime {

    private int value;

    CreativeTime(int value) {
        if (value <= 0) {
            value = 1;
        }

        if (value > 30) {
            value = 30;
        }

        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
