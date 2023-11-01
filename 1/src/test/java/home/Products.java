package home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products{
	WebDriver driver;
	
	public Products(WebDriver driver) 
	{
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".title.text-center")
    private WebElement product_title;
	
	@FindBy(css = "a[href='/product_details/1']")
	private WebElement first_product;
	
	@FindBy(id="aswift_7")
	private WebElement iframe;
	
	@FindBy(css ="div[id='dismiss-button']")
	private WebElement closead;
	
	@FindBy(css = "div[class='product-information'] h2")
	private WebElement product_name;
	
    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    private WebElement product_category;

    @FindBy(css = "div[class='product-information'] span span")
    private WebElement product_price;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    private WebElement product_availability;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[3]")
    private WebElement product_condition;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    private WebElement product_brand;
    
    @FindBy(id = "search_product")
    private WebElement search_prod;
    
    @FindBy(id = "submit_search")
    private WebElement search_button;

    
	 public void click_first_product()
	 {
		 String pro_text = product_title.getText();
		 mywait.waitForElementToBeClickable(driver, first_product);
		 first_product.click();
//		 driver.switchTo().frame(iframe);
//		 mywait.waitForElementToBeClickable(driver, closead);
//		 closead.click();
//		 driver.switchTo().parentFrame();
		 
	 }
	 
	 public Boolean Get_Product_name()
	 {
		 return product_name.isDisplayed();
	 }
	 public Boolean Get_Product_category()
	 {
		 return product_category.isDisplayed();
	 }
	 public Boolean Get_Product_price()
	 {
		 return product_price.isDisplayed();
	 }
	 public Boolean Get_Product_avail()
	 {
		 return product_availability.isDisplayed();
	 }
	 public Boolean Get_Product_condition()
	 {
		 return product_condition.isDisplayed();
	 }
	 public Boolean Get_Product_brand()
	 {
		 return product_brand.isDisplayed();
	 }
	 
	 public String search_product()
	 {
		 mywait.waitForElementToBeClickable(driver, search_prod);
		 search_prod.sendKeys("tshirt");
		 search_button.click();
		 return product_title.getText();
	 }


}
