/**
 * Created by bgc82 on 2016-11-06.
 */
public class Vector2D {
    private float x;
    private float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void addVector(Vector2D v) {
        x += v.getX();
        y += v.getY();
    }

    public void multVector(float scalar) {
        x *= scalar;
        y *= scalar;
    }

    public void setVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

}
