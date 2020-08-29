import java.io.*;

/**
 * Introducing the i and j which relate the location of the Human Player
 */
public class HumanPlayer {
    int i, j;
    char c;

    /**
     * Introducing the token P of the Human Player
     */
    public HumanPlayer() {
        c = 'P';
    }


    /**
     * Reads player's input from the console.
     *
     * @return : A string containing the input the player entered.
     */
    protected String getInputFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cmd = ""; // stores the command as a string
        try {
            cmd = in.readLine().toUpperCase();
        } catch (Exception e) {
        }
        return cmd; // returns the stored command
    }
}