package archive;


import org.apache.poi.ss.usermodel.Row;
import utill.ExcelHandler;
import testDriver.Shell;

public class ReadAndExecutefn extends Shell{

	// Read all the test cases that has to be executed.
	public static void readAndExecuteTestcases() throws Exception {
		// ------Call function to open excel
		ExcelHandler xlHandler = new ExcelHandler();
		xlHandler.closeAllOpenExcel();
		xlHandler.identifyTestcaseFile();

		// ------initializing variables
		Row columnHeading = xlHandler.testcaseSheet.getRow(1);
		int rowCount = xlHandler.testcaseSheet.getLastRowNum() - xlHandler.testcaseSheet.getFirstRowNum();
		int colCount = columnHeading.getLastCellNum();
		int colTCNo = 0, colModule = 0, colTD = 0, colDes = 0, colTR = 0;

		// ------Traversing through rows and columns
		for (int i = 0; i < rowCount + 1; i++) {
			for (int j = 0; j < colCount; j++) {
				String TRStatusHeading = columnHeading.getCell(j).getStringCellValue();
				if (TRStatusHeading.equals("Test Case No")) {
					colTCNo = j;
				}
				if (TRStatusHeading.equals("Module")) {
					colModule = j;
				}
				if (TRStatusHeading.equals("Test Data")) {
					colTD = j;
				}
				if (TRStatusHeading.equals("Test Case Description")) {
					colDes = j;
				}
				if (TRStatusHeading.equals("Test Run")) {
					colTR = j;
					String TRStatus = xlHandler.testcaseSheet.getRow(i).getCell(colTR).getStringCellValue();
					String TCNumber = xlHandler.testcaseSheet.getRow(i).getCell(colTCNo).getStringCellValue();
					String ModuleName = xlHandler.testcaseSheet.getRow(i).getCell(colModule).getStringCellValue();
					String TestData = xlHandler.testcaseSheet.getRow(i).getCell(colTD).getStringCellValue();
					String TCDescription = xlHandler.testcaseSheet.getRow(i).getCell(colDes).getStringCellValue();
					if (TRStatus.equals("Y")) {
						// TestExecutor will drive the test cases individually
						log.info("Executing " + TCNumber + ":-" + TCDescription);
						TestExecutor te = new TestExecutor(TRStatus, TCNumber, ModuleName, TestData, TCDescription);
						//te.Browserinitialization();
						te.OpenWebApplication();
						te.runTestCase();
						te.closeBrowser();
						log.info(TCNumber + " execution completed");
					}
				}
			}
		}
	}
}
