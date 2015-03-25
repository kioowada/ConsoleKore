public class NotOverException extends Exception {
    int which;

    public NotOverException(int which) {
        this.which = which;
    }

    public int getWhich() {
        return which;
    }
}

