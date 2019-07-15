package souq.automation.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import junit.framework.Assert;

public class Toy {
	ChromeDriver driver;

	@BeforeMethod
	public void open_driver() {
		String Chromepath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://egypt.souq.com/eg-en/");
	}

	@Test
	public void toy() throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement optionlist = driver.findElement(By.linkText("Toys"));
		act.moveToElement(optionlist);
		act.build().perform();

		Thread.sleep(3000);
		WebElement guns = driver.findElementByPartialLinkText("Guns");
		String exp_url = guns.getAttribute("href");
		String atc_url = "https://egypt.souq.com/eg-en/guns/%D8%A3%D9%84%D8%B9%D8%A7%D8%A8-24/a-t/s/?page=1";
		Assert.assertEquals(exp_url,atc_url);
		
		// For More Check about the page URL ^_^
		//System.out.println("The Actual URL Is : " + guns.getAttribute("href"));
	}

	@AfterTest
	public void close_driver() {
		driver.close();
	}
}