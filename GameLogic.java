/**
 * Used to print out the text in the form of an error
 */
import java.io.*;

import static java.lang.System.err;

/**
 * This class is the main part og the game
 */
class GameLogic {
    static Map m;
    static int Gold = 0;

    /**
     * this method provides the player to look around which is called from Game()
     * @param hp : denotes the Human Player
     */
    private void look(HumanPlayer hp) {
        for (int i = hp.i-2; i < hp.i+3; i++) {
            for (int j = hp.j-2; j < hp.j+3; j++) {
                if ((hp.i == i) && (hp.j == j)) {
                    System.out.print("P ");
                }
                else {
                    System.out.print(m.getMap()[i][j] + " ");
                }
            }
            System.out.println("\n");
        }
    }

    /**
     * this method returns the Instructions in ReadMe.txt when the user enters help
     * @return : the converted String 'Help'
     */
    public String help() {
        String root = System.getProperty("user.dir"); // using the user's directory to access the maps
        //System.out.println(System.getProperty("user.dir"));
        File file = new File(root + "\\ReadMe.txt");

        String Help = new String();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file)); // the file variable

            String Line;
            while ((Line = br.readLine()) != null) {
                Help += "\n" + Line;
            }
        } catch (FileNotFoundException e) {
            err.println("FILE NOT FOUND!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Help;
    }

    /**
     * This method returns the gold required for the player to win the game which is called from Game()
     * @param m : denotes the map
     */
    private void hello(Map m) {
        System.out.print("Gold to win: ");
        System.out.println( m.getGoldRequired());
    }

    /**
     * This method checks if there is wall in front of the player
     * @param hp : denotes the Human Player
     * @return : false if there is a wall in front of the player
     */
    private boolean canGo(HumanPlayer hp) {
        if (m.wall(hp.i, hp.j) == true ) {
            err.println("FAIL"); // prints out in red if the actions cannot be executed
            return false;
        }
        return true;
    }

    /**
     * This method checks if there is gold when the user enters "PICK UP" at the current location of the player
     * If the gold is there it adds one and returns 'true' else it reurns 'false'
     * @param hp : denotes the Human Player
     * @return : true if there is gold at the location of i and j
     */
    private boolean goldDigger(HumanPlayer hp) {
        if (m.gold(hp.i, hp.j) == true ) {
            Gold += 1;
            return true;
        }
        return false;
    }

    /**
     * This meethod checks if there is an 'E' on the player's location when the player enters "QUIT"
     * If its there then the player can quit the game
     * @param hp : denotes the Human Player
     * @return : true if the player can exit
     */
    private boolean canQuit(HumanPlayer hp) {
        if (m.exit(hp.i, hp.j) == true) {
            return true;
        }
        return false;
    }

    /**
     * This method gives out a random value of i and j for the player's location
     * This method also check if the assigned location is a '#' or a 'G' then it reassigns the value of x and y
     * @return : the x and y which are further assigned to the human player
     */
    public static int[] rndm(){
        int[] ints = new int[2];
        int x = (int) ((Math.random() * 7)+3);
        int y = (int) ((Math.random() * 17)+3);
        while (true) {
            if (m.choosemap() == "\\large_example_map.txt"){ // check if the map used is the large map or not
                if (m.getMap()[x][y] == m.getMap()[25][y]){ // if it is  it dosent set the location of x&y between the triangles at the corner of the map
                    if (m.getMap()[x][y] == '#') {
                        if (m.getMap()[x][y] == 'G') {
                            x = (int) ((Math.random() * 7) + 3);
                            y = (int) ((Math.random() * 17) + 3);
                        }
                    } else {
                        break;
                    }
                }
            }else{
            if (m.getMap()[x][y] == '#') {
                if (m.getMap()[x][y] == 'G') {
                    x = (int) ((Math.random() * 7) + 3);
                    y = (int) ((Math.random() * 17) + 3);
                }
            } else {
                break;
            }
        }}
        ints[0] = x;
        ints[1] = y;
        return ints;
    }

    /**
     * This is the main part where the whole Game usually works
     */
    private static void Game() {
        m = new Map();
        System.out.println(m.getMapName());
        System.out.println("Press enter and 'input your commands or enter help'");
        int[] r = rndm();
        GameLogic M = new GameLogic();

        HumanPlayer hp = new HumanPlayer();
        hp.i = r[0];
        hp.j = r[1];

        /**
         * This is a loop where the player can continuously enter and execute the inputs
         */
        while (true) {
            switch (hp.getInputFromConsole()) {

                /**
                 * Prints out the ReadMe.txt
                 */
                case "HELP":
                    err.println(M.help());
                    break;

                /**
                 * Prints out the number of gold required to win
                 */
                case "HELLO":
                    M.hello(m);
                    break;

                /**
                 * Moves front when the player inputs 'MOVE N' in any case
                 * And checks if the player con go front i.e. to see if there is a wall in front of the player
                 * If there then it returns the player to its previous location
                 */
                case "MOVE N":
                    hp.i -= 1;
                    if ((M.canGo(hp) == false)) {
                        hp.i += 1;
                    }
                    else {
                        System.out.println("SUCCESS");
                        continue;
                    }
                    break;

                /**
                 * Moves back when the player inputs 'MOVE S' in any case
                 * And checks if the player con go back i.e. to see if there is a wall in front of the player
                 * If there then it returns the player to its previous location
                 */
                case "MOVE S":
                    hp.i += 1;
                    if ((M.canGo(hp) == false)) {
                        hp.i -= 1;
                    }
                    else {
                        System.out.println("SUCCESS");
                        continue;
                    }
                    break;

                /**
                 * Moves left when the player inputs 'MOVE W' in any case
                 * And checks if the player con go left i.e. to see if there is a wall in the left of the player
                 * If there then it returns the player to its previous location
                 */
                case "MOVE W":
                    hp.j -= 1;
                    if ((M.canGo(hp) == false)) {
                        hp.j += 1;
                    }
                    else {
                        System.out.println("SUCCESS");
                        continue;
                    }
                    break;

                /**
                 * Moves right when the player inputs 'MOVE S' in any case
                 * And checks if the player con go right i.e. to see if there is a wall in the right of the player
                 * If there then it returns the player to its previous location
                 */
                case "MOVE E":
                    hp.j += 1;
                    if ((M.canGo(hp) == false)) {
                        hp.j -= 1;
                    }
                    else {
                        System.out.println("SUCCESS");
                        continue;
                    }
                    break;

                /**
                 * Gives out a 5x5 view around the player
                 */
                case "LOOK":
                    M.look(hp);
                    break;

                /**
                 * Picks up the gold if present
                 */
                case "PICK UP":
                    if(M.goldDigger(hp) == true) {
                        System.out.print("SUCCESS. Gold owned: ");
                        System.out.println(Gold);
                    }
                    else {
                        err.println("FAIL");
                    }
                    break;

                /**
                 * Checks the amount of gold owned by the player
                 */
                case "GOLD":
                    System.out.print("Gold owned: ");
                    System.out.println(Gold);
                    break;

                /**
                 * Checks if the player can quit if an 'E' is present
                 */
                case "QUIT":
                    if(M.canQuit(hp) == true) {
                        if (m.getGoldRequired() == Gold) {
                            System.out.println("WIN, you have successfully exitied the game");
                            System.exit(0);
                        }
                        else {
                            Gold = 0;
                            System.out.print("Gold owned: ");
                            System.out.println(Gold);
                            System.out.println("LOOSE");
                            System.exit(0);
                        }

                    }
                    else {
                        err.println("You can only exit the game at \"E\""); // this prints out in red when the player tries to exit at any other block than 'E'
                    }
                    break;

                /**
                 * This is for when the player enters any other value than the ones given above
                 */
                default:
                    err.println("Please enter a valid Input"); // this prints out in red if the player dosen't input the specified inputs
                    break;
            }
        }
    }

    /**
     * This is the main Method of the Game where everything is executed
     * @param args : takes in argument
     */
    public static void main(String[] args) {
        err.println("Read the \"ReadMe.txt\" before starting the game or enter 'help' after choosing the map");// this prints out in red for the player to see, to read the document first
        System.out.println("The game has started");
        System.out.println("CHOOSE MAP");
        System.out.println("map 1: Dungeon of Doom");
        System.out.println("map 2: Dungeon of Disaster");
        System.out.println("map 3: Dungeon of Despair");
        System.out.println("map 4: enter 'choose' to use your own map");
        Game();

    }
}