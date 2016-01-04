package player;

/**
 * Created by xlo on 2016/1/4.
 * it's the player
 */
public abstract class Player {

    protected String playerName;
    protected PlayerJob playerJob;

    protected Player(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerJob(PlayerJob playerJob) {
        this.playerJob = playerJob;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerJob getPlayerJob() {
        return playerJob;
    }
}
