package run.com;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

//import com.opera.core.systems.internal.input.KeyEvent;


public class OpenBrowser {
	
	 public Properties obj;
	 public WebDriver driver;  // No duplicate web driver in class file
	

	
	public void setChromeProperty() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				System.setProperty(
						ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
						"chromedriver.exe");
			} else {
				System.setProperty(
						ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
						"chromedriver");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Run() throws IOException, InterruptedException
	{
	    obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\objects\\object.properties");									
	    obj.load(objfile);
	    
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
		driver.get(obj.getProperty("URL"));
		Thread.sleep(1000); 
		
		   
	}
	public void test() throws InterruptedException
	{
		
		driver.findElement(By.id(obj.getProperty("Email_id"))).click();
	    driver.findElement(By.id(obj.getProperty("Email_id"))).sendKeys(obj.getProperty("Email"));
	    driver.findElement(By.className(obj.getProperty("Arrow"))).click();
	   Thread.sleep(1000);
	    driver.findElement(By.id(obj.getProperty("UserPassword"))).click();
	    driver.findElement(By.id(obj.getProperty("UserPassword"))).sendKeys(obj.getProperty("Password"));
	    driver.findElement(By.className(obj.getProperty("Arrow"))).click();
	}
}
