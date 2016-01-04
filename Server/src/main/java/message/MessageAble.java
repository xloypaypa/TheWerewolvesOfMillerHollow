package message;

/**
 * Created by xlo on 2016/1/4.
 * it's the message able
 */
public interface MessageAble {

    void send(String event, byte[] message);

    void get(Action action);

    interface Action {
        void action(String event, byte[] message);
    }
}
