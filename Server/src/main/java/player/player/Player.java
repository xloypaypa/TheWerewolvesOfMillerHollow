package player.player;

import game.ActionAble;
import player.KillAble;
import player.playerInfo.PlayerGameInfo;

/**
 * Created by xlo on 2016/1/4.
 * it's the player
 */
public abstract class Player implements KillAble, ActionAble {

    private PlayerGameInfo playerGameInfo;
    private boolean isAction, isAlive;

    public Player(PlayerGameInfo playerGameInfo) {
        this.playerGameInfo = playerGameInfo;
        this.isAction = false;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isAction() {
        return isAction;
    }

    public void action() {
        this.isAction = true;
    }

    public void clearAction() {
        this.isAction = false;
    }

    public PlayerGameInfo getPlayerGameInfo() {
        return playerGameInfo;
    }
}
