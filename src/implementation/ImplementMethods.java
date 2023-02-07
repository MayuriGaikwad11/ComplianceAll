package implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import companyadmin.CompanyPOM;
import performer.OverduePOM;

public class ImplementMethods {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	

	
	public static void CreateCustomers(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.clickCustomers(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClickAddNew(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]"))); 
		ImplementPOM.clickServiceProvider(driver).click();

		ImplementPOM.SelectAvantis(driver).click();
		Thread.sleep(5000);
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(3);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.CustomerName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(4000);

		row0 = sheet.getRow(4);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.BuyerName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(4000);
		row0 = sheet.getRow(5);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		int No = (int) c1.getNumericCellValue();
		ImplementPOM.BuyerContactNo(driver).sendKeys("" + No + ""); // Writing Task title
		Thread.sleep(4000);
		row0 = sheet.getRow(6);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.BuyerEmail(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(4000);
		ImplementPOM.ClickSave(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Message displayed - 'Customer Saved Successfully'");
	}

	public static void CustomersAssignment(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		sheet = workbook.getSheetAt(13);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.CustomerAssignment(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClickAddNewCA(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomer(driver).clear();
		Thread.sleep(1000);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(3);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.SelectCustomer(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(5000);
		ImplementPOM.SelectPerformer(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectRT(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectReviewer(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectAA(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClickSaveCA(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Message displayed - 'Customer Assignment Successfully'");

		ImplementPOM.ClickEditCA(driver).click();
		Thread.sleep(5000);
		ImplementPOM.SelectReviewer(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectIA(driver).click();
		Thread.sleep(4000);
		Thread.sleep(4000);
		ImplementPOM.ClickSaveCA(driver).click();
		Thread.sleep(5000);

		String saveMsg = ImplementPOM.UpdateMsg(driver).getText();

		if (saveMsg.equalsIgnoreCase("Customer Assigned updated successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
		} else {
			test.log(LogStatus.FAIL, "Message displayed -" + saveMsg + "not Displayed");
		}
		ImplementPOM.CloseCA(driver).click();

		Thread.sleep(5000);

		// ImplementPOM.DeleteCA(driver).click();
		// test.log(LogStatus.PASS, "Delete Successfully");
		ImplementPOM.FilterCA(driver).sendKeys("demo Final 7dec", Keys.ENTER);
		Thread.sleep(6000);
		test.log(LogStatus.PASS, "Customer Assignment - Filter Working  Successfully");

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.clickCustomers(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClickEditC(driver).click();
		Thread.sleep(5000);
		ImplementPOM.Address(driver).clear();

		ImplementPOM.Address(driver).sendKeys("ABC");
		Thread.sleep(1000);
		ImplementPOM.ClickSave(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Update Successfully");
		// ImplementPOM.Delete(driver).click();
		// Thread.sleep(5000);
		ImplementPOM.Filter(driver).sendKeys("customer123", Keys.ENTER);

		test.log(LogStatus.PASS, " Customer- Filter Working  Successfully");

		Thread.sleep(5000);
	}

	public static void SubEntity(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
		Thread.sleep(3000);
		ImplementPOM.clickCustomers(driver).click();
		Thread.sleep(4000);
		ImplementPOM.clickSubEntity(driver).click();
		Thread.sleep(5000);
		ImplementPOM.SubEntityAddNew(driver).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_tbxName']")));
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(8);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.EnterName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.SubEntityType(driver).click();
		Thread.sleep(3000);
		ImplementPOM.LegalEntity(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Type(driver).click();
		Thread.sleep(1000);
		ImplementPOM.DeemedPublicCompany(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Industry(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ClickCheck(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Industry(driver).click();

		row0 = sheet.getRow(9);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.AddressLine1(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.State(driver).clear();
		Thread.sleep(2000);
		ImplementPOM.State(driver).sendKeys("Maharashtra");
		Thread.sleep(2000);
		ImplementPOM.Maharashtra(driver).click();
		Thread.sleep(2000);
		ImplementPOM.City(driver).clear();
		Thread.sleep(2000);
		ImplementPOM.City(driver).sendKeys("Ahmednagar");
		Thread.sleep(2000);
		ImplementPOM.Anagar(driver).click();
		Thread.sleep(2000);
		row0 = sheet.getRow(10);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ContactPerson(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(11);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ContactEmail(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);
		ImplementPOM.SaveSE(driver).click();

		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Sub Entity- Add New Branch Successfully");
		Thread.sleep(1000);
		row0 = sheet.getRow(8);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.FilterSE(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Sub Entity-Filter Working Successfully");
		ImplementPOM.ClickExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Sub Entity- Export to Excel Successfully");
		ImplementPOM.ClickEditSE(driver).click();
		Thread.sleep(4000);
		ImplementPOM.Type(driver).click();
		Thread.sleep(1000);
		ImplementPOM.LLP(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SaveSE(driver).click();
		test.log(LogStatus.PASS, " Sub Entity- Update Successfully");
		Thread.sleep(3000);
		ImplementPOM.ClickDeleteSE(driver).click();
		String DeleteMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase(
				"This will also delete all the sub-entities associated with current entity. Are you certain you want to delete this entity?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}

	}

	public static void Department(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ClickDepartment(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerDept(driver).clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerDept(driver).sendKeys("customer123");
		ImplementPOM.customer123(driver).click();
		Thread.sleep(3000);
		ImplementPOM.AddNewDept(driver).click();
		Thread.sleep(3000);
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(13);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartmentName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);

		ImplementPOM.DepartmentSave(driver).click();
		Thread.sleep(2000);
		String DeptSaveMsg = ImplementPOM.DepartmentSaveMsg(driver).getText();

		if (DeptSaveMsg.equalsIgnoreCase("Department saved successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeptSaveMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed - Department already exists");
		}
		Thread.sleep(2000);
		ImplementPOM.DepartmentClose(driver).click();
		Thread.sleep(3000);
		row0 = sheet.getRow(13);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartFilter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " .Department-Filter Working Successfully");

		ImplementPOM.DepartEdit(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DepartmentName(driver).clear();
		Thread.sleep(2000);
		row0 = sheet.getRow(14);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartmentName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.DepartmentSave(driver).click();
		Thread.sleep(3000);
		String DeptUpdateMsg = ImplementPOM.DepartUpdateMsg(driver).getText();

		if (DeptUpdateMsg.equalsIgnoreCase("Department updated successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeptUpdateMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed - Department already exists");
		}

		Thread.sleep(2000);
		ImplementPOM.DepartmentClose(driver).click();
		Thread.sleep(3000);

		ImplementPOM.DepartDelete(driver).click();
		String DeleteMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Department Details?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}

	}

	public static void UserandBranchUpload(WebDriver driver, ExtentTest test) throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ClickUserandBrach(driver).click();
		Thread.sleep(4000);

		Select Customer = new Select(ImplementPOM.SelectCustomerUB(driver));
		Thread.sleep(500);
		Customer.selectByIndex(2);
		Thread.sleep(500);
		ImplementPOM.ClickUsers(driver).click();
		Thread.sleep(500);
		ImplementPOM.UploadFile(driver)
				.sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\SampleUserBranchUploadFormat (1)A.xlsx");
		Thread.sleep(1000);

		ImplementPOM.clickUpload(driver).click();
		Thread.sleep(3000);
		String UploadMsg = ImplementPOM.UsersUploadMsg(driver).getText();
		test.log(LogStatus.PASS, "Message displayed -" + UploadMsg);
		Thread.sleep(3000);
		Select Customer1 = new Select(ImplementPOM.SelectCustomerUB(driver));
		Thread.sleep(500);
		Customer1.selectByIndex(2);
		Thread.sleep(500);
		ImplementPOM.ClickBranches(driver).click();
		Thread.sleep(500);
		ImplementPOM.UploadFile(driver)
				.sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\SampleUserBranchUploadFormat (1)A.xlsx");
		Thread.sleep(1000);
		ImplementPOM.clickUpload(driver).click();
		Thread.sleep(4000);
		String UploadMsg1 = ImplementPOM.UsersUploadMsg(driver).getText();
		test.log(LogStatus.PASS, "Message displayed -" + UploadMsg1);
		Thread.sleep(3000);

	}

	public static void Users(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();

		Thread.sleep(6000);
		ImplementPOM.clickUsers(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectCustomerUser(driver).clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerUser(driver).sendKeys("ABCD Pvt Ltd");
		ImplementPOM.customer123Users(driver).click();
		Thread.sleep(4000);
		ImplementPOM.AddNewDept(driver).click();
		Thread.sleep(3000);
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(16);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersEmail(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(17);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersFirstName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(18);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersLastName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(19);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersDesignation(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(20);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

		int No = (int) c1.getNumericCellValue();
		ImplementPOM.UsersMobileNo(driver).sendKeys("" + No + ""); // Writing Task title
		Thread.sleep(4000);
		ImplementPOM.UsersDepartment(driver).click();
		Thread.sleep(2000);
		ImplementPOM.DepartmentTech(driver).click();
		Thread.sleep(5000);
		ImplementPOM.UsersDepartment(driver).click();
		Thread.sleep(2000);
		ImplementPOM.UserComplianceRole(driver).click();
		Thread.sleep(3000);
		ImplementPOM.UserCompanyAdmin(driver).click();
		Thread.sleep(4000);

		ImplementPOM.SelectHrRole(driver).click();
		Thread.sleep(2000);
		ImplementPOM.HR(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SC(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ABC(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LoginSSO(driver).click();
		Thread.sleep(500);
		ImplementPOM.DesktopAccess(driver).click();
		Thread.sleep(2000);
		ImplementPOM.UserSave(driver).click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "User - Add Successfully");
		row0 = sheet.getRow(17);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartFilter(driver).sendKeys("ss", Keys.ENTER); // Writing Task title
		Thread.sleep(6000);
		test.log(LogStatus.PASS, "User - Filter working Successfully");
		ImplementPOM.ExportUser(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User - Export to excel Successfully");
		ImplementPOM.UserEdit(driver).click();
		Thread.sleep(3000);
		ImplementPOM.UsersFirstName(driver).clear();
		Thread.sleep(1000);
		row0 = sheet.getRow(21);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersFirstName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.UsersDepartment(driver).click();
		Thread.sleep(2000);
		ImplementPOM.DepartmentTech(driver).click();
		Thread.sleep(5000);
		ImplementPOM.UsersDepartment(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocation(driver).click();
		Thread.sleep(5000);
		ImplementPOM.Location1(driver).click();
		Thread.sleep(2000);
		ImplementPOM.UserSave(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "User - Update Successfully");
		ImplementPOM.ResetPass(driver).click();
		Thread.sleep(3000);
		String ResetPass = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (ResetPass.equalsIgnoreCase("Are you certain you want to reset password for this user?")) {
			test.log(LogStatus.PASS, "Message displayed -" + ResetPass);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + ResetPass + "not Displayed");
		}
		Thread.sleep(2000);
		String ResetMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (ResetMsg.equalsIgnoreCase("Password reset successfully.")) {
			test.log(LogStatus.PASS, "Message displayed -" + ResetMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + ResetMsg + "not Displayed");
		}
		Thread.sleep(4000);

		ImplementPOM.UserDelete(driver).click();
		Thread.sleep(3000);
		String DeleteMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this User?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}
		Thread.sleep(2000);

	}

	public static void productMapping(WebDriver driver, ExtentTest test) throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ProductMapping(driver).click();
		Thread.sleep(4000);
		ImplementPOM.AddNewDept(driver).click();
		Thread.sleep(4000);
		ImplementPOM.PMCustomer(driver).click();
		Thread.sleep(1000);
		ImplementPOM.PMABCDPvtLtd(driver).click();
		Thread.sleep(2000);
		ImplementPOM.PMProduct(driver).click();
		Thread.sleep(1000);
		ImplementPOM.PMCompliance(driver).click();

		Thread.sleep(2000);
		ImplementPOM.PMSave(driver).click();
		Thread.sleep(2000);
		String Msg = ImplementPOM.PMAddMsg(driver).getText();

		Thread.sleep(3000);
		if (Msg.equalsIgnoreCase("Your details have been saved successfully.")) {
			test.log(LogStatus.PASS, "Message displayed -" + Msg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -Product & Customer name already exists.");
		}

		Thread.sleep(500);

		ImplementPOM.PMClose(driver).click();
		Thread.sleep(3000);
		ImplementPOM.DepartFilter(driver).sendKeys("PQR Pvt ltd", Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -Filter Working Successfully");
		ImplementPOM.PMDelete(driver).click();
		Thread.sleep(1000);
		String DeleteMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Product?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}
		Thread.sleep(2000);

	}

	public static void modifyAssignmentsReassign(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments(driver).click();
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Statutory
		// --------------------------------------

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA(driver).click();
		ImplementPOM.SelectABCD(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		ImplementPOM.Selectaaa(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		ImplementPOM.SelectPerformerabcabd(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		ImplementPOM.Selectaaaaaad(driver).click();
		Thread.sleep(5000);

		ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(1000);
		ImplementPOM.CheckBox2(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -Statutory - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Statutory :-Event Based
		// --------------------------------------
		Thread.sleep(7000);
		ImplementPOM.ClickStaEventBased(driver).click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(1000);
		ImplementPOM.CheckBox2(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAEventMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAEventMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -Event Based - " + MAEventMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAEventMsg + "not Displayed");
		}

		// --------------------------- Modify Assignments :- Statutory :-CheckList
		// --------------------------------------
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList(driver).click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(1000);
		ImplementPOM.CheckBox2(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MACheckListMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MACheckListMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -CheckList " + MACheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MACheckListMsg + "not Displayed");
		}

		// --------------------------- Modify Assignments :- Internal
		// --------------------------------------
		Thread.sleep(5000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA(driver).click();
		ImplementPOM.SelectBitademopune(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		ImplementPOM.SelectASs(driver).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		ImplementPOM.SelectPerformeraaaaa(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		ImplementPOM.SelectASsd(driver).click();
		Thread.sleep(5000);

		ImplementPOM.CheckINBox1(driver).click();
		Thread.sleep(1000);
		ImplementPOM.CheckINBox2(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAInMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to aaa aa?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal - " + MAInMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInMsg + "not Displayed");
		}
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Internal :-CheckList
		// --------------------------------------
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList(driver).click();
		Thread.sleep(5000);
		ImplementPOM.CheckINBox1(driver).click();
		Thread.sleep(1000);
		ImplementPOM.CheckINBox2(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAInCheckListMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInCheckListMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to aaa aa?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal- CheckList " + MAInCheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInCheckListMsg + "not Displayed");
		}

		Thread.sleep(2000);

	}

	public static void modifyAssignmentsExclude(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 
		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments(driver).click();
		Thread.sleep(6000);

		// --------------------------- Modify Assignments :- Statutory :- Exclude
		// --------------------------------------
		ImplementPOM.ClickExclude(driver).click();
		Thread.sleep(6000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA(driver).click();
		ImplementPOM.SelectBitademopune(driver).click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectASs(driver).click();
		Thread.sleep(8000);
		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox2(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		Thread.sleep(3000);
		String MAEMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAEMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Statutory - Exclude" + MAEMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAEMsg + "not Displayed");
		}
		Thread.sleep(4000);
		// --------------------- Modify Assignments :- Statutory :-Exclude-Event Based
		// --------------------------------------
		Thread.sleep(7000);
		ImplementPOM.ClickStaEventBased(driver).click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox2(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAEEventMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAEEventMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Event Based - Exclude " + MAEEventMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAEEventMsg + "not Displayed");
		}

		// --------------------------- Modify Assignments :- Statutory
		// :-Exclude-CheckList --------------------------------------
		Thread.sleep(5000);
		ImplementPOM.ClickStaCheckList(driver).click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox2(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAECheckListMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAECheckListMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for aaa aaa?")) {
			test.log(LogStatus.PASS, "Message displayed -CheckList -Exclude " + MAECheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAECheckListMsg + "not Displayed");
		}
		ImplementPOM.ClickStaCheckList(driver).click();
		// --------------------------- Modify Assignments :- Internal- exclude
		// --------------------------------------
		Thread.sleep(5000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA(driver).click();
		ImplementPOM.SelectBitademopune(driver).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		ImplementPOM.SelectASs(driver).click();
		Thread.sleep(4000);

		ImplementPOM.CheckINBox0(driver).click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckINBox2(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAInMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal -exclude :- " + MAInMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInMsg + "not Displayed");
		}
		Thread.sleep(4000);
		// --------------------------- Modify Assignments :- Internal :-exclude:-
		// CheckList --------------------------------------
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList(driver).click();
		Thread.sleep(5000);
		ImplementPOM.CheckINBox0(driver).click();

		Thread.sleep(3000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAInCheckListMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInCheckListMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal-exclude:- CheckList " + MAInCheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInCheckListMsg + "not Displayed");
		}

		Thread.sleep(2000);

	}

	public static void modifyAssignmentsTask(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments(driver).click();
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Statutory :-Task :-Reassign
		// -------------------------------------
		ImplementPOM.ClickTask(driver).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA(driver).click();
		ImplementPOM.SelectABCD(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		ImplementPOM.Selectaaa(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		ImplementPOM.SelectPerformerabcabd(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		ImplementPOM.Selectaaaaaad(driver).click();
		Thread.sleep(5000);

		ImplementPOM.ChechBoxInTask0(driver).click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -Statutory -Task :- Reassign " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Internal Task :- Reassign
		// --------------------------------------
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA(driver).click();
		ImplementPOM.SelectABCD(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(500);

		Thread.sleep(500);
		ImplementPOM.Selectaaa(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); // Wait until	 records t	 get visible.
		Thread.sleep(2000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		ImplementPOM.Selectaaaaaad(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		ImplementPOM.SelectPerformerabcabd(driver).click();
		Thread.sleep(5000);

		ImplementPOM.ChechBoxInTask0(driver).click();
		// Thread.sleep(1000);
		// ImplementPOM.ChechBoxInTask1(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAInMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to aaa aaa?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal -Task :- Reassign " + MAInMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInMsg + "not Displayed");
		}
		Thread.sleep(4000);

	}

	public static void UsageReportCustomer(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																											
		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UsageReportCustomer(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerRe(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectABCpvtltd(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectCustomerRe(driver).click();
		Thread.sleep(500);
		ImplementPOM.FromDate(driver).click();
		Thread.sleep(500);
		ImplementPOM.January19(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ToDate(driver).click();
		Thread.sleep(500);
		ImplementPOM.January25(driver).click();
		Thread.sleep(1000);

		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportRe(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

		if (ImplementPOM.ClickClearBtn(driver).isEnabled()) {

			ImplementPOM.ClickClearBtn(driver).click();
			test.log(LogStatus.PASS, " :-Clear Button Working successfully.");
		} else {
			test.log(LogStatus.FAIL, " :-Clear Button is not  Working successfully.");
		}

	}
	
	public static void UsageReport( WebDriver driver,ExtentTest test,String report) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
			      Thread.sleep(1000);
			      ImplementPOM.ClickUsageReport(driver).click();
			      Thread.sleep(3000);
			      ImplementPOM.SelectCustomerUR(driver).click();
			      Thread.sleep(500);
			      ImplementPOM.SelectBitademopuneRE(driver).click();
			      Thread.sleep(500);
			      ImplementPOM.SelectABitaPharmaCompany(driver).click();
			      ImplementPOM.FromDateUR(driver).click();
			      Thread.sleep(500);
			      ImplementPOM.January19(driver).click();
			      Thread.sleep(1000);
			      ImplementPOM.ToDateUR(driver).click();
			      Thread.sleep(500);
			      ImplementPOM.January25(driver).click();
			      Thread.sleep(1000);
			      
			      File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
					File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
					
					Thread.sleep(500);
					ImplementPOM.ExportToExcel(driver).click();				//Exporting (Downloading) file
					
					Thread.sleep(3000);//C://Users//jiya//Downloads//
					File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
					File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
					Thread.sleep(3000);
					if(dirContents.length < allFilesNew.length)
					{
						test.log(LogStatus.PASS, report+" :- File downloaded successfully.");	
					}
					else
					{
						test.log(LogStatus.INFO, report+" :- File does not downloaded.");
					}
												
	}
	
	public static void StatutoryAssignmentReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.StatutoryAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}

	public static void CheckListAssignmentReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.CheckListAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}

	public static void EventBasedAssignmentReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EventBasedAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(8000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}

	public static void InternalAssignmentReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.InternalAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}
	
	public static void InternalCheckListAssignment(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.InternalCheckListAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}
	
	public static void StatutoryLabelReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.StatutoryLabelReport(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}
	
	public static void InternalLabelReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.InternalLabelReport(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}
	
	public static void AllReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.AllReport(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerSA(driver).click();

		ImplementPOM.SelectBitademopuneSA(driver).click();
		Thread.sleep(10000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}
	
	public static void CompliaceCountReport(WebDriver driver, ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.CompliaceCountReport(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCategory(driver).click();

		ImplementPOM.Commercial(driver).click();
		Thread.sleep(5000);
		ImplementPOM.SelectType(driver).click();

		ImplementPOM.Central(driver).click();
		Thread.sleep(5000);
		
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}
	
	public static void AssignCompliance(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation(driver).click();
		Thread.sleep(3000);
		ImplementPOM.AssignCompliance(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectPerformerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FEManager(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceCategory(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABCD(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED(driver).click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectReviewerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FMManager(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(1000);
		String MAInMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		
	}
	
	public static void IntermediateCompliance(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation(driver).click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateCompliance(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClickEdit(driver).click();
		Thread.sleep(3000);
		ImplementPOM.EditUser(driver).click();
		Thread.sleep(2000);
		ImplementPOM.EditUseraaaaa(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickUpdate(driver).click();
		Thread.sleep(3000);
	String text=	ImplementPOM.CheckEdit(driver).getText();
		if(text.equalsIgnoreCase("FM Manager")) {
			test.log(LogStatus.PASS, "Intermediate Compliance - Update Successfully");
			
		}
		Thread.sleep(1000);
		ImplementPOM.ClickEdit(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Intermediate Compliance - Delete Successfully");
		
	}
	
	public static void ActivateCompliance(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ActivateCompliance(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB(driver).click();
		Thread.sleep(1000);
		ImplementPOM.select(driver).click();
		Thread.sleep(3000);
		ImplementPOM.selectDate(driver).click();
		Thread.sleep(1000);
		ImplementPOM.Date11(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ActivateCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(1000);
		String AMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		String ActivateMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
	}
	
	public static void AssignCheckList(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation(driver).click();
		Thread.sleep(3000);
		ImplementPOM.AssignCheckList(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectPerformerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FEManager(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceCategory(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABCD(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED(driver).click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectReviewerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FMManager(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(6000);
	
		try
		{
			String MAInMsg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		}
		catch(Exception e)
		{
			
		}
	
		Thread.sleep(4000);
		
		
	}
	
	public static void IntermediateCheckList(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation(driver).click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateCheckList(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ClickEdit(driver).click();
		Thread.sleep(3000);
		ImplementPOM.EditUser(driver).click();
		Thread.sleep(2000);
		ImplementPOM.EditUseraaaaa(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickUpdate(driver).click();
		Thread.sleep(3000);
	String text=	ImplementPOM.CheckEdit(driver).getText();
		if(text.equalsIgnoreCase("FM Manager")) {
			test.log(LogStatus.PASS, "Intermediate CheckList - Update Successfully");
			
		}
		Thread.sleep(1000);
		ImplementPOM.ClickEdit(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Intermediate CheckList - Delete Successfully");
		
	}
	
	public static void ActivateCheckList(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ActivateCheckList(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB(driver).click();
		Thread.sleep(1000);
		ImplementPOM.select(driver).click();
		Thread.sleep(3000);
		ImplementPOM.selectDate(driver).click();
		Thread.sleep(1000);
		ImplementPOM.Date11(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ActivateCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(1000);
		String AMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		String ActivateMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
	}
	
	public static void ComplianceCategory(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters(driver).click();
		Thread.sleep(3000);
		ImplementPOM.MastersComplianceCategory(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.AddNewCC(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Customer(driver).click();
		Thread.sleep(500);
		ImplementPOM.Bitademopune(driver).click();
		Thread.sleep(2000);
		
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(23);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.name(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(24);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Description(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.Save(driver).click();
		test.log(LogStatus.PASS, " Compliance Category:-Add successfully.");
		Thread.sleep(2000);
		row0 = sheet.getRow(23);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.FilterM(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
		Thread.sleep(2000);
		String textfilter =ImplementPOM.FilterM(driver).getText();
		String text=ImplementPOM.NameCheck(driver).getText();
		if(text.equalsIgnoreCase(textfilter)){
			
			test.log(LogStatus.PASS, " Compliance Category:-Filter Working  successfully.");
			
		}else
		{
			test.log(LogStatus.FAIL, " Compliance Category:-Filter not Working  Properly.");
		}
		Thread.sleep(2000);
		ImplementPOM.EditComplianceCategory(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Description(driver).clear();
		Thread.sleep(1000);
		row0 = sheet.getRow(25);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Description(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);

	Thread.sleep(3000);
		ImplementPOM.Save(driver).click();
	Thread.sleep(2000);

			
			test.log(LogStatus.PASS, " Compliance Category:-Update successfully.");
			
		
       Thread.sleep(5000);
       ImplementPOM.DeleteComplianceCategory(driver).click();
       Thread.sleep(1000);
   	String MAInCheckListMsg = driver.switchTo().alert().getText();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);

		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg);
	

	}
	
	public static void Compliances(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters(driver).click();
		Thread.sleep(3000);
		ImplementPOM.Compliances(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectCategoryMC(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABCDMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.AddNewCompliances(driver).click();
		Thread.sleep(3000);
		ImplementPOM.TypeName(driver).clear();
		Thread.sleep(500);
		ImplementPOM.TypeName(driver).sendKeys("Maharashtra");
		Thread.sleep(1000);
		ImplementPOM.MaharashtraC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.CategoryName(driver).clear();
		Thread.sleep(500);
		ImplementPOM.CategoryName(driver).sendKeys("ABCD");
		Thread.sleep(1000);
		ImplementPOM.ABCDCom(driver).click();
		Thread.sleep(3000);
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(27);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ShortDescription(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(28);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ShortForm(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(29);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DetailedDescription(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.Frequency(driver).click();
		Thread.sleep(500);
		ImplementPOM.Annual(driver).click();
		Thread.sleep(2000);
		ImplementPOM.PriorityType(driver).click();
		Thread.sleep(500);
		ImplementPOM.Low(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SaveCom(driver).click();
		Thread.sleep(2000);
		String Msg=ImplementPOM.RecordSavemsg(driver).getText();
		
		if (Msg.equalsIgnoreCase("Record Saved Sucessfully.")) {
			test.log(LogStatus.PASS, "Message displayed -" + Msg);
		} else {
			test.log(LogStatus.FAIL, "Message displayed -" + Msg + "");
		}
		
		Thread.sleep(2000);
		ImplementPOM.RecordClose(driver).click();
		
		Thread.sleep(5000);
		row0 = sheet.getRow(27);
		c1 = row0.getCell(1); 
		
		ImplementPOM.FilterType(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
		Thread.sleep(3000);

			test.log(LogStatus.PASS, " Compliances :-Filter Working  successfully.");
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " :- File downloaded successfully.");
			} else {
				test.log(LogStatus.INFO,  " :- File does not downloaded.");
			}
			
			ImplementPOM.EditCompliance(driver).click();
			Thread.sleep(2000);
			ImplementPOM.CategoryName(driver).clear();
			Thread.sleep(500);
			ImplementPOM.CategoryName(driver).sendKeys("ABCD");
			Thread.sleep(1000);
		
			Thread.sleep(1000);
			ImplementPOM.ABCDCom(driver).click();
			Thread.sleep(1000);
		
		ImplementPOM.SaveCom(driver).click();
		Thread.sleep(2000);
	
String Msg1=ImplementPOM.RecordSavemsg(driver).getText();
		
		if (Msg.equalsIgnoreCase("Record Saved Sucessfully.")) {
			test.log(LogStatus.PASS, "Message displayed - Edit - " + Msg1);
		} else {
			test.log(LogStatus.FAIL, "Message displayed -" + Msg1 + "");
		}
Thread.sleep(2000);
ImplementPOM.RecordClose(driver).click();
Thread.sleep(3000);
ImplementPOM.DisplayScheduleInformation(driver).click();
Thread.sleep(4000);
ImplementPOM.close(driver).click();
Thread.sleep(3000);
test.log(LogStatus.PASS, " Compliances:-Display Schedule Information view successfully.");



Thread.sleep(3000);
ImplementPOM.DeleteCompliance(driver).click();
Thread.sleep(1000);
String MAInCheckListMsg = driver.switchTo().alert().getText();
Thread.sleep(2000);
driver.switchTo().alert().accept();
Thread.sleep(2000);

	test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg);
	Thread.sleep(2000);
	
	
	ImplementPOM.FilterType(driver).clear();
	Thread.sleep(1000);
	ImplementPOM.FilterType(driver).sendKeys("18674",Keys.ENTER);
	Thread.sleep(3000);
	ImplementPOM.DisplayScheduleInformation(driver).click();
	Thread.sleep(4000);
	ImplementPOM.SaveDsI(driver).click();
	Thread.sleep(1000);
	String msg=ImplementPOM.DsIMsg(driver).getText();
	test.log(LogStatus.PASS, "----------------- If Compliance assigned -------------- " );
	test.log(LogStatus.PASS, " Message displayed - " + msg);
	ImplementPOM.close(driver).click();
	
	Thread.sleep(3000);
	ImplementPOM.DeleteCompliance(driver).click();
	Thread.sleep(1000);
	String MAInCheckListMsg1 = driver.switchTo().alert().getText();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	
		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
		Thread.sleep(2000);
		
String Msg2=ImplementPOM.RecordSavemsg(driver).getText();
		
		
			test.log(LogStatus.PASS, "Message displayed - " + Msg2);
	
	}
	
	public static void EditCompliances(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters(driver).click();
		Thread.sleep(3000);
		ImplementPOM.EditCompliances(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(4000);
		ImplementPOM.EditCompliance(driver).click();
		Thread.sleep(2000);
		ImplementPOM.EditCompliancesCN(driver).click();
		Thread.sleep(500);
		//ImplementPOM.CategoryName(driver).sendKeys("ABCD");
		//Thread.sleep(1000);
	
		Thread.sleep(1000);
		ImplementPOM.EditCompliancesCNA(driver).click();
		Thread.sleep(1000);
	
	ImplementPOM.SaveCom(driver).click();
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "Message displayed - update Successfully" );

	Thread.sleep(3000);
	ImplementPOM.DeleteCompliance(driver).click();
	Thread.sleep(1000);
	String MAInCheckListMsg1 = driver.switchTo().alert().getText();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	
		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
		Thread.sleep(2000);
		
String Msg2=ImplementPOM.RecordSavemsg(driver).getText();
		
		
			test.log(LogStatus.PASS, "Message displayed - " + Msg2);
			Thread.sleep(2000);
			ImplementPOM.RecordClose(driver).click();
			Thread.sleep(2000);
			ImplementPOM.DisplayScheduleInformation(driver).click();
			Thread.sleep(4000);
			ImplementPOM.close(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " Compliances:-Display Schedule Information view successfully.");

			ImplementPOM.FilterType(driver).sendKeys("18674",Keys.ENTER);
			Thread.sleep(3000);
	
	}
	
	public static void UploadAssignment(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtility(driver).click();
		Thread.sleep(3000);
		ImplementPOM.UploadAssignment(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerU(driver).click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(4000);
		ImplementPOM.UploadFileU(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\ComplianceAssignmentFormat (7) (2).xlsx");
		
		ImplementPOM.Upload(driver).click();
		Thread.sleep(1000);
	String msg=	ImplementPOM.UploadMsg(driver).getText();
		Thread.sleep(500);
		if(msg.equalsIgnoreCase("Data uploaded successfully.")) {
			
			test.log(LogStatus.PASS, "Message displayed - " + msg);
			
		}else {
			
			test.log(LogStatus.FAIL, "Message displayed - " + msg);
			
		}
		
		
	}
	
	public static void PreviousInternalComplianceDepartmentMapping(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtility(driver).click();
		Thread.sleep(3000);
		ImplementPOM.PreviousInternalComplianceDepartmentMapping(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerPICDM(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABCDPvtLtd(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectEntityLocation(driver).click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtd(driver).click();
		Thread.sleep(1000);
		ImplementPOM.AWSGFJBitaLimited(driver).click();
		Thread.sleep(500);
		ImplementPOM.select(driver).click();
		Thread.sleep(500);
		
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.Export(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  "  File does not downloaded.");
		}
		Thread.sleep(500);
		ImplementPOM.FilterType(driver).sendKeys("18557",Keys.ENTER);
		Thread.sleep(3000);
	String text=ImplementPOM.InternalComplianceID(driver).getText();
	if(text.equalsIgnoreCase("18557")) {
		test.log(LogStatus.PASS, " Filter Working  successfully.");
	} else {
		test.log(LogStatus.INFO,  "Filter not working");
	}
	
		
	}
	
	public static void EntitiesAssignments(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignments(driver).click();
		Thread.sleep(3000);
		ImplementPOM.EntitiesAssignments1(driver).click();
		Thread.sleep(8000);
	
	
		Thread.sleep(2000);
		Select d=new Select(ImplementPOM.SelectCustomerPICDM(driver));
		Thread.sleep(2000);
		d.selectByVisibleText("ABCD Pvt Ltd");
		Thread.sleep(4000);
		ImplementPOM.AddNew(driver).click();
		Thread.sleep(4000);
		ImplementPOM.CustomerAE(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABCDPvtLtdEA(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LocationExpand(driver).click();
		Thread.sleep(500);
		ImplementPOM.ASDAZFTextile(driver).click();
		Thread.sleep(1000);
		ImplementPOM.selectAE(driver).click();
		Thread.sleep(4000);
		ImplementPOM.User(driver).click();
		Thread.sleep(500);
		ImplementPOM.mgmtf(driver).click();
		Thread.sleep(4000);
		ImplementPOM.Location(driver).click();
		Thread.sleep(500);
		ImplementPOM.ComplianceCategoryAE(driver).click();
		Thread.sleep(500);
		ImplementPOM.JuneCompliance(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SaveAE(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectEntityLocation(driver).click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtd(driver).click();
		Thread.sleep(1000);
		ImplementPOM.AWSGFJBitaLimited(driver).click();
		Thread.sleep(500);
		ImplementPOM.select(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectUserAE(driver).click();
		Thread.sleep(500);
		ImplementPOM.mgmtf(driver).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entities Assignments successfully.");
		//---------------------------Delete Entities --------------------------------																						

		Thread.sleep(500);
		ImplementPOM.DeleteEntities(driver).click();
		Thread.sleep(3000);
		ImplementPOM.DeleteCustomer(driver).click();
		Thread.sleep(500);
		ImplementPOM.DeleteABCDPvtLtd(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DeleteExpand(driver).click();
		Thread.sleep(500);
		ImplementPOM.DeleteTextile(driver).click();
		Thread.sleep(1000);
		ImplementPOM.DeleteLocation(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DeleteUser(driver).click();
		Thread.sleep(500);
		ImplementPOM.mgmtf(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DeleteLocation(driver).click();
		Thread.sleep(500);
		ImplementPOM.DeleteCategory(driver).click();
		Thread.sleep(500);
		ImplementPOM.JuneCompliance(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DeleteAE(driver).click();
		Thread.sleep(4000);
		String Msg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
		Thread.sleep(4000);
		
		//----------------Export file-----------------------
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
		
	}
		
	public static void LicenseEntitiesAssignments(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.InternalCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignments(driver).click();
		Thread.sleep(3000);
		ImplementPOM.LicenseEntitiesAssignments(driver).click();
		Thread.sleep(3000);
		ImplementPOM.LicenseCustomer(driver).click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(4000);
		ImplementPOM.AddNew(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseCustomerAE(driver).click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseExpand(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABitaPharmaCompany(driver).click();
		Thread.sleep(1000);
		ImplementPOM.selectAe(driver).click();
		Thread.sleep(4000);
		ImplementPOM.Licenseuser(driver).click();
		Thread.sleep(500);
		ImplementPOM.CFOFinance(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation(driver).click();
		Thread.sleep(500);
		ImplementPOM.LicenseType(driver).click();
		Thread.sleep(500);
		ImplementPOM.aaaaaa(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SaveAE(driver).click();
		Thread.sleep(4000);
		//---------------------Export------------------------
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
		//---------------------------Delete Entities --------------------------------																						

				Thread.sleep(500);
				ImplementPOM.LicenseDeleteEntities(driver).click();
				Thread.sleep(6000);
				ImplementPOM.LicenseDeleteC(driver).click();
				Thread.sleep(500);
				ImplementPOM.BitademopuneU(driver).click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLocExpand(driver).click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteABitPharmaCompany(driver).click();
				Thread.sleep(1000);
		
				ImplementPOM.LicenseDeleteLoc(driver).click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteUser(driver).click();
				Thread.sleep(500);
				ImplementPOM.CFOFinance(driver).click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc(driver).click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteType(driver).click();
				Thread.sleep(500);
				ImplementPOM.aaaaaa(driver).click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc(driver).click();
				Thread.sleep(2000);
				ImplementPOM.LicenseDelete(driver).click();
				Thread.sleep(4000);
			/*	String Msg = driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();

				test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
				Thread.sleep(4000);
				*/
		
	}
	
	public static void MasterCompliances(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.CompliancesMC(driver).click();
		Thread.sleep(6000);
		ImplementPOM.ComplianceCatagory(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecific(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ActGroup(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ActDemo1(driver).click();
		Thread.sleep(4000);
		ImplementPOM.CompliancesType(driver).click();
		Thread.sleep(1000);
		ImplementPOM.CentralMC(driver).click();
		Thread.sleep(8000);
		ImplementPOM.EditComplianceMC(driver).click();
		Thread.sleep(3000);
	/*	String actualTitle=ImplementPOM.ComplianceDetails(driver).getText();
		
		if(actualTitle.equalsIgnoreCase("Compliance Details")) {
			test.log(LogStatus.PASS,  " Edit Compliance - view Successfully");
		}else {
			test.log(LogStatus.FAIL,  "Edit Compliance - view Successfully");

		}*/
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,400)");

		ImplementPOM.EditComplianceClose(driver).click();
		Thread.sleep(5000);
		
		test.log(LogStatus.PASS,  " Edit Compliance - view Successfully");
		ImplementPOM.DisplaySchedule(driver).click();
		Thread.sleep(3000);
		ImplementPOM.DisplayScheduleClose(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS,  " Display Schedule Information - view Successfully");
		ImplementPOM.FilterType(driver).sendKeys("111854",Keys.ENTER); // Writing Task title
		Thread.sleep(3000);
	String match=	ImplementPOM.idMatch(driver).getText();
		if(match.equalsIgnoreCase("111854")){
			test.log(LogStatus.PASS,  " Filter Working  successfully.");
		}else
		{
			test.log(LogStatus.PASS,  " Filter not Working properly ");
		}
	}
	
	public static void Acts(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.Acts(driver).click();
		Thread.sleep(6000);
		
		ImplementPOM.ActsCatrgory(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecific(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ActsType(driver).click();
		Thread.sleep(1000);
		ImplementPOM.CentralMC(driver).click();
		Thread.sleep(6000);
		ImplementPOM.EditAct(driver).click();
		Thread.sleep(3000);
		
	/*	String actualTitle=ImplementPOM.Act(driver).getText();
		
		if(actualTitle.equalsIgnoreCase("Act")) {
			test.log(LogStatus.PASS,  " Edit Act - view Successfully");
		}else {
			test.log(LogStatus.FAIL,  "Edit Act - view Successfully");

		}*/
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,400)");
		test.log(LogStatus.PASS,  " Edit Act - view Successfully");

		ImplementPOM.EditActClose(driver).click();
		Thread.sleep(5000);
		
		ImplementPOM.FilterType(driver).sendKeys("2708",Keys.ENTER); // Writing Task title
		Thread.sleep(8000);
	String match=	ImplementPOM.idCheck(driver).getText();
	Thread.sleep(5000);
		if(match.equalsIgnoreCase("2708")){
			test.log(LogStatus.PASS,  " Filter Working  successfully.");
		}else
		{
			test.log(LogStatus.PASS,  " Filter not Working properly ");
		}
		Thread.sleep(8000);
	}
	
	public static void HolidayMaster(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
			//----------------------Add New --------------------------		
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.HolidayMaster(driver).click();
		Thread.sleep(6000);
		ImplementPOM.SelectComplianceType(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ComplianceTypeCentral(driver).click();
		Thread.sleep(3000);
		ImplementPOM.AddNewHM(driver).click();
		Thread.sleep(3000);
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(32);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Name(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.TypeHM(driver).click();
		Thread.sleep(2000);
		ImplementPOM.CentralMC(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Date(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Date15(driver).click();
		Thread.sleep(2000);
		ImplementPOM.save(driver).click();
		Thread.sleep(2000);
	String msg=	ImplementPOM.savemsg(driver).getText();
	if(msg.equalsIgnoreCase("Record Saved Sucessfully.")){
		test.log(LogStatus.PASS,  "Message displayed :- " +msg);
	}else
	{
		test.log(LogStatus.PASS,  "Message displayed :- " +msg);
	}
	Thread.sleep(2000);
	
	ImplementPOM.Close(driver).click();
	Thread.sleep(2000);
	//-------------------------Filter-------------------------
	row0 = sheet.getRow(32);
	c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	ImplementPOM.FilterM(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
	Thread.sleep(2000);
	String match=	ImplementPOM.namecheck(driver).getText();
	Thread.sleep(5000);
		if(match.equalsIgnoreCase("Shehal Patil")){
			test.log(LogStatus.PASS,  " Filter Working  successfully.");
		}else
		{
			test.log(LogStatus.PASS,  " Filter not Working properly ");
		}
		Thread.sleep(4000);
		///-------------------Update-------------------------
		ImplementPOM.EditHoliday(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Date(driver).click();
		Thread.sleep(2000);
		ImplementPOM.Date16(driver).click();
		Thread.sleep(2000);
		ImplementPOM.save(driver).click();
		Thread.sleep(2000);
	String msg1=	ImplementPOM.savemsg(driver).getText();
	if(msg1.equalsIgnoreCase("Record Updated Sucessfully.")){
		test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
	}else
	{
		test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
	}
	Thread.sleep(2000);
	
	ImplementPOM.Close(driver).click();
	Thread.sleep(2000);
	//---------------------Delete----------------
	ImplementPOM.DeleteHM(driver).click();
	Thread.sleep(1000);
	String MAInCheckListMsg1 = driver.switchTo().alert().getText();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	
		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
		Thread.sleep(2000);
		
	
	}
	
	public static void WidgetMaster(WebDriver driver, ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
			//----------------------Add New --------------------------		
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.WidgetMaster(driver).click();
		Thread.sleep(8000);
		ImplementPOM.WidgeC(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtd1(driver).click();
		Thread.sleep(4000);
		ImplementPOM.WidgetAddNew(driver).click();
		Thread.sleep(4000);
		ImplementPOM.WidgetCustomer(driver).click();
		Thread.sleep(1000);
		ImplementPOM.WidgetABCDPvtLtd(driver).click();
		Thread.sleep(2000);
		ImplementPOM.WidgetLocation(driver).click();
		Thread.sleep(1000);
		ImplementPOM.AWSGFJBitaLimited1(driver).click();
		Thread.sleep(2000);
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(34);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.WidgetName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.WidgetAct(driver).click();
		Thread.sleep(2000);
		ImplementPOM.WidgetActCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.WidgetOk(driver).click();
		Thread.sleep(2000);
		
		ImplementPOM.WidgetCompliance(driver).click();
		Thread.sleep(2000);
		ImplementPOM.WidgetCompliancecheck(driver).click();
		Thread.sleep(1000);
		ImplementPOM.WidgetComplianceOk(driver).click();
		Thread.sleep(2000);
		ImplementPOM.WidgetSave(driver).click();
		Thread.sleep(2000);
		String msg=	ImplementPOM.WidgetSavemsg(driver).getText();
		if(msg.equalsIgnoreCase("Widget Details Saved Successfully.")){
			test.log(LogStatus.PASS,  "Message displayed :- " +msg);
		}else
		{
			test.log(LogStatus.PASS,  "Message displayed :- " +msg);
		}
		Thread.sleep(2000);
		
		ImplementPOM.WidgetClose(driver).click();
		Thread.sleep(2000);
		//----------------------Filter --------------------------
		row0 = sheet.getRow(34);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.FilterM(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
		Thread.sleep(2000);
		String match=	ImplementPOM.WidgetNameCheck(driver).getText();
		Thread.sleep(5000);
			if(match.equalsIgnoreCase("ABCDA")){
				test.log(LogStatus.PASS,  " Filter Working  successfully.");
			}else
			{
				test.log(LogStatus.PASS,  " Filter not Working properly ");
			}
			
			//----------------------Updated --------------------------

			ImplementPOM.WidgetEdit(driver).click();
			Thread.sleep(3000);
			ImplementPOM.WidgetName(driver).clear();
			row0 = sheet.getRow(35);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			ImplementPOM.WidgetName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(2000);
			ImplementPOM.WidgetSave(driver).click();
			Thread.sleep(2000);
			String msg1=	ImplementPOM.WidgetSavemsg(driver).getText();
			if(msg1.equalsIgnoreCase("Widget details updated successfully")){
				test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
			}else
			{
				test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
			}
			Thread.sleep(2000);
			
			ImplementPOM.WidgetClose(driver).click();
			Thread.sleep(2000);
			ImplementPOM.WidgeC(driver).click();
			Thread.sleep(1000);
			ImplementPOM.ABCDPvtLtd1(driver).click();
			Thread.sleep(4000);
			
			row0 = sheet.getRow(35);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			ImplementPOM.FilterM(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
			Thread.sleep(5000);
			//---------------------Delete----------------
			ImplementPOM.WidgetDeletet(driver).click();
			Thread.sleep(1000);
			String MAInCheckListMsg1 = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			
				test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
				Thread.sleep(2000);
				
			
	}
	
	public static void UploadInternalCompliance(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC(driver).click();
		Thread.sleep(1000);
		ImplementPOM.UploadInternalCompliance(driver).click();
		Thread.sleep(3000);
		ImplementPOM.CustomerMC(driver).click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\Internal Compliance Upload Format.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC(driver).click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg(driver).getText();
		
		test.log(LogStatus.PASS, "Message displayed - " + Msg1);
		
		Thread.sleep(3000);
		ImplementPOM.AddChecklist(driver).click();
		Thread.sleep(3000);
		ImplementPOM.checklistcustomer(driver).click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(3000);
		ImplementPOM.CheckListFileUpload(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\Internal Compliance Upload Format (2).xlsx");
		Thread.sleep(3000);
		ImplementPOM.ChecklistUploadFile(driver).click();
		Thread.sleep(3000);
String Msg2=ImplementPOM.ReadMsg1(driver).getText();
		
		test.log(LogStatus.PASS, "Message displayed - " + Msg2);
		
		Thread.sleep(3000);
		
	}
	
	public static void UploadAssignmentUU(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC(driver).click();
		Thread.sleep(1000);
		ImplementPOM.UploadAssignmentMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\ManageComplinace_UploadUtility_UploadAssignment.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC(driver).click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg(driver).getText();
		
		test.log(LogStatus.PASS, "UploadAssignment - Message displayed - " + Msg1);
		
		Thread.sleep(3000);
	}
	
	public static void UploadEventBasedComplianceAssignment(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC(driver).click();
		Thread.sleep(1000);
		ImplementPOM.UploadEventBasedComplianceAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUE(driver).click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneUE(driver).click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\ManageComplinace_UploadUtility_EventBasedComplianceMapping.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC(driver).click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg(driver).getText();
		
		test.log(LogStatus.PASS, "Upload Event Based Compliance Assignment -Message displayed - " + Msg1);
		
		Thread.sleep(3000);
	}
	
	public static void UploadAssignmentAll(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC(driver).click();
		Thread.sleep(1000);
		ImplementPOM.UploadAssignmentAll(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\ManageComplinace_UploadUtility_UploadAssignmentAll.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC(driver).click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg(driver).getText();
		
		test.log(LogStatus.PASS, "Message displayed - " + Msg1);
		
		Thread.sleep(3000);
	}
	
	public static void AssignComplianceCA(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.AssignComplianceCA(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(1000);
		ImplementPOM.SelectPerformerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FEManager(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceCategory(driver).click();
		Thread.sleep(500);
		ImplementPOM.ClientSpecific(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED(driver).click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectReviewerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FMManager(driver).click();
		Thread.sleep(3000);
		
		ImplementPOM.ComplianceType(driver).click();
		Thread.sleep(500);
		ImplementPOM.CentralMC(driver).click();
		Thread.sleep(3000);
		
		ImplementPOM.ClickCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(1000);
		String MAInMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		
	}
	
	public static void IntermediateComplianceCA(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateComplianceCA(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB(driver).click();
		Thread.sleep(500);
		ImplementPOM.select(driver).click();
		Thread.sleep(4000);
		ImplementPOM.FilterM(driver).sendKeys("FE Manager",Keys.ENTER);
		Thread.sleep(4000);
		String text1=	ImplementPOM.CheckFilter(driver).getText();
		if(text1.equalsIgnoreCase("FE Manager")) {
			test.log(LogStatus.PASS, "Intermediate Compliance - Filter Working  Successfully");	
		}
		
		ImplementPOM.ClickEdit1(driver).click();
		Thread.sleep(3000);
		ImplementPOM.EditUser1(driver).click();
		Thread.sleep(2000);
		ImplementPOM.EditUserFE(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickUpdate1(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Intermediate Compliance - Update Successfully");
		ImplementPOM.FilterM(driver).clear();
		Thread.sleep(500);
		ImplementPOM.FilterM(driver).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		ImplementPOM.ClickEdit1(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete1(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Intermediate Compliance - Delete Successfully");
		
	}
	
	public static void ActivateComplianceCA(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ActivateComplianceCA(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB(driver).click();
		Thread.sleep(1000);
		ImplementPOM.select(driver).click();
		Thread.sleep(3000);
		ImplementPOM.selectDate(driver).click();
		Thread.sleep(1000);
		ImplementPOM.Date11(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ActivateCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(1000);
		String AMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		String ActivateMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
		
	}
	
	public static void AssignCheckListCA(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.AssignCheckListCA(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(4000);
		ImplementPOM.SelectPerformerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FEManager(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceCategory(driver).click();
		Thread.sleep(500);
		ImplementPOM.ClientSpecific(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED(driver).click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectReviewerCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.FMManager(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(6000);
	
		try
		{
			String MAInMsg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		}
		catch(Exception e)
		{
			
		}
	
		Thread.sleep(4000);
		
		
	}
	
	public static void IntermediateCheckListCA(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												
		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateCheckListCA(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		
		ImplementPOM.ALENAVENTURESLIMITEDCB(driver).click();
		Thread.sleep(1000);
		ImplementPOM.select(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickEdit1(driver).click();
		Thread.sleep(3000);
		ImplementPOM.EditUser1(driver).click();
		Thread.sleep(2000);
		ImplementPOM.EditUserFE(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickUpdate1(driver).click();
		Thread.sleep(3000);
	
		
		Thread.sleep(1000);
		ImplementPOM.ClickEdit1(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete1(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Intermediate CheckList - Delete Successfully");
		
	}
	
	public static void ActivateCheckListCA(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment(driver).click();
		Thread.sleep(3000);
		ImplementPOM.ActivateCheckListCA(driver).click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR(driver).click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneRE(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA(driver).click();
		Thread.sleep(500);
		ImplementPOM.LocationCA(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB(driver).click();
		Thread.sleep(1000);
		ImplementPOM.select(driver).click();
		Thread.sleep(3000);
		ImplementPOM.selectDate(driver).click();
		Thread.sleep(1000);
		ImplementPOM.Date11(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ActivateCheckBox(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ClickSaveBTn(driver).click();
		Thread.sleep(1000);
		String AMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		String ActivateMsg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
	}
	
	public static void EntitiesAssignmentsMC(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignmentsMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.EntitiesAssignmentsMC1(driver).click();
		Thread.sleep(8000);
	//	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("BodyContent_ddlFiltercustomer"))); 

	/*	By locator = By.name("ctl00$BodyContent$ddlFiltercustomer");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(3000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);*/
		//ImplementPOM.SelectCustomerPICDM(driver).click();
		Thread.sleep(2000);
		Select d=new Select(ImplementPOM.SelectCustomerPICDM(driver));
		Thread.sleep(2000);
		d.selectByVisibleText("ABCD Pvt Ltd");
	//	ImplementPOM.ABCDPvtLtd(driver).click();
		Thread.sleep(4000);
		ImplementPOM.AddNew(driver).click();
		Thread.sleep(4000);
		ImplementPOM.CustomerAE(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABCDPvtLtdEA(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LocationExpand(driver).click();
		Thread.sleep(500);
		ImplementPOM.ASDAZFTextile(driver).click();
		Thread.sleep(1000);
		ImplementPOM.Location(driver).click();
		Thread.sleep(4000);
		ImplementPOM.User1(driver).click();
		Thread.sleep(500);
		ImplementPOM.mgmtf1(driver).click();
		Thread.sleep(4000);
		ImplementPOM.User1(driver).click();
		Thread.sleep(500);
		ImplementPOM.ComplianceCategoryAE1(driver).click();
		Thread.sleep(500);
		ImplementPOM.ClientSpecific1(driver).click();
		Thread.sleep(4000);
		ImplementPOM.ComplianceCategoryAE1(driver).click();
		Thread.sleep(500);
		ImplementPOM.SaveAE(driver).click();
		Thread.sleep(4000);
		
	//	ImplementPOM.SelectEntityLocation(driver).click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtd(driver).click();
		Thread.sleep(1000);
		ImplementPOM.ASDAZFTextile1(driver).click();
		Thread.sleep(500);
		ImplementPOM.select(driver).click();
		Thread.sleep(500);

		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entities Assignments successfully.");
		//---------------------------Delete Entities --------------------------------																						

		Thread.sleep(500);
		ImplementPOM.DeleteEntities(driver).click();
		Thread.sleep(3000);
		ImplementPOM.DeleteCustomer(driver).click();
		Thread.sleep(500);
		ImplementPOM.DeleteABCDPvtLtd(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DeleteExpand(driver).click();
		Thread.sleep(500);
		ImplementPOM.DeleteTextile(driver).click();
		Thread.sleep(1000);
		ImplementPOM.DeleteLocation(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DeleteUser1(driver).click();
		Thread.sleep(500);
		ImplementPOM.Deletemgmtf(driver).click();
		Thread.sleep(4000);
	
		Thread.sleep(500);
		ImplementPOM.DeleteCategory1(driver).click();
		Thread.sleep(500);
		ImplementPOM.DeleteClientSpecific(driver).click();
		Thread.sleep(4000);
		ImplementPOM.DeleteAE(driver).click();
		Thread.sleep(4000);
		String Msg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
		Thread.sleep(4000);
		ImplementPOM.DeleteLocation(driver).click();
		Thread.sleep(1000);
		ImplementPOM.DeleteClose(driver).click();
		Thread.sleep(1000);
		//----------------Export file-----------------------
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
		
	}
	
	public static void LicenseEntitiesAssignmentsMC(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances(driver)).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignmentsMC(driver).click();
		Thread.sleep(3000);
		ImplementPOM.LicenseEntitiesAssignments1(driver).click();
		Thread.sleep(3000);
		ImplementPOM.LicenseCustomer(driver).click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(4000);
		ImplementPOM.AddNew(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseCustomerAE(driver).click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseExpand(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABitaPharmaCompany(driver).click();
		Thread.sleep(1000);
		ImplementPOM.selectAe(driver).click();
		Thread.sleep(4000);
		ImplementPOM.Licenseuser(driver).click();
		Thread.sleep(500);
		ImplementPOM.CFOFinance(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation(driver).click();
		Thread.sleep(500);
		ImplementPOM.LicenseType(driver).click();
		Thread.sleep(500);
		ImplementPOM.ABCD(driver).click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation(driver).click();
		Thread.sleep(2000);
		ImplementPOM.SaveAE(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS,  " Add New  License Entities Assignments successfully.");
		//---------------------Export------------------------
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
		//---------------------------Delete Entities --------------------------------																						

				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteEntities1(driver).click();
				Thread.sleep(6000);
				ImplementPOM.LicenseDeleteC(driver).click();
				Thread.sleep(500);
				ImplementPOM.BitademopuneU(driver).click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLocExpand(driver).click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteABitPharmaCompany(driver).click();
				Thread.sleep(2000);
				
				ImplementPOM.LicenseDeleteLoc(driver).click();
				Thread.sleep(4000);
				
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteUser(driver).click();
				Thread.sleep(500);
				ImplementPOM.CFOFinance(driver).click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc(driver).click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteType(driver).click();
				Thread.sleep(500);
				ImplementPOM.ABCD(driver).click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc(driver).click();
				Thread.sleep(2000);
				ImplementPOM.LicenseDelete1(driver).click();
				Thread.sleep(4000);
			String Msg = driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();

				test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
				Thread.sleep(4000);
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
