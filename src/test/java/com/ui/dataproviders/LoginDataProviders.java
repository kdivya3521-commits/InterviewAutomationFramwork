package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.ui.utilities.CSVReaderUtility;
import com.ui.utilities.ExcelReaderUtility;

public class LoginDataProviders {

	@DataProvider(name = "Login Data CSV Provider")
	public Iterator<User> loginDataCSVProvider() {
		return CSVReaderUtility.readCSVUtility("loginData");
	}

	@DataProvider(name = "Login Data Excel Provider")
	public Iterator<User> loginDataExcelProvider() {
		return ExcelReaderUtility.readExcelUtility("loginData");
	}

	@DataProvider(name = "Login Data JSON provider")
	public Iterator<Object[]> loginDataJSONProvider() throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "/TestData/loginData.json");
		FileReader fileReader = new FileReader(file);
		List<Object[]> userList = new ArrayList<Object[]>();
		Gson gson = new Gson();
		TestData testdata =gson.fromJson(fileReader, TestData.class);
		
		for(User user:testdata.getData()) {
			userList.add(new Object[] {user});
		}
		return userList.iterator();
	}
}
