package SimpleCSVManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * For writing CSV files
 *
 * @author Alex Logvin (Oleskandr Lohvyn)
 */
public class CSVWriter {

	//Delimiter used in CSV file
	public static final String COMMA_DELIMITER = ",";

	private final ArrayList<ArrayList<String>> items;

	private final String delimiter;

	private FileWriter fileWriter = null;

	public CSVWriter(String filename, String delimiter) throws IOException {
		this.delimiter = delimiter;

		//Create a list to be written on CSV file data
		this.items = new ArrayList<>(0);

		fileWriter = new FileWriter(filename);

	}

	public void append(ArrayList<String> row) throws IOException {
		int i;
		for (i = 0; i < row.size() - 1; i++) {
			fileWriter.append(row.get(i));
			fileWriter.append(delimiter);
		}

		fileWriter.append(row.get(i));
		fileWriter.append('\n');

	}

	public void saveAndClose() throws IOException {
		fileWriter.flush();
		fileWriter.close();
	}

}
