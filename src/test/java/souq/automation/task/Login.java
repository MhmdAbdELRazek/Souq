package souq.automation.task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class Login {

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
	public void login() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement optionlist = driver.findElementByXPath("//*[@id=\"login_user_name_topbar\"]");
		action.moveToElement(optionlist);
		action.build().perform();

		WebElement Login_btn = driver.findElementByXPath("//*[@id=\"userName_topbar\"]/li[1]/div[1]/a");
		Login_btn.click();

		WebElement mail_txt = driver.findElementByXPath("//*[@id=\"email\"]");
		mail_txt.sendKeys("tester@gmail.com");

		WebElement sign_in_btn = driver.findElementById("siteLogin");
		sign_in_btn.click();
		Thread.sleep(3000);

		WebElement con_btn = driver.findElementById("auth-portal-continue");
		con_btn.click();
		Thread.sleep(3000);

		WebElement con_btn2 = driver.findElementById("continue");
		con_btn2.click();

		WebElement pass_txt = driver.findElementById("ap_password");
		pass_txt.sendKeys("P@ssw0rd");

		WebElement sign_in_btn2 = driver.findElementById("signInSubmit");
		sign_in_btn2.click();
	}

	@AfterTest
	public void close_driver() {
		driver.close();
	}
}
