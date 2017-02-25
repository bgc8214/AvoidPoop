import processing.core.PApplet;

import java.util.Random;

/**
 * Created by bgc82 on 2016-11-01.
 */
public class Enemy extends Transform {
    Random random = new Random();
    private int width = Constant.ENEMY_WIDTH;
    private int height = Constant.ENEMY_HEIGHT;

    public Enemy(Vector2D position, Vector2D accelVector, Vector2D speedVector) {
        super(position, accelVector, speedVector);
    }

    @Override
    public void draw(PApplet p) {
        update(p);
        if (getPosY() > 1050) {
            resetEnemy();
        }
        p.ellipse(getPosX(), getPosY(), height, width);
    }

    public void resetEnemy() {
        setPosY(0);
        setSpeedY(0);
        setPosX(random.nextInt(980));
    }

    public int getHeight() {
        return height;
    }
}
