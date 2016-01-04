package game;

import game.jobAllocator.JobAllocator;
import player.Player;
import player.playerInfo.PlayerGameInfo;
import player.playerInfo.PlayerJob;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xlo on 2016/1/4.
 * it's the default game
 */
public class DefaultGame extends Game {

    protected Set<Player> players;

    public DefaultGame(JobAllocator jobAllocator, Set<PlayerGameInfo> playerGameInfo) {
        super(jobAllocator, playerGameInfo);
        this.players = new HashSet<>();
    }

    public final Set<Player> getPlayersWithJob(PlayerJob job, Set<Player> from) {
        return from.stream().filter(now -> now.getPlayerGameInfo().isJob(job)).collect(Collectors.toSet());
    }

    public final Set<Player> getAlive(Set<Player> from) {
        return from.stream().filter(Player::isAlive).collect(Collectors.toSet());
    }

    public final boolean isAllAction(Set<Player> players) {
        for (Player player : players) {
            if (!player.isAction()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void beforeGameStart(CallBack callBack) {
        this.jobAllocator.allocate(playerGameInfo);
        this.players.addAll(this.playerGameInfo.stream().map(PlayerGameInfo::getPlayer).collect(Collectors.toList()));
        this.players.forEach(now -> now.call(GameState.BEFORE_GAME_START));
        call(GameState.WHEN_GAME_START);
    }

    @Override
    public void whenGameStart(CallBack callBack) {
        Set<Player> nowPlayer = this.getPlayersWithJob(PlayerJob.CUPID, this.players);
        if (nowPlayer.size() == 0) {
            call(GameState.AFTER_GAME_START);
        } else {
            for (Player now : nowPlayer) {
                now.call(GameState.WHEN_GAME_START, () -> {
                    now.action();
                    if (isAllAction(nowPlayer)) {
                        call(GameState.AFTER_GAME_START);
                    }
                });
            }
        }
    }

    @Override
    public void afterGameStart(CallBack callBack) {

    }

    @Override
    public void beforeRoundStart(CallBack callBack) {

    }

    @Override
    public void whenRoundStart(CallBack callBack) {

    }

    @Override
    public void afterRoundStart(CallBack callBack) {

    }

    @Override
    public void beforeDayTime(CallBack callBack) {

    }

    @Override
    public void whenDayTime(CallBack callBack) {

    }

    @Override
    public void afterDayTime(CallBack callBack) {

    }

    @Override
    public void beforeNight(CallBack callBack) {

    }

    @Override
    public void whenNight(CallBack callBack) {

    }

    @Override
    public void afterNight(CallBack callBack) {

    }

    @Override
    public void beforeRoundEnd(CallBack callBack) {

    }

    @Override
    public void whenRoundEnd(CallBack callBack) {

    }

    @Override
    public void afterRoundEnd(CallBack callBack) {

    }

    @Override
    public void beforeGameEnd(CallBack callBack) {

    }

    @Override
    public void whenGameEnd(CallBack callBack) {

    }

    @Override
    public void afterGameEnd(CallBack callBack) {

    }
}
