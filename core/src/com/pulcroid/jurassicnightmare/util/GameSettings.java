package com.pulcroid.jurassicnightmare.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.MathUtils;

public class GameSettings {

	public static final GameSettings instance = new GameSettings();

	public boolean sound;
	public boolean music;
	public float volSound;
	public float volMusic;

	private Preferences prefs;

	// singleton: prevent instantiation from other classes
	private GameSettings () {
		prefs = Gdx.app.getPreferences(Constants.SETTINGS);
	}

	public void load () {
		sound = prefs.getBoolean("sound", true);
		music = prefs.getBoolean("music", true);
		volSound = MathUtils.clamp(prefs.getFloat("volSound", 0.5f), 0.0f, 1.0f);
		volMusic = MathUtils.clamp(prefs.getFloat("volMusic", 0.5f), 0.0f, 1.0f);
	}

	public void save () {
		prefs.putBoolean("sound", sound);
		prefs.putBoolean("music", music);
		prefs.putFloat("volSound", volSound);
		prefs.putFloat("volMusic", volMusic);
		prefs.flush();
	}

}