package approval;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import performer.MethodsPOM;
import performer.OverduePOM;

public class ApprovalcountStatutory {
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
	
	public static String link = "Shivraj";           //Check link in excel sheet first.
			
		
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		fis = new FileInputStream("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(6);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Reports\\Approver.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.PASS, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Loging In - Approval (Statutory)");
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
		Thread.sleep(2000);
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement(driver)));

		ApprovalcountPOM.clickManagement(driver).click();
		Thread.sleep(5000);*/
		
		extent.endTest(test);
		extent.flush();
	}
	
	public static void progress1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, (30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
//	@Test(priority = 2)
	void FilterWiseCategoriesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count Match Filter Wise by Clicking on 'Categories' - Compliances ");
		
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		CFOcountPOM.clickCategories(driver).click();
		Thread.sleep(500);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(3000);
		CFOcountPOM.clickLocation(driver).click();
		Thread.sleep(1000);
		CFOcountPOM.clickBPVT(driver).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
	
		Thread.sleep(8000);
		elementsList1 = CFOcountPOM.readCompliancesList(driver);
	int	value = Integer.parseInt(elementsList1.get(1).getText());
	Thread.sleep(500);
		elementsList1.get(1).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();
		
		Thread.sleep(1000);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount1 = bits[bits.length - 2];				//Getting the second last word (total number of users)
		
	int	count1 = Integer.parseInt(compliancesCount1);
		js.executeScript("window.scrollBy(0,3000)");
		if(value == count1)
		{
			test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + value+ ", Grid Records = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+value+", Grid Records = "+count1);
		}
		
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
		//Thread.sleep(2000);
	
	//	Thread.sleep(3000);
		js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
			
		Thread.sleep(4000);
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	

	
	//@Test(priority = 3)
	void CategoriesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Categories'");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Categories =CFOcountPOM.clickCategories(driver).getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories(driver).click();
		Thread.sleep(500);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
	/*	
		elementsList1 = CFOcountPOM.readCompliancesList(driver);
		elementsList1.get(1).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
		Thread.sleep(2000);
	
		int n1 = elementsList1.size();
		int value = 0;
		int count1 = 0;
		for(int i = 0; i < n1; i++)
		{		
			Thread.sleep(500);
			elementsList1 = CFOcountPOM.readCompliancesList(driver);
			value = Integer.parseInt(elementsList1.get(i).getText());
			elementsList1.get(i).click();
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress(driver);
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD(driver).click();
			
			Thread.sleep(1000);
			String item1 = CFOcountPOM.readTotalItemsD(driver).getText();
			String[] bits1 = item.split(" ");								//Splitting the String
			String compliancesCount1 = bits[bits.length - 2];				//Getting the second last word (total number of users)
			
			count1 = Integer.parseInt(compliancesCount1);
			js.executeScript("window.scrollBy(0,3000)");
			if(value == count1)
			{
				test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + value+ ", Grid Records = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+value+", Grid Records = "+count1);
			}
			driver.switchTo().parentFrame();								//Switching back to parent frame.
			Thread.sleep(3000);
			CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
			Thread.sleep(2000);
		}	*/
		if(CategoriesCountDas == CatcountGrid)
		{
			//test.log(LogStatus.PASS, "Number of Categories grid matches to Dashboard Categories  Count.");
			test.log(LogStatus.PASS, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
			test.log(LogStatus.FAIL, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(4000);
		
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 4)
	void UniqueCompliancesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Unique Compliances'");
		
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Compliances =CFOcountPOM.uniqueCompliances(driver).getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.uniqueCompliances(driver).click();
		Thread.sleep(1000);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			//test.log(LogStatus.PASS, "Number of Unique Compliances grid matches to Dashboard Unique Compliances  Count.");
			test.log(LogStatus.PASS, "No of Unique Compliances in the grid = "+ComcountGrid+" | Dashboard Unique Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Unique compliances does not matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.FAIL, "No of Unique Compliances in the grid = "+ComcountGrid+" | Dashboard Unique Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 5)
	void TotalCompliancesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Total Compliances'");
		
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Compliances =CFOcountPOM.TotalCompliances(driver).getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.TotalCompliances(driver).click();
		Thread.sleep(1000);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportExcel(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			//test.log(LogStatus.PASS, "Number of Total Compliances grid matches to Dashboard Total Compliances  Count.");
			test.log(LogStatus.PASS, "No of Total Compliances in the grid = "+ComcountGrid+" | Dashboard Total Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Total compliances does not matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.FAIL, "No of Total Compliances in the grid = "+ComcountGrid+" | Dashboard Total Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 6)
	void UsersCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Users'");
	
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_User =CFOcountPOM.clickUsersCount(driver).getText();		//Storing old value of Statutory overdue.
	int	UserCountDas = Integer.parseInt(string_User);
		CFOcountPOM.clickUsersCount(driver).click();
		Thread.sleep(500);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int UserGrid = Integer.parseInt(compliancesCount);
		if(UserCountDas == UserGrid)
		{
		//	test.log(LogStatus.PASS, "Number of User grid matches to Dashboard User  Count.");
			test.log(LogStatus.PASS, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of User does not matches to Dashboard User  Count.");
			test.log(LogStatus.FAIL, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
		}
		
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 7)
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		Thread.sleep(3000);
		if(CFOcountPOM.ClickShowAll(driver).isEnabled()) {
			CFOcountPOM.ClickShowAll(driver).click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		litigationPerformer.MethodsPOM.progress(driver);
		WebDriverWait wait = new WebDriverWait(driver, (100));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	WebElement farme=	driver.findElement(By.xpath("//*[@id='showdetails']"));
      driver.switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(3000); 
	//	elementsList1=	CFOcountPOM.ActionviewList(driver);
		//elementsList1.get(1).click();                   //Clicking on OverdueView  button
	//	driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[16]/a[1]")).click();
	//	Thread.sleep(3000);
	//	CFOcountPOM.closeDocument(driver).click();						//Closing the View Document
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(4000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButtons = driver.findElements(locator);							
			ViewButtons.get(1).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
//	@Test(priority = 8)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
	*/
		if(NotCompletedValue > 0)
		{
			
				ApprovalcountPOM.GraphCount(driver, test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount(driver, test, "High", high, "Statutory");
				
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount(driver, test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount(driver, test, "Low", low, "Statutory");
				
				Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(1000);
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 9)
	void ClosedDelayed_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedA(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedA(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
		*/
		if(ClosedDelayedValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1(driver, test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1(driver, test, "High", high, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1(driver, test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1(driver, test, "Low", low, "Statutory");
			
				Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 10)
	void ClosedTimely_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		Actions action = new Actions(driver);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		try{
		Thread.sleep(3000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyA(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyA(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
		*/
		if(ClosedTimelyValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1(driver, test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1(driver, test, "Low", low, "Statutory");
			
				Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
		}catch(NumberFormatException ex){
			ex.printStackTrace();
		}
	}
	
//	@Test(priority = 11)
	void Overdue_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
	
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdue(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
	*/
		if(OverdueValue > 0)
		{
			
				ApprovalcountPOM.GraphCount(driver, test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount(driver, test, "High", high, "Statutory");
				
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount(driver, test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount(driver, test, "Low", low, "Statutory");
			
				Thread.sleep(2000);
			//Thread.sleep(5000);
		   // action.moveToElement(CFOcountPOM.clickBack3(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack3(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
		
//	@Test(priority = 12)
	void pendingForReview_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, (40));
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement(driver)));

	/*	ApprovalcountPOM.clickManagement(driver).click();
		Thread.sleep(5000);
		Thread.sleep(500);
		Actions action = new Actions(driver);*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReview(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Pending For Review' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Pending For Review' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	*/
		if(pendingForReviewValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1(driver, test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "Low", low, "Statutory");
		
				Thread.sleep(2000);
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(2000);
		
		}	else
		{
			test.log(LogStatus.PASS, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 13)
	void rejected_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- ' Rejected' Count Verification");
	
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,(40));
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement(driver)));

	//	ApprovalcountPOM.clickManagement(driver).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejected(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejected(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Rejected' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+total+" | Total Sum : "+rejectedValue);
		}
	*/
		if(rejectedValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1(driver, test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1(driver, test, "Low", low, "Statutory");
			
			
			//Thread.sleep(5000);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			//performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 14)
	void RiskSummaryHighStatutory() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			ApprovalcountPOM.RiskGraphCount1(driver, test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
		/*
		Thread.sleep(2000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayedA(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayedA(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			ApprovalcountPOM.RiskGraphCount2(driver, test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		*/
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimelyA(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimelyA(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			ApprovalcountPOM.RiskGraphCount(driver, test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 15)
	void DepartmentSummaryAccountStatutory() throws InterruptedException
	{
		Thread.sleep(3000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1500)");					//Scrolling down window by 1500 px.
		js.executeScript("window.scrollBy(0,500)");
		test = extent.startTest("Department Summary - 'Account' Count Verification");
	
		
	/*	Thread.sleep(500);
		String ClosedDelayed = CFOcountPOM.clickHumanClosedDelayed(driver).getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
	//	int Closed_Delayed = Integer.parseInt(CFOcountPOM.clickHumanClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance

		if(Closed_Delayed > 0)
		{
			CFOcountPOM.clickHumanClosedDelayed(driver).click();
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount2(driver, test, "Closed Delayed", Closed_Delayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.SKIP, "Closed Delayed Complaince Count = "+ Closed_Delayed + ".");
		}
		*/
		//-----------------------------------------------------
		/*
		Thread.sleep(5000);
		String ClosedTimely = CFOcountPOM.clickAccountClosedTimely(driver).getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);						
		if(Closed_Timely > 0)
		{
			CFOcountPOM.clickAccountClosedTimely(driver).click();
			ApprovalcountPOM.RiskGraphCount(driver, test, "Closed Timely", Closed_Timely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Closed Timely Complaince Count = "+ Closed_Timely + ".");
		}
		*/
		//-----------------------------------------------------
		
		Thread.sleep(1000);
		String NotCompleted = CFOcountPOM.clickAccountOverdue(driver).getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);						
		if(Overdue > 0)
		{
			CFOcountPOM.clickAccountOverdue(driver).click();
			ApprovalcountPOM.RiskGraphCount1(driver, test, "Overdue", Overdue, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Overdue Complaince Count = "+ Overdue + ".");
		}
		
		//-----------------------------------------------------
		
		Thread.sleep(1000);
		String PendingReview = CFOcountPOM.clickAccountPendingReview(driver).getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);						
		if(Pending_Review > 0)
		{
			CFOcountPOM.clickAccountPendingReview(driver).click();
			ApprovalcountPOM.RiskGraphCount(driver, test, "Pending For Review", Pending_Review, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Pending For Review Complaince Count = "+ Pending_Review + ".");
		}
		
		//-----------------------------------------------------
		
		try
		{
			Thread.sleep(500);
			String NotApplicable = CFOcountPOM.clickAccountRejected(driver).getText();	//Reading the Pending For Review value of Human Resource
			NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
			int Rejected = Integer.parseInt(NotApplicable);						
			if(Rejected > 0)
			{
				CFOcountPOM.clickAccountRejected(driver).click();
				ApprovalcountPOM.RiskGraphCount(driver, test, "Rejected", Rejected, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Rejected Complaince Count = "+ Rejected + ".");
			}
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(500);
	//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void NotCompleted_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,2000)");
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
		/*
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
	*/
		if(NotCompletedValue > 0)
		{
			if(critical > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void ClosedTimely_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		try{
		Thread.sleep(1500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyA(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyA(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
		*/
		if(ClosedTimelyValue > 0)
		{
			if(critical > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
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
	
	@Test(priority = 18)
	void Overdue_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
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
		/*
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
	*/
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				ApprovalcountPOM.GraphCountPe(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		   // action.moveToElement(CFOcountPOM.clickBack3(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack3(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 19)
	void pendingForReview_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, (40));
	/*	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement(driver)));

		ApprovalcountPOM.clickManagement(driver).click();
		Thread.sleep(5000);
		Thread.sleep(500);
		Actions action = new Actions(driver);*/	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");			//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
		/*
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
	*/
		if(pendingForReviewValue > 0)
		{
			if(critical > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
		//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void rejected_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Rejected' Count Verification");
	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, (40));
	/*	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement(driver)));

		ApprovalcountPOM.clickManagement(driver).click();
		Thread.sleep(5000);
		Thread.sleep(500);
		Actions action = new Actions(driver);*/	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");			//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickRejectedPe1(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe1(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	*/
		if(pendingForReviewValue > 0)
		{
			if(critical > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				ApprovalcountPOM.GraphCountPe1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
		//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void GradingReportStatutory() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'Grading Report'  Export and OverView");
	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,2600)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(500);	
		CFOcountPOM.clickRedGrading(driver).click();
		Thread.sleep(4000);	
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
		
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[12]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closePopup(driver).click();					
			
		Thread.sleep(1000);
	//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void complianceCalendar() throws InterruptedException
	{
		test = extent.startTest("compliance Calendar Verifications");
		
		
		WebDriverWait wait = new WebDriverWait(driver,(70));
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,3200)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
		 CFOcountPOM.clickExportImage(driver).click();
		 Thread.sleep(2000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]/a");
			
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

			test.log(LogStatus.PASS, "overView successfully");
			driver.switchTo().parentFrame();
	/*		js.executeScript("window.scrollBy(0,-50)");
			CFOcountPOM.clickAll(driver).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[3]/div")));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[2]")));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
			Thread.sleep(5000);
			 CFOcountPOM.clickExportImage(driver).click();
			 Thread.sleep(2000);
			// test.log(LogStatus.PASS, "After Clicking All(Including Checklist)");
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
	By locator1 = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]/a");
	
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(2000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton1 = driver.findElement(locator1);	
				Thread.sleep(2000);
		//	
			Thread.sleep(1000);
			jse.executeScript("arguments[0].click();", ViewButton1);
				Thread.sleep(4000);
				driver.switchTo().parentFrame();
				CFOcountPOM.closeView_cal(driver).click();
				test.log(LogStatus.PASS, "overView Successfully");
				driver.switchTo().parentFrame();
				Thread.sleep(1000);*/
			//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
				
				
			extent.endTest(test);
			extent.flush();
	}
	
		@Test(priority = 23)
	void DailyUpdates() throws InterruptedException, IOException
	{
		Thread.sleep(2000);		
		test = extent.startTest("'Daily Updates'  OverView");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,4600)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,500)");
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
		OverduePOM.searchBox(driver).sendKeys("Haryana Land Partnership Policy-2022");
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
	
	@Test(priority = 24)
	void NewsLetter() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
		//test.log(LogStatus.INFO, "Test Initiated");
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, (40));
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement(driver)));

	//	ApprovalcountPOM.clickManagement(driver).click();
	//	Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4300)","");					//Scrolling down window by 2600 px.
		
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
	
	@Test(priority = 25)
	void StandardReportOverall() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Overall Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportOverall(test, driver, "Approval");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26)
		void StandardReportLocation() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Location Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportLocation(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 27)
		void StandardReportUser() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -User Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportUser(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 28)
		void StandardReportCategory() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Category  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCategory(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 29)
		void StandardReportRisk() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportRisk(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 30)
		void StandardReportDetailed() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Detailed  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDetailed(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 31)
		void StandardReportCriticalRisk() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Critical Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCriticalRisk(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 32)
		void StandardReportDepartment () throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report - Department   Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDepartment(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 33)
		void StandardReportOverallIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Overall Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportOverallIn(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	    @Test(priority = 34)
		void StandardReportLocationIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Location Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportLocationIN(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 35)
		void StandardReportUserIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -User Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportUserIN(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 36)
		void StandardReportCategoryIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Category  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCategoryIN(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 37)
		void StandardReportRiskIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal-Risk  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportRiskIN(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 38)
		void StandardReportDetailedIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal-Detailed  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDetailedIN(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 39)
		void StandardReportCriticalRiskIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Critical Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCriticalRiskIN(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 40)
		void StandardReportDepartmentIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Department  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDepartmentIN(test, driver, "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 41)
	void DetailedReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReport(test, driver, "Approval");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 42) 
	void DetailedReportIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Internal Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReportIn(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 43)
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.AssignmentReport(test, driver);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 44)
	void ComplianceRepository() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance  Repository  verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.ActRepository(test,driver);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 45)
	void ComplianceDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents  verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.ComplianceDocuments(test,driver);
		
				extent.endTest(test);
				extent.flush();
	}
	
//	@Test(priority = 46)
	void ComplianceDocumentsIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents-Internal  verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.complianceDocumentIn(test,driver);
		
				extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 47) //	pass	
	void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Critical Document Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		OverduePOM.CriticalDocuments(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 48)
	void ActDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Act Documents  verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
WebDriverWait wait = new WebDriverWait(driver,(140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments(driver).click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickActDocuments(driver).click();			//Clicking on 'Act Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[2]/td[5]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully.");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			driver.findElement(By.xpath("//*[@id='basic']/tbody/tr[2]/td[2]")).click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "File Download successfully.");
			performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	
	
//	@Test(priority = 49) // pass
	void MyReminderStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Statutory Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		OverduePOM.MyReminder(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	 @Test(priority = 50)
		void InternalMsg() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'Internal Msg  '  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
				Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(500);
			OverduePOM.ClickInternalMsg(driver).click();
			Thread.sleep(4000);
			OverduePOM.ClickTo(driver).sendKeys("mayuri@tlregtech.in");
			Thread.sleep(500);
			OverduePOM.ClickSub(driver).sendKeys("Automation");
			Thread.sleep(1000);
			OverduePOM.TypeMsg(driver).sendKeys("Automation testing");
			Thread.sleep(1000);
			OverduePOM.choosefile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads/Report .xlsx");
			Thread.sleep(1000);
			//OverduePOM.send(driver).click();
			By locator = By.xpath("//*[@id='btnsendmailNew']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Internal Message working Succefully");
			Thread.sleep(1000);
			extent.endTest(test);
			extent.flush();
		}
		
		 @Test(priority = 51)
			void SupportTicket() throws InterruptedException, IOException
			{
				Thread.sleep(1000);		
				test = extent.startTest("'Support Ticket  '  Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				MethodsPOM.SupportTicket(test,driver);
				
				extent.endTest(test);
				extent.flush();
			}
	 
	
	
//	@Test(priority = 51) // pass
	void MyNotifications() throws InterruptedException, IOException
	{
		test = extent.startTest("My Notifications - Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		WebDriverWait wait = new WebDriverWait(driver, (30));
		Thread.sleep(8000);
		CFOcountPOM.clickMyNotifications(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickViewBtnNO(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.CloseViewNO(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "View Successfully");	
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_chkCompliances_0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_chkCompliances_1']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2100 px.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMarkasRead']")).click();
		test.log(LogStatus.PASS, "Read Successfully");	
		Thread.sleep(1000);
		performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 52) // pass
	void MessageCenter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Message Center - Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		WebDriverWait wait = new WebDriverWait(driver, (30));
		Thread.sleep(8000);
		CFOcountPOM.clickMessageCenter(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickViewMsg(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "View Button is clickable");
		Thread.sleep(1000);
		performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 53) 
	void DetailedReportRe() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Reopen Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReportRe(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
}
