package sprites;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Tank2re {
    private static Vector3 position;
    private Texture tank;
    public int fuel = 100, health = 100;
    public Tank2re(int x, int y){
        position = new Vector3(x, y, 0);
        tank = new Texture("Tank2.png");
    }

    public void update(float dt){
        if(position.x < 0){
            position.x = 0;
        }
        if(position.x > 1363){
            position.x = 1363;
        }
        position.add(position.x, 0, 0);
    }

    public static Vector3 getPosition(){
        return position;
    }

    public Texture getTexture(){
        return tank;
    }

    public int getfuel(){
        if(fuel < 0)
        {
            return 0;
        }
        return fuel;
    }
    public void refuel(){
        fuel = 100;
    }

    public void controlforward(){
        position.x += 2;
        fuel -= 1;
        if(fuel < 0)
        {
            position.x -= 2;
        }
    }
    public void controlbackward(){
        position.x += -2;
        fuel -= 1;
        if(fuel < 0)
        {
            position.x += 2;
        }
    }
    public int gethealth(){
        if(health < 0)
        {
            return 0;
        }
        return health;
    }
    public int health(){
        health -= 10;
        return health;
    }
}