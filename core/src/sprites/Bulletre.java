package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import java.lang.Math;

public class Bulletre {
    private static Vector3 position;
    private double speed = 50;
    private Texture bullet;
    public Bulletre(int x, int y){
        position = new Vector3(x, y, 0);
        bullet = new Texture("bullet.png");
    }

    public void update(float dt){
        position.add(position.x, 0, 0);
    }

    public static Vector3 getPosition(){
        return position;
    }

    public Texture getTexture(){
        return bullet;
    }

    public void fire(){
    }
}
