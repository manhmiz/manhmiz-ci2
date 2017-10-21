package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.enemies.EnemyBullet;

public class Enemy extends GameObject {

    public BoxCollider boxCollider;

    final int yTurn = 200;
    final int SPEED = 2;

    boolean bulletDisabled;
    final int COOL_DOWN_TIME = 30;
    int coolDownTime;

    public Enemy() {
        boxCollider = new BoxCollider(30,30);
        this.image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
    }


    public void run() {
        position.addUP(0, SPEED);
        boxCollider.position.set(this.position);
        shoot();
//        move();
    }


//        public void move(){
//        if (position.y != yTurn ) {
//            position.y += SPEED;
//        }else position.x += SPEED;
//
//    }
    private void shoot() {
        if (bulletDisabled) {
            coolDownTime++;
            if (coolDownTime >= COOL_DOWN_TIME) {
                bulletDisabled = false;
                coolDownTime = 0;
            }
            return;
        }
        EnemyBullet newBullet = new EnemyBullet();
        newBullet.position.set(position);
        GameObject.add(newBullet);
        bulletDisabled = true;


    }

    public void getHit() {
        isActive = false;
    }
}
