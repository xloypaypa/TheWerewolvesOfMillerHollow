package game.vote;

import player.playerInfo.PlayerGameInfo;

import java.util.Collection;

/**
 * Created by xlo on 2016/1/4.
 * it's the vote
 */
public interface Vote {

    PlayerGameInfo vote(Collection<PlayerGameInfo> aim, Collection<PlayerGameInfo> voter);

}
