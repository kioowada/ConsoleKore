
public class NotEnoughException extends Exception {
    int which;

    public NotEnoughException(int which) {
        this.which = which;
    }

    public int getWhich() {
        return which;
    }
}

