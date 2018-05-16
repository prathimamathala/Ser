package package1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManualTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "E:\\ankalrao\\selenium 64bit kit\\chromedriver.exe");
	     
		  WebDriver driver = new ChromeDriver();
	 
	       //Login into the application //
	       
	       LoginPage login=new LoginPage(driver);
	        
	       login.validatingLogin("admin@seismic360.com", "123456");
	       
	     
	       //select view tab from menu list//
	       
	       login.menuList(1);
	       
	       //Select incidents tab from list //
	          
	      driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/ul/li[2]/ul/li[2]")).click();
	      
	      //click on create new incident tab//
	      
	      driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/ul/li[2]/ul/li[2]/ul/li[3]")).click();
	      
	      
	      //Manual ticket creation //
	      
	      driver.findElement(By.className("col-md-7")).click(); //parent field click event
	      
	      WebElement options= driver.findElement(By.id("Patner"));
	      
	      Select select = new Select(options);
	     
	      List<WebElement> allOptions = select.getOptions();
	      
	      allOptions.get(22).click();  //// select parent from drop down //
	      
	      
	      //client field click event //
	      
	      driver.findElement(By.className("input-group")).click();
	      
          WebElement options1= driver.findElement(By.id("Client"));
	      
	      Select select1 = new Select(options1);
	     
	      List<WebElement> allclients = select1.getOptions();
	      
	      allclients.get(1).click(); //// select client from drop down //
	      
	     
	      // click on location field and select location//
	      
	      WebElement Locations=driver.findElement(By.id("ClientLocation"));
	      
	      Select select2 = new Select(Locations);
		     
	      List<WebElement> allLocations = select2.getOptions();
	      
	      allLocations.get(1).click(); //// select Locations from drop down //
	      
	      // click on device field and select device //
	      
	     WebElement device= driver.findElement(By.id("Devices"));
	     
	     Select select3 = new Select(device);
	     
	      List<WebElement> alldevices = select3.getOptions();
	      
	      alldevices.get(2).click(); //// select devices from drop down //
	      
	      //Services field value verification //
	      
	    // String Text=  driver.findElement(By.id("serivces")).getText();
	     
	    // String Expected= "Interface utiilization-Vlan700";
	      
	   // Categories field value selection//
	      
	      WebElement Categories=driver.findElement(By.id("Categories"));
	      
	      Select select4 = new Select(Categories);
		     
	      List<WebElement> allcategories = select4.getOptions();
	      
	      allcategories.get(1).click(); //// select category from drop down //
	      
	      // Sub Categories field value selection//
	      
	      WebElement SubCategories=driver.findElement(By.id("SubCategories"));
	      
	      Select select5 = new Select(SubCategories);
		     
	      List<WebElement> allSubCategories = select5.getOptions();
	      
	      allSubCategories.get(1).click(); //// select urgency from drop down //
	      
          // Sub ContractType field value selection//
	      
	    //  WebElement ContractType =driver.findElement(By.id("contract"));
	      
	     // ContractType.click();
	      
	      
           // Sub urgency field value selection//
	      
	      WebElement urgency =driver.findElement(By.id("urgency"));
	      
	      Select select6 = new Select(urgency);
		     
	      List<WebElement>allurgency = select6.getOptions();
	      
	       allurgency.get(1).click(); //// select urgency from drop down //
	      
	      
	       //Requester field value selection//
	       
	       WebElement requester= driver.findElement(By.id("requester"));
	       
	       Select select7 = new Select(requester);
		     
		   List<WebElement>allrequeste = select7.getOptions();
		      
		   allrequeste.get(2).click(); //// select requester from drop down //
		   
		   
		   //EventCritical field value selection//
	      
            WebElement EventCritical= driver.findElement(By.id("severity"));
	       
	       Select select8 = new Select(EventCritical);
		     
		   List<WebElement>allEventCritical = select8.getOptions();
		      
		   allEventCritical.get(2).click(); //// select EventCritical from drop down //
		   
		   //severity field value selection//
		      
           WebElement severity= driver.findElement(By.id("skill_id"));
	       
	       Select select9 = new Select(severity);
		     
		   List<WebElement>allseverity = select9.getOptions();
		      
		   allseverity.get(2).click(); //// select severity from drop down //
		   
		 
		   //AssignedTo field value selection//
		      
           WebElement AssignedTo= driver.findElement(By.id("Users"));
	       
	       Select select10 = new Select(AssignedTo);
		     
		   List<WebElement>allAssignedTo = select10.getOptions();
		      
		   allAssignedTo.get(2).click(); //// select AssignedTo from drop down //
		   
		   
		   //External Reference field enter some text into field//
		      
            WebElement ExternalReference= driver.findElement(By.id("external_ref"));
	       
            ExternalReference.sendKeys("Akhil");
            
		  
            // Vendor Reference field enter some text into field//
            
            WebElement VendorReference= driver.findElement(By.id("vendor_ref"));
 	       
            VendorReference.sendKeys("Akhil Torlapati");
            
		   
             // Subject field enter some text into field//
            
            WebElement Subject= driver.findElement(By.id("subject"));
 	       
            Subject.sendKeys("RNSOC011 - A Low severity alert has generated for malware proxy traffic from at 2018-03-28T20:39:16Z.");
            
            
            //Description field send data into it //
            
          //  WebElement Description= driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe"));
  	       
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe")));
            actions.click();
            actions.sendKeys("SOME DATA");
            actions.build().perform();
           // Description.sendKeys("RNSOC011 - A Low severity alert has generated for malware proxy traffic from at 2018-03-28T20:39:16Z.");
            
            //click on submit button//
            
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/form/div[19]/button")).click();
            
            
            // Ticket created sucessfully message//
            
            String Value= driver.findElement(By.xpath("/html/body/div[6]/p")).getText();
            
            System.out.println(Value);
            
            // Click on "OK" Button //
            
            driver.findElement(By.xpath("/html/body/div[6]/div[7]/div/button")).click();
            
		   //driver.quit();
		   
		
	}

}
