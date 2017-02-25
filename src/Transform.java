import processing.core.PApplet;

abstract public class Transform {
    Vector2D position;
    Vector2D accelVector;
    Vector2D speedVector;

    public Transform(Vector2D position, Vector2D accelVector, Vector2D speedVector) {
        this.position = position;
        this.accelVector = accelVector;
        this.speedVector = speedVector;
    }

    public void setPosX(float posX) {
        position.setVector(posX, position.getY());
    }

    public void setPosY(float posY) {
        position.setVector(position.getX(), posY);
    }

    public void setAcceleration(float x, float y) {
        accelVector.setVector(x, y);
    }

    public void moveByAcceleration() {
        speedVector.addVector(accelVector);
        if (speedVector.getX() > Constant.MAX_PLAYER_SPEED) {
            speedVector.setVector(Constant.MAX_PLAYER_SPEED, speedVector.getY());
        } else if (speedVector.getX() < -Constant.MAX_PLAYER_SPEED) {
            speedVector.setVector(-Constant.MAX_PLAYER_SPEED, speedVector.getY());
        }
        position.addVector(speedVector);
        if (position.getX() < 0) {
            position.setVector(0, position.getY());
        } else if (position.getX() > 1000) {
            position.setVector(1000, position.getY());
        }
    }

    public void reduceAcceleration() {
        speedVector.multVector(0.9f);
    }

    public void update(PApplet p) {
        if (accelVector.getX() == 0 || accelVector.getY() == 0) {
            reduceAcceleration();
        }

        moveByAcceleration();
    }

    abstract public void draw(PApplet p);

    public void setSpeedY(float speedY) {
        speedVector.setVector(speedVector.getX(), speedY);
    }

    public float getSpeedY() {
        return speedVector.getY();
    }

    public float getPosX() {
        return position.getX();
    }

    public float getPosY() {
        return position.getY();
    }
}