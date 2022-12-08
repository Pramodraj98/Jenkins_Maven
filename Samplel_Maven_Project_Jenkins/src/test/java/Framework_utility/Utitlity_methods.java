package Framework_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utitlity_methods {
	// utility methods for send keys
		public static void Enter_Value_In_Textfield(WebElement element ,String value) {
			element.sendKeys(value);
		}
		
	// utility methods for click
		public static void Click_Element(WebElement element) {
			element.click();
		}
		
	// utitlity methods for dropdown
		public static void selectbyindex(WebElement element,int indexno) {
			Select select=new Select(element);
			select.selectByIndex(indexno);
		}
		
		public static void selectbyvisibletext(WebElement element,String text) {
			Select select=new Select(element);
			select.selectByVisibleText(text);
		}
		
		public static void selectbyvalue(WebElement element,String value) {
			Select select=new Select(element);
			select.selectByValue(value);
		}
		
	 //action class
		public static void actionclass(WebElement element,WebDriver d) {
			Actions action=new Actions(d);
			action.moveToElement(element).perform();
		}
		
		//Utility methods for test configuration
		public static String Test_configuration() throws IOException {
			String filepath="./Test_configuration/Testconfiguration.properties";
			FileInputStream fis=new FileInputStream(filepath);
			
			// create object for properties class
			Properties prop=new Properties();
			prop.load(fis);
			String url=prop.getProperty("URL");
			//String url=prop.getProperty("Link");
			return url;
		}
		
	// to get the test data
		public static Object[][] getTestData(String sheetname) throws IOException{
			
		String filepath="./Testdata/Testdata.xlsx";

		FileInputStream fis=new FileInputStream(filepath);

		//Create object for excel file
		Workbook book=new XSSFWorkbook(fis);

		//access the sheet
		Sheet sheet=book.getSheet(sheetname);

		//get row n column count
		int rowcount=sheet.getPhysicalNumberOfRows();
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data =new Object[rowcount-1][colcount];

		for(int row=1;row<=rowcount-1;row++) {
			for(int col=0;col<=colcount-1;col++) {
				data[row-1][col]=sheet.getRow(row).getCell(col).getStringCellValue();
			}
					}
		
		book.close();
				return data;
}}
