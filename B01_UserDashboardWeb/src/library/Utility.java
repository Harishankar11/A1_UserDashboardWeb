package library;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Utility {
	
	public WebDriver driver;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void beforesuite()
	{
		//extent = new ExtentReports (System.getProperty("user.dir") +"D://testngre.html", true);
		extent = new ExtentReports("D:\\UserDashboardExtentreport.html",true);
		
		extent.loadConfig(new File("D:\\Harishankar\\Workplace\\B01_UserDashboardWeb\\Extentconfig.xml"));

	}
	@AfterSuite
	public void aftersuite()
	{   
	        extent.flush();
	        extent.close();
	}
	
	public void Browser(String Browsername)
	{
		if(Browsername.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "./Files/chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		
		}else if(Browsername.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "./Files/geckodriver.exe");
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if(Browsername.equalsIgnoreCase("IE"))
		{
		
			System.setProperty("webdriver.ie.driver", "./Files/IEDriverServer.exe");
		
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else
		{
			System.out.println("Invalid browser name");
		}
	}
	
	public void FirefoxMobile()
	{
		FirefoxProfile FFP = new FirefoxProfile();
		FFP.setPreference("general.useragent.override", "iPhone");
		driver = new FirefoxDriver(FFP);
		driver.manage().window().setSize(new Dimension(400,800));
		
	}
	//@BeforeClass
	public void Chromemobileview()
	{
		System.setProperty("webdriver.chrome.driver", "./Files/chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<String, String>(); 

        mobileEmulation.put("deviceName", "Google Nexus 5");  

        Map<String, Object> chromeOptions = new HashMap<String, Object>(); 

        chromeOptions.put("mobileEmulation", mobileEmulation); 

        DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 

		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions); 

		driver = new ChromeDriver(capabilities); 
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}

	@AfterMethod
		public void teardown(ITestResult result)
		{
			extent.endTest(test);
			
			if(ITestResult.FAILURE==result.getStatus())
			{
				test.log(LogStatus.FAIL, result.getName()+" - This testcase is fail after second try");
				CaptureScreenshot(driver, result.getName());
			}
			
		}	
	
	public void CaptureScreenshot(WebDriver driver, String Screenshotname)
	{
		try
		{
			Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("dd_MM-HH_mm");  
		    String strDate= formatter.format(date);  
		
		TakesScreenshot TS = (TakesScreenshot)driver;
		File Source = TS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("./Screenshots/"+strDate+Screenshotname+".png"));
		System.out.println("Screenshot taken");
		}catch(Exception ie2)
		{
			System.out.println("Screenshot not taken");
		}
	}
	
	public void OTP() throws InterruptedException
	{
		 String OTP ="999999";
		//OTP 
		 WebDriverWait wait = new WebDriverWait(driver, 25);
		 
		 Thread.sleep(2000);
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("verf-code")));
			 
		 WebElement ele = driver.findElement(By.className("verf-code"));
		 
		 ele.isDisplayed();
		 
		driver.findElement(By.className("verf-code")).sendKeys(OTP);
	}
	
	public void ThankorDash() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			
		//Thank content contain thank word
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".lcf-listing.success-message>h4")));
		String thank = driver.findElement(By.cssSelector(".lcf-listing.success-message>h4")).getText();
		
		if(thank.contains("Thank"))
		{
			
			Reporter.log("Lead posted and thank you message is display", true);
			
		} else {
			
			Reporter.log("====Thank you message is not capture====", true);
			
		}}catch(Exception ie1){
			
			System.out.println(ie1.getMessage());
			
		}
		
		Thread.sleep(2000);
		
		//Dashboard url contain Dashboard text
		int i;
		
		for(i=1;i<10;i++){
			
		String dashurl = driver.getCurrentUrl();
		
		if(dashurl.contains("dashboard"))
		{
			
			Reporter.log("LCF to Dashboard navgation is succesful", true);
			
			break;
			
		}else {
			
			Thread.sleep(4000);
		}
		}
		if(i==9)
		{
		Reporter.log("==== LCF submission not landed on Dashboard ===", true);
		}
	}
	
	public void leadmatch() 
	{
		  
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(120, TimeUnit.SECONDS)
		       .pollingEvery(10, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     @Override
			public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//button[@class='btn-p small ng-scope']"));
		     }
		   });
		   System.out.println("Update status button is displayed : "+element.isDisplayed());
		
		
	}

	
	
	

}
