package com.space_invaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MusicTest {
    private Music music;
    private Clip clipMock;

    @BeforeEach
    public void setUp() {
        clipMock = Mockito.mock(Clip.class);
        music = new Music("AlienKilled.wav");
    }
/*
    @Test
    public void testIsPlayingWhenRunning() {
        Mockito.when(clipMock.isRunning()).thenReturn(true);
        assertTrue(music.isPlaying());
    }
*/
    @Test
    public void testIsPlayingWhenStopped() {
        when(clipMock.isRunning()).thenReturn(false);
        assertFalse(music.isPlaying());
        verify(clipMock, never()).isRunning();
    }
/*
    @Test
    public void testStop() {
        music.stop();
        Mockito.verify(clipMock, Mockito.times(1)).stop();
    }
    */
}
