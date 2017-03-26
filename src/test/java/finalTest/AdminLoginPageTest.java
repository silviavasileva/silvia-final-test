package finalTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pages.AdminLoginPage;
import pages.ProductsPage;
import utils.Browser;

public class AdminLoginPageTest {


	@Test
	public void successfullLogin() throws Throwable {
		Browser.goTo();
		AdminLoginPage.open();
		String adminLoginPageTitle = AdminLoginPage.getLoginTitle();
		assertEquals("Please enter your login details.", adminLoginPageTitle);
		
		AdminLoginPage.login("admin", "parola");
		AdminLoginPage.isAt();
		ProductsPage.clickProducts();
		ProductsPage.isAtProducts();
		ProductsPage.searchProduct("X");
		ProductsPage.insertProduct();
		ProductsPage.addProductName("X");
		ProductsPage.clickData();
		ProductsPage.addModel("X2X");
		ProductsPage.deleteProduct();
	
	//	Browser.close();
	}
}
