package net.kunmc.lab.sometimescreativemode.config;

public abstract class TimeLimit {
    protected int limit;
    private int currentTime;

    /**
     * 時間を進めて制限時間に達しているか判定する
     * */
    public boolean count() {
        currentTime ++;

        if (limit < currentTime) {
            clear();
            return true;
        }

        return false;
    }

    /**
     * 残り時間を取得する
     * */
    public int timeLeft() {
        int timeLeft = limit - currentTime;

        if (timeLeft < 0) {
            timeLeft = 0;
        }

        return timeLeft;
    }

    /**
     * 残り時間をクリアする
     * */
    public void clear() {
        currentTime = 0;
    }

    public int value() {
        return this.limit;
    }
}
