package implementation;

import java.io.File;
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
	
	public static void SubEntity( WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
			      Thread.sleep(3000);
			      ImplementPOM.clickCustomers(driver).click();
			      Thread.sleep(4000);
			      ImplementPOM.clickSubEntity(driver).click();
			      Thread.sleep(5000);
			      ImplementPOM.SubEntityAddNew(driver).click();
			      Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_tbxName']")));	//Wait until records table get visible.
			 sheet = workbook.getSheetAt(13);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
				Cell c1 = null;
				row0= sheet.getRow(8);
				c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
				ImplementPOM.EnterName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
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
				  
				  row0= sheet.getRow(9);
					c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
					ImplementPOM.AddressLine1(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
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
					    row0= sheet.getRow(10);
						c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
						ImplementPOM.ContactPerson(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
						  Thread.sleep(2000);
						  row0= sheet.getRow(11);
							c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
							ImplementPOM.ContactEmail(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
							  Thread.sleep(3000);
							  ImplementPOM.SaveSE(driver).click();
					    
							  Thread.sleep(4000);
							  test.log(LogStatus.PASS, " Sub Entity- Add New Branch Successfully");
							  Thread.sleep(1000);
							  row0= sheet.getRow(8);
								c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
								ImplementPOM.FilterSE(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER);	//Writing Task title
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
							String DeleteMsg=driver.switchTo().alert().getText();
							  Thread.sleep(2000);
							  driver.switchTo().alert().accept();
							  Thread.sleep(2000);
									
									
									if(DeleteMsg.equalsIgnoreCase("This will also delete all the sub-entities associated with current entity. Are you certain you want to delete this entity?"))
									{
										test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg);
									}
									else
									{
										test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg +"not Displayed");
									}
									
	}
	
	public static void Department( WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
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
			      sheet = workbook.getSheetAt(13);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
					int row = 0;
					Thread.sleep(500);
					Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
					Cell c1 = null;
					row0= sheet.getRow(13);
					c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
					ImplementPOM.DepartmentName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
					  Thread.sleep(2000);
			      
					  ImplementPOM.DepartmentSave(driver).click();
					  Thread.sleep(2000);
					String DeptSaveMsg= ImplementPOM.DepartmentSaveMsg(driver).getText();
					
					if(DeptSaveMsg.equalsIgnoreCase("Department saved successfully"))
					{
						test.log(LogStatus.PASS, "Message displayed -" +DeptSaveMsg);
					}
					else
					{
						test.log(LogStatus.PASS, "Message displayed - Department already exists");
					}
					Thread.sleep(2000);
					 ImplementPOM.DepartmentClose(driver).click();
					 Thread.sleep(3000);
					 row0= sheet.getRow(13);
						c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
						ImplementPOM.DepartFilter(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER);	//Writing Task title
						  Thread.sleep(4000);
						  test.log(LogStatus.PASS, " .Department-Filter Working Successfully");
						  
						  ImplementPOM.DepartEdit(driver).click();
						  Thread.sleep(4000);
						  ImplementPOM.DepartmentName(driver).clear();
						  Thread.sleep(2000);
						  row0= sheet.getRow(14);
							c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
							ImplementPOM.DepartmentName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
							  Thread.sleep(2000);
							  ImplementPOM.DepartmentSave(driver).click();
							  Thread.sleep(3000);
								String DeptUpdateMsg= ImplementPOM.DepartUpdateMsg(driver).getText();
								
								if(DeptUpdateMsg.equalsIgnoreCase("Department updated successfully"))
								{
									test.log(LogStatus.PASS, "Message displayed -" +DeptUpdateMsg);
								}
								else
								{
									test.log(LogStatus.PASS, "Message displayed - Department already exists");
								}
								
								Thread.sleep(2000);
								 ImplementPOM.DepartmentClose(driver).click();
								 Thread.sleep(3000);
								 
								 ImplementPOM.DepartDelete(driver).click();
								 String DeleteMsg=driver.switchTo().alert().getText();
								  Thread.sleep(2000);
								  driver.switchTo().alert().accept();
								  Thread.sleep(2000);
										
										
										if(DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Department Details?"))
										{
											test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg);
										}
										else
										{
											test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg +"not Displayed");
										}
													
	}
	
	public static void UserandBranchUpload( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
			   
			      Thread.sleep(4000);
			      ImplementPOM.ClickUserandBrach(driver).click();
			      Thread.sleep(4000);
			     
			      Select Customer=new Select(ImplementPOM.SelectCustomerUB(driver));
			      Thread.sleep(500);
			      Customer.selectByIndex(2);
			      Thread.sleep(500);
			      ImplementPOM.ClickUsers(driver).click();
			      Thread.sleep(500);
			      ImplementPOM.UploadFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\SampleUserBranchUploadFormat (1)A.xlsx");
			      Thread.sleep(1000);
			      
			      ImplementPOM.clickUpload(driver).click();
			      Thread.sleep(3000);
			  String UploadMsg =    ImplementPOM.UsersUploadMsg(driver).getText();
			  test.log(LogStatus.PASS, "Message displayed -" +UploadMsg);
			      Thread.sleep(3000);
			      Select Customer1=new Select(ImplementPOM.SelectCustomerUB(driver));
			      Thread.sleep(500);
			      Customer1.selectByIndex(2);
			      Thread.sleep(500);
			      ImplementPOM.ClickBranches(driver).click();
			      Thread.sleep(500);
			      ImplementPOM.UploadFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\SampleUserBranchUploadFormat (1)A.xlsx");
			      Thread.sleep(1000);
			      ImplementPOM.clickUpload(driver).click();
			      Thread.sleep(4000);
			      String UploadMsg1 =    ImplementPOM.UsersUploadMsg(driver).getText();
				  test.log(LogStatus.PASS, "Message displayed -" +UploadMsg1);
				      Thread.sleep(3000);
			  	      
	}
	
	public static void Users( WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
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
			      sheet = workbook.getSheetAt(13);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
					int row = 0;
					Thread.sleep(500);
					Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
					Cell c1 = null;
					row0= sheet.getRow(16);
					c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
					ImplementPOM.UsersEmail(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
					  Thread.sleep(2000);
					  row0= sheet.getRow(17);
						c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
						ImplementPOM.UsersFirstName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
						  Thread.sleep(2000);
						  row0= sheet.getRow(18);
							c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
							ImplementPOM.UsersLastName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
							  Thread.sleep(2000);
							  row0= sheet.getRow(19);
								c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
								ImplementPOM.UsersDesignation(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
								  Thread.sleep(2000);
								  row0= sheet.getRow(20);
									c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
									
									  int No = (int) c1.getNumericCellValue();
										ImplementPOM.UsersMobileNo(driver).sendKeys(""+No+"");	//Writing Task title
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
									  row0= sheet.getRow(17);
										c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
										ImplementPOM.DepartFilter(driver).sendKeys("ss",Keys.ENTER);	//Writing Task title
										  Thread.sleep(6000);
										  test.log(LogStatus.PASS, "User - Filter working Successfully");
										  ImplementPOM.ExportUser(driver).click();
										  Thread.sleep(2000);
										  test.log(LogStatus.PASS, "User - Export to excel Successfully");
										  ImplementPOM.UserEdit(driver).click();
										  Thread.sleep(3000);
										  ImplementPOM.UsersFirstName(driver).clear();
										  Thread.sleep(1000);
										  row0= sheet.getRow(21);
											c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
											ImplementPOM.UsersFirstName(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
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
											  String ResetPass=driver.switchTo().alert().getText();
											  Thread.sleep(2000);
											  driver.switchTo().alert().accept();
											  Thread.sleep(2000);
												
													if(ResetPass.equalsIgnoreCase("Are you certain you want to reset password for this user?"))
													{
														test.log(LogStatus.PASS, "Message displayed -" +ResetPass);
													}
													else
													{
														test.log(LogStatus.PASS, "Message displayed -" +ResetPass +"not Displayed");
													}
													 Thread.sleep(2000);
													 String ResetMsg=driver.switchTo().alert().getText();
													  Thread.sleep(2000);
													  driver.switchTo().alert().accept();
													  Thread.sleep(2000);
														
															if(ResetMsg.equalsIgnoreCase("Password reset successfully."))
															{
																test.log(LogStatus.PASS, "Message displayed -" +ResetMsg);
															}
															else
															{
																test.log(LogStatus.PASS, "Message displayed -" +ResetMsg +"not Displayed");
															}
															  Thread.sleep(4000);
											  
											  ImplementPOM.UserDelete(driver).click();
											  Thread.sleep(3000);
											  String DeleteMsg=driver.switchTo().alert().getText();
											  Thread.sleep(2000);
											  driver.switchTo().alert().accept();
											  Thread.sleep(2000);
												
													if(DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this User?"))
													{
														test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg);
													}
													else
													{
														test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg +"not Displayed");
													}
													 Thread.sleep(2000);
												
	}
	
	public static void productMapping( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
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
			      String Msg =    ImplementPOM.PMAddMsg(driver).getText();
				  
				      Thread.sleep(3000);
				      if(Msg.equalsIgnoreCase("Your details have been saved successfully."))
						{
							test.log(LogStatus.PASS, "Message displayed -" +Msg);
						}
						else
						{
							test.log(LogStatus.PASS, "Message displayed -Product & Customer name already exists.");
						}
			      
				      Thread.sleep(500);
			      
				      ImplementPOM.PMClose(driver).click();
				      Thread.sleep(3000);
				      ImplementPOM.DepartFilter(driver).sendKeys("PQR Pvt ltd",Keys.ENTER);
				      Thread.sleep(3000);
				      test.log(LogStatus.PASS, "Message displayed -Filter Working Successfully");
				      ImplementPOM.PMDelete(driver).click();
				      Thread.sleep(1000);
				      String DeleteMsg=driver.switchTo().alert().getText();
					  Thread.sleep(2000);
					  driver.switchTo().alert().accept();
					  Thread.sleep(2000);
						
							if(DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Product?"))
							{
								test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg);
							}
							else
							{
								test.log(LogStatus.PASS, "Message displayed -" +DeleteMsg +"not Displayed");
							}
							Thread.sleep(2000);
			      
	}
	
	public static void modifyAssignmentsReassign( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
			   
			      Thread.sleep(4000);
			      ImplementPOM.ModifyAssignments(driver).click();
			      Thread.sleep(4000);
			      
  //  --------------------------- Modify Assignments :- Statutory --------------------------------------
			      
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));	//Wait until records table get visible.
					 Thread.sleep(2000);
					ImplementPOM.SelectCustomerMA(driver).click();
					 ImplementPOM.SelectABCD(driver).click();
					  Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
			 Thread.sleep(2000);
			ImplementPOM.SelectUser(driver).click();
			 ImplementPOM.Selectaaa(driver).click();
			 Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
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
				 String MAMsg=driver.switchTo().alert().getText();
				  Thread.sleep(2000);
				  driver.switchTo().alert().accept();
				  Thread.sleep(2000);
					
						if(MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?"))
						{
							test.log(LogStatus.PASS, "Message displayed -Statutory - " +MAMsg);
						}
						else
						{
							test.log(LogStatus.PASS, "Message displayed -" +MAMsg +"not Displayed");
						}
						  Thread.sleep(4000);
						 
						  //  --------------------------- Modify Assignments :- Statutory :-Event Based --------------------------------------
				 Thread.sleep(7000);
				 ImplementPOM.ClickStaEventBased(driver).click();
				 Thread.sleep(5000);
				 ImplementPOM.CheckBox1(driver).click();
				 Thread.sleep(1000);
				 ImplementPOM.CheckBox2(driver).click();
				 Thread.sleep(4000);
				 ImplementPOM.ClicksaveBtn(driver).click();
				 String MAEventMsg=driver.switchTo().alert().getText();
				  Thread.sleep(2000);
				  driver.switchTo().alert().accept();
				  Thread.sleep(2000);
					
						if(MAEventMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?"))
						{
							test.log(LogStatus.PASS, "Message displayed -Event Based - " +MAEventMsg);
						}
						else
						{
							test.log(LogStatus.PASS, "Message displayed -" +MAEventMsg +"not Displayed");
						}
				 
						 //  --------------------------- Modify Assignments :- Statutory :-CheckList --------------------------------------
						 Thread.sleep(6000);
						 ImplementPOM.ClickStaCheckList(driver).click();
						 Thread.sleep(5000);
						 ImplementPOM.CheckBox1(driver).click();
						 Thread.sleep(1000);
						 ImplementPOM.CheckBox2(driver).click();
						 Thread.sleep(4000);
						 ImplementPOM.ClicksaveBtn(driver).click();
						 String MACheckListMsg=driver.switchTo().alert().getText();
						  Thread.sleep(2000);
						  driver.switchTo().alert().accept();
						  Thread.sleep(2000);
							
								if(MACheckListMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?"))
								{
									test.log(LogStatus.PASS, "Message displayed -CheckList " +MACheckListMsg);
								}
								else
								{
									test.log(LogStatus.PASS, "Message displayed -" +MACheckListMsg +"not Displayed");
								}
								
				  //  --------------------------- Modify Assignments :- Internal --------------------------------------
								 Thread.sleep(5000);
								ImplementPOM.ClickInternalRB(driver).click();
								Thread.sleep(5000);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));	//Wait until records table get visible.
								 Thread.sleep(2000);
								ImplementPOM.SelectCustomerMA(driver).click();
								 ImplementPOM.SelectBitademopune(driver).click();
								  Thread.sleep(5000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
						 Thread.sleep(2000);
						ImplementPOM.SelectUser(driver).click();
						 ImplementPOM.SelectASs(driver).click();
						 Thread.sleep(4000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
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
							 String MAInMsg=driver.switchTo().alert().getText();
							  Thread.sleep(2000);
							  driver.switchTo().alert().accept();
							  Thread.sleep(2000);
								
									if(MAInMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to aaa aa?"))
									{
										test.log(LogStatus.PASS, "Message displayed -Internal - " +MAInMsg);
									}
									else
									{
										test.log(LogStatus.PASS, "Message displayed -" +MAInMsg +"not Displayed");
									}
									  Thread.sleep(4000);
									  
									//  --------------------------- Modify Assignments :- Internal :-CheckList --------------------------------------
										 Thread.sleep(6000);
										 ImplementPOM.ClickStaCheckList(driver).click();
										 Thread.sleep(5000);
										 ImplementPOM.CheckINBox1(driver).click();
										 Thread.sleep(1000);
										 ImplementPOM.CheckINBox2(driver).click();
										 Thread.sleep(4000);
										 ImplementPOM.ClicksaveBtn(driver).click();
										 String MAInCheckListMsg=driver.switchTo().alert().getText();
										  Thread.sleep(2000);
										  driver.switchTo().alert().accept();
										  Thread.sleep(2000);
											
												if(MAInCheckListMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to aaa aa?"))
												{
													test.log(LogStatus.PASS, "Message displayed -Internal- CheckList " +MAInCheckListMsg);
												}
												else
												{
													test.log(LogStatus.PASS, "Message displayed -" +MAInCheckListMsg +"not Displayed");
												}
												
												 Thread.sleep(2000);
	
	}
	
	public static void modifyAssignmentsExclude( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
			   
			      Thread.sleep(4000);
			      ImplementPOM.ModifyAssignments(driver).click();
			      Thread.sleep(6000);
			      
  //  --------------------------- Modify Assignments :- Statutory :- Exclude --------------------------------------
			      ImplementPOM.ClickExclude(driver).click();
			      Thread.sleep(6000);
			      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));	//Wait until records table get visible.
					 Thread.sleep(2000);                                                      
					ImplementPOM.SelectCustomerMA(driver).click();
					 ImplementPOM.SelectBitademopune(driver).click();
					  Thread.sleep(8000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
						 Thread.sleep(5000);
						ImplementPOM.SelectUser(driver).click();
						Thread.sleep(1000);
						 ImplementPOM.SelectASs(driver).click();
						 Thread.sleep(8000);
						 ImplementPOM.CheckBox0(driver).click();
						 Thread.sleep(1000);
					//	 ImplementPOM.CheckBox2(driver).click();
						 Thread.sleep(5000);
						 ImplementPOM.ClicksaveBtn(driver).click();
						 Thread.sleep(3000);
						 String MAEMsg=driver.switchTo().alert().getText();
						  Thread.sleep(2000);
						  driver.switchTo().alert().accept();
						  Thread.sleep(2000);
							
								if(MAEMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?"))
								{
									test.log(LogStatus.PASS, "Message displayed -Statutory - Exclude" +MAEMsg);
								}
								else
								{
									test.log(LogStatus.PASS, "Message displayed -" +MAEMsg +"not Displayed");
								}
								  Thread.sleep(4000);
								  //  --------------------- Modify Assignments :- Statutory :-Exclude-Event Based --------------------------------------
									 Thread.sleep(7000);
									 ImplementPOM.ClickStaEventBased(driver).click();
									 Thread.sleep(5000);
									 ImplementPOM.CheckBox0(driver).click();
									 Thread.sleep(1000);
								//	 ImplementPOM.CheckBox2(driver).click();
									 Thread.sleep(4000);
									 ImplementPOM.ClicksaveBtn(driver).click();
									 String MAEEventMsg=driver.switchTo().alert().getText();
									  Thread.sleep(2000);
									  driver.switchTo().alert().accept();
									  Thread.sleep(2000);
										
											if(MAEEventMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?"))
											{
												test.log(LogStatus.PASS, "Message displayed -Event Based - Exclude " +MAEEventMsg);
											}
											else
											{
												test.log(LogStatus.PASS, "Message displayed -" +MAEEventMsg +"not Displayed");
											}
									 
											 //  --------------------------- Modify Assignments :- Statutory :-Exclude-CheckList --------------------------------------
											 Thread.sleep(5000);
											 ImplementPOM.ClickStaCheckList(driver).click();
											 Thread.sleep(5000);
											 ImplementPOM.CheckBox0(driver).click();
											 Thread.sleep(1000);
										//	 ImplementPOM.CheckBox2(driver).click();
											 Thread.sleep(4000);
											 ImplementPOM.ClicksaveBtn(driver).click();
											 String MAECheckListMsg=driver.switchTo().alert().getText();
											  Thread.sleep(2000);
											  driver.switchTo().alert().accept();
											  Thread.sleep(2000);
												
													if(MAECheckListMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for aaa aaa?"))
													{
														test.log(LogStatus.PASS, "Message displayed -CheckList -Exclude " +MAECheckListMsg);
													}
													else
													{
														test.log(LogStatus.PASS, "Message displayed -" +MAECheckListMsg +"not Displayed");
													}
													 ImplementPOM.ClickStaCheckList(driver).click();
					 //  --------------------------- Modify Assignments :- Internal- exclude --------------------------------------
													 Thread.sleep(5000);
													ImplementPOM.ClickInternalRB(driver).click();
													Thread.sleep(5000);
													wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));	//Wait until records table get visible.
													 Thread.sleep(2000);
													ImplementPOM.SelectCustomerMA(driver).click();
													 ImplementPOM.SelectBitademopune(driver).click();
													  Thread.sleep(3000);
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
											 Thread.sleep(2000);
											ImplementPOM.SelectUser(driver).click();
											 ImplementPOM.SelectASs(driver).click();
											 Thread.sleep(4000);
												
												 ImplementPOM.CheckINBox0(driver).click();
												// Thread.sleep(1000);
												// ImplementPOM.CheckINBox2(driver).click();
												 Thread.sleep(3000);
												 ImplementPOM.ClicksaveBtn(driver).click();
												 String MAInMsg=driver.switchTo().alert().getText();
												  Thread.sleep(2000);
												  driver.switchTo().alert().accept();
												  Thread.sleep(2000);
													
														if(MAInMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?"))
														{
															test.log(LogStatus.PASS, "Message displayed -Internal -exclude :- " +MAInMsg);
														}
														else
														{
															test.log(LogStatus.PASS, "Message displayed -" +MAInMsg +"not Displayed");
														}
														  Thread.sleep(4000);
					//  --------------------------- Modify Assignments :- Internal :-exclude:- CheckList --------------------------------------
															 Thread.sleep(6000);
															 ImplementPOM.ClickStaCheckList(driver).click();
															 Thread.sleep(5000);
															 ImplementPOM.CheckINBox0(driver).click();
															
															 Thread.sleep(3000);
															 ImplementPOM.ClicksaveBtn(driver).click();
															 String MAInCheckListMsg=driver.switchTo().alert().getText();
															  Thread.sleep(2000);
															  driver.switchTo().alert().accept();
															  Thread.sleep(2000);
																
																	if(MAInCheckListMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?"))
																	{
																		test.log(LogStatus.PASS, "Message displayed -Internal-exclude:- CheckList " +MAInCheckListMsg);
																	}
																	else
																	{
																		test.log(LogStatus.PASS, "Message displayed -" +MAInCheckListMsg +"not Displayed");
																	}
																	
																	 Thread.sleep(2000);
					  
	}
	
	public static void modifyAssignmentsTask( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.clickManageUser(driver)).click().build().perform();
			   
			      Thread.sleep(4000);
			      ImplementPOM.ModifyAssignments(driver).click();
			      Thread.sleep(4000);
			      
  //  --------------------------- Modify Assignments :- Statutory :-Task :-Reassign -------------------------------------
			      ImplementPOM.ClickTask(driver).click();
			      Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));	//Wait until records table get visible.
					 Thread.sleep(2000);
					ImplementPOM.SelectCustomerMA(driver).click();
					 ImplementPOM.SelectABCD(driver).click();
					  Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
			 Thread.sleep(2000);
			ImplementPOM.SelectUser(driver).click();
			 ImplementPOM.Selectaaa(driver).click();
			 Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
				Thread.sleep(5000);
				ImplementPOM.SelectNewPerformerUser(driver).click();
				 ImplementPOM.SelectPerformerabcabd(driver).click();
				 Thread.sleep(5000);
				 
				 ImplementPOM.SelectNewReviewerUser(driver).click();
				 ImplementPOM.Selectaaaaaad(driver).click();
				 Thread.sleep(5000);
				 
				 ImplementPOM.ChechBoxInTask0(driver).click();
			//	 Thread.sleep(1000);
			//	 ImplementPOM.CheckBox1(driver).click();
				 Thread.sleep(5000);
				 ImplementPOM.ClicksaveBtn(driver).click();
				 String MAMsg=driver.switchTo().alert().getText();
				  Thread.sleep(2000);
				  driver.switchTo().alert().accept();
				  Thread.sleep(2000);
					
						if(MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to abc abd?"))
						{
							test.log(LogStatus.PASS, "Message displayed -Statutory -Task :- Reassign " +MAMsg);
						}
						else
						{
							test.log(LogStatus.PASS, "Message displayed -" +MAMsg +"not Displayed");
						}
						  Thread.sleep(4000);
						  
						  //  --------------------------- Modify Assignments :- Internal Task :- Reassign --------------------------------------
							 Thread.sleep(2000);
							ImplementPOM.ClickInternalRB(driver).click();
							Thread.sleep(5000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));	//Wait until records table get visible.
							 Thread.sleep(2000);
							ImplementPOM.SelectCustomerMA(driver).click();
							 ImplementPOM.SelectABCD(driver).click();
							  Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
					 Thread.sleep(2000);
					ImplementPOM.SelectUser(driver).click();
					 Thread.sleep(500);
					
					 Thread.sleep(500);
					 ImplementPOM.Selectaaa(driver).click();
					 Thread.sleep(5000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]")));	//Wait until records table get visible.
						Thread.sleep(2000);
						ImplementPOM.SelectNewPerformerUser(driver).click();
						 ImplementPOM.Selectaaaaaad(driver).click();
						 Thread.sleep(5000);
						 
						 ImplementPOM.SelectNewReviewerUser(driver).click();
						 ImplementPOM.SelectPerformerabcabd(driver).click();
						 Thread.sleep(5000);
						 
						 ImplementPOM.ChechBoxInTask0(driver).click();
					//	 Thread.sleep(1000);
					//	 ImplementPOM.ChechBoxInTask1(driver).click();
						 Thread.sleep(4000);
						 ImplementPOM.ClicksaveBtn(driver).click();
						 String MAInMsg=driver.switchTo().alert().getText();
						  Thread.sleep(2000);
						  driver.switchTo().alert().accept();
						  Thread.sleep(2000);
							
								if(MAInMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to aaa aaa?"))
								{
									test.log(LogStatus.PASS, "Message displayed -Internal -Task :- Reassign " +MAInMsg);
								}
								else
								{
									test.log(LogStatus.PASS, "Message displayed -" +MAInMsg +"not Displayed");
								}
								  Thread.sleep(4000);
						 
	}
	
	public static void UsageReportCustomer( WebDriver driver,ExtentTest test,String report) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
		
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
					File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
					
					Thread.sleep(500);
					ImplementPOM.ClickExportRe(driver).click();				//Exporting (Downloading) file
					
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
					
					if( ImplementPOM.ClickClearBtn(driver).isEnabled()) {
						
						ImplementPOM.ClickClearBtn(driver).click();
						test.log(LogStatus.PASS, " :-Clear Button Working successfully.");	
					}else
					{
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
	
	public static void StatutoryAssignmentReport( WebDriver driver,ExtentTest test,String report) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
			      Thread.sleep(1000);
			      ImplementPOM.StatutoryAssignment(driver).click();
			      Thread.sleep(3000);
			      ImplementPOM.SelectCustomerSA(driver).click();
			      
			      ImplementPOM.SelectBitademopuneSA(driver).click();
			      Thread.sleep(7000);
			      File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
					File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
					
					Thread.sleep(500);
					ImplementPOM.ClickExportSA(driver).click();				//Exporting (Downloading) file
					
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
					public static void CheckListAssignmentReport( WebDriver driver,ExtentTest test,String report) throws InterruptedException, IOException
					{		
						Actions action = new Actions(driver);
						WebDriverWait wait = new WebDriverWait(driver, (40));
						Thread.sleep(3000);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
						
							      action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
							      Thread.sleep(1000);
							      ImplementPOM.CheckListAssignment(driver).click();
							      Thread.sleep(3000);
							      ImplementPOM.SelectCustomerSA(driver).click();
							      
							      ImplementPOM.SelectBitademopuneSA(driver).click();
							      Thread.sleep(7000);
							      File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
									File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
									
									Thread.sleep(500);
									ImplementPOM.ClickExportSA(driver).click();				//Exporting (Downloading) file
									
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
					
									public static void EventBasedAssignmentReport( WebDriver driver,ExtentTest test,String report) throws InterruptedException, IOException
									{		
										Actions action = new Actions(driver);
										WebDriverWait wait = new WebDriverWait(driver, (40));
										Thread.sleep(3000);

										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
										
											      action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
											      Thread.sleep(1000);
											      ImplementPOM.EventBasedAssignment(driver).click();
											      Thread.sleep(3000);
											      ImplementPOM.SelectCustomerSA(driver).click();
											      
											      ImplementPOM.SelectBitademopuneSA(driver).click();
											      Thread.sleep(8000);
											      File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
													File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
													
													Thread.sleep(500);
													ImplementPOM.ClickExportSA(driver).click();				//Exporting (Downloading) file
													
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
	
									public static void InternalAssignmentReport( WebDriver driver,ExtentTest test,String report) throws InterruptedException, IOException
									{		
										Actions action = new Actions(driver);
										WebDriverWait wait = new WebDriverWait(driver, (40));
										Thread.sleep(3000);

										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
										
											      action.moveToElement(ImplementPOM.ClickReport(driver)).click().build().perform();
											      Thread.sleep(1000);
											      ImplementPOM.InternalAssignment(driver).click();
											      Thread.sleep(3000);
											      ImplementPOM.SelectCustomerSA(driver).click();
											      
											      ImplementPOM.SelectBitademopuneSA(driver).click();
											      Thread.sleep(7000);
											      File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
													File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
													
													Thread.sleep(500);
													ImplementPOM.ClickExportSA(driver).click();				//Exporting (Downloading) file
													
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
