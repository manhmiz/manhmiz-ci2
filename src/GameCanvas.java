import bases.GameObject;
import bases.inputs.InputManager;
import bases.scenes.Scene;
import bases.scenes.SceneManager;
import game.scenes.GameOverScene;
import game.scenes.GameStartScene;
import game.scenes.GameWinScene;
import game.scenes.scenelvl1.SceneLvl1;
import game.scenes.scenelvl1.SceneLvl1Black;
import game.scenes.scenelvl1.SceneLvl1Blue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//import game.players.Sphere;
//import game.players.Sphere2;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backGraphics;




    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        SceneManager.changeScene(new GameStartScene());

    }

    public void render() {
        //1.Draw everything on back buffer
//        backGround.render(backGraphics);
        backGraphics.setColor(Color.black);
        backGraphics.fillRect(0,0,616,636);
        GameObject.renderAll(backGraphics);
        //2. Call repaint
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    public void run() {
        GameObject.runAll();

        if (InputManager.instance.jPressed){
            if (SceneManager.getCurrentScene().getClass().equals(GameStartScene.class)){
                SceneManager.changeScene(new SceneLvl1Black());
            }
        }
        if (InputManager.instance.kPressed) {
            if (SceneManager.getCurrentScene().getClass().equals(GameStartScene.class)) {
                SceneManager.changeScene(new SceneLvl1Blue());
            }
        }
        if (InputManager.instance.spacePressed){
            if (SceneManager.getCurrentScene().getClass().equals(GameOverScene.class)){
                SceneManager.changeScene(new GameStartScene());
            }
        }
        if (InputManager.instance.xPressed){
            if (SceneManager.getCurrentScene().getClass().equals(GameWinScene.class)){
                SceneManager.changeScene(new GameStartScene());
            }
        }
        SceneManager.changeSceneIfNeeded();
    }

}
