package lcfs;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import excelReader.Dynamicexcelread;
import library.Utility;

public class LCFpostingold extends Utility{
		
	
	public void LCFsubmit() throws Exception
	{
		Dynamicexcelread obj1 = new Dynamicexcelread();
		
		Browser("Chrome");
		
		driver.get("http://www.sulekha.com/siddha-doctors/ypcity");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//driver.findElement(By.className(obj1.LCFsubmit("Mobile_number"))).clear();
		driver.findElement(By.className(obj1.LCFsubmit("Mobile_number"))).sendKeys("9380835000");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//driver.findElement(By.className(obj1.LCFsubmit("User_name"))).clear();
		driver.findElement(By.className(obj1.LCFsubmit("User_name"))).sendKeys("Shan");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.className(obj1.LCFsubmit("Email"))).clear();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.className(obj1.LCFsubmit("password"))).sendKeys("999999");
		
		//verify the update status
		
				Thread.sleep(2000);
						
				try{
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//div[@class='push-popup-cnt']/following::a[1]")).click();
				
				}catch(Exception re){}
				try{
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//a[contains(text(), 'Thanks')]")).click();
					
				}catch(Exception re1){}
				
				
				WebDriverWait waits = new WebDriverWait(driver, 20);
				waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-p small ng-scope']")));
				
				WebElement ele1 = driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']"));
				System.out.println("Update status button is display : "+ele1.isDisplayed());
				
				
				
			
	}
	

}
