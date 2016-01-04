package game.jobAllocator;

import org.junit.Before;
import org.junit.Test;
import player.playerInfo.PlayerGameInfo;
import player.playerInfo.PlayerJob;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by xlo on 2016/1/4.
 * it's the testing code for custom job allocator
 */
public class CustomJobAllocatorTest {

    private CustomJobAllocator customJobAllocator;

    @Before
    public void setUp() throws Exception {
        List<PlayerJob> playerJobs = new ArrayList<>();
        playerJobs.add(PlayerJob.WEREWOLF);
        playerJobs.add(PlayerJob.WEREWOLF);
        playerJobs.add(PlayerJob.WEREWOLF);
        playerJobs.add(PlayerJob.PROPHET);
        playerJobs.add(PlayerJob.HUNTER);
        playerJobs.add(PlayerJob.VILLAGER);
        playerJobs.add(PlayerJob.VILLAGER);

        Random random = mock(Random.class);
        when(random.nextInt()).thenReturn(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);

        this.customJobAllocator = new CustomJobAllocator(random, playerJobs);
    }

    @Test
    public void should_3_players_are_were_wolf_when_only_have_three_player() {
        List<PlayerGameInfo> playerGameInfo = new ArrayList<>();
        playerGameInfo.add(new PlayerGameInfo("a"));
        playerGameInfo.add(new PlayerGameInfo("b"));
        playerGameInfo.add(new PlayerGameInfo("c"));
        customJobAllocator.allocate(playerGameInfo);

        int count = 0;
        for (PlayerGameInfo now : playerGameInfo) {
            if (now.isJob(PlayerJob.WEREWOLF)) {
                count++;
            }
        }

        assertEquals(3, count);
    }

    @Test
    public void should_the_1st_player_is_prophet_when_have_4_players() {
        List<PlayerGameInfo> playerGameInfo = new ArrayList<>();
        playerGameInfo.add(new PlayerGameInfo("a"));
        playerGameInfo.add(new PlayerGameInfo("b"));
        playerGameInfo.add(new PlayerGameInfo("c"));
        playerGameInfo.add(new PlayerGameInfo("d"));
        customJobAllocator.allocate(playerGameInfo);

        assertTrue(playerGameInfo.get(0).isJob(PlayerJob.PROPHET));
    }

    @Test
    public void should_the_1st_player_is_hunter_when_have_5_players() {
        List<PlayerGameInfo> playerGameInfo = new ArrayList<>();
        playerGameInfo.add(new PlayerGameInfo("a"));
        playerGameInfo.add(new PlayerGameInfo("b"));
        playerGameInfo.add(new PlayerGameInfo("c"));
        playerGameInfo.add(new PlayerGameInfo("d"));
        playerGameInfo.add(new PlayerGameInfo("e"));
        customJobAllocator.allocate(playerGameInfo);

        assertTrue(playerGameInfo.get(0).isJob(PlayerJob.HUNTER));
    }

    @Test(expected = InvalidParameterException.class)
    public void should_get_exception_when_give_too_many_player() {
        List<PlayerGameInfo> playerGameInfo = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            playerGameInfo.add(new PlayerGameInfo("a") {
            });
        }
        customJobAllocator.allocate(playerGameInfo);
    }

}