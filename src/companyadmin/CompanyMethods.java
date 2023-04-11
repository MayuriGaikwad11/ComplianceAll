package companyadmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import implementation.ImplementPOM;

public class CompanyMethods {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	

	public static void SwitchtoChild( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		CompanyPOM.clickAdmin(driver).click();
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	      
	    
			Thread.sleep(1000);
	      
	  
	}
	
	public static void SwitchtoParent( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      driver.close();
	      Thread.sleep(3000);
	      driver.switchTo().window(pw);         // switching child window
	      
	    
	  
	}

	
	public static void Reports( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.clickStatutoryAssi(driver).click();
	      		  	 Thread.sleep(2000);
	 	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.

		  	CompanyPOM.clickExport(driver).click();
		  	 Thread.sleep(4000);
		  	test.log(LogStatus.PASS, "Statutory Assignment Report -Export Succefully");
		  	
		  //-------------------------------CheckList  Assignment Report-------------------------------
		  	Thread.sleep(1000);
		  	action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickCheckListAssi(driver).click();
		    Thread.sleep(4000);
		 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
			  	 Thread.sleep(1000);
		 	CompanyPOM.clickExport(driver).click();
			  	 Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "CheckList Assignment  Report -Export Succefully");
			  	
		 	 //-------------------------------EventBased  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickEventBasedAssi(driver).click();
		    Thread.sleep(4000);
		//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
			  	 Thread.sleep(1000);
		 	CompanyPOM.clickExport(driver).click();
			  	 Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "EventBased Assignment  Report -Export Succefully");
			  	
		 	 //-------------------------------Internal  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalAssi(driver).click();
		      
		//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
			  	 Thread.sleep(4000);
		 	CompanyPOM.clickExport(driver).click();
			  	 Thread.sleep(1000);
		 	test.log(LogStatus.PASS, "Internal Assignment  Report -Export Succefully");
			  	
		 	 //-------------------------------Internal CheckList  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalCheckListAssi(driver).click();
		      
		//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
			  	 Thread.sleep(4000);
		 	CompanyPOM.clickExport(driver).click();
			  	 Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "Internal CheckList Assignment  Report -Export Succefully");
			  	
		 	//-------------------------------Statutory Label Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickStatutoryLabelReport(driver).click();
		      
		 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
			  	 Thread.sleep(4000);
		 	CompanyPOM.clickExport(driver).click();
			  	 Thread.sleep(4000);
		 	test.log(LogStatus.PASS, " Statutory Label  Report -Export Succefully");
			  	
		 	//-------------------------------Internal Label Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalLabelReport(driver).click();
		      
		//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
			  	 Thread.sleep(4000);
		 	CompanyPOM.clickExport(driver).click();
			  	 Thread.sleep(4000);
		 	test.log(LogStatus.PASS, " Internal Label  Report -Export Succefully");
			  	
		 	//-------------------------------All Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickAllReport(driver).click();
		      
		 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
			  	 Thread.sleep(5000);
		 	CompanyPOM.clickExport(driver).click();
			  	 Thread.sleep(4000);
		 	test.log(LogStatus.PASS, " All Report -Export Succefully");
		 	 Thread.sleep(4000);
		  	
		  	 Thread.sleep(1000);
	      test.log(LogStatus.PASS, "Location Internal-Perview");
	 
	      SwitchtoParent(driver,test);
	      Thread.sleep(3000);
	}
	
	public static void EventAssignments( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.EventAssignments(driver).click();
		  	 Thread.sleep(3000);
		  	  CompanyPOM.SelectLocation(driver).click();
			  	 Thread.sleep(1000);
			  	  CompanyPOM.DPvtLtd(driver).click();
				  	 Thread.sleep(3000);
		  	 
		  	Thread.sleep(3000);
			File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.ExporttoExcel(driver).click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "After Selecting Location :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			 CompanyPOM.SelectOwner(driver).click();
		  	 Thread.sleep(1000);
		  	  CompanyPOM.abclawyer(driver).click();
			  	 Thread.sleep(3000);
	  	 
			 	Thread.sleep(3000);
				File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
				File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				CompanyPOM.ExporttoExcel(driver).click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
				File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents1.length < allFilesNew1.length) {
					test.log(LogStatus.PASS,  "After Selecting Location and  Event owner:- File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " :- File does not downloaded.");
				}
			
			
			  SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void Eventassignmentexportimport( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	 
		  	 CompanyPOM.SelectEntity(driver).click();
		  	 Thread.sleep(1000);
		  	  CompanyPOM.FPvtLTd(driver).click();
			  	 Thread.sleep(1000);
			  	 CompanyPOM.SelectEntityok(driver).click();
			  	 Thread.sleep(8000);
			  	 
			  	 CompanyPOM.Location(driver).click();
			  	 Thread.sleep(1000);
			  	  CompanyPOM.LocationExpand(driver).click();
				  	 Thread.sleep(1000);
				  	 CompanyPOM.ExpandFPvtLTd(driver).click();
				  	 Thread.sleep(1000);
				  	CompanyPOM.MPvtLtd(driver).click();
				  	 Thread.sleep(1000);
				 	CompanyPOM.Select(driver).click();
				  	 Thread.sleep(3000);
				  	Thread.sleep(3000);
					File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
					File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

					Thread.sleep(500);
					CompanyPOM.Download(driver).click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
					File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents1.length < allFilesNew1.length) {
						test.log(LogStatus.PASS,  " File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  " :- File does not downloaded.");
					}
					 SwitchtoParent(driver,test);
				      Thread.sleep(3000);
	}
	
	public static void EventassignmentexportimportValidation( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	 
		  	
					Thread.sleep(500);
					CompanyPOM.Download(driver).click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					String ValMsg =driver.switchTo().alert().getText();
					Thread.sleep(1000);
						test.log(LogStatus.PASS,  "Without Selecting Entity , location validation message display : -"+ValMsg);
						driver.switchTo().alert().accept();
						Thread.sleep(1000);
					 SwitchtoParent(driver,test);
				      Thread.sleep(3000);
	}
	
	public static void ImportBlankScript( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\EventAssignmentReport (3).xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload(driver).click();
		  	 Thread.sleep(6000);
		  //	 String Msg=CompanyPOM.BlankMsg(driver).getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  "When blank Sheet Uploaded : - Validation Msg Not Displyed");
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void ImportInvalidSheet( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\EventAssignmentReport.xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload(driver).click();
		  	 Thread.sleep(6000);
		 	 String Msg=CompanyPOM.InvalidMsg(driver).getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  "upload invalid Data validation message display : -"+Msg);
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void ImportValidSheet( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\EventAssignmentReport (4).xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload(driver).click();
		  	 Thread.sleep(6000);
		 	 String Msg=CompanyPOM.BlankMsg(driver).getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  " valid Data Upload validation message display : -"+Msg);
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void UploadedFileisplay ( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 if(CompanyPOM.UploadLink(driver).isDisplayed()) {
			 
				test.log(LogStatus.PASS,  "  Uploaded File displayed On Grid Table"); 
		 }
		  	 Thread.sleep(3000);
		  
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
