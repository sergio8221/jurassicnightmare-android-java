package com.pulcroid.jurassicnightmare.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.pulcroid.jurassicnightmare.JurassicNightmareGame;
import com.pulcroid.jurassicnightmare.util.Constants;

public class SplashPulcroidScreen implements Screen {
	
	final JurassicNightmareGame game;
	
	OrthographicCamera camera;
	
	private Texture texture = new Texture(Gdx.files.internal("Splash_Pulcroid/Logo.jpg"));
    private Image splashImage = new Image(texture);
    private Stage stage;
	
	public SplashPulcroidScreen(final JurassicNightmareGame gam) {
        game = gam;

        stage = new Stage(new StretchViewport(Constants.CAMERA_WIDTH,Constants.CAMERA_HEIGHT));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);

    }
	
	@Override
    public void render(float delta) {  
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {  
    	stage.getViewport().update(width, height);
    }

    @Override
    public void show() { 
    	stage.addActor(splashImage);
        
        splashImage.addAction(Actions.sequence(Actions.alpha(0)
                       ,Actions.fadeIn(1.5f),Actions.delay(1),Actions.fadeOut(1.5f),Actions.run(new Runnable() {
            @Override
            public void run() {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen(game));
            }
        })));
    }

    @Override
    public void hide() { 
    	dispose();
    }

    @Override
    public void pause() {       
    }

    @Override
    public void resume() {      
    }

    @Override
    public void dispose() {    
    	texture.dispose();
        stage.dispose();
    }

}
