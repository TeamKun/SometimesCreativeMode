package net.kunmc.lab.sometimescreativemode.config;

public class SurvivalTime extends TimeLimit{
    SurvivalTime(int limit) {
        if (limit <= 0) {
            limit = 1;
        }

        if (limit > 1000) {
            limit = 1000;
        }

        super.limit = limit;
    }
}
