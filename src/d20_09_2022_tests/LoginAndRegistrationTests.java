package d20_09_2022_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndRegistrationTests extends AutomationPracticeBasicTests{
		
	@Test (priority = 10)
	public void newUserRegistration() {
		//provera da li smo na HOME page
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "You're not on home page!");
		//iz navigacionog menija kliknemo na signup dugme
		navPage.getSignupLoginLink().click();
		//provera da li smo na login/signup stranici
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'signup-form')]/h2")).getText(),
				"New User Signup!",
				"There is no signUp form!");
		//popunimo formu
		login_signup_page.getSignupNameInput().sendKeys("sasa");
		login_signup_page.getSignupEmailInput().sendKeys("sasa@gmail.com");
		login_signup_page.getSignupButton().click();
		//provera da li smo na signup stranici
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Not signup page");
		signup_page.waitForFormForSignUpToOpen();
		//popunjavamo formu
		signup_page.getGenderTitleMRSInput().click();
		signup_page.getNameInput().clear();
		signup_page.getNameInput().sendKeys("Cale");
//mail moze da se unese samo prvi put - greska ili namerno da se mail ne duplira!!!
//		signup_page.getEmailInput().clear();
//		signup_page.getEmailInput().sendKeys("cale@gmail.com");
		signup_page.getPasswordInput().clear();
		signup_page.getPasswordInput().sendKeys("a123");
		Select selectD = new Select(signup_page.getDaysSelect());
		Select selectM = new Select(signup_page.getMonthsSelect());
		Select selectY = new Select(signup_page.getYearsSelect());
		Select selectC = new Select(signup_page.getCountrySelect());
		selectD.selectByIndex(1);
		selectM.selectByValue("2");
		selectY.selectByVisibleText("2000");
		signup_page.getSignupForNewsletterCheckbox().click();
		signup_page.getFirstNameInput().sendKeys("Milan");
		signup_page.getLastNameInput().sendKeys("Jovic");
		signup_page.getCompanyInput().sendKeys("BGi");
		signup_page.getAddressInput().sendKeys("Jovana Ristica 3, Kraljevo");
		selectC.selectByIndex(2);
		signup_page.getStateInput().sendKeys("Srbija");
		signup_page.getCityInput().sendKeys("Kraljevo");
		signup_page.getZipcodeInput().sendKeys("15200");
		signup_page.getMobileNumberInput().sendKeys("+38160 89 89 563");
		signup_page.getCreateAccountButton().click();
		login_signup_page.waitForAccountToBeCreated();
		driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
		//brisemo nalog
		navPage.getDeleteAccountLink().click();
		login_signup_page.waitForAccountToBeDeleted();
		
		
		
	}
	
}
