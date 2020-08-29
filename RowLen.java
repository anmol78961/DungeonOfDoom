import java.io.*;

/**
 * This class provides us the Row Length of the map
 */
public class RowLen {

    public int i;
    public int i1;

    /**
     * Uses the large map to calculate the row length
     * @return : the length of the row
     */
    public int Rowlen() {

        String root = System.getProperty("user.dir");
        String name = "\\size.txt";
        File file = new File(root + "\\Size" + name);

        /**
         * Reads the lines of the large map
         */
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Map not found");
            System.exit(0);
        }

        /**
         * After reading each line it adds one to 'i' which is later transmitted to 'i1'
         */
        try {
            i1 = 0;
            i = 1;
            while (br.readLine() != null) {
                i1 = i++;
            }
        } catch (IOException e1) {
        } catch (NumberFormatException e2) {
        }
        return i1;

    }

    /**
     * @return : The Row Length
     */
    protected int getI() {
        return Rowlen();
    }
}
