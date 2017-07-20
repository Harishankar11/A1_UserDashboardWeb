package lcfs;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.support.ui.WebDriverWait;


import library.Utility;




public class LCFposting extends Utility{
		

	public void LCFsubmit() throws Exception
	{
		
		
		Browser("Chrome");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://www.sulekha.com/siddha-doctors/ypcity");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-p.btn-next.btnmdld")));
		
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		
		Thread.sleep(500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("txtlcfmob")));
		
		
		//driver.findElement(By.className("txtlcfmob")).clear();
		driver.findElement(By.className("txtlcfmob")).sendKeys("9380835000");
		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//driver.findElement(By.className("txlcftname")).clear();
		driver.findElement(By.className("txlcftname")).sendKeys("Shan");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.className("txtlcfmail")).clear();
		
		Thread.sleep(1000);
		
		
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		
	
		OTP();
		ThankorDash();
		leadmatch();
		
		
		
		
		
		
				
		/*try{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='push-popup-cnt']/following::a[1]")).click();
		Thread.sleep(2000);
		
		}catch(Exception re){}
		try{
			Thread.sleep(1000);
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(), 'Thanks')]")).click();
			
		}catch(Exception re1){}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-p small ng-scope']")));
		
		WebElement ele1 = driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']"));
		System.out.println("Update status button is display : "+ele1.isDisplayed());
		
		*/

		
		
		
			
	}

}
