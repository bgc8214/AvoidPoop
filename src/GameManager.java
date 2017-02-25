import processing.core.PApplet;


public class GameManager extends PApplet {
    private StartScene startScene;
    private PlayScene playScene;
    private GameOverScene gameOverScene;
    private int sceneNumber;

    public GameManager() {
        startScene = new StartScene();
        playScene = new PlayScene();
        gameOverScene = new GameOverScene();
        sceneNumber = 0;
    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.runSketch();
    }

    @Override
    public void settings() {
        playScene.initGame(this);

    }

    @Override
    public void setup() {
        background(0);
    }

    @Override
    public void draw() {
        background(0);
        fill(0, 0, 255);

        if (sceneNumber == 0)
            startScene.drawStartScene(this);
        else if (sceneNumber == 1) {
            playScene.drawPlayScene(this);
            sceneNumber = playScene.getPlayer().getHealth() <= 0 ? 2 : 1;
        } else
            gameOverScene.drawGameOverScene(this, playScene.getScore());
    }

    @Override
    public void keyPressed() {
        key = Character.toUpperCase(key);

        if (sceneNumber == 0) {
            sceneNumber = 1;
        }

        if (key == 'R' && sceneNumber == 2) {
            playScene.initGame(this);
            sceneNumber = 1;
        }
    }
}


