import java.io.*;

/**
 * This class provides us the Column Length of the map
 */
public class ColumnLen {
    public int j1;

    /**
     * Uses the large map to calculate the Column length
     * @return : the column length
     */
    public int Columnlen() {
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

        String st;
        /**
         * After reading each line it adds one to 'c' which is later transmitted to 'j1'
         */
        try {
            j1 = 1;
            while ((st = br.readLine()) != null) {
                int c = st.toCharArray().length;
                j1 = c++;
            }
        } catch (IOException e1) {
        } catch (NumberFormatException e2) {
        }
        return j1;
    }

    /**
     * @return : The length of the column
     */
    protected int getJ() {
        return Columnlen();
    }

}