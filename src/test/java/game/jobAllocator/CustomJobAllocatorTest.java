package game.jobAllocator;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.Test;
import player.Player;
import player.PlayerJob;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
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
        List<Player> players = new ArrayList<>();
        players.add(new Player("a") {
        });
        players.add(new Player("b") {
        });
        players.add(new Player("c") {
        });
        customJobAllocator.allocate(players);

        int count = 0;
        for (Player now : players) {
            if (now.getPlayerJob().equals(PlayerJob.WEREWOLF)) {
                count++;
            }
        }

        assertEquals(3, count);
    }

    @Test
    public void should_the_1st_player_is_prophet_when_have_4_players() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("a") {
        });
        players.add(new Player("b") {
        });
        players.add(new Player("c") {
        });
        players.add(new Player("d") {
        });
        customJobAllocator.allocate(players);

        assertEquals(PlayerJob.PROPHET, players.get(0).getPlayerJob());
    }

    @Test
    public void should_the_1st_player_is_hunter_when_have_5_players() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("a") {
        });
        players.add(new Player("b") {
        });
        players.add(new Player("c") {
        });
        players.add(new Player("d") {
        });
        players.add(new Player("e") {
        });
        customJobAllocator.allocate(players);

        assertEquals(PlayerJob.HUNTER, players.get(0).getPlayerJob());
    }

    @Test (expected = InvalidParameterException.class)
    public void should_get_exception_when_give_too_many_player() {
        List<Player> players = new ArrayList<>();
        for (int i=0;i<100;i++) {
            players.add(new Player("a") {
            });
        }
        customJobAllocator.allocate(players);
    }

}