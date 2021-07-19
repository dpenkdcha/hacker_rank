package Crest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class FileProcessBackUp {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String filePathIput = "D:\\LEARNING\\HACKER_RANK\\hacker_rank\\src\\resources\\input\\";
	private static final String filePathOutput = "D:\\LEARNING\\HACKER_RANK\\hacker_rank\\src\\resources\\output\\";

	public static void main(String[] args) {
		ArrayList<String> dataArrayList = new ArrayList<String>();
		HashSet<String> identicalRecord = new HashSet<String>();
		try {
			String dataFile = "DATA.dat";
			String data1File = "DATA1.dat";

			Path pathToFile = Paths.get(dataFile);
			System.out.println(pathToFile.toAbsolutePath());
			System.out.println(System.getProperty("user.dir"));

			URL path = FileProcessBackUp.class.getResource(dataFile);
			// System.out.println(path.toString());
			File f = new File("../src/resources/input/" + dataFile);
			System.out.println(f.toPath());
			System.out.println(new File("../src/resources/input/" + dataFile));

			File directory = new File("./");
			System.out.println(directory.getAbsolutePath());

			String[] datalines = Files.readAllLines(new File("./src/resources/input/" + dataFile).toPath()).toArray(new String[0]);
			String[] data1lines = Files.readAllLines(new File(filePathIput + data1File).toPath()).toArray(new String[0]);

			int datLength = datalines.length;
			int dat1Length = data1lines.length;

			String[] combineDAT = new String[datLength + dat1Length - 1];
			System.arraycopy(datalines, 0, combineDAT, 0, datLength);
			System.arraycopy(data1lines, 1, combineDAT, datLength, dat1Length - 1);

			ArrayList<Integer> grossSalaryList = new ArrayList<Integer>();
			float totalSalary = 0.0f;
			float totalRecords = 0.0f;
			for (int index = 0; index < combineDAT.length; index++) {
				String trimedData = combineDAT[index].trim().replaceAll("\t", COMMA_DELIMITER);
				if (index == 0) {
					trimedData = trimedData + ",Gross Salary";
					dataArrayList.add(trimedData);
				} else {
					String singleRecordArray[] = trimedData.split(COMMA_DELIMITER);
					String recordID = singleRecordArray[0];
					if (!identicalRecord.contains(recordID)) {
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

			/*
			 * for (int index = 1; index < data1lines.length; index++) { String trimedData =
			 * data1lines[index].trim().replaceAll("\t", COMMA_DELIMITER); String
			 * singleRecordArray[] = trimedData.split(COMMA_DELIMITER); String recordID =
			 * singleRecordArray[0]; if (!identicalRecord.contains(recordID)) {
			 * identicalRecord.add(recordID); int grossSalary =
			 * (Integer.valueOf(singleRecordArray[5]) +
			 * Integer.valueOf(singleRecordArray[6])); grossSalaryList.add(grossSalary);
			 * totalSalary += grossSalary; totalRecords++; trimedData = trimedData +
			 * COMMA_DELIMITER + String.valueOf(grossSalary); dataArrayList.add(trimedData);
			 * } }
			 */

			Collections.sort(grossSalaryList, Collections.reverseOrder());

			/* Adding second higest value */
			float averageSalary = totalSalary / totalRecords;
			String lastRow = "Second Highest Salary=" + grossSalaryList.get(1) + COMMA_DELIMITER + "average salary = " + averageSalary;
			dataArrayList.add(lastRow);

			// for (String sda : dataArrayList) { System.out.println(sda); }

			writeCsvFile(filePathOutput + "RESULT.CSV", dataArrayList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
