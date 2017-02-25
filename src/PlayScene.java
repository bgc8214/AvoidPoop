import processing.core.PApplet;

import java.util.Random;

public class PlayScene {
    private Player player;
    private Enemy[] enemies = new Enemy[Constant.ENEMY_NUMBER];
    private boolean isCollision;
    private int score;
    int lastScore;


    public void initGame(PApplet p) {
        player = new Player(new Vector2D(500,770), new Vector2D(0, 0), new Vector2D(0, 0));
        lastScore = p.millis();
        Random random = new Random();
        p.size(1000, 800);
        for (int i = 0; i < Constant.ENEMY_NUMBER; i++) {
            enemies[i] = new Enemy(new Vector2D(random.nextInt(900) + 50 , -random.nextInt(1000)) ,
                    new Vector2D(0, random.nextFloat()*Constant.MIN_ACCELERATION + (Constant.MAX_ACCELERATION - Constant.MIN_ACCELERATION))
                    , new Vector2D(0, 0));
        }
    }

    public void drawPlayScene(PApplet p) {
        player.draw(p);
        score = p.millis() - lastScore;
        for (Enemy e : enemies) {
            p.fill(255, 0, 0);
            e.draw(p);
            isCollision = player.findCollision(e);
            if (isCollision) {
                player.reduceHealth();
            }
            drawHealthBar(p);
            drawScore(p);
        }
    }

    public void drawHealthBar(PApplet p) {
        if (player.getHealth() > 30) {
            p.fill(0, 255, 0);
        } else if (player.getHealth() > 15) {
            p.fill(200, 200, 0);
        } else {
            p.fill(255, 0, 0);
        }
        p.rect(player.getPosX(), player.getPosY() + 25, player.getHealth(), 8);
    }

    public void drawScore(PApplet p) {
        p.textSize(25);
        p.fill(133, 133, 133);
        p.text("" + score, 25, 25);
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getScore() {
        return this.score;
    }
}
