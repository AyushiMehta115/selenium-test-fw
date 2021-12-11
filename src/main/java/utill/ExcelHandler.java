package utill;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testDriver.Shell;

public class ExcelHandler extends Shell {

	// initialize variables
	public String testCaseFilePath = "C:\\Users\\ayushi_mehta\\Downloads\\Selenium Java\\TestFW\\src\\main\\java\\testData\\TestCases.xlsx";
	public Workbook testCaseWorkbook;
	public Sheet testcaseSheet;

	// Open excel file
	public void identifyTestcaseFile() {
		try {
			File file = new File(testCaseFilePath);
			FileInputStream fip = new FileInputStream(file);
			testCaseWorkbook = null;
			testCaseWorkbook = new XSSFWorkbook(fip);
			testcaseSheet = testCaseWorkbook.getSheet(prop.getProperty("TestCaseSheet"));
			Shell.log.info("Excel Opened");
		} catch (Exception e) {
			Shell.log.info("Test case sheet opening failed - " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Close all excel files
	public void closeAllOpenExcel() {
		try {
			Shell.log.info("Closing all Excels");
			Runtime.getRuntime().exec("taskkill /f /t /IM EXCEL.EXE");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
