package game;

/**
 * Created by xlo on 2016/1/4.
 * it's the action able
 */
public interface ActionAble {

    default void call(GameState gameState) {
        call(gameState, () -> {

        });
    }

    default void call(GameState gameState, CallBack callBack) {
        switch (gameState) {
            case BEFORE_GAME_START:
                beforeGameStart(callBack);
                break;
            case WHEN_GAME_START:
                whenGameStart(callBack);
                break;
            case AFTER_GAME_START:
                afterGameStart(callBack);
                break;
            case BEFORE_ROUND_START:
                beforeRoundStart(callBack);
                break;
            case WHEN_ROUND_START:
                whenRoundStart(callBack);
                break;
            case AFTER_ROUND_START:
                afterRoundStart(callBack);
                break;
            case BEFORE_DAY_TIME:
                beforeDayTime(callBack);
                break;
            case WHEN_DAY_TIME:
                whenDayTime(callBack);
                break;
            case AFTER_DAY_TIME:
                afterDayTime(callBack);
                break;
            case BEFORE_NIGHT:
                beforeNight(callBack);
                break;
            case WHEN_NIGHT:
                whenNight(callBack);
                break;
            case AFTER_NIGHT:
                afterNight(callBack);
                break;
            case BEFORE_ROUND_END:
                beforeRoundEnd(callBack);
                break;
            case WHEN_ROUND_END:
                whenRoundEnd(callBack);
                break;
            case AFTER_ROUND_END:
                afterRoundEnd(callBack);
                break;
            case BEFORE_GAME_END:
                beforeGameEnd(callBack);
                break;
            case WHEN_GAME_END:
                whenGameEnd(callBack);
                break;
            case AFTER_GAME_END:
                afterGameEnd(callBack);
                afterGameEnd(callBack);
                break;
        }
    }

    void beforeGameStart(CallBack callBack);

    void whenGameStart(CallBack callBack);

    void afterGameStart(CallBack callBack);

    void beforeRoundStart(CallBack callBack);

    void whenRoundStart(CallBack callBack);

    void afterRoundStart(CallBack callBack);

    void beforeDayTime(CallBack callBack);

    void whenDayTime(CallBack callBack);

    void afterDayTime(CallBack callBack);

    void beforeNight(CallBack callBack);

    void whenNight(CallBack callBack);

    void afterNight(CallBack callBack);

    void beforeRoundEnd(CallBack callBack);

    void whenRoundEnd(CallBack callBack);

    void afterRoundEnd(CallBack callBack);

    void beforeGameEnd(CallBack callBack);

    void whenGameEnd(CallBack callBack);

    void afterGameEnd(CallBack callBack);

    interface CallBack {
        void action();
    }

}
