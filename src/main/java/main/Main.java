package main;

import game.DefaultGame;
import game.jobAllocator.CustomJobAllocator;
import player.playerInfo.PlayerGameInfo;
import player.playerInfo.PlayerJob;

import java.util.*;

/**
 * Created by xlo on 2016/1/4.
 * it's the main
 */
public class Main {

    public static void main(String[] args) {
        List<PlayerJob> playerJobs = new ArrayList<>();
        playerJobs.add(PlayerJob.WEREWOLF);
        playerJobs.add(PlayerJob.WEREWOLF);
        playerJobs.add(PlayerJob.CUPID);
        playerJobs.add(PlayerJob.PROPHET);
        playerJobs.add(PlayerJob.HUNTER);
        playerJobs.add(PlayerJob.VILLAGER);
        playerJobs.add(PlayerJob.VILLAGER);

        Set<PlayerGameInfo> playerGameInfo = new HashSet<>();
        playerGameInfo.add(new PlayerGameInfo("1"));
        playerGameInfo.add(new PlayerGameInfo("2"));
        playerGameInfo.add(new PlayerGameInfo("3"));
        playerGameInfo.add(new PlayerGameInfo("4"));
        playerGameInfo.add(new PlayerGameInfo("5"));
        playerGameInfo.add(new PlayerGameInfo("6"));
        playerGameInfo.add(new PlayerGameInfo("7"));

        DefaultGame defaultGame = new DefaultGame(new CustomJobAllocator(new Random(), playerJobs), playerGameInfo);
        defaultGame.startGame();
    }

}
