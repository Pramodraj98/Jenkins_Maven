package Sample_Maven_ELF39;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework_utility.Base_test;
import Framework_utility.Utitlity_methods;

public class Dms_SearchTest extends Base_test {
	@DataProvider(name="search")
	public Object []testsearch() throws IOException{
		Object [][] data=Utitlity_methods.getTestData("Search");
		return data;
	}
	
@Test(dataProvider = "search")

public void TC01(String search) {
	
//	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//	WebDriver driver=new ChromeDriver();
//	driver.get("https://demowebshop.tricentis.com/");
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	WebElement srch=driver.findElement(By.id("small-searchterms"));
	Utitlity_methods.Enter_Value_In_Textfield(srch, search);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	
}
}
