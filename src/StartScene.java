import processing.core.PApplet;

public class StartScene {

    public void drawStartScene(PApplet p) {
        p.textSize(60);
        p.text("Avoid Poop Game", p.width / 2 - 240, p.height / 2 - 200);
        p.textSize(32);
        p.text("Press Any Key to Start Game", p.width / 2 - 220, p.height / 2 + 200);
    }

}
