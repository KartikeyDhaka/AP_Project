package State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Options extends State{
    private Texture Logo;
    private Texture background;
    private Stage stage;
    private Viewport vp;
    private Skin mySkin;

    private Button play, load, exit;

    public Options(final GameStateManager gsm){
        super(gsm);
        vp =  new FillViewport(1362,671,new OrthographicCamera());
        stage = new Stage(vp);

        Gdx.input.setInputProcessor(stage);

        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        background = new Texture("War.png");
        Logo = new Texture("Logo.png");

        cam.setToOrtho(false, 1352, 671);

        play = new TextButton("New Game",mySkin,"default");
        play.setPosition(481,360);
        play.setSize(400,100);
        stage.addActor(play);
        play.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set( new Selecting(gsm));
            }
        } );

        load = new TextButton("Load Game",mySkin,"default");
        load.setPosition(481,240);
        load.setSize(400,100);
        stage.addActor(load);

        exit = new TextButton("Exit",mySkin,"default");
        exit.setPosition(571,120);
        exit.setSize(200,100);
        stage.addActor(exit);
        exit.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        } );
    }

    @Override
    public void handleInput(){
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
        sb.draw(background, 0, 0, 1353, 671);
        sb.draw(Logo, 676 - Logo.getWidth()/2, 671 - Logo.getHeight());
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose(){
        background.dispose();
    }
}