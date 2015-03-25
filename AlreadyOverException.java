public class AlreadyOverException extends Exception {

    private int player_number;

    public AlreadyOverException(int player_number) {
        super();

        this.player_number = player_number;
    }

    public int getPlayerNumber() {
        return player_number;
    }

}

