package game;

import game.jobAllocator.JobAllocator;
import player.Player;

import java.util.Set;

/**
 * Created by xlo on 2016/1/4.
 * it's the game logic
 */
public abstract class Game {

    protected JobAllocator jobAllocator;
    protected Set<Player> players;

    protected abstract void beforGameStart();

    protected abstract void whenGameStart();

    protected abstract void afterGameStart();

    protected abstract void beforeRoundStart();

    protected abstract void whenRoundStart();

    protected abstract void afterRoundStart();

    protected abstract void beforeDayTime();

    protected abstract void whenDayTime();

    protected abstract void afterDayTime();

    protected abstract void beforeNight();

    protected abstract void whenNight();

    protected abstract void afterNight();

}
