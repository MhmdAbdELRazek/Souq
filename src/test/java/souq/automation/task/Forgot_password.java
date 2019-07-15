package souq.automation.task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class Forgot_password {
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
	public void forgot_pass() throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement optionlist = driver.findElementByXPath("//*[@id=\"login_user_name_topbar\"]");
		act.moveToElement(optionlist);
		act.build().perform();

		WebElement Login = driver.findElementByXPath("//*[@id=\"userName_topbar\"]/li[1]/div[1]/a");
		Login.click();

		WebElement mailtxt = driver.findElementByXPath("//*[@id=\"email\"]");
		mailtxt.sendKeys("tester@gmail.com");

		WebElement sign_in_btn = driver.findElementById("siteLogin");
		sign_in_btn.click();
		Thread.sleep(3000);

		WebElement con_btn = driver.findElementByPartialLinkText("Continue");
		con_btn.click();
		Thread.sleep(3000);

		WebElement con_btn2 = driver.findElementById("continue");
		con_btn2.click();

		WebElement forgot_link = driver.findElementById("auth-fpp-link-bottom");
		forgot_link.click();

		WebElement con_btn3 = driver.findElementById("continue");
		con_btn3.click();

		WebElement zip_txt = driver.findElementById("ap_zip");
		zip_txt.sendKeys("56273");

		WebElement con_btn4 = driver.findElementById("continue");
		con_btn4.click();
	}

	@AfterTest
	public void close_driver() {
		driver.close();
	}
}
