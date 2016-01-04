package game;

import game.jobAllocator.JobAllocator;
import player.Player;
import player.PlayerJob;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xlo on 2016/1/4.
 * it's the game logic
 */
public abstract class Game {

    protected JobAllocator jobAllocator;
    protected Set<Player> players;

    public Game(JobAllocator jobAllocator, Set<Player> players) {
        this.jobAllocator = jobAllocator;
        this.players = players;
    }

    public final Set<Player> getPlayersWithJob(PlayerJob job) {
        return players.stream().filter(player -> player.isJob(job)).collect(Collectors.toSet());
    }

    public final void clearAndCall(GameState gameState) {
        this.players.forEach(Player::clearAction);
        switch (gameState) {
            case BEFORE_GAME_START:
                beforeGameStart();
                break;
            case WHEN_GAME_START:
                whenGameStart();
                break;
            case AFTER_GAME_START:
                afterGameStart();
                break;
            case BEFORE_ROUND_START:
                beforeRoundStart();
                break;
            case WHEN_ROUND_START:
                whenRoundStart();
                break;
            case AFTER_ROUND_START:
                afterRoundStart();
                break;
            case BEFORE_DAY_TIME:
                beforeDayTime();
                break;
            case WHEN_DAY_TIME:
                whenDayTime();
                break;
            case AFTER_DAY_TIME:
                afterDayTime();
                break;
            case BEFORE_NIGHT:
                beforeNight();
                break;
            case WHEN_NIGHT:
                whenNight();
                break;
            case AFTER_NIGHT:
                afterNight();
                break;
        }
    }

    public final void startGame() {
        clearAndCall(GameState.BEFORE_GAME_START);
    }

    protected abstract void beforeGameStart();

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

    protected enum GameState {
        BEFORE_GAME_START, WHEN_GAME_START, AFTER_GAME_START, BEFORE_ROUND_START, WHEN_ROUND_START, AFTER_ROUND_START,
        BEFORE_DAY_TIME, WHEN_DAY_TIME, AFTER_DAY_TIME, BEFORE_NIGHT, WHEN_NIGHT, AFTER_NIGHT
    }

}
