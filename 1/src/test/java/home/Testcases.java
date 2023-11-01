package home;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Testcases {
WebDriver driver;
Homepage homepage;
Products products;
Cart cart;

  @BeforeTest
  public void beforeTest() {
	  ChromeOptions opt = new ChromeOptions();
	  opt.addExtensions(new File("Extensions/adsblock.crx"));
	  WebDriverManager.chromedriver().setup();
      driver   = new ChromeDriver(opt);
      homepage = new Homepage(driver);
      products = new Products(driver);
      cart     = new Cart(driver);
      
  }

 
  public void Verify_Homepage() throws InterruptedException 
  {
	  driver.navigate().to("https://automationexercise.com/");
      driver.manage().window().maximize();
      Assert.assertTrue(homepage.homepage_is_visible());
	  System.out.println("Home Page is verify: " + homepage.homepage_is_visible());
  }
  
  @Test(priority = 1)
  public void Verify_Landing_Products_page() throws InterruptedException
  {
	  //Testcase 1
	  Verify_Homepage();
	  homepage.Click_Products();
	  products.click_first_product();
	  Boolean p_name= products.Get_Product_name();
	  Boolean p_catg= products.Get_Product_category();
	  Boolean p_price= products.Get_Product_price();
	  Boolean p_avail= products.Get_Product_avail();
	  Boolean p_cond= products.Get_Product_condition();
	  Boolean p_brand= products.Get_Product_brand();		
	  
	  System.out.println("Name is displayed :" + p_name + p_catg + p_price + p_avail + p_cond + p_brand);
	  Assert.assertTrue(p_name);
	  Assert.assertTrue(p_catg);
	  Assert.assertTrue(p_price);
	  Assert.assertTrue(p_avail);
	  Assert.assertTrue(p_cond);
	  Assert.assertTrue(p_brand);
  }
  
  @Test(priority = 2)
  public void Search_product() throws InterruptedException
  {
	  //Test case 2
	  Verify_Homepage();
	  homepage.Click_Products();
	  String Title = products.search_product();
	  Assert.assertEquals(Title, "SEARCHED PRODUCTS");
  }
  
  @Test(priority = 3)
  public void add_product_cart() throws InterruptedException
  {
	  //Testcase 3
	  Verify_Homepage();
	  homepage.Click_Products();
	  cart.add_product();
	  String added_text = cart.prod_added();
	  Assert.assertEquals(added_text, "Your product has been added to cart.");
  }
  
  @Test(priority = 4 , dependsOnMethods = "add_product_cart")
  public void check_cart() throws InterruptedException
  {
	  //Testcase 4
	  cart.view_cart();
	  System.out.println("click on the view cart and on cart page");
	  String Quantity = cart.check_product_quantity();
	  System.out.println("Quantity =" + Quantity);
	  Assert.assertEquals(Quantity, "1");
  }
  
  @Test(priority = 5)
  public void Scrolling() throws InterruptedException
  {
	  //Testcase 5
	  Verify_Homepage();
	  String footer_text = homepage.scroll_down();
	  Assert.assertEquals(footer_text, "Copyright © 2021 All rights reserved");
	  String header_text = homepage.scroll_up();
	  Assert.assertEquals(header_text, " Products");
  }
  
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
	  driver.quit();
  }
  

}
