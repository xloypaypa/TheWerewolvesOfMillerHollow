package player.player;

import game.ActionAble;
import net.sf.json.JSONObject;
import player.playerInfo.PlayerGameInfo;

/**
 * Created by xlo on 2016/1/4.
 * it's the robber
 */
public class Robber extends Player {
    public Robber(PlayerGameInfo playerGameInfo) {
        super(playerGameInfo);
    }

    @Override
    public void beforeGameStart(CallBack callBack) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("job", this.getClass().getSimpleName());
        this.getPlayerGameInfo().send("job", jsonObject.toString().getBytes());
        callBack.action();
    }

    @Override
    public void whenGameStart(CallBack callBack) {

    }

    @Override
    public void afterGameStart(CallBack callBack) {

    }

    @Override
    public void beforeRoundStart(CallBack callBack) {

    }

    @Override
    public void whenRoundStart(CallBack callBack) {

    }

    @Override
    public void afterRoundStart(CallBack callBack) {

    }

    @Override
    public void beforeDayTime(CallBack callBack) {

    }

    @Override
    public void whenDayTime(CallBack callBack) {

    }

    @Override
    public void afterDayTime(CallBack callBack) {

    }

    @Override
    public void beforeNight(CallBack callBack) {

    }

    @Override
    public void whenNight(CallBack callBack) {

    }

    @Override
    public void afterNight(CallBack callBack) {

    }

    @Override
    public void beforeRoundEnd(CallBack callBack) {

    }

    @Override
    public void whenRoundEnd(CallBack callBack) {

    }

    @Override
    public void afterRoundEnd(CallBack callBack) {

    }

    @Override
    public void beforeGameEnd(CallBack callBack) {

    }

    @Override
    public void whenGameEnd(CallBack callBack) {

    }

    @Override
    public void afterGameEnd(CallBack callBack) {

    }

    @Override
    public void whenKill() {

    }

    @Override
    public void whenVoteKill() {

    }

    @Override
    public void whenToxic() {

    }
}
