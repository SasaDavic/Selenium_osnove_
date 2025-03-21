package d20_09_2022_tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import d20_09_2022_pages.ContactUsPage;
import d20_09_2022_pages.LoginSignupPage;
import d20_09_2022_pages.NavPage;
import d20_09_2022_pages.ProductDetailsPage;
import d20_09_2022_pages.ProductsPage;
import d20_09_2022_pages.SignupPage;
import d20_09_2022_pages.TestCasesPage;


public abstract class AutomationPracticeBasicTests {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "https://www.automationexercise.com";
	protected NavPage navPage;
	protected LoginSignupPage login_signup_page;
	protected SignupPage signup_page;
	protected ContactUsPage contactUsPage;
	protected TestCasesPage testCasesPage;
	protected ProductsPage productsPage;
	protected ProductDetailsPage productDetailsPage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		navPage = new NavPage(driver);
		login_signup_page = new LoginSignupPage(driver);
		signup_page = new SignupPage(driver);
		contactUsPage = new ContactUsPage(driver);
		testCasesPage = new TestCasesPage(driver);
		productsPage = new ProductsPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void afterMethod() {
			
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	
}
