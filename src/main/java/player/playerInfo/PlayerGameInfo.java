package player.playerInfo;

import message.MessageAble;
import player.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xlo on 2016/1/4.
 * it's the player
 */
public class PlayerGameInfo implements MessageAble {

    protected String playerName;
    protected Set<PlayerJob> playerJob;
    private Player player;

    public PlayerGameInfo(String playerName) {
        this.playerName = playerName;
    }

    public void changePlayerJob(PlayerJob playerJob) {
        this.playerJob = new HashSet<>();
        addPlayerJob(playerJob);
    }

    public void addPlayerJob(PlayerJob playerJob) {
        this.playerJob.add(playerJob);
    }

    public String getPlayerName() {
        return playerName;
    }

    public Set<PlayerJob> getPlayerJob() {
        return playerJob;
    }

    public boolean isJob(PlayerJob playerJob) {
        return this.playerJob.contains(playerJob);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void send(byte[] message) {

    }

    @Override
    public void get(Action action) {

    }
}
