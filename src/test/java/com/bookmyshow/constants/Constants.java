package com.bookmyshow.constants;

import java.io.File;

public class Constants {

	public static final String SUITE_DIRECTORY = System.getProperty("user.dir");
	public static final String TESTRESOURCE_PATH = SUITE_DIRECTORY + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources";
	public static final String TESTDATA_PATH = TESTRESOURCE_PATH + File.separator + "TestData";
	public static final String TESTDATAFILE_PATH = TESTDATA_PATH + File.separator + "Test_Data_Sheet.xlsx";
	public static final String PROPERTIESFOLDER_PATH = TESTRESOURCE_PATH + File.separator + "properties";
	public static final String PROPERTYFILE_PATH = PROPERTIESFOLDER_PATH + File.separator + "Config.properties";
	public static final String EXTENTREPORTFOLDER_PATH = SUITE_DIRECTORY + File.separator + "extent-reports";
	public static final String DOWNLOADSFOLDER_PATH = SUITE_DIRECTORY + File.separator + "Downloads";
	
	// wait constants
	public static int TOOSHORT_SLEEP = 2000;
	public static int SHORT_SLEEP = 5000;
	public static int SHORT_IMPLICIT = 5;
	public static int SHORT_EXPLICIT = 10;

	public static int AVG_SLEEP = 10000;
	public static int AVG_IMPLICIT = 10;
	public static int AVG_EXPLICIT = 30;

	public static int LONG_SLEEP = 20000;
	public static int LONG_IMPLICIT = 15;
	public static int LONG_EXPLICIT = 50;
	public static int DOUBLE_LONG_SLEEP = 120000;

	// TestCases Sheet of TestData.xlsx workbook
	public static final int COL_TESTCASENAME = 1;
	
	//Google Form- Create Listener
	public static final int COL_NAME = 2;
	public static final int COL_EMAIL = 3;
	public static final int COL_PHONENUMBER = 4;
	public static final int COL_LINKEDIN_URL = 5;
	public static final int COL_ABOUT_CONNECTION =6;
	public static final int COL_BACKGROUNT_INCIDENT = 7;
	public static final int COL_LIFE_EXPERIENCE = 8;
	public static final int COL_LANGUAGE_TO_SPEAK = 9;
	public static final int COL_HEAR_ABOUT = 10;
	
	//Create User Form constants
	public static final String CREATE_PROFILE_SHEETNAME = "CreateAccount_TestData";
	public static final int COL_FIRST_NAME = 2;
	public static final int COL_LAST_NAME = 3;
	public static final int COL_STREETONE = 4;
	public static final int COL_STREETTWO = 5;
	public static final int COL_CITY =6;
	public static final int COL_STATE = 7;
	public static final int COL_ZIP = 8;
	public static final int COL_TIME_ZONE = 9;
	public static final int COL_DOB = 10;
	public static final int COL_PHONE_NUMBER = 11;
	public static final int COL_GENDER = 12;
	public static final int COL_PRONOUS = 13;
	public static final int COL_RACE = 14;
	public static final int COL_PRIMARY_LANGUAGE = 15;
	public static final int COL_SECONDARY_LANGUAGE= 16;
	public static final int COL_SPIRITUALITY = 17;
	public static final int COL_FAMILY= 18;
	public static final int COL_RELATIONSHIP= 19;
}
