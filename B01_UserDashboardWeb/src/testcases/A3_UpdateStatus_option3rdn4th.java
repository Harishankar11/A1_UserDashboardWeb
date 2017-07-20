package testcases;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import lcfs.LCFposting;
import library.Retry;


public class A3_UpdateStatus_option3rdn4th extends LCFposting {
	
	@Test(retryAnalyzer=Retry.class)
	public void Update3n4() throws Exception
	{
		test = extent.startTest(this.getClass().getSimpleName(),"UpdateStatus option 3 n 4 ");
		
		test.log(LogStatus.INFO, "UpdateStatus option 3 functionality testing started");
		
	
		LCFsubmit();
		
		//Updated status
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait waits = new WebDriverWait(driver, 25);
		
		Thread.sleep(500);
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		
		driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']")).click();
		
		//Update option 3
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[@for='updatest3']")).click();	
		
		
		//Submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@ng-click='updatestatus_submit()']")).click();	
		
		//Close popup
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement ele4 = driver.findElement(By.xpath("//div[@class='sdialog']/following::a"));
		System.out.println("Update status Option 3 Not received calls function is working fine : " +ele4.isDisplayed());
		Reporter.log("Update status Option 3 Not received calls function is working fine : " +ele4.isDisplayed());
		
		ele4.click();
		
		test.log(LogStatus.PASS, "Update status Option 3 Not received calls function is working fine");
		
		
		//Update status 4th option    ---------------------
		
		test.log(LogStatus.INFO, "UpdateStatus option 4 functionality testing started");
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Thread.sleep(500);
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		
		driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']")).click();
		
		//Update option 3
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[@for='updatest4']")).click();	
		
		//Text box
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtmorequotes")).sendKeys("Need more quote from this need");	
		
		
		//Submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@ng-click='updatestatus_submit()']")).click();
		
		Thread.sleep(5000);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(60, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				   
			     @Override
				public WebElement apply(WebDriver driver) {
			    	
			    	 WebElement ele = driver.findElement(By.xpath("//a[@class='divdbnotify']"));
			    	 
			    	 String sr = ele.getAttribute("innerHTML");
			    	
			    	 if(sr.contains("more service experts"))
			    	 {
			    		 return ele;
			    		 
			    	 } else{
			    		 return null;
			    	 }
			       
			     }
			   });
			   
			   System.out.println("Update status Option 4 More quote function is working fine : "+element.isDisplayed());
			   Reporter.log("Update status Option 4 More quote function is working fine");
			   test.log(LogStatus.PASS, "Update status Option 4 More quote function is working fine");
		
		
		
	}

}
