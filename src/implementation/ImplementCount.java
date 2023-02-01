package implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import companyadmin.CompanyMethods;

public class ImplementCount {
	
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
	
	
	public static String link = "Implementation";  
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(13);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Reports\\Implementation.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "Browser test is initiated");
		
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
		test = extent.startTest("Loging In - Implementation ");
		test.log(LogStatus.INFO, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		test.log(LogStatus.PASS, "Test Passed.");
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
	
	//@Test(priority = 2)
	void CustomersCreate() throws InterruptedException, IOException
	{
		test = extent.startTest("Customers Create");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.CreateCustomers(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 3)
	void CustomersAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Customers Assignment");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.CustomersAssignment(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 4)
	void SubEntity() throws InterruptedException, IOException
	{
		test = extent.startTest("Sub Entity");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.SubEntity(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 5)
	void Department() throws InterruptedException, IOException
	{
		test = extent.startTest("Department");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.Department(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 6)
	void Users() throws InterruptedException, IOException
	{
		test = extent.startTest("Users");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.Users(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 7)
	void UsersandBranchUpload() throws InterruptedException, IOException
	{
		test = extent.startTest("Users");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.UserandBranchUpload(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 8)
	void ProductMapping() throws InterruptedException, IOException
	{
		test = extent.startTest("Product Mapping");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.productMapping(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 9)
	void ModifyAssignmentsR() throws InterruptedException, IOException
	{
		test = extent.startTest("Modify Assignments - Reassign");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.modifyAssignmentsReassign(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 10)
	void ModifyAssignmentsExclude() throws InterruptedException, IOException
	{
		test = extent.startTest("Modify Assignments - Exclude");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.modifyAssignmentsExclude(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 11)
	void ModifyAssignmentsTask() throws InterruptedException, IOException
	{
		test = extent.startTest("Modify Assignments - Task");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.modifyAssignmentsTask(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 12)
	void UsageReportCustomer() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Usage Report Customer");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.UsageReportCustomer(driver,test,"Usage Report Customer");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 13)
	void UsageReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Usage Report ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.UsageReport(driver,test,"Usage Report ");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 14)
	void StatutoryAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Usage Report ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.StatutoryAssignmentReport(driver,test,"Statutory Assignment Report ");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 15)
	void CheckListAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - CheckList Assignment Report  ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.StatutoryAssignmentReport(driver,test,"CheckList Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 16)
	void EventBasedAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - EventBased Assignment Report   ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.EventBasedAssignmentReport(driver,test,"EventBased Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 17)
	void InternalAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Internal Assignment Report   ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.InternalAssignmentReport(driver,test,"Internal Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
/*	
	@Test(priority = 18)
	void InternalCheckListAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Internal CheckList Assignment Report   ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.InternalCheckListAssignment(driver,test,"Internal CheckList Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void StatutoryLabelReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Statutory Label Report ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.StatutoryLabelReport(driver,test,"Statutory Label Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void InternalLabelReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Internal Label Report ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.InternalLabelReport(driver,test,"Internal Label Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void AllReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - All Report ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.AllReport(driver,test,"All Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void CompliaceCountReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Compliace Count Report ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.CompliaceCountReport(driver,test,"Compliace Count Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 23)
	void ComplianceActivation() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Assign Compliance ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.AssignCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void IntermediateCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Intermediate Compliance ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.IntermediateCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25)
	void ActivateCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances- Compliance Activation -Activate Compliance  ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.ActivateCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26)
	void AssignCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Assign CheckList");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.AssignCheckList(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27)
	void IntermediateCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Compliance Activation - Intermediate CheckList ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.IntermediateCheckList(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28)
	void ActivateCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Activate CheckList  ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.ActivateCheckList(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	*/
//	@Test(priority = 29)
	void ComplianceCategory() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Masters - Compliance Category  ");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.ComplianceCategory(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 30)
	void Compliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Masters - Compliances");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.Compliances(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void EditCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Masters - Edit Compliances");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ImplementMethods.EditCompliances(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	//@AfterTest
		void Closing() throws InterruptedException
		{
			Thread.sleep(1000);
			driver.close();
		}	 
	
	

}
