import java.io.Serializable;

public class Message implements Serializable {
    private int x, y;
    private boolean isOpp;
    private boolean isMissed;

    public Message(int x, int y, boolean isMissed) {
        this.x = x;
        this.y = y;
        this.isMissed = isMissed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMissed() {
        return isMissed;
    }
}
