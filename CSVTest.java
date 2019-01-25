
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

		// **** writing new CSV file ***
		
		// the file to create
		String fileName = "file.csv";
		// delimiter user to delimit values. normaly is ","
		// (String) CSVWriter.COMMA_DELIMITER - comma delimiter ","
		String delimiter = CSVWriter.COMMA_DELIMITER;

		// try block because writing errors can take place
		try {
			// * create the file
			// (String) fileFrom - the file to create
			// (String) delimiterFrom - delimiter user to delimit values. normaly is ","
			CSVWriter csvWriter = new CSVWriter(fileName, delimiter);

			// create a line (row) of items to put on a file
			ArrayList<String> line = new ArrayList<>(3);
			// put items on line
			line.add("Name");
			line.add("Number");
			line.add("Phone");

			// put the line on the file
			csvWriter.append(line);

			// save and close the file
			csvWriter.saveAndClose();

		} catch (IOException ex) {
			// in case writing or file saving errors happen
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

		//* connect the file and read all data
		// (String) fileName - the file to read
		// (String) delimiter - delimiter user to delimit values. normaly is ","
		CSVReader csvReader = new CSVReader(fileName, delimiter);

		//* for each row
		// (int) csvReader.size() - returns the count of the rows found in the file
		for (int row = 0; row < csvReader.size(); row++) {

			//* for each element in the row
			// (int) csvReader.getRow(row).size() - returns the count of the elements
			//     found in that row
			for (int element = 0; element < csvReader.getRow(row).size(); element++) {

				//* write element on the screen
				// (String) csvReader.getRow(row).get(element) - returns the element
				//     in "element" position on "row" row
				System.out.print(csvReader.getRow(row).get(element) + " ");
			}
			// just go to new line
			System.out.println();
		}
		//--------
	}

}
