import java.io.*;

public class Kore {
    public static void main(String args[]) {
        KoreGame kg = new KoreGame();
        int from, to;
        int turn;
        

        turn = 0;
        from = 0;
        to = 0;
        while (!kg.isEnd()) {
            kg.dumpToConsole();

            System.out.print(((turn==0)?kg.getPlayer1Name():kg.getPlayer2Name()) + " attack from[0:left, 1:right]");
            do {
                System.out.print(">");
                try {
                    from = inputInteger();
                } catch (IOException e) {
                    continue;
                } catch (NumberFormatException e) {
                    continue;
                }
            } while (!((from == 0) || (from == 1)));

            System.out.print(((turn==0)?kg.getPlayer1Name():kg.getPlayer2Name()) + " attack to[0:left, 1:right]");
            do {
                System.out.print(">");
                try {
                    to = inputInteger();
                } catch (IOException e) {
                    continue;
                }
            } while (!((from == 0) || (from == 1)));

            try {
                kg.attack(1 + ((turn+1)%2), from, to);
            } catch (AlreadyOverException aoe) {
                System.err.println("Already Over");
                continue;
            } catch (NoHandException nhe) {
                System.err.println("Wrong Hand Specified");
                continue;
            } catch (NoPlayerException npe) {
                System.err.println("Wrong Player Selection");
                turn = 0;
                continue;
            }

            turn = (turn+1)%2;
        }

        kg.dumpToConsole();
        System.out.println("Game is over");
    }

    public static int inputInteger() throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        line = br.readLine();
        return Integer.parseInt(line);
    }
}

