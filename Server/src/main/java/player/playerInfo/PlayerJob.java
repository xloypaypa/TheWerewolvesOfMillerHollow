package player.playerInfo;

import player.player.*;

/**
 * Created by xlo on 2016/1/4.
 * it's the player jobs
 */
public enum PlayerJob {
    POLICEMEN, WEREWOLF, PROPHET, HUNTER, WITCH, LITTLE_GIRL, CUPID, ROBBER, VILLAGER;

    public Player toPlayer(PlayerGameInfo playerGameInfo) {
        switch (this) {
            case VILLAGER:
                return new Villager(playerGameInfo);
            case ROBBER:
                return new Robber(playerGameInfo);
            case CUPID:
                return new Cupid(playerGameInfo);
            case LITTLE_GIRL:
                return new LittleGirl(playerGameInfo);
            case WITCH:
                return new Witch(playerGameInfo);
            case HUNTER:
                return new Hunter(playerGameInfo);
            case PROPHET:
                return new Prophet(playerGameInfo);
            case WEREWOLF:
                return new WereWolf(playerGameInfo);
            default:
                return new Villager(playerGameInfo);
        }
    }
}
