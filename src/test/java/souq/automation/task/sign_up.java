package souq.automation.task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class sign_up {
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
	public void signup() {
		Actions action = new Actions(driver);
		WebElement optionlist = driver.findElementByXPath("//*[@id=\"login_user_name_topbar\"]");
		action.moveToElement(optionlist);
		action.build().perform();

		WebElement signup = driver.findElementByXPath("//*[@id=\"userName_topbar\"]/li[1]/div[2]/span/a");
		signup.click();

		WebElement nametxt = driver.findElementById("ap_customer_name");
		nametxt.sendKeys("smoke Testing");

		WebElement mailtxt = driver.findElementById("ap_email");
		mailtxt.sendKeys("tester@gmail.com");

		WebElement pass = driver.findElementById("ap_password");
		pass.clear();
		pass.sendKeys("P@ssw0rd");

		WebElement pass_con = driver.findElementById("ap_password_check");
		pass_con.sendKeys("P@ssw0rd");

		WebElement createbtn = driver.findElementById("continue");
		createbtn.click();
	}

	@AfterTest
	public void close_driver() {
		driver.close();
	}
}
