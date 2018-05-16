/**
 * 
 */
package package1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Akhil.t
 *
 */
public class LoginPage {
	
	
  WebDriver driver;
	
   
    By usernme= By.id("username");
    By password = By.id("password");
    By signIn= By.xpath("//*[@id=\"login-form\"]/div[4]/button");
	
    
    public LoginPage(WebDriver driver) {

        this.driver=driver;
    }
    
    public void validatingLogin(String uid, String pwd) {
    	
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
 	    
	      //Launch the Online Store Website
	 
	       driver.get("http://10.10.32.52/qa/s360/v28/login");
	       
	       driver.manage().window().maximize();
	       
	       System.out.println(" Login Successfully, welcome to event edge.");
	       
    	    driver.findElement(usernme).sendKeys(uid);
    	    driver.findElement(password).sendKeys(pwd);
    	    driver.findElement(signIn).click();
      }
    
    // Menu list code//
       public void menuList(int id) {
    	
    	 WebElement parent= driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div"));
	      
	      List<WebElement>child=parent.findElements(By.tagName("li"));
	      
	      child.get(id).click();
     }
       
       
     //Select Add Activity Tab from list//
       public void Addactivity(int id) {
    	   
 	      WebElement AllTabs=driver.findElement(By.cssSelector("body > div.page-container > div.page-content-wrapper > div.page-content > div.full-height-content-body > div > div.col-md-12.parent > div > div.portlet-body.ticket_form_data.remove_pad > div > div > div.tabbable-custom.hover-up > ul"));
 	      
 	      List<WebElement>Tabs=AllTabs.findElements(By.tagName("li"));
 	      
 	      Tabs.get(id).click();   	   
       }
       
       
       //select start date from date picker for add activity//
       
       public void StartDate(int id,int id1) {
    	   
           driver.findElement(By.name("start_time")).click();
	       
	       WebElement datepicker=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/table/tbody"));
	      
	       List<WebElement>rows=datepicker.findElements(By.tagName("tr"));
	       
	       List<WebElement>columns=rows.get(id).findElements(By.tagName("td"));
	       
	       columns.get(id1).click();
    	   
       }
       
     //select End date from date picker for add activity//
       
       public void EndDate(int id2,int id3) {
    	   
           driver.findElement(By.name("end_time")).click();
	       
	       WebElement Enddatepicker=driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/table/tbody"));
	      
	       List<WebElement>rows1=Enddatepicker.findElements(By.tagName("tr"));
	       
	       List<WebElement>columns1=rows1.get(id2).findElements(By.tagName("td"));
	       
	       columns1.get(id3).click();
       } 
       
       	//Activity Types//
       
	       public void ActivityType(int id) {  
		  
			  WebElement ActivityType= driver.findElement(By.id("activity_type"));
			  
			  Select select = new Select(ActivityType);
			     
			   List<WebElement>AllActivityType = select.getOptions();
			      
			   AllActivityType.get(id).click(); //// select ActivityTypes from drop down //
    	   
       }
	       
	       //Comments Fields//
	       
	       public void Comments(String message) {
	    	   
	    	   driver.findElement(By.tagName("textarea")).sendKeys(message);
	       }
	       
	       
	       //Add attachment //
	       
	       public void attachment() {
	    	   
	    	   driver.findElement(By.id("attachment")).sendKeys("C:\\Users\\ankalarao.t\\Desktop\\screen shots\\Abid Ali.png");
	       }
	       
	       //Notes//
	       
	       public void Notes(String Note) {
	    	   
	    	   Actions actions = new Actions(driver);
	           actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe")));
	           actions.click();
	           actions.sendKeys(Note);
	           actions.build().perform();
	            
	       }
	       
	     // Save and Ok button with message//
	       
	       public void Save() {
	    	   
	    	   driver.findElement(By.id("save_activity")).click();//save button //
	    	   
	    	// Capture the added successfully message //
		       
		       //String Value1= driver.findElement(By.xpath("/html/body/div[8]/p")).getText();
		       
		      // System.out.println(Value1);
		       
		       
		       //"ok" button of Active logs//
		       
		       driver.findElement(By.xpath("/html/body/div[8]/div[7]/div/button")).click();
	       }
  }



