package game.players.playerblack;

import bases.Utils;
import bases.renderers.Animation;
import game.players.Player;
import game.players.PlayerAnimator;

public class BlackAnimator extends PlayerAnimator{
    public BlackAnimator(){
        leftAnimation = new Animation(Utils.loadImage("assets/images/player/black_left.png"));
        rightAnimation = new Animation(Utils.loadImage("assets/images/player/black_right.png"));
        upAnimation = new Animation(Utils.loadImage("assets/images/player/black_up.png"));
        downAnimation = new Animation(Utils.loadImage("assets/images/player/black_down.png"));

        currentAnimation = upAnimation;
    }
}
