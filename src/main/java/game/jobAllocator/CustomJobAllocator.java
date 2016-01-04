package game.jobAllocator;

import player.Player;
import player.PlayerJob;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Created by xlo on 2016/1/4.
 * it's the job allocator can set jobs and the number of job
 */
public class CustomJobAllocator implements JobAllocator {

    private Random random;
    private List<PlayerJob> playerJobs;

    public CustomJobAllocator(Random random, List<PlayerJob> playerJobs) {
        this.random = random;
        this.playerJobs = playerJobs;
    }

    @Override
    public void allocate(Collection<Player> players) {
        checkHaveEnoughtJob(players);
        PlayerRandomHelper[] playerRandomHelpers = buildJobArray(players);
        setPlayerJob(players, playerRandomHelpers);
    }

    private void checkHaveEnoughtJob(Collection<Player> players) {
        if (players.size() > playerJobs.size()) {
            throw new InvalidParameterException("too many players");
        }
    }

    private void setPlayerJob(Collection<Player> players, PlayerRandomHelper[] playerRandomHelpers) {
        Iterator<Player> iterator = players.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next().setPlayerJob(playerRandomHelpers[i].getPlayerJob());
            i++;
        }
    }

    private PlayerRandomHelper[] buildJobArray(Collection<Player> players) {
        PlayerRandomHelper[] playerRandomHelpers = new PlayerRandomHelper[players.size()];
        for (int i = 0; i < playerRandomHelpers.length; i++) {
            playerRandomHelpers[i] = new PlayerRandomHelper(this.playerJobs.get(i), this.random.nextInt());
        }
        Arrays.sort(playerRandomHelpers);
        return playerRandomHelpers;
    }

    private class PlayerRandomHelper implements Comparable<PlayerRandomHelper> {
        private PlayerJob playerJob;
        private int value;

        public PlayerRandomHelper(PlayerJob playerJob, int value) {
            this.playerJob = playerJob;
            this.value = value;
        }

        @Override
        public int compareTo(PlayerRandomHelper o) {
            return Integer.compare(this.value, o.value);
        }

        public PlayerJob getPlayerJob() {
            return playerJob;
        }
    }
}
