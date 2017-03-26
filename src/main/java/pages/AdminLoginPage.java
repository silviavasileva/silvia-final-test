package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.steadystate.css.util.ThrowCssExceptionErrorHandler;

import utils.Browser;

public class AdminLoginPage {
	@FindBy(name = "username")
	private static WebElement username;
	@FindBy(name = "password")
	private static WebElement password;
	@FindBy(linkText = "Login")
	private static WebElement loginButton;
	@FindBy(xpath = ".//div/h1")
	private static WebElement titleText;
	@FindBy(xpath = "//li/a")
	public static WebElement dashboard;
	

	public static void open() {
		Browser.driver.get("http://shop.pragmatic.bg/admin/");
		PageFactory.initElements(Browser.driver, AdminLoginPage.class);
	}

	public static void populateCredentioal(String userParam, String passParam) {
		username.sendKeys(userParam);
		password.sendKeys(passParam);
	}

	public static void clickLogin() {
		loginButton.click();
	}

	public static void login(String user, String pass) {
		populateCredentioal(user, pass);
		clickLogin();
	}

	public static String getLoginTitle() {
		return titleText.getText();
	}

	public static boolean isAt() {
		try {
			assertEquals("Dashboard", dashboard.getText());
		} catch (Throwable e) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void assertEquals(String string, String text) {
		// TODO Auto-generated method stub

	}

}
