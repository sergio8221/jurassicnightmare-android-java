package com.pulcroid.jurassicnightmare.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pulcroid.jurassicnightmare.JurassicNightmareGame;
import com.pulcroid.jurassicnightmare.util.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int)Constants.CAMERA_WIDTH;
		config.height = (int)Constants.CAMERA_HEIGHT;
		new LwjglApplication(new JurassicNightmareGame(), config);
	}
}
