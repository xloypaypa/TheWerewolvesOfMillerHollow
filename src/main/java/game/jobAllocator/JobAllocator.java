package game.jobAllocator;

import player.Player;

import java.util.Collection;

/**
 * Created by xlo on 2016/1/4.
 * it's the job allocator
 */
public interface JobAllocator {

    void allocate(Collection<Player> players);

}
