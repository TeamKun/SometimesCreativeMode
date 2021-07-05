package net.kunmc.lab.sometimescreativemode.config;

public class CreativeTime extends TimeLimit{
    CreativeTime(int limit) {
        if (limit <= 0) {
            limit = 1;
        }

        if (limit > 30) {
            limit = 30;
        }

        super.limit = limit;
    }
}
