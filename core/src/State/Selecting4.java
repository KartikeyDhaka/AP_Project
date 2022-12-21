package State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sprites.Tank;
import sprites.Tank2;
import sprites.Tank3;

import java.text.CollationElementIterator;

public class Selecting4 extends State{
    private Tank3 tank;
    private Texture background, setup, set, circle;
    private TextButton stgm, next;
    private ImageButton Setting;
    private ImageButton t3;
    private ImageButton t2;
    private Stage stage;
    private Viewport vp;
    private Skin mySkin;

    public Selecting4(final GameStateManager gsm){
        super(gsm);
        vp =  new FillViewport(1362,671,new OrthographicCamera());
        stage = new Stage(vp);

        Gdx.input.setInputProcessor(stage);

        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        tank = new Tank3(270, 165);
        background = new Texture("Homescreen_BG.png");
        set = new Texture("Setting.png");
        setup = new Texture("setup.png");
        circle = new Texture("circle.png");

        cam.setToOrtho(false, 1352, 671);

        Setting = new ImageButton(mySkin);
        Setting.setPosition(0,580);
        Setting.setSize(100,80);
        Setting.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Setting.png"))));
        Setting.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Setting.png"))));
        stage.addActor(Setting);
        Setting.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new Setting(gsm));
            }
        });

        ImageButton t3 = new ImageButton(mySkin);
        t3.setPosition(150,500);
        t3.setSize(300,100);
        t3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Tank3.png"))));
        t3.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Tank3.png"))));
        stage.addActor(t3);

        t3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new PlayState3(gsm));
            }
        });

        next = new TextButton("Next Tank",mySkin,"default");
        next.setPosition(850,500);
        next.setSize(300,100);
        stage.addActor(next);
        next.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new Selecting5(gsm));
            }
        });
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
        sb.draw(background,0 , 0, 1353, 671);
        sb.draw(tank.getTexture(), tank.getPosition().x, tank.getPosition().y, 500, 240);
        stage.act();
        stage.draw();
        sb.draw(set, 10, 580, 80, 80);
        sb.end();
    }

    @Override
    public void dispose(){
        background.dispose();
        stage.dispose();
    }
}
