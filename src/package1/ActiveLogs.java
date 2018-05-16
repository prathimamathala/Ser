package package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveLogs {

	public static void main(String[] args) {
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
	      
	      
	      //Select any one incident from list//
	      
	      WebElement Incidents= driver.findElement(By.xpath("//*[@id=\"employee-grid\"]/tbody"));
	      
	      List<WebElement>AllIncidents=Incidents.findElements(By.tagName("tr"));
	      
	      List<WebElement>IncidentColumns=AllIncidents.get(1).findElements(By.tagName("td"));
	       
	      IncidentColumns.get(0).click();
	      
	      
	      //Select active log tab //
	      
	      login.Addactivity(2);
		
	      
	      //Select edit icon of saved Log details//
	      
	      WebElement Logs= driver.findElement(By.cssSelector("#tblGrid_activity_log > tbody"));
	      
          List<WebElement>AllLogs=Logs.findElements(By.tagName("tr"));
	      
	      List<WebElement>LogColumns=AllLogs.get(0).findElements(By.tagName("td"));
	       
	      LogColumns.get(8).findElement(By.tagName("i")).click();
	      
	      
	      //click on update button //
	    
		 driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/form/div/div/a/i")).click();
		
		 driver.findElement(By.cssSelector("#save_activity")).click();
		 
		 //Capture the message of updated log//
		 
		// String Log=driver.findElement(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > p")).getText();
		 
		// System.out.println(Log);
	}

}
