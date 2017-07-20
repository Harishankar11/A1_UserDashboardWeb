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



public class A3_UpdateStatus_option6thn7th extends LCFposting {
	
	@Test(retryAnalyzer=Retry.class)
	public void Update7n6() throws Exception
	{
		
		test = extent.startTest(this.getClass().getSimpleName(),"UpdateStatus option 6 n 7");
		
		test.log(LogStatus.INFO, "UpdateStatus option 7 functionality testing started");
		
	
		LCFsubmit();
		
		//Updated status
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait waits = new WebDriverWait(driver, 25);
		
		Thread.sleep(500);
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		
		driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']")).click();
		
		//Update option 7
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='update6']")));
		
		driver.findElement(By.xpath("//label[@for='update6']")).click();	
		
		//Other
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtOquotes")).sendKeys("I dont want this need");	
		
		
		//Submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@ng-click='updatestatus_submit()']")).click();	
		
		Thread.sleep(4000);
		System.out.println("Update status Option 7 Other function is working fine");
		Reporter.log("Update status Option 7 Other function is working fine");
		test.log(LogStatus.PASS, "Update status Option 7 Other function is working fine");
		
		//------------ 6
		
		Thread.sleep(4000);
		
		//Updated status
		Thread.sleep(5000);
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
				
		driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']")).click();
		
		test.log(LogStatus.INFO, "UpdateStatus option 6 functionality testing started");
				
		//Update option 6
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='updatest7']")));
				
		driver.findElement(By.xpath("//label[@for='updatest7']")).click();	
		
		//submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@ng-click='updatestatus_submit()']")).click();	
		
		
		//Popup close
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sdialog']/following::a")));
		
		driver.findElement(By.xpath("//div[@class='sdialog']/following::a")).click();
		
		Thread.sleep(5000);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(60, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				   
			     @Override
				public WebElement apply(WebDriver driver) {
			    	
			    	 WebElement ele = driver.findElement(By.xpath("//span[@class='label cancelled ng-binding ng-scope']"));
			    	 
			    	 String sr = ele.getAttribute("innerHTML");
			    	 
			    	 if(sr.equalsIgnoreCase("Cancelled - by user"))
			    	 {
			    		 return ele;
			    		 
			    	 } else{
			    		 return null;
			    	 }
			       
			     }
			   });
			   
			   System.out.println("Update status Option 6 User cancel  need function is working fine : "+element.isDisplayed());
			   Reporter.log("Update status Option 6 User cancel need function is working fine");
		
			   test.log(LogStatus.PASS, "Update status Option 6 User cancel need function is working fine");
		
		
	}

}
