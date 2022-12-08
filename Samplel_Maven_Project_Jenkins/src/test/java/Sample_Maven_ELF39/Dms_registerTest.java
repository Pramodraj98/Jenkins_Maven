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

public class Dms_registerTest extends Base_test {
	@DataProvider(name="reg")
	public Object []testsearch() throws IOException{
		Object [][] data=Utitlity_methods.getTestData("Register");
		return data;
	}
	@Test(dataProvider = "reg")
	
	public void register(String FN,String LN,String mail,String pwd,String cpwd) {
//	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//	WebDriver driver=new ChromeDriver();
//	driver.get("https://demowebshop.tricentis.com/");
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	driver.findElement(By.linkText("Register")).click();
	driver.findElement(By.id("gender-male")).click();
	WebElement frstn=driver.findElement(By.id("FirstName"));
	Utitlity_methods.Enter_Value_In_Textfield(frstn, FN);
	
	WebElement lstn=driver.findElement(By.id("LastName"));
	Utitlity_methods.Enter_Value_In_Textfield(lstn, LN);
	
	WebElement ml=driver.findElement(By.name("Email"));
	Utitlity_methods.Enter_Value_In_Textfield(ml, mail);
	
	WebElement pass=driver.findElement(By.cssSelector("input[class='text-box single-line password']"));
	Utitlity_methods.Enter_Value_In_Textfield(pass, pwd);
	
	
	WebElement conpwd=driver.findElement(By.id("ConfirmPassword"));
	Utitlity_methods.Enter_Value_In_Textfield(conpwd, cpwd);
	
	driver.findElement(By.id("register-button")).click();
	
}
}
