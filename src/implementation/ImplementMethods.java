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
import org.openqa.selenium.support.ui.Select;
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
	
	
	
	
	
	
	
	
	
	
	
	

}
