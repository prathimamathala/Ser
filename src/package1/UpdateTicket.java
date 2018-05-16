/**
 * 
 */
package package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Akhil.t
 *
 */
public class UpdateTicket {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		 System.setProperty("webdriver.chrome.driver", "E:\\ankalrao\\selenium 64bit kit\\chromedriver.exe");
	     
		    WebDriver driver = new ChromeDriver();
	 
	       //Login into the application //
	       
	        LoginPage login=new LoginPage(driver);
	        
	        login.validatingLogin("admin@seismic360.com", "123456");
	       
	       
	     
	       //select view tab from menu list//
	       
	          login.menuList(1);
	      
	      //select incidents from sublist//
	      
	         driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/ul/li[2]/ul/li[2]")).click();
	      
	      
	      // Select All incidents Tab//
	       driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/ul/li[2]/ul/li[2]/ul/li[1]")).click();
	      
	       
	       Thread.sleep(500);
	       
	      // WebElement New= driver.findElement(By.xpath("//*[@id=\"employee-grid_filter\"]/label/input"));
	     //  New.click();
	       
	     //  New.sendKeys("new");
	       
	       //Select status new//
	       
	       driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div/form/div[1]/div[4]/div/div/div/div[1]/div")).click();
	       
	       WebElement New=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div/form/div[1]/div[4]/div/div/div/div[2]/div[2]/div[1]/span"));
	       
	       New.click();
	 
	       //Select any one incident from list//
	       
	      Thread.sleep(1000);
	     
	       WebElement Incidents= driver.findElement(By.xpath("//*[@id=\"employee-grid\"]/tbody"));
	      
	      List<WebElement>AllIncidents=Incidents.findElements(By.tagName("tr"));
	      
	      List<WebElement>IncidentColumns=AllIncidents.get(0).findElements(By.tagName("td"));
	       
	      IncidentColumns.get(0).click();
	      
		 
	      // Change Status by using status field//
		
	        WebElement status= driver.findElement(By.id("status_code"));
	     
	        status.click();
	     
	        Select select = new Select(status);
		     
		    List<WebElement>Allstatus = select.getOptions();
		   
		  
		  // Navigate to second window(user window) //
		    
		    String parentHandle = driver.getWindowHandle(); // get the current window handle
		    
		    Allstatus.get(1).click(); //// select Status Assigned from drop down from drop down //
		    
		   // Allstatus.get(0).click();
		   
		   
		    for (String winHandle : driver.getWindowHandles()) {
		       
		    	driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    	
		    	Thread.sleep(500);
		    	 
		    	try {
					WebElement users=driver.findElement(By.xpath("/html/body/div/div/table/tbody"));
					 
					  List<WebElement>list=users.findElements(By.tagName("tr"));
					  List<WebElement>rows=list.get(0).findElements(By.tagName("td"));
					  rows.get(0).findElement(By.xpath("//*[@id=\"ddlNames\"]")).click();
					  Thread.sleep(500);
					  driver.switchTo().window(parentHandle);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }  
		    
		    Thread.sleep(500);
		    
		    // click on Update button //
		    
		    WebElement update= driver.findElement(By.id("update"));
		    
		    update.click();
		    
		    String msg=driver.findElement(By.xpath("/html/body/div[8]/p")).getText();
		   
		    System.out.println(msg);
		   
		    WebElement OK= driver.findElement(By.xpath("/html/body/div[8]/div[7]/div/button")); 
		   
		    OK.click();
		    
		
		    Thread.sleep(1000);
		   
		    driver.navigate().refresh();
		    
		   WebElement status1=driver.findElement(By.xpath("//*[@id=\"status_code\"]"));
		   
		     status1.click();
		     
	        Select select1 = new Select(status1);
		     
		    List<WebElement>Allstatus1 = select1.getOptions();
		    
		    Allstatus1.get(1).click();
		    
		    driver.findElement(By.xpath("//*[@id=\"update\"]")).click();
		    
		   driver.findElement(By.xpath("/html/body/div[8]/div[7]/div/button")).click();
		    // Add activity tab // // outbound activity //	
		    
		    Thread.sleep(1000);
		    
		    login.Addactivity(1);
		   
		    
		 // Select start date from date picker//
		      
	        login.StartDate(2, 2);
	   
	        driver.findElement(By.name("start_time")).click();
	      
	       // Select End date from date picker//
	      
	        login.EndDate(2, 3);;
	  
	      
	       //Activity Types//
		  
		   login.ActivityType(2); //// select ActivityTypes from drop down //
	
		 
		   //Comments field//
		   
		   login.Comments("This is first log");
		   
		   //Add Attachments//
		   
		   login.attachment();
		   
		   
		   // Notes//
		   
		   login.Notes("This is first note");
           
           //Save Button//
           
           login.Save();
     
           //Thread.sleep(2000);
           
       //  Allstatus.get(0).click(); //// select Status from drop down //
           
       //  update.click();
         // 
       //  OK.click();
         
       // Trouble Shoot activity//
           Thread.sleep(1000);
		   try {
			   login.Addactivity(1); // Add activity tab //
			
			   
			   login.StartDate(2, 2);  // Select start date from date picker//
			   driver.findElement(By.name("start_time")).click();
			   login.EndDate(2, 3);  // Select End date from date picker//
			   login.ActivityType(23); //// select ActivityTypes from drop down //
			   login.Comments("This is second log");
			   login.attachment();
			   login.Notes("This is second note");
			   login.Save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
		   // Restore to services activity//
           Thread.sleep(1000);
		   try {
			   login.Addactivity(1); // Add activity tab //
			
			   
			   login.StartDate(2, 2);  // Select start date from date picker//
			   driver.findElement(By.name("start_time")).click();
			   login.EndDate(2, 3);  // Select End date from date picker//
			   login.ActivityType(19); //// select ActivityTypes from drop down //
			   login.Comments("This is Third log");
			   login.attachment();
			   login.Notes("This is Third note");
			   login.Save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   Thread.sleep(1000);
		   
		   //Status Resolved //
		  
		   WebElement status2=driver.findElement(By.xpath("//*[@id=\"status_code\"]"));
		   
		     status2.click();
		     
	        Select select2 = new Select(status2);
		     
		    List<WebElement>Allstatus2 = select2.getOptions();
		    
		    Allstatus2.get(5).click();
		    
		    driver.findElement(By.xpath("//*[@id=\"update\"]")).click();
		    
		   driver.findElement(By.xpath("/html/body/div[8]/div[7]/div/button")).click();
		   
		 
		   //Status Closed //
			  
		      driver.navigate().refresh();
		   
		   try {
			WebElement status3=driver.findElement(By.xpath("//*[@id=\"status_code\"]"));
			   
			     status3.click();
			     
			    Select select3 = new Select(status3);
			     
			    List<WebElement>Allstatus3 = select3.getOptions();
			    
			    Allstatus3.get(2).click();
			    
			    driver.findElement(By.xpath("//*[@id=\"update\"]")).click();
			    
			   driver.findElement(By.xpath("/html/body/div[8]/div[7]/div/button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		      
		  
	}

}
