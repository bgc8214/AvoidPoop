import processing.core.PApplet;

public class GameOverScene {
    public void drawGameOverScene(PApplet p, int score) {
        p.textSize(50);
        p.fill(255, 0, 0);
        p.text("Game Over", p.width / 2 - 120, p.height / 2 - 200);
        p.textSize(32);
        p.fill(0, 200, 150);
        p.text("Score : " + score, p.width / 2 - 100, p.height / 2 + 100);
        p.text("Press 'R' key to restart", p.width / 2 - 160, p.height / 2 + 300);
    }
}
