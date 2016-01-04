package game.jobAllocator;

import player.playerInfo.PlayerGameInfo;
import player.playerInfo.PlayerJob;

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
    public void allocate(Collection<PlayerGameInfo> playerGameInfo) {
        checkHaveEnoughtJob(playerGameInfo);
        PlayerRandomHelper[] playerRandomHelpers = buildJobArray(playerGameInfo);
        setPlayerJob(playerGameInfo, playerRandomHelpers);
    }

    private void checkHaveEnoughtJob(Collection<PlayerGameInfo> playerGameInfos) {
        if (playerGameInfos.size() > playerJobs.size()) {
            throw new InvalidParameterException("too many players");
        }
    }

    private void setPlayerJob(Collection<PlayerGameInfo> playerGameInfos, PlayerRandomHelper[] playerRandomHelpers) {
        Iterator<PlayerGameInfo> iterator = playerGameInfos.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next().changePlayerJob(playerRandomHelpers[i].getPlayerJob());
            i++;
        }
    }

    private PlayerRandomHelper[] buildJobArray(Collection<PlayerGameInfo> playerGameInfos) {
        PlayerRandomHelper[] playerRandomHelpers = new PlayerRandomHelper[playerGameInfos.size()];
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
