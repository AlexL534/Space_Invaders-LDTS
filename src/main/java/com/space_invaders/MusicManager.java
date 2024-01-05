package com.space_invaders;

public class MusicManager {
    private static MusicManager config;
    Music MenuMusic, AlienKilled, LostLife, Shoot, PowerUpShipAlive, PowerUpShipDead, GameOver, GotPowerUp, RoundClear;

    private MusicManager(){
        MenuMusic = new Music("MenuMusic.wav");
        AlienKilled = new Music("AlienKilled.wav");
        LostLife = new Music("LostLife.wav");
        Shoot =  new Music("Shoot.wav");
        PowerUpShipAlive =  new Music("PowerUpShip Sound while on screen.wav");
        PowerUpShipDead =  new Music("PowerUpShip Destroyed.wav");
        GameOver =  new Music("GameOver.wav");
        GotPowerUp = new Music("GotPowerup.wav");
        RoundClear = new Music("RoundClear.wav");
    }


    public void stopMenuMusic(){
        MenuMusic.stop();
    }

    public void stopPowerShipMusic(){
        PowerUpShipAlive.stop();
    }
    public Music getMenuMusic() {return MenuMusic;}

    public Music getAlienKilledMusic() {return AlienKilled;}

    public Music getLostLifeMusic() {return LostLife;}

    public Music getShootMusic() {return Shoot;}

    public Music getGameOverMusic() {return GameOver;}

    public Music getPowerUpMusic() {return GotPowerUp;}

    public Music getRoundClearMusic() {return RoundClear;}

    public Music getPowerUpShipAlive() {return PowerUpShipAlive;}

    public Music getPowerUpShipDead() {return PowerUpShipDead;}

    public static MusicManager getInstance() {
        if(config==null)
            config = new MusicManager();
        return config ;
    }

}