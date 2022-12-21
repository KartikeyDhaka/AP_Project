package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Tank {
    private static Vector3 position;
    public int fuel = 100, health = 100;
    private Bullet b;
    private Texture tank;
    public Tank(int x, int y){
        position = new Vector3(x, y, 0);
        tank = new Texture("Tank1.png");
        b = new Bullet(x, y);
    }

    public void update(float dt){
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

    public int gethealth(){
        if(health < 0)
        {
            return 0;
        }
        return health;
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

    public int health(){
        health -= 10;
        return health;
    }
}