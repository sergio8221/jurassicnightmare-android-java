package com.pulcroid.jurassicnightmare;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pulcroid.jurassicnightmare.screens.SplashPulcroidScreen;

public class JurassicNightmareGame extends Game {
	
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		this.setScreen(new SplashPulcroidScreen(this));
	}

	@Override
	public void render () {
		super.render(); //important!
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}
	
	public void dispose() {
        //batch.dispose();
        //img.dispose();
    }
}
