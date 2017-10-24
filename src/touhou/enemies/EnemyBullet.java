package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject {

    final int SPEED = 3;

    public BoxCollider boxCollider;

    public EnemyBullet() {

        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        boxCollider = new BoxCollider(10,10);
    }

    public void run() {
        position.addUP(0, SPEED);
        boxCollider.position.set(this.position);
        Player player = GameObject.collideWith2(this.boxCollider);
        if (player != null){
         player.getHit();
         this.isActive = false;
        }
    }

}
