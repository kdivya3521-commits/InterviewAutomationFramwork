package com.ui.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.ENV;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JSONUtiltiy {

	public static Environment readJSONFile(ENV env) {
		File file = new File(System.getProperty("user.dir") + "/EnvConfiguarations/config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();

		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get(env.name());

		return environment;

	}

}
