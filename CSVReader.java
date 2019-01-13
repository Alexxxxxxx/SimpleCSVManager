package MyLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * For reading CSV files
 *
 * @author Oleskandr Lohvyn
 */
public class CSVReader {

    //Delimiter used in CSV file
    public static final String COMMA_DELIMITER = ",";

    private final ArrayList<ArrayList<String>> items;

    //Create the file reader
    public CSVReader(String filename, String delimiter) {
        //Create a list to be filled by CSV file data
        this.items = new ArrayList<>(0);

        BufferedReader fileReader = null;

        try {
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(filename));

            String line;

            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(delimiter);
                if (tokens.length > 0) {
                    ArrayList<String> tmp = new ArrayList<>(0);

                    tmp.addAll(Arrays.asList(tokens));

                    items.add(tmp);
                }
            }

        } catch (IOException ex) {
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    public ArrayList<String> getRow(int index) {
        if (index < size() && index >= 0) {
            return items.get(index);
        }
        return null;
    }

    public int size() {
        return items.size();
    }

}
