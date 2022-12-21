package State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends State {
    private Texture background;
    private Music theme;
    public Menu(GameStateManager gsm){
        super(gsm);
        background = new Texture("Homemenu.jpg");
        theme = Gdx.audio.newMusic(Gdx.files.internal("startmusic1.mp3"));
    }

    @Override
    public void handleInput(){
        if(Gdx.input.justTouched()){
            gsm.set(new Options(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt){
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb){
        sb.begin();
        sb.draw(background, 0, 0, 1353, 671);
        theme.setLooping(true);
        theme.play();
        sb.end();
    }

    @Override
    public void dispose(){
        background.dispose();
        theme.dispose();
    }
    public static boolean isJUnitTest() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }
}
