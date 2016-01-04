package game;

import game.jobAllocator.JobAllocator;
import player.playerInfo.PlayerGameInfo;

import java.util.Set;

/**
 * Created by xlo on 2016/1/4.
 * it's the game logic
 */
public abstract class Game implements ActionAble {

    protected JobAllocator jobAllocator;
    protected Set<PlayerGameInfo> playerGameInfo;

    public Game(JobAllocator jobAllocator, Set<PlayerGameInfo> playerGameInfo) {
        this.jobAllocator = jobAllocator;
        this.playerGameInfo = playerGameInfo;
    }

    public final void startGame() {
        call(GameState.BEFORE_GAME_START);
    }

}
