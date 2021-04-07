package WebDriverProject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginClass {
	
	WebDriver driver;
		
	@BeforeTest
             public void setup(){
	System.setProperty("WebDriver.gecko.driver","C:\\Users\\shalini\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
      	driver = new FirefoxDriver();                    //initialise the WebDriver
	}

            @Test
                         public void loginTest(){	
     	driver.get("https://opensource-demo.orangehrmlive.com/"); //define the url
	String pageTitle = driver.getTitle();		//get the title of the webpage
	System.out.println("The title of this page is ===> " +pageTitle);
	Assert.assertEquals("OrangeHRM", pageTitle);	//verify the title of the webpage
		
		driver.findElement(By.id("txtUsername")).clear();//clear the input field before entering any value
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");//enter the value of username
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");//enter the value of password
		driver.findElement(By.id("btnLogin")).click();		//click Login button
		System.out.println(“Successfully logged in”);
}

@AfterTest
             public void teardown(){
		driver.quit();
}
		
}
