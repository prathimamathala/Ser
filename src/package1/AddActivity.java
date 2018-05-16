package package1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WebDriver driver;
		
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
	      
	      
	      //Select any one incident from list//
	      
	      WebElement Incidents= driver.findElement(By.xpath("//*[@id=\"employee-grid\"]/tbody"));
	      
	      List<WebElement>AllIncidents=Incidents.findElements(By.tagName("tr"));
	      
	      List<WebElement>IncidentColumns=AllIncidents.get(0).findElements(By.tagName("td"));
	       
	      IncidentColumns.get(0).click();
	      
	      
	      //Verify the incident id ,is the right incident selected or not//
	      
	      String IncidentId= driver.findElement(By.id("incident_id")).getAttribute("value");
	      
	      System.out.println("Incident Id is ="+ IncidentId);
	      
	      
	      //Select Add Activity Tab from list//
	      
	       login.Addactivity(1);
	      
		
	      // Select start date from date picker//
	      
	        login.StartDate(2, 1);
	   
	       driver.findElement(By.name("start_time")).click();
	      
	       // Select End date from date picker//
	      
	       login.EndDate(2, 2);;
	  
	      
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
           
           
           
	       
	    
		   
	}
	

}
