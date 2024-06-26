package com.orangehrm.app.utitlities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/orangehrm/app/testData/TestData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Data");
		int colcount = XLUtils.getCellCount(path, "Data", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Data", i, j);// 1 0
			}
		}
		return logindata;
	}

}
