# SimpleCSVManager
A small Java library developed to make reading and writing CSV files easier.
The library will be useful if you want to read or write CSV files with few commands.
This library is not prefessional, so use it where the performance is **not** required

You can read and write CSV files with different number of items on any row.
You can choose the delimiter (typically it's comma ",")

## Get Started

#### You need to install the library
Copy the folder **SimpleCSVManager** into your project's source folder

#### Connect it to your project
Make sure you have the following imports
```java
import SimpleCSVManager.CSVReader;
import SimpleCSVManager.CSVWriter;
import java.io.IOException;
import java.util.ArrayList;
```

#### How to read CSV
```java
// the file to read
String fileFrom = "file.csv";
// delimiter user to delimit values. normaly is ","
String delimiterFrom = "\t";

//* connect the file and read all data
// (String) fileFrom - the file to read
// (String) delimiterFrom - delimiter user to delimit values. normaly is ","
CSVReader csvReader = new CSVReader(fileFrom, delimiterFrom);

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
```

#### How to write CSV
```java
// the file to create
String fileName = "file.csv";
// delimiter user to delimit values. normaly is ","
// (String) CSVWriter.COMMA_DELIMITER - comma delimiter ","
String delimiter = CSVWriter.COMMA_DELIMITER;

// try block because writing errors can take place
try {
    //* create the file
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
```

You can look at _[CSVTest.java](CSVTest.java)_ to get the basic usage of the **SimpleCSVManager** library and test it yourself
