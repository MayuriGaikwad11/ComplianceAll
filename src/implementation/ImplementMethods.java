package implementation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import companyadmin.CompanyPOM;
import performer.OverduePOM;

public class ImplementMethods {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	

	
	public static void CreateCustomers( WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
			      Thread.sleep(1000);
			      ImplementPOM.clickCustomers(driver).click();
			      Thread.sleep(4000);
			      ImplementPOM.ClickAddNew(driver).click();
			      
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]")));	//Wait until records table get visible.
    	
    	ImplementPOM.clickServiceProvider(driver).click();
    	  
    	ImplementPOM.SelectAvantis(driver).click();
    	  Thread.sleep(5000);
    	  sheet = workbook.getSheetAt(13);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
			Cell c1 = null;
			row0= sheet.getRow(3);
			c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
			ImplementPOM.CustomerName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
			  Thread.sleep(4000);
			      
			row0= sheet.getRow(4);
			c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
			ImplementPOM.BuyerName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
			  Thread.sleep(4000);
			row0= sheet.getRow(5);
			c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
			int No = (int) c1.getNumericCellValue();
			ImplementPOM.BuyerContactNo(driver).sendKeys(""+No+"");	//Writing Task title
			  Thread.sleep(4000);
			row0= sheet.getRow(6);
			c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
			ImplementPOM.BuyerEmail(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
			  Thread.sleep(4000);
			ImplementPOM.ClickSave(driver).click();
			  Thread.sleep(4000);
			test.log(LogStatus.PASS, "Message displayed - 'Customer Saved Successfully'");
	}
	
	public static void CustomersAssignment( WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		  sheet = workbook.getSheetAt(13);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
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
					Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
					Cell c1 = null;
			      row0= sheet.getRow(3);
					c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
					ImplementPOM.SelectCustomer(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER);	//Writing Task title
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
							
							
							if(saveMsg.equalsIgnoreCase("Customer Assigned updated successfully"))
							{
								test.log(LogStatus.PASS, "Message displayed -" +saveMsg);
							}
							else
							{
								test.log(LogStatus.PASS, "Message displayed -" +saveMsg +"not Displayed");
							}
							 ImplementPOM.CloseCA(driver).click();
							 
							 Thread.sleep(5000);
						 
						//	 ImplementPOM.DeleteCA(driver).click();
						//	 test.log(LogStatus.PASS, "Delete Successfully");
							 ImplementPOM.FilterCA(driver).sendKeys("demo Final 7dec",Keys.ENTER);
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
						   //   ImplementPOM.Delete(driver).click();
						   //   Thread.sleep(5000);
						      ImplementPOM.Filter(driver).sendKeys("customer123",Keys.ENTER);
						      
						      test.log(LogStatus.PASS, " Customer- Filter Working  Successfully");
						      
						      Thread.sleep(5000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
