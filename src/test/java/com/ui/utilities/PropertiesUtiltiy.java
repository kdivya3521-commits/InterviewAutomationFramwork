package com.ui.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.ENV;

public class PropertiesUtiltiy {

	public static String readEnvProperties(ENV env, String propertyName) {
		File propertiesFile = new File(System.getProperty("user.dir") + "EnvConfiguarations/" + env + ".properties");
		FileReader fileReader;
		Properties properties = new Properties();

		try {
			fileReader = new FileReader(propertiesFile);
			properties.load(fileReader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = properties.getProperty(propertyName);
		return value;
	}

}
