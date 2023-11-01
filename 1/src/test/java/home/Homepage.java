package home;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage{
	@FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement active_image;
 
	@FindBy(css = "a[href='/products']")
    private WebElement products_button;
    
    @FindBy(css = "div[class='footer-bottom'] p")
	private WebElement page_down_element;
    
    @FindBy(css = "a[href='/products']")
    private WebElement page_up_element;
    
	WebDriver driver;
	
	public Homepage(WebDriver driver) 
	{
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	
	public WebElement get_home_page()
	{
		mywait.waitForElementToBeVisible(driver, active_image);
		return active_image;
	}
	 
	 public boolean homepage_is_visible()
	 {
		return get_home_page().isDisplayed();
	 }
	 
	 public void Click_Products()
	 {
		 mywait.waitForElementToBeClickable(driver, products_button);
		 products_button.click();

	 }
	 
	 public String scroll_down() throws InterruptedException
	 {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].scrollIntoView();", page_down_element);
	     Thread.sleep(3000);
	     System.out.println(page_down_element.getText());
		 return page_down_element.getText();
		 
	 }
	 
	 public String scroll_up() throws InterruptedException
	 {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].scrollIntoView();", page_up_element);
	     Thread.sleep(3000);
	     System.out.println(page_up_element.getText());
		 return page_up_element.getText();
		 
	 }
	 
	 
}
