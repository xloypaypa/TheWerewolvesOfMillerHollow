package game;

import game.jobAllocator.JobAllocator;
import player.Player;

import java.util.Set;

/**
 * Created by xlo on 2016/1/4.
 * it's the default game
 */
public class DefaultGame extends Game {
    public DefaultGame(JobAllocator jobAllocator, Set<Player> players) {
        super(jobAllocator, players);
    }

    @Override
    protected void beforeGameStart() {

    }

    @Override
    protected void whenGameStart() {

    }

    @Override
    protected void afterGameStart() {

    }

    @Override
    protected void beforeRoundStart() {

    }

    @Override
    protected void whenRoundStart() {

    }

    @Override
    protected void afterRoundStart() {

    }

    @Override
    protected void beforeDayTime() {

    }

    @Override
    protected void whenDayTime() {

    }

    @Override
    protected void afterDayTime() {

    }

    @Override
    protected void beforeNight() {

    }

    @Override
    protected void whenNight() {

    }

    @Override
    protected void afterNight() {

    }
}
