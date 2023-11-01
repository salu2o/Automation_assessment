package home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	
	WebDriver driver;
	
	public Cart(WebDriver driver) 
	{
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[data-product-id='1']")
    private WebElement add_cart_button;
    
    @FindBy(css = "div[class='modal-body'] p")
    private WebElement prod_added_text;
    
    @FindBy(css = "a[href='/view_cart'] u")
    private WebElement view_cart_button;
    
    @FindBy(css = "li[class='active']")
    private WebElement view_cart_page;
    
    @FindBy(css = "td.cart_quantity")
    private WebElement prod_cart_quanity;
    
	 public void add_product() 
	 {
		 mywait.waitForElementToBeClickable(driver, add_cart_button);
		 add_cart_button.click(); 
	 }
	 
	 public String prod_added()
	 {
		 mywait.waitForElementToBeVisible(driver, prod_added_text);
		 return prod_added_text.getText();
	 }
	 
	 public void view_cart()
	 {
		 mywait.waitForElementToBeClickable(driver, view_cart_button);
		 view_cart_button.click();
	 }
	 
	 public String check_product_quantity()
	 {
		 mywait.waitForElementToBeVisible(driver, view_cart_page);
		 mywait.waitForElementToBeVisible(driver, prod_cart_quanity);
		 return prod_cart_quanity.getText();
		 
	 }

    

}
