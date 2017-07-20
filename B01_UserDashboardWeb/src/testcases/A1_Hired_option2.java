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


public class A1_Hired_option2 extends LCFposting {
	
	@Test(retryAnalyzer=Retry.class)
	public void hired2() throws Exception
	{
		test = extent.startTest(this.getClass().getSimpleName(),"Hired option 2 ");
		
		test.log(LogStatus.INFO, "Hired option 2 functionality testing started");
		

		
		
		LCFsubmit();
		
		//Hired find after the matched expert
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait waits = new WebDriverWait(driver, 20);
		
		//Hired find after the matched expert
		
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		driver.findElement(By.xpath("//a[text()='Matched Experts']/following::button[1]")).click();
		
		//Hired option 2
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[@for='hired2']")).click();	
		
		//Option date
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("input[id='datepicker2']")).click();	
		
		//Next button
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//input[@id='datepicker2']/following::th[4]")).click();
		
		//Next month first date
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//td[@class='day' and text()='1']")).click();
		
		//Appointment time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.cssSelector("a[id='hrddropdown1']")).click();	
		
		//Appointment time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
						
		driver.findElement(By.xpath("//a[@id='hrddropdown1']/following::a[1]")).click();	
		
		//price
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtcprice1")).sendKeys("2000");
			
		
		//Submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@ng-click='w_hiredBtn_click()']")).click();	
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(60, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				   
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
			   
			   System.out.println("Hired Option 2 Job done function is working fine : "+element.isDisplayed());
			   Reporter.log("Hired Option 2 Job done function is working fine");
			   test.log(LogStatus.PASS, "Hired Option 2 Job done function is working fine");
			  
		
		
	}

}
