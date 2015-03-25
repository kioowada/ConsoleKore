

public class KoreGame {

    public static final int CNT_LEFT = 0;
    public static final int CNT_RIGHT = 1;

    private int player_one_cnt[] = new int[2];
    private int player_two_cnt[] = new int[2];

    private String player_one_name;
    private String player_two_name;

    public KoreGame() {
        initGame();
    }

    public void initGame() {
        player_one_cnt[0] = 1;
        player_one_cnt[1] = 1;
        player_two_cnt[0] = 1;
        player_two_cnt[1] = 1;

        player_one_name = "Player 1";
        player_two_name = "Player 2";
    }

    public void setPlayer1Name(String name) {
        player_one_name = name;
    }

    public void setPlayer2Name(String name) {
        player_two_name = name;
    }

    public String getPlayer1Name() {
        return this.player_one_name;
    }

    public String getPlayer2Name() {
        return this.player_two_name;
    }

    public void attackOne(int from, int to) throws NoHandException, AlreadyOverException {//{{{
        if ( (from != CNT_LEFT) && (from != CNT_RIGHT) ) {
            throw new NoHandException(1);
        }

        if ( (to != CNT_LEFT) && (to != CNT_RIGHT) ) {
            throw new NoHandException(2);
        }

        if ( (player_one_cnt[to] == 0) ) {
            throw new AlreadyOverException(1);
        }

        if ( (player_two_cnt[from] == 0) ) {
            throw new AlreadyOverException(2);
        }

        player_one_cnt[to] += player_two_cnt[from];
        player_one_cnt[to] %= 5;
    }//}}}

    public void attackTwo(int from, int to) throws NoHandException, AlreadyOverException {//{{{
        if ( (from != CNT_LEFT) && (from != CNT_RIGHT) ) {
            throw new NoHandException(2);
        }

        if ( (to != CNT_LEFT) && (to != CNT_RIGHT) ) {
            throw new NoHandException(1);
        }

        if ( (player_two_cnt[to] == 0) ) {
            throw new AlreadyOverException(2);
        }

        if ( (player_one_cnt[from] == 0) ) {
            throw new AlreadyOverException(1);
        }

        player_two_cnt[to] += player_one_cnt[from];
        player_two_cnt[to] %= 5;
    }//}}}

    public void attack(int who, int from, int to) throws NoPlayerException, NoHandException, AlreadyOverException {//{{{
        switch (who) {
            case 1:
                attackOne(from, to);
                break;
            case 2:
                attackTwo(from, to);
                break;
            default:
                throw new NoPlayerException();
        }
    }//}}}

    public void divideOne(int which, int cnt) throws NoHandException, NotEnoughException {
        if ((which != CNT_LEFT) && (which != CNT_RIGHT)) {
            throw new NoHandException(1);
        }

        if (player_one_cnt[which] == 1) {
            throw new NotEnoughException(which);
        }

        if (player_one_cnt[which] <= cnt) {
            throw new NotEnoughException(which);
        }

        int alternative = (which+1)%2;

        player_one_cnt[alternative] += cnt;
        player_one_cnt[which] -= cnt;
    }

    public void divideTwo(int which, int cnt) throws NoHandException, NotEnoughException {
        if ((which != CNT_LEFT) && (which != CNT_RIGHT)) {
            throw new NoHandException(2);
        }

        if (player_two_cnt[which] == 1) {
            throw new NotEnoughException(which);
        }

        if (player_two_cnt[which] <= cnt) {
            throw new NotEnoughException(which);
        }

        int alternative = (which+1)%2;

        player_two_cnt[alternative] += cnt;
        player_two_cnt[which] -= cnt;
    }

    public void divide(int player, int which, int cnt) throws NoPlayerException, NotEnoughException, NoHandException {
        switch (player) {
            case 1:
                divideOne(which, cnt);
                break;
            case 2:
                divideTwo(which, cnt);
                break;
            default:
                throw new NoPlayerException();
        }
    }

    public boolean isEnd() {
        if ((player_one_cnt[CNT_LEFT] == 0) && (player_one_cnt[CNT_RIGHT] == 0)) {
            return true;
        }

        if ((player_two_cnt[CNT_LEFT] == 0) && (player_two_cnt[CNT_RIGHT] == 0)) {
            return true;
        }

        return false;
    }

    public void dumpToConsole() {
        System.out.println("Player 2 : " + Integer.toString(player_two_cnt[CNT_LEFT]) + "   " + Integer.toString(player_two_cnt[CNT_RIGHT]));
        System.out.println("\n\n");
        System.out.println("Player 1 : " + Integer.toString(player_one_cnt[CNT_LEFT]) + "   " + Integer.toString(player_one_cnt[CNT_RIGHT]));
    }
}

