
import SimpleCSVManager.CSVReader;
import SimpleCSVManager.CSVWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Test class implements basic ways for reading, coping and writing CSV files
 *
 * @author Alex Logvin (Oleskandr Lohvyn)
 */
public class CSVTest {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		// **** creating new CSV file ***
		String fileName = "file.csv";
		String delimiter = CSVWriter.COMMA_DELIMITER;

		try {
			// connect to file
			CSVWriter csvWriter = new CSVWriter(fileName, delimiter);

			// create a line
			ArrayList<String> line = new ArrayList<>(3);
			// put data on line
			line.add("Name");
			line.add("Number");
			line.add("Phone");

			// write line on file
			csvWriter.append(line);

			// close file
			csvWriter.saveAndClose();

		} catch (IOException ex) {
			System.err.println("Can't create the file");
		}
		//--------

		// *** coping CSV file ***
		String fileFrom = "file.csv";
		String fileTo = "NEWfile.csv";

		String delimiterFrom = CSVReader.COMMA_DELIMITER;
		String delimiterTo = "\t";

		try {
			// connecting 2 files
			CSVReader csvFrom = new CSVReader(fileFrom, delimiterFrom);
			CSVWriter csvTo = new CSVWriter(fileTo, delimiterTo);

			// for each row
			for (int i = 0; i < csvFrom.size(); i++) {
				// copy the row from one file to other
				csvTo.append(csvFrom.getRow(i));
			}

			// save new file
			csvTo.saveAndClose();

		} catch (IOException ex) {
			System.err.println("Can't read/create the file");
		}
		//--------

		// *** reading CSV file ***
		fileName = "NEWfile.csv";
		delimiter = "\t";

		// connect the file
		CSVReader csvReader = new CSVReader(fileFrom, delimiterFrom);
		// for each row
		for (int i = 0; i < csvReader.size(); i++) {
			// for each element in the row
			for (int CSVTest = 0; CSVTest < csvReader.getRow(i).size(); CSVTest++) {
				// write element on the screen
				System.out.print(csvReader.getRow(i).get(CSVTest));
			}
			System.out.println();
		}
		//--------
	}

}
