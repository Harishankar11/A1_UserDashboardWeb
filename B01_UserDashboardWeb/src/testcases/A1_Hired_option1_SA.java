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


public class A1_Hired_option1_SA extends LCFposting {
	
	@Test(retryAnalyzer=Retry.class)
	public void hired1() throws Exception
	{
		
		test = extent.startTest(this.getClass().getSimpleName(),"Hired option 1 ");
		
		test.log(LogStatus.INFO, "Hired option 1 functionality testing started");
		
		
		LCFsubmit();
		
		//Hired find after the matched expert
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait waits = new WebDriverWait(driver, 30);
		
		//Hired find after the matched expert
		
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Matched Experts']/following::button[1]")));
		
		
		driver.findElement(By.xpath("//a[text()='Matched Experts']/following::button[1]")).click();
		
		//Hired option 1
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
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
		
		driver.findElement(By.id("txthrdcprice")).sendKeys("2000");
		
		//Share address uncheck
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("label[for='share-add']")).click();*/	
		
		//Submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@ng-click='w_hiredBtn_click()']")).click();	
		
	
		
		Thread.sleep(4000);
		//Share Address
		try{
		Thread.sleep(3000);
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='edit']")));
		
		
		driver.findElement(By.xpath("//a[@class='edit']")).click();	
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtname")).clear();Thread.sleep(2000);
		driver.findElement(By.id("txtname")).sendKeys("Shans");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtaddress1")).clear();Thread.sleep(2000);
		driver.findElement(By.id("txtaddress1")).sendKeys("Kurungulam East Street");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtcityname")).clear();Thread.sleep(2000);
		driver.findElement(By.id("txtcityname")).sendKeys("chennai");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtpincode")).clear();Thread.sleep(2000);
		driver.findElement(By.id("txtpincode")).sendKeys("601454");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@ng-click='shareaddressfunc()']")).click();
		 test.log(LogStatus.PASS, "Share address function is working fine");
		}catch(Exception ie)
		
		{
			System.out.println("issue in share address");
		}
		
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
			  
			   
			   System.out.println("Hired Option 1 Appointment fixed with share address function is working fine : "+element.isDisplayed());
			   Reporter.log("Hired Option 1 Appointment fixed with share address function is working fine");
			  test.log(LogStatus.PASS, "Hired Option 1 Appointment fixed with share address function is working fine");
		
		
	}

}
