package com.bookmyshow.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;

import com.bookmyshow.constants.Constants;


public class PropertiesOperation {

	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) {
		String value = null;
		try {
			// 1. load data form properties file
			FileInputStream fis = new FileInputStream(Constants.PROPERTYFILE_PATH);
			prop.load(fis);

			// 2. read data
			value = prop.get(key).toString();
			if (StringUtils.isEmpty(value)) {
				throw new Exception("VALUE IS NOT SPECIFIED FOR KEY==>" + key + " IN PROPERTIES FILE.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
