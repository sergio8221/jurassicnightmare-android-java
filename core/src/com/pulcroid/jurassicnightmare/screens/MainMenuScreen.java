package com.pulcroid.jurassicnightmare.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.pulcroid.jurassicnightmare.JurassicNightmareGame;
import com.pulcroid.jurassicnightmare.util.Constants;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenuScreen implements Screen{
	
	final JurassicNightmareGame game;
	
	private Stage stage;
	
	//background
	private Table layerBackground;
	private Texture textureBackground;
    private TextureRegion menuBackgroundReg;
    private Image menuBackgroundImg;
	
	//buttons
    private Table layerButtons;
	private Button facebookButton;
	private Button gplusButton;
	private Button settingsButton;
	private Button shopButton;
	private Button quitButton;
	private Button playButton;
	private Texture textureButtons;
	private TextureRegion facebookReg;
	private TextureRegion gplusReg;
	private TextureRegion settingsReg;
	private TextureRegion shopReg;
	private TextureRegion quitReg;
	private TextureRegion playReg;
	private TextureRegion facebookPressedReg;
	private TextureRegion gplusPressedReg;
	private TextureRegion settingsPressedReg;
	private TextureRegion shopPressedReg;
	private TextureRegion quitPressedReg;
	private TextureRegion playPressedReg;
	private Skin buttonsSkin;
	
	//settings
	private Table layerSettings;
	private Window settingsWindow;
	private WindowStyle settingsWindowStyle;
	private Skin windowSkin;
	private TextureRegion windowBackgroundReg;
	public MainMenuScreen(final JurassicNightmareGame gam){
		game = gam;
		
	}

	@Override
	public void show() {
		stage = new Stage(new StretchViewport(Constants.CAMERA_WIDTH,Constants.CAMERA_HEIGHT));
		Gdx.input.setInputProcessor(stage);
		
		rebuildStage();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act(delta);
	    stage.draw();
	    

		
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		dispose();
		
	}

	@Override
	public void dispose() {
		textureBackground.dispose();
		textureButtons.dispose();
		stage.dispose();
		
	}
	
	private void rebuildStage(){
		textureBackground = new Texture(Gdx.files.internal("MainMenu/background_atlas.png"));
		textureButtons = new Texture(Gdx.files.internal("MainMenu/buttons_atlas.png"));
		
		//build layers
		layerBackground = buildBackgroundLayer();
		layerButtons = buildButtonsLayer();
		layerSettings = buildSettingsLayer();
		
		//assemble stage
		stage.clear();
		Stack stack = new Stack();
		stage.addActor(stack);
		stack.setSize(Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
		stack.add(layerBackground);
		stack.add(layerButtons);
		stage.addActor(layerSettings);
		
	}
	
	private Table buildBackgroundLayer(){
		Table table = new Table();
			
		menuBackgroundReg = new TextureRegion(textureBackground,0,0,1280,720);
		menuBackgroundImg = new Image(menuBackgroundReg);
		table.add(menuBackgroundImg);
		
		return table;
		
	}
	
	private Table buildButtonsLayer(){
		Table table = new Table();
		
		//Create regions for the buttons and add them to the skin
		buttonsSkin = new Skin();	
		facebookReg = new TextureRegion(textureButtons,0,0,230,135);
		facebookPressedReg = new TextureRegion(textureButtons,0,400,230,135);
		gplusReg = new TextureRegion(textureButtons,0,135,230,124);
		gplusPressedReg = new TextureRegion(textureButtons,0,535,230,124);
		settingsReg = new TextureRegion(textureButtons,0,259,230,130);
		settingsPressedReg = new TextureRegion(textureButtons,0,659,230,130);
		shopReg = new TextureRegion(textureButtons,240,720,280,270);
		shopPressedReg = new TextureRegion(textureButtons,530,720,280,270);
		quitReg = new TextureRegion(textureButtons,240,379,280,331);
		quitPressedReg = new TextureRegion(textureButtons,240,19,280,331);
		playReg = new TextureRegion(textureButtons,520,379,280,331);
		playPressedReg = new TextureRegion(textureButtons,520,19,280,331);
		buttonsSkin.add("facebookReg", facebookReg);
		buttonsSkin.add("facebookPressedReg", facebookPressedReg);
		buttonsSkin.add("gplusReg", gplusReg);
		buttonsSkin.add("gplusPressedReg", gplusPressedReg);
		buttonsSkin.add("settingsReg", settingsReg);
		buttonsSkin.add("settingsPressedReg", settingsPressedReg);
		buttonsSkin.add("shopReg", shopReg);
		buttonsSkin.add("shopPressedReg", shopPressedReg);
		buttonsSkin.add("quitReg", quitReg);
		buttonsSkin.add("quitPressedReg", quitPressedReg);
		buttonsSkin.add("playReg", playReg);
		buttonsSkin.add("playPressedReg", playPressedReg);
				
				
		//Create the table and add the buttons
		table.setFillParent(true);
		table.setDebug(false); //Show table lines for debugging purposes
		table.left().top();
		facebookButton = new Button(buttonsSkin.newDrawable("facebookReg"),buttonsSkin.newDrawable("facebookPressedReg"),
				buttonsSkin.newDrawable("facebookPressedReg"));
		table.add(facebookButton).width(230).height(135).left();
		table.row();
		gplusButton = new Button(buttonsSkin.newDrawable("gplusReg"),buttonsSkin.newDrawable("gplusPressedReg"),
				buttonsSkin.newDrawable("gplusPressedReg"));
		table.add(gplusButton).width(230).height(124).left();
		table.row();
		settingsButton = new Button(buttonsSkin.newDrawable("settingsReg"),buttonsSkin.newDrawable("settingsPressedReg"),
				buttonsSkin.newDrawable("settingsPressedReg"));
		settingsButton.addListener(new ChangeListener(){
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				if(settingsButton.isChecked()) settingsWindow.setVisible(true);
				else settingsWindow.setVisible(false);
			}
		});
		table.add(settingsButton).width(230).height(130).left();
		table.row();
		shopButton = new Button(buttonsSkin.newDrawable("shopReg"),buttonsSkin.newDrawable("shopPressedReg"),
				buttonsSkin.newDrawable("shopPressedReg"));
		table.add(shopButton).width(280).height(270).bottom().expandY();
		quitButton = new Button(buttonsSkin.newDrawable("quitReg"),buttonsSkin.newDrawable("quitPressedReg"),
				buttonsSkin.newDrawable("quitPressedReg"));
		quitButton.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event,Actor actor){
				if(quitButton.isChecked()){
					Gdx.app.exit();
				}
			}
		});
		table.add().width(70);
		table.add(quitButton).width(280).height(331).bottom().right().expandY();
		playButton = new Button(buttonsSkin.newDrawable("playReg"),buttonsSkin.newDrawable("playPressedReg"),
				buttonsSkin.newDrawable("playPressedReg"));
		table.add(playButton).width(280).height(331).bottom().left().expandY();
		
		return table;
	}
	
	private Table buildSettingsLayer(){
		//Ninepatch for window background
		windowBackgroundReg = new TextureRegion(textureBackground,1290,0,660,330);
		
		windowSkin = new Skin();
		windowSkin.add("windowBackgroundReg", windowBackgroundReg);
		settingsWindowStyle = new WindowStyle(new BitmapFont(),Color.WHITE,windowSkin.newDrawable("windowBackgroundReg"));
		windowSkin.add("settingsWindowStyle", settingsWindowStyle);
		settingsWindow = new Window("",windowSkin.get("settingsWindowStyle", WindowStyle.class));
		
		// Hide options window by default
		settingsWindow.setVisible(false);
		// Let TableLayout recalculate widget sizes and positions
		settingsWindow.pack();
		// Move settings window
		settingsWindow.setPosition(310, 380); //it seems from bottom-left
		settingsWindow.setSize(660, 330);
		
		return settingsWindow;
	}

}
