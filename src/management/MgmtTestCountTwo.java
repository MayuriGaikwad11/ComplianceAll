package management;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import performer.OverduePOM;

public class MgmtTestCountTwo {
	
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	public static List<WebElement> elementsList2 = null;
	public static List<WebElement> elementsList3 = null;
	public static List<WebElement> elementsList4 = null;
	public static List<WebElement> menus = null;
	public int count = 0;
	public int interest = 0;					//Variable created for reading Interest
	public int penalty = 0;						//Variable created for reading Penalty
	
	public static String link = "Tlcg";  
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		fis = new FileInputStream("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(15);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Reports\\CompanyAdminResults.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.PASS, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Loging In - MGMT (Statutory)");
		test.log(LogStatus.PASS, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		//Write "CFO-diy" for DIYProduction link.
		//Write "CFO" for login.avantis
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
			
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	public static void progress1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,(30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 2)
	void RiskSummaryCriticalStatutory() throws InterruptedException
	{
	//	driver.navigate().refresh();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1450)");					//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,700)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(1000);
/*		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
	//	int RiskCritical_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotCompleted > 0)
		{
			CFOcountPOM.clickRiskCriticalNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1(driver, test, "Critical - Not Completed", RiskCritical_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
		}
		*/
		Thread.sleep(2000);
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedTimely > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void RiskSummaryHighStatutory() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(1000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1(driver, test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
		
		Thread.sleep(2000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void RiskSummaryMediumStatutory() throws InterruptedException
	{
		test = extent.startTest("Risk Summary - 'Medium' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,1450)");
		Thread.sleep(1000);
		String NotCompleted = CFOcountPOM.clickRiskMediumNotCompleted(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskMedium_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1(driver, test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
	//	driver.navigate().refresh();
		Thread.sleep(4000);
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void RiskSummaryLowStatutory() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'Low' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
	//	driver.navigate().refresh();
		Thread.sleep(500);
	/*	String NotCompleted = CFOcountPOM.clickRiskLowNotCompleted(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskLow_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1(driver, test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}*/

		Thread.sleep(2000);
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
		}
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void DepartmentSummaryHumanResourceStatutory() throws InterruptedException
	{
		Thread.sleep(2000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 1500 px.
		
		test = extent.startTest("Department Summary - 'Human Resource' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
	/*	String ClosedDelayed = CFOcountPOM.clickHumanClosedDelayed(driver).getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
	//	int Closed_Delayed = Integer.parseInt(CFOcountPOM.clickHumanClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		
		if(Closed_Delayed > 0)
		{
			Thread.sleep(500);	
			CFOcountPOM.clickHumanClosedDelayed(driver).click();
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount(driver, test, "Closed Delayed", Closed_Delayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "Closed Delayed Complaince Count = "+ Closed_Delayed + ".");
		}
		*/
		//-----------------------------------------------------
		
		Thread.sleep(3000);
		String ClosedTimely = CFOcountPOM.clickHumanClosedTimelym(driver).getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);						
		if(Closed_Timely > 0)
		{
			CFOcountPOM.clickHumanClosedTimelym(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Closed Timely", Closed_Timely, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "Closed Timely Complaince Count = "+ Closed_Timely + ".");
		}
		
		//-----------------------------------------------------
		
	/*		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickHumanOverduem(driver).getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);						
		if(Overdue > 0)
		{
			CFOcountPOM.clickHumanOverduem(driver).click();
			CFOcountPOM.RiskGraphCount1(driver, test, "Overdue", Overdue, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "Overdue Complaince Count = "+ Overdue + ".");
		}
		
		//-----------------------------------------------------
		
		Thread.sleep(3000);
		String PendingReview = CFOcountPOM.clickHumanPendingReviewm(driver).getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);						
		if(Pending_Review > 0)
		{
			CFOcountPOM.clickHumanPendingReviewm(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Pending For Review", Pending_Review, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "Pending For Review Complaince Count = "+ Pending_Review + ".");
		}
		
		//-----------------------------------------------------
		
		/*	try
		{
			Thread.sleep(500);
			String NotApplicable = CFOcountPOM.clickHumanNotApplicable(driver).getText();	//Reading the Pending For Review value of Human Resource
			NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
			int Not_Applicable = Integer.parseInt(NotApplicable);						
			if(Not_Applicable > 0)
			{
				CFOcountPOM.clickHumanNotApplicable(driver).click();
				CFOcountPOM.RiskGraphCount(driver, test, "Not Applicable", Not_Applicable, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "Not Applicable Complaince Count = "+ Not_Applicable + ".");
			}
		}
		catch(Exception e)
		{
			
		}*/
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 7)
	void NotCompleted_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Completed' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2400)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
		}
	
		if(NotCompletedValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Completed' Compliance Count = "+NotCompletedValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ClosedDelayed_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayed(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayed(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
		}
		
		if(ClosedDelayedValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(500);
			driver.switchTo().parentFrame();
		}
		else
		{
			test.log(LogStatus.SKIP, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void ClosedTimely_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		try{
		Thread.sleep(1500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimely(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Timely' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Timely' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
		}
		
		if(ClosedTimelyValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(1000);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard(driver).click();	
		}
		else
		{
			test.log(LogStatus.SKIP, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
		}catch(NumberFormatException ex){
			ex.printStackTrace();
		}
	}
	
	@Test(priority = 10)
	void NotApplicable_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		Thread.sleep(800);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(800);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickNotApplicable(driver)));
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicable(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicable(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(NotApplicableValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicableValue);
		}
		
		if(NotApplicableValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance")); 
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance")); 
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance")); 
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		}
		else
		{
			test.log(LogStatus.SKIP, "'Not Applicable' Compliance Count = "+NotApplicableValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
			
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)
	void Overdue_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		WebDriverWait wait = new WebDriverWait(driver, (30));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdue(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
	
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
		//	Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 12)
	void dueToday_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueToday(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(dueTodayValue == total)
		{
			test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+dueTodayValue);
		}
	
		if(dueTodayValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Due Today' Compliance Count = "+dueTodayValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void pendingForReview_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReview(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	
		if(pendingForReviewValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void rejected_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- ' Rejected' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
	//	driver.navigate().refresh();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejectedPe(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+rejectedValue);
		}
	
		if(rejectedValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 15)
	void PenaltySummaryStatutory() throws InterruptedException
	{		
		Thread.sleep(500);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2100 px.
		
		test = extent.startTest("Penalty Summary Graph - Amount Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(300);
	/*	CFOcountPOM.clickPenaltyYear(driver).click();
		Select drp = new Select(CFOcountPOM.clickPenaltyYear(driver));
		Thread.sleep(300);
		drp.selectByValue("2020-2021");
		Thread.sleep(300);
		CFOcountPOM.clickPenaltyYear(driver).click();
		
		Thread.sleep(300);
		CFOcountPOM.clickApply3(driver).click();
		*/
		Thread.sleep(500);
	//	js.executeScript("window.scrollBy(0,2525)");					//Scrolling down window by 2100 px.
		
		//----------------------------------------------Critical-------------------------------------
		
		Thread.sleep(500);
	//	String critical = CFOcountPOM.clickPenaltyCritical(driver).getText();	//Reading the High Penalty value of April-Jun
	//	critical = critical.replaceAll(" ","");									//Removing all white spaces from string. 
	//	int PenaltyCritical = Integer.parseInt(critical);
		String PendingReview = CFOcountPOM.clickPenaltyCritical(driver).getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int PenaltyCritical = Integer.parseInt(PendingReview);
		if(PenaltyCritical > 0)
		{
			test.log(LogStatus.PASS, "-------- Critical Risk Penalty Export --------");
			CFOcountPOM.clickPenaltyCritical(driver).click();
		//	CFOcountPOM.CountPenalty(driver, test, PenaltyCritical);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			
			 CFOcountPOM.clickExportImage(driver).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
				CFOcountPOM.clickInterest(driver).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
				 CFOcountPOM.clickExportImage(driver).click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "Excel file Export Successfully");
					Thread.sleep(3000);
				driver.switchTo().parentFrame();								//Switching back to Interest's parent frame.
				driver.switchTo().parentFrame();	
				Thread.sleep(500);
				CFOcountPOM.closeCategories(driver).click();					//Closing the 'Penalty' pop up.
				
				
		}
		else
		{
			test.log(LogStatus.FAIL, "'Critical Penalty' value is zero.");
		}
		
		//----------------------------------High-------------------------------
		
		Thread.sleep(500);
		String high = CFOcountPOM.clickPenaltyHigh(driver).getText();	//Reading the High Penalty value of April-Jun
		high = high.replaceAll(" ","");									//Removing all white spaces from string. 
		int PenaltyHigh = Integer.parseInt(high);
		
		if(PenaltyHigh > 0)
		{
			test.log(LogStatus.PASS, "-------- High Risk Penalty Count --------");
			CFOcountPOM.clickPenaltyHigh(driver).click();
			//CFOcountPOM.CountPenalty(driver, test, PenaltyHigh);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			
			 CFOcountPOM.clickExportImage(driver).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
				CFOcountPOM.clickInterest(driver).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
				 CFOcountPOM.clickExportImage(driver).click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "Excel file Export Successfully");
					Thread.sleep(3000);
				driver.switchTo().parentFrame();								//Switching back to Interest's parent frame.
				driver.switchTo().parentFrame();	
				Thread.sleep(500);
				CFOcountPOM.closeCategories(driver).click();					//Closing the 'Penalty' pop up.
				
		}
		else
		{
			test.log(LogStatus.SKIP, "'High Penalty' value is zero.");
		}
		
		//----------------------------------Medium-------------------------------
		
		Thread.sleep(500);
		String medium = CFOcountPOM.clickPenaltyMedium(driver).getText();	//Reading the High Penalty value of April-Jun
		medium = medium.replaceAll(" ","");									//Removing all white spaces from string. 
		int PenaltyMedium = Integer.parseInt(medium);
		
		if(PenaltyMedium > 0)
		{
			test.log(LogStatus.PASS, "-------- Medium Risk Penalty Count --------");
			CFOcountPOM.clickPenaltyMedium(driver).click();
		//	CFOcountPOM.CountPenalty(driver, test, PenaltyMedium);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			
			 CFOcountPOM.clickExportImage(driver).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
				CFOcountPOM.clickInterest(driver).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
				 CFOcountPOM.clickExportImage(driver).click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "Excel file Export Successfully");
					Thread.sleep(3000);
				driver.switchTo().parentFrame();								//Switching back to Interest's parent frame.
				driver.switchTo().parentFrame();	
				Thread.sleep(500);
				CFOcountPOM.closeCategories(driver).click();					//Closing the 'Penalty' pop up.
				
		}
		else
		{
			test.log(LogStatus.FAIL, "'Medium Penalty' value is zero.");
		}
		
		//----------------------------------Low-------------------------------
		
		Thread.sleep(500);
		String low = CFOcountPOM.clickPenaltyLow(driver).getText();	//Reading the High Penalty value of April-Jun
		low = low.replaceAll(" ","");									//Removing all white spaces from string. 
		int PenaltyLow = Integer.parseInt(low);
		
		if(PenaltyLow > 0)
		{
			test.log(LogStatus.PASS, "-------- Low Risk Penalty Count --------");
			CFOcountPOM.clickPenaltyLow(driver).click();
		//	CFOcountPOM.CountPenalty(driver, test, PenaltyLow);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			
			 CFOcountPOM.clickExportImage(driver).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
				CFOcountPOM.clickInterest(driver).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
				 CFOcountPOM.clickExportImage(driver).click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "Excel file Export Successfully");
					Thread.sleep(3000);
				driver.switchTo().parentFrame();								//Switching back to Interest's parent frame.
				driver.switchTo().parentFrame();	
				Thread.sleep(500);
				CFOcountPOM.closeCategories(driver).click();					//Closing the 'Penalty' pop up.
				
		}
		else
		{
			test.log(LogStatus.FAIL, "'Low Penalty' value is zero.");
		}
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void GradingReportStatutory() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		test = extent.startTest("'Grading Report'  Export and OverView");
		test.log(LogStatus.PASS, "Test Initiated");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3300)");					//Scrolling down window by 2600 px.
		Thread.sleep(500);	
		CFOcountPOM.clickRedGrading(driver).click();
		Thread.sleep(4000);	
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		//*[@id="showGRdetails"]
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
		
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView success");
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closePopup(driver).click();					
			
		Thread.sleep(1000);
	//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void complianceCalendar() throws InterruptedException
	{
		test = extent.startTest("compliance Calendar Verifications");
		test.log(LogStatus.PASS, "Test Initiated");
		
		WebDriverWait wait = new WebDriverWait(driver,(70));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		//js.executeScript("window.scrollBy(0,4225)");	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
		 CFOcountPOM.clickExportImage(driver).click();
		 Thread.sleep(2000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeView_cal(driver).click();

			test.log(LogStatus.PASS, "overView success");
			driver.switchTo().parentFrame();
			js.executeScript("window.scrollBy(0,-50)");
			CFOcountPOM.clickAll(driver).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[3]/div")));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[2]")));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			 CFOcountPOM.clickExportImage(driver).click();
			 Thread.sleep(2000);
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
	By locator1 = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a");
	
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(2000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton1 = driver.findElement(locator1);	
				Thread.sleep(4000);
		//	
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", ViewButton1);
				Thread.sleep(4000);
				driver.switchTo().parentFrame();
				CFOcountPOM.closeView_cal(driver).click();
				test.log(LogStatus.PASS, "overView success");
				driver.switchTo().parentFrame();
				Thread.sleep(3000);
			//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
				
				
			extent.endTest(test);
			extent.flush();
	}
	
	@Test(priority = 18)
	void DailyUpdates() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		test = extent.startTest("'Daily Updates'  OverView");
		test.log(LogStatus.PASS, "Test Initiated");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,4600)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(500);	
		CFOcountPOM.clickViewAllDU(driver).click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		CFOcountPOM.clickView1(driver).click();
		Thread.sleep(4000);	
		CFOcountPOM.closeNewsView(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "view Succefully");
		OverduePOM.searchBox(driver).sendKeys("NSE issued the MFSS Settlement Calendar");
		Thread.sleep(500);
		OverduePOM.ClicksearchBtn(driver).click();
		Thread.sleep(7000);
		test.log(LogStatus.PASS, "Search Succefully");
		Thread.sleep(1000);
		OverduePOM.ClickClearBtn(driver).click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Clear button Working Succefully");
	
		performer.OverduePOM.clickDashboard(driver).click();
		
		extent.endTest(test);
		extent.flush();
	}
	
 @Test(priority = 19)
	void NewsLetter() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
		test.log(LogStatus.PASS, "Test Initiated");
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,7000)","");					//Scrolling down window by 2600 px.
		
		CFOcountPOM.clickViewAllNL(driver).click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		CFOcountPOM.clickView2(driver).click();
		Thread.sleep(4000);	
		CFOcountPOM.closeNewsLView(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "OverView Successfully");
		performer.OverduePOM.clickDashboard(driver).click();
		
		extent.endTest(test);
		extent.flush();
	}
 
 @AfterTest
	void Closing() throws InterruptedException
	{
	 test = extent.startTest("Verify Close Browser");
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Browser Close");
		driver.close();
		extent.endTest(test);
		extent.flush();
	}	 

	

}
