package com.space_invaders;

import com.space_invaders.Music;
import com.space_invaders.MusicManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MusicManagerTest {

    MusicManager musicManager;
    Music MenuMusicMock = Mockito.mock(Music.class);
    Music AlienKilledMock = Mockito.mock(Music.class);
    Music LostLifeMock = Mockito.mock(Music.class);
    Music ShootMock = Mockito.mock(Music.class);
    Music PowerUpShipAliveMock = Mockito.mock(Music.class);
    Music PowerUpShipDeadMock = Mockito.mock(Music.class);
    Music GameOverMock = Mockito.mock(Music.class);
    Music GotPowerUpMock = Mockito.mock(Music.class);
    Music RoundClearMock = Mockito.mock(Music.class);


    @BeforeEach
    public void setUp() {
        musicManager = MusicManager.getInstance();
        MenuMusicMock = Mockito.spy(musicManager.getMenuMusic());
        AlienKilledMock = Mockito.spy(musicManager.getAlienKilledMusic());
        LostLifeMock = Mockito.spy(musicManager.getLostLifeMusic());
        ShootMock = Mockito.spy(musicManager.getShootMusic());
        PowerUpShipAliveMock = Mockito.spy(musicManager.getPowerUpShipAlive());
        PowerUpShipDeadMock = Mockito.spy(musicManager.getPowerUpShipDead());
        GameOverMock = Mockito.spy(musicManager.getGameOverMusic());
        GotPowerUpMock = Mockito.spy(musicManager.getPowerUpMusic());
        RoundClearMock = Mockito.spy(musicManager.getRoundClearMusic());
    }

    @Test
    public void testStopMenuMusic() {

    }

    @Test
    public void testStopPowerShipMusic() {

    }

    @Test
    public void testGetMenuMusic() {
        Assertions.assertNotNull(musicManager.getMenuMusic());
    }

    @Test
    public void testGetInstance() {
        MusicManager instance1 = MusicManager.getInstance();
        MusicManager instance2 = MusicManager.getInstance();
        Assertions.assertEquals(instance1, instance2);
    }
}