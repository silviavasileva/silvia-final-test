package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Browser;

public class ProductsPage {
	@FindBy(linkText = "Catalog")
	public static WebElement catalog;
	@FindBy(linkText = "Products")
	public static WebElement products;
	@FindBy(xpath = ".//tr[1]/td[3]/input")
	public static WebElement productField;
	@FindBy(linkText = "Insert")
	public static WebElement insert;
	@FindBy(linkText = "General")
	public static WebElement generalTitle;
	@FindBy(linkText="Data")
	public static WebElement data;
	@FindBy(name="product_description[1][name]")
	public static WebElement productName;
	@FindBy(name="model")
	public static WebElement model;
	@FindBy(linkText="Save")
	public static WebElement saveButton;
	@FindBy(name="selected[]")
	public static WebElement checkX;
	@FindBy(linkText="Delete")
	public static WebElement deleteProduct;
	
	public static void clickProducts() {
		PageFactory.initElements(Browser.driver, ProductsPage.class);
		catalog.click();
		products.click();

	}

	public static String getProductsTitle() {
		return products.getText();
	}

	public static boolean isAtProducts() {
		try {
			assertEquals("Products", getProductsTitle());
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

	private static void assertEquals(String string, String productsTitle) {
		// TODO Auto-generated method stub

	}

	public static void searchProduct(String search) {
		productField.sendKeys(search);
		Browser.driver.findElement(By.linkText("Filter")).click();
	}

	public static void insertProduct() {
		insert.click();
		isAtGeneral();
	}

public static boolean isAtGeneral() {
	if(generalTitle.getText().equals("General")) {
		return true;
	} else {
	return false;
	}
}
public static boolean isAtData() {
	if(data.getText().equals("Data")) {
		return true;
	} else {
		return false;
	}
}
public static void clickData() {
	data.click();
	isAtData();
}
public static void addProductName(String name) {
	productName.sendKeys(name);
}
public static void addModel(String modelParam) {
	model.sendKeys(modelParam);
	clickSave();
}
public static void clickSave() {
	saveButton.click();
}
public static void deleteProduct() throws Throwable {
	checkX.click();
	deleteProduct.click();
	try {
		Alert alert = Browser.driver.switchTo().alert();
		String textOfAlert = alert.getText();
		Thread.sleep(2000);
		alert.accept();
		assertEquals("Delete/Uninstall cannot be undone! Are you sure you want to do this?", textOfAlert);
	} catch (NoAlertPresentException e) {
		e.printStackTrace();
	}

	}
}

