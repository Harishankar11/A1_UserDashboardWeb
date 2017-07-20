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

import com.google.common.base.Function;

import lcfs.LCFposting;


public class A0_Hired_common extends LCFposting {
	
	
	public void hiredcommon() throws Exception
	{
		
		LCFsubmit();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait waits = new WebDriverWait(driver, 20);
		
		//Hired find after the matched expert
		
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		driver.findElement(By.xpath("//a[text()='Matched Experts']/following::button[1]")).click();
		
		
		
		//Hired option 1
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='hired1']")));
		
		driver.findElement(By.xpath("//label[@for='hired1']")).click();	
		
		//Option date
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("input[id='datepicker1']")).click();	
		
		//Next button
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//input[@id='datepicker1']/following::th[4]")).click();
		
		//Next month first date
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//td[@class='day' and text()='1']")).click();
		
		//Appointment time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.cssSelector("a[id='hrddropdown']")).click();	
		
		//Appointment time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
						
		driver.findElement(By.xpath("//a[@id='hrddropdown']/following::a[1]")).click();	
		
		/*//price
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txthrdcprice")).sendKeys("2000");*/
		
		//Share address uncheck
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("label[for='share-add']")).click();	
		
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
			
			   Thread.sleep(4000);
			   System.out.println("Hired Option 1 Appointment fixed function is working fine : "+element.isDisplayed());
			   Thread.sleep(5000);
			   Reporter.log("Hired Option 1 Appointment fixed function is working fine");
			   
		
		
		
	}

}
