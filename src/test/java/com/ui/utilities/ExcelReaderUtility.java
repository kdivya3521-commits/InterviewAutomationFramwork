package com.ui.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelUtility(String fileName) {
		File file = new File(System.getProperty("user.dir") + "/TestData/" + fileName + ".xlsx");

		XSSFWorkbook xssfworkbook;
		XSSFSheet xssfsheet;
		Iterator<Row> rowIterator;

		User user;
		List<User> userList = new ArrayList<User>();
		try {
			xssfworkbook = new XSSFWorkbook(file);
			xssfsheet = xssfworkbook.getSheet("LoginTestData");

			rowIterator = xssfsheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell emailAddress = row.getCell(0);
				Cell password = row.getCell(1);
				user = new User(emailAddress.toString(), password.toString());
				userList.add(user);
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();

	}

}
