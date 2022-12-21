package State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sprites.Tank;

public class Setting extends State{
    private Texture setup, background;
    private TextButton resume, mainmenu, setting;
    private Stage stage;
    private Viewport vp;
    private Skin mySkin;

    public Setting(final GameStateManager gsm){
        super(gsm);
        vp =  new FillViewport(1362,671,new OrthographicCamera());
        stage = new Stage(vp);
        Gdx.input.setInputProcessor(stage);

        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        setup = new Texture("setup.png");
        background = new Texture("Homescreen_BG.png");

        cam.setToOrtho(false, 1352, 671);

        resume = new TextButton("Resume",mySkin,"default");
        resume.setPosition(893,350);
        resume.setSize(400,100);
        stage.addActor(resume);
        resume.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set( new Selecting(gsm));
            }
        });

        setting = new TextButton("Setting",mySkin,"default");
        setting.setPosition(893,550);
        setting.setSize(400,100);
        stage.addActor(setting);
        setting.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new Setting(gsm));
            }
        });

        mainmenu = new TextButton("Main Menu",mySkin,"default");
        mainmenu.setPosition(893,150);
        mainmenu.setSize(400,100);
        stage.addActor(mainmenu);
        mainmenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new Options(gsm));
            }
        });
    }

    @Override
    public void handleInput(){
//        public void write() throws IOException {
//            Object obj = new Game();
//            Game.serialize(obj);
//            System.out.println("Object has been serialized\n");
//        }
//
//        public void read() throws IOException, ClassNotFoundException {
//            Object obj2 = Game.deserialize();
//            System.out.println("this is the health of the player1 "+obj2.getPlayer1health());
//            System.out.println("this is the tank of the player1 "+obj2.getPlayer1currrentTank());
//            System.out.println("this is the fuel of the player1 "+obj2.getPlayer1fuelLevel());
//            System.out.println("this is the fuel of the player1 "+obj2.getPlayer1fuelLevel());
//            System.out.println("this is the health of the player2 "+obj2.getPlayer2health());
//            System.out.println("this is the tank of the player2 "+obj2.getPlayer2currrentTank());
//            System.out.println("this is the fuel of the player2 "+obj2.getPlayer2fuelLevel());
//            System.out.println("this is the fuel of the player2 "+obj2.getPlayer2fuelLevel());
//        }
    }

    @Override
    public void update(float dt){
    }

    @Override
    public void render(SpriteBatch sb){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0 , 0, 1353, 671);
        sb.draw(setup, 743, 0, 810, 685);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose(){
        background.dispose();
    }
}