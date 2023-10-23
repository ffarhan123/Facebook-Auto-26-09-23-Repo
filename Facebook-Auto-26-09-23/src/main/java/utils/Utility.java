package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	public static void captureScreenshot(WebDriver driver,String testCaseID) throws IOException
	{
		Date d = new Date();
		System.out.println(d);
		String date = d.toString().replace(" ", "-").replace(":", " ");
		TakesScreenshot ts = (TakesScreenshot)driver;  
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output/FailedTestScreenShots/Test- "+testCaseID+" "+date+".jpg");
		FileHandler.copy(src, dest);
	}
	public static String getExcelData(String sheetName,int rowNo,int cellNo) throws IOException
	{
		String path = "src/main/resources/data/Book1.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data;
		try 
		{
			data = cell.getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double numericData = cell.getNumericCellValue();
			data = Double.toString(numericData);
		}
		return data;	
	}
}
