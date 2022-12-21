package State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.BinaryHeap;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sprites.Bullet;
import sprites.Bulletre;
import sprites.Tank;
import sprites.Tank2re;

public class PlayState extends State{
    private Tank tank;
    private Bullet bullet;
    private Bulletre bulletr;
    private BitmapFont font, font1, font2;
    private Tank2re tank2;
    private Texture background, health1, health2, vs;
    private Texture terrain;
    private Stage stage;
    private Viewport vp;
    private ImageButton Setting;
    private Skin mySkin;
    private World world;
    private Box2DDebugRenderer debugRenderer;

    public PlayState(final GameStateManager gsm){
        super(gsm);
        world = new World(new Vector2(0, -9.8f), true);

        font = new BitmapFont();
        font1 = new BitmapFont();
        font2 = new BitmapFont();

        vp =  new FillViewport(1362,671,new OrthographicCamera());
        stage = new Stage(vp);

        Gdx.input.setInputProcessor(stage);

        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        tank = new Tank(50, 100);
        bullet = new Bullet(50, 100);
        bulletr = new Bulletre(50, 100);
        tank2 = new Tank2re(50, 100);
        background = new Texture("War.png");
        terrain = new Texture("Terrain.png");
        health1 = new Texture("Health.jfif");
        health2 = new Texture("Health.jfif");
        cam.setToOrtho(false, 1352, 671);

        vs = new Texture("vs.png");

        Setting = new ImageButton(mySkin);
        Setting.setPosition(0,580);
        Setting.setSize(100,80);
        Setting.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Setting.png"))));
        Setting.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Setting.png"))));
        stage.addActor(Setting);
        Setting.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new Setter(gsm));
            }
        });
    }

    @Override
    public void handleInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tank.controlbackward();
            tank2.refuel();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            bullet.fire();
            tank2.health();
            tank2.refuel();
            if(tank2.gethealth() == 0)
            {
                gsm.push(new Over2(gsm));
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tank.controlforward();
            tank2.refuel();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tank2.controlforward();
            tank.refuel();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            bulletr.fire();
            tank.health();
            tank.refuel();
            if(tank.gethealth() == 0)
            {
                gsm.push(new Over(gsm));
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tank2.controlbackward();
            tank.refuel();
        }
    }

    @Override
    public void update(float dt){
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0, 1353, 671);
        sb.draw(terrain, 0, 0, 1353, 100);
//        sb.draw(health1, 30, 600, 240, 30);
//        sb.draw(health2, 1083, 600, 240, 30);
        sb.draw(tank.getTexture(), tank.getPosition().x, tank.getPosition().y, 50, 30);
        sb.draw(tank2.getTexture(), 1300 - tank2.getPosition().x, tank2.getPosition().y, 50, 30);
        font.draw(sb, String.valueOf(tank.getfuel()), 50, 50);
        font.draw(sb, String.valueOf(tank2.getfuel()), 1300, 50);

        font.draw(sb, String.valueOf(tank2.gethealth()), 1100, 615);
        font.draw(sb, String.valueOf(tank.gethealth()), 200, 615);
        sb.draw(vs, 651, 560, 70, 70);
        stage.act();
        stage.draw();
        sb.end();
    }

    @Override
    public void dispose(){
        background.dispose();
    }
}