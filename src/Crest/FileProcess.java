package Crest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * The FileProcess program implements an application that read input form 2
 * provided DAT file and generate output into separate CSV file
 *
 * @author Dipen Kadecha
 */
public class FileProcess {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String filePathIput = "C:\\input\\";
	private static final String filePathOutput = "C:\\output\\";

	/**
	 * This is main method for reading DAT file and it will process records, remove
	 * duplicates and calculate average salary and second higest income
	 * 
	 * datalines : will contains both DAT file input grossSalaryList : for
	 * containing gross salary list averageSalary : contains average salary of
	 * identical records dataArrayList : processed combined array list of both DAT
	 * file
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<String> dataArrayList = new ArrayList<String>();
		HashSet<String> identicalRecord = new HashSet<String>();
		try {

			List<String> datalines = Files.readAllLines(new File(filePathIput + "DATA.dat").toPath());
			List<String> data1lines = Files.readAllLines(new File(filePathIput + "DATA1.dat").toPath());
			data1lines.remove(0); // reomve header from second DATA1.DAT file
			datalines.addAll(data1lines);

			ArrayList<Integer> grossSalaryList = new ArrayList<Integer>();
			float totalSalary = 0.0f;
			float totalRecords = 0.0f;

			for (int index = 0; index < datalines.size(); index++) {
				String trimedData = datalines.get(index).trim().replaceAll("\t", COMMA_DELIMITER);
				if (index == 0) { // for header processing
					trimedData = trimedData + ",Gross Salary";
					dataArrayList.add(trimedData);
				} else { // rest of line processing
					String singleRecordArray[] = trimedData.split(COMMA_DELIMITER);
					String recordID = singleRecordArray[0];
					if (!identicalRecord.contains(recordID)) { // for identification of unique records
						identicalRecord.add(recordID);
						int grossSalary = (Integer.valueOf(singleRecordArray[5]) + Integer.valueOf(singleRecordArray[6]));

						grossSalaryList.add(grossSalary);
						totalSalary += grossSalary;
						totalRecords++;
						trimedData = trimedData + COMMA_DELIMITER + String.valueOf(grossSalary);
						dataArrayList.add(trimedData);
					}
				}
			}

			Collections.sort(grossSalaryList, Collections.reverseOrder());
			float averageSalary = totalSalary / totalRecords;

			/* Adding second higest value and average salary as last element */
			String lastRow = "Second Highest Salary=" + grossSalaryList.get(1) + COMMA_DELIMITER + "average salary = " + averageSalary;
			dataArrayList.add(lastRow);

			writeCsvFile(filePathOutput + "RESULT.CSV", dataArrayList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function for read data from array list and generate CSV file.
	 * 
	 * @param fileName resulted CSV file
	 * @param data     list of all recored
	 */
	public static void writeCsvFile(String fileName, ArrayList<String> data) {
		ArrayList<String> dataDAT = data;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			for (String record : dataDAT) {
				String singleRecordArray[] = record.split(COMMA_DELIMITER);
				for (String dat1 : singleRecordArray) {
					fileWriter.append(dat1);
					fileWriter.append(COMMA_DELIMITER);
				}
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("CSV file was created successfully!");

		} catch (Exception e) {
			System.out.println("Error in CSV File Creation!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error in Finally!");
				e.printStackTrace();
			}
		}
	}

}

class salaryId implements Comparator<Employe> {

	public int compare(Employe emp1, Employe emp2) {
		//return emp2.getId() - emp1.getId();
		
		return emp1.getName().compareTo(emp2.getName());
	}

}

class salaryName implements Comparable<Employe> {

	private int id;
	
	public int compare(Employe emp1, Employe emp2) {
		return emp2.getId() - emp1.getId();
	}

	@Override
	public int compareTo(Employe emp1) {
		return this.id - emp1.getId();
	}

}

