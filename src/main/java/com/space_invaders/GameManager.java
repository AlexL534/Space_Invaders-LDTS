package com.space_invaders;

public class GameManager {
    private static GameManager instance;
    private double velocityMultiplier = 1.0;

    public GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public double getVelocityMultiplier() {
        return velocityMultiplier;
    }

    public void setVelocityMultiplier(double multiplier) {
        this.velocityMultiplier *= multiplier;
    }
}