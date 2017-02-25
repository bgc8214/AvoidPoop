import processing.core.PApplet;

public class Player extends Transform {
    private int health = Constant.PLAYER_HEALTH;
    private int width = Constant.PLAYER_WIDTH;
    private int height = Constant.PLAYER_HEIGHT;

    public Player(Vector2D position, Vector2D accelVector, Vector2D speedVector) {
        super(position, accelVector, speedVector);
    }

    @Override
    public void draw(PApplet p) {
        update(p);
        p.rectMode(p.CENTER);
        p.rect(getPosX(), getPosY(), height, width);
    }

    @Override
    public void update(PApplet p) {
        super.update(p);
        movePlayer(p);
    }

    public int getHealth() {
        return this.health;
    }

    public void movePlayer(PApplet p) {
        if (p.keyCode == p.LEFT) {
            setAcceleration(-Constant.PLAYER_ACCELERATION, 0);
        } else if (p.keyCode == p.RIGHT) {
            setAcceleration(Constant.PLAYER_ACCELERATION, 0);
        }

        if (!p.keyPressed) {
            p.keyCode = 10;
            setAcceleration(0, 0);
        }
    }

    public void reduceHealth() {
        health -= Constant.ENEMY_DAMAGE;
        if (health < 0)
            health = 0;
    }

    public boolean findCollision(Enemy enemy) {
        double distance = Math.sqrt(Math.pow(enemy.getPosX() - getPosX(), 2) + Math.pow(enemy.getPosY() - getPosY(), 2));
        if (distance < enemy.getHeight() / 2 + height / 2) {
            enemy.setPosY(1000);
            return true;
        } else {
            return false;
        }
    }
}
