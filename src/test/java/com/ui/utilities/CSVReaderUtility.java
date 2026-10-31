package com.ui.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVUtility(String fileName) {

		File file = new File(System.getProperty("user.dir") + "/TestData/" + fileName + ".csv");
		FileReader fileReader;
		CSVReader csvReader;

		String line[];
		User users;
		List<User> userList = new ArrayList<User>();

		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();
			while ((line = csvReader.readNext()) != null) {
				users = new User(line[0], line[1]);
				userList.add(users);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList.iterator();
	}

}
