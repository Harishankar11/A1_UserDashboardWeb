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


public class A3_UpdateStatus_option1 extends LCFposting {
	
	@Test(retryAnalyzer=Retry.class)
	public void Update1() throws Exception
	{
		
		test = extent.startTest(this.getClass().getSimpleName(),"UpdateStatus option 1 ");
		
		test.log(LogStatus.INFO, "UpdateStatus option 1 functionality testing started");
		
	
		
		LCFsubmit();
		
		//Hired find after the matched expert
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait waits = new WebDriverWait(driver, 25);
		
		Thread.sleep(500);
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		
		driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']")).click();
		
		//Hired option 1
		
		
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='updatest1']")));
		
		driver.findElement(By.xpath("//label[@for='updatest1']")).click();	
		
		//Option date
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("input[id='updtstatusdatepicker']")).click();	
		
		//Next button
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//input[@id='updtstatusdatepicker']/following::th[4]")).click();
		
		//Next month first date
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//td[@class='day' and text()='1']")).click();
		
		//Appointment time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//div[@id='up_hiredslot_dt']/a")).click();	
		
		//Appointment time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
						
		driver.findElement(By.xpath("//div[@id='up_hiredslot_dt']/a/following::li[1]")).click();
		
		//------------------------------
		
		//Business
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='up_hiredslot_dt']/following::a[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='up_hiredslot_dt']/following::a[1]/following::a[1]")).click();
		
		Thread.sleep(2000);
		//Share address uncheck
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("label[for='share-address']")).click();	
		Thread.sleep(1000);
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
			    	
			    	 WebElement ele = driver.findElement(By.xpath("//span[@class='label inprogress ng-binding ng-scope']"));
			    	 
			    	 String sr = ele.getAttribute("innerHTML");
			    	 
			    	 if(sr.equalsIgnoreCase("Hired"))
			    	 {
			    		 return ele;
			    		 
			    	 } else{
			    		 return null;
			    	 }
			       
			     }
			   });
			   
			   System.out.println("Update status Option 1 Appointment fixed function is working fine : "+element.isDisplayed());
			   Reporter.log("Update status Option 1 Appointment fixed function is working fine");
			   test.log(LogStatus.PASS, "Update status Option 1 Appointment fixed function is working fine");

		
		
	}

}
