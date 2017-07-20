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

import library.Retry;

public class A2_Jobdone_option1 extends A0_Hired_common {
	
	@Test(retryAnalyzer=Retry.class)
	public void JobDone1() throws Exception
	{
		test = extent.startTest(this.getClass().getSimpleName(),"Jobdone option 1 ");
		
		test.log(LogStatus.INFO, "Jobdone option 1 functionality testing started");
		
		
		
		hiredcommon();
		
		 //click on job Done button  ---------------------
		 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait waits = new WebDriverWait(driver, 25);
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		 
		driver.findElement(By.xpath("//a[text()='Matched Experts']/following::button[1]")).click();
		
		//Hired option 2
		
		
		//Hired option 1
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='job-done1']")));
			
		driver.findElement(By.xpath("//label[@for='job-done1']")).click();	
					
				
		//price
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.id("txtcprice")).sendKeys("2000");
					
				
		//Submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//button[@ng-click='w_jobdoneBtn_click()']")).click();	
		
		Thread.sleep(5000);
				
				Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
					       .withTimeout(120, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);

					   WebElement element1 = wait1.until(new Function<WebDriver, WebElement>() {
						   
					     @Override
						public WebElement apply(WebDriver driver) {
					    	
					    	 WebElement ele = driver.findElement(By.xpath("//span[@class='label completed ng-binding ng-scope']"));
					    	 
					    	 String sr = ele.getAttribute("innerHTML");
					    	 
					    	 if(sr.equalsIgnoreCase("Job Done"))
					    	 {
					    		 return ele;
					    		 
					    	 } else{
					    		 return null;
					    	 }
					       
					     }
					   });
					   
					   System.out.println("Job Done Option 1 Job done function is working fine : "+element1.isDisplayed());
					   Reporter.log("Job Done Option 1 Job done function is working fine");
					   test.log(LogStatus.PASS, "Job Done Option 1 Job done function is working fine");
		
		
	}

}
