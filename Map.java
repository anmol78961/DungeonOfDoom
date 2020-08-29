import java.io.*;

/**
 * Contains the map of the game.
 */
public class Map {

    /* Representation of the map*/
    private char[][] map;
    /* Map name*/
    private String mapName;
    /* Gold required for the human player to win */
    private int goldRequired;

    public int j;

    ColumnLen C = new ColumnLen();
    RowLen R = new RowLen();

    /**
     * Default constructor, creates the map
     * The root variable is assigned to the user.dir which is further read by the file variable
     * Also the chosen map is also read by the file variable
     * The map is choosen by the user and if the map isn't detected then the backup map is used
     */
    public Map() {
        String root = System.getProperty("user.dir"); // using the user's directory to access the maps
        System.out.println(System.getProperty("user.dir"));
        File file = new File(root + "\\Maps" + "\\" + choosemap() + ".txt"); // takes the chosen map and assigns to the variable file

        String st;
        /**
         * The Buffered Reader br reads the file and further reads it line by line and converts it to a character array
         * Also if the file is not found the code prints out "MAP NOT FOUND!!!" in red
         * After every thing runs successfully the code returns the map name, gold required and the map
         */
        try {
            BufferedReader br = new BufferedReader(new FileReader(file)); // the file variable
            mapName = br.readLine();
            goldRequired = Integer.parseInt(br.readLine().replace("win ", "").trim());// for it to read the number of gold required it replaces the 'win ' with ' "" ' and it trims it and the line is read as an integer
            map = new char[R.getI()][C.getJ()];
            j = 0;
            while ((st = br.readLine()) != null) {
                char[] c = st.toCharArray();
                System.out.print(c);
                System.out.println(map[j]);
                map[j] = c;
                j++;
            }
        } catch (FileNotFoundException e) { // if file is not found then use then the code prints out that the map is not found
            System.err.println("MAP NOT FOUND!!!");
            System.exit(0);

        } catch (IOException e1) {
        } catch (NumberFormatException e2) {
        }
    }

    protected int getGoldRequired() {
        return goldRequired;
    }

    protected char[][] getMap() {
        return map;
    }

    protected String getMapName() {
        return mapName;
    }

    /**
     * Checks if there is a wall
     * @param i : is the x axis
     * @param j : is the y axis
     * @return : true if there is a wall for the specified location of i and j
     */
    protected boolean wall(int i, int j) {
        if (map[i][j] == '#') {
            return true;
        }
        return false;
    }

    /**
     * When the user uses "PICK UP" then it checks if there is gold or not
     * Also if the gold is present then it converts the "G" to "."
     * @param i : is the x axis
     * @param j : is the y axis
     * @return : returns true if there is gold at the specified location of i and j and after it replaces that 'G' by a '.'
     */
    protected boolean gold(int i, int j) {
        if (map[i][j] == 'G') {
            map[i][j] = '.';
            return true;
        }
        return false;
    }

    /**
     * Checks if there is an "E"
     * If the E is there then it returns true else it returns false
     * @param i : is the x axis
     * @param j : is the y axis
     * @return : true if there is an 'E' at the specified location of i and j
     */
    protected boolean exit(int i, int j) {
        if (map[i][j] == 'E') {
            return true;
        }
        return false;
    }

    /**
     * This method takes an input from the user to select the map
     * @return : cmd
     */
    protected String Input() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cmd = "";
        try {
            cmd = in.readLine().toUpperCase();
        } catch (Exception e) {
        }
        return cmd;
    }

    /**
     * When the user gives the input of the map which they want to use it returns the String maps
     * Also the user can enter 'choose' which then asks the user to enter their map name without the extension
     * @return : the option the the user has chosen
     */
    public String choosemap() {
        String chooseMap = Input();
        String map1 = "small_example_map";
        String map2 = "medium_example_map";
        String map3 = "large_example_map";
        String map4 = "";
        switch (chooseMap) {
            case "MAP 1":
                return map1;
            case "MAP 2":
                return map2;
            case "MAP 3":
                return map3;
            case "CHOOSE":
                System.err.println("Enter your map name only without the extension:");
                map4 += Input();
                return map4;
        }
        return chooseMap;
    }
}