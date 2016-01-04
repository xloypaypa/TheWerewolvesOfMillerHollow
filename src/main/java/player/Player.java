package player;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xlo on 2016/1/4.
 * it's the player
 */
public abstract class Player {

    protected String playerName;
    protected Set<PlayerJob> playerJob;
    private boolean isAction;

    protected Player(String playerName) {
        this.playerName = playerName;
        this.isAction = false;
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

    public boolean isAction() {
        return isAction;
    }

    public void action() {
        this.isAction = true;
    }

    public void clearAction() {
        this.isAction = false;
    }
}
