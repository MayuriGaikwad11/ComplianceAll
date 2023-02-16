package complianceCertificateOwner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class CertificateOwnerMethod {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	public static void CertificateOwner(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		Thread.sleep(1000);
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		Thread.sleep(1000);
		CertificateOwnerPOM.CertificateOwner(driver).click();
		Thread.sleep(3000);
	String text=	CertificateOwnerPOM.CertificateOwnerPage(driver).getText();
	test.log(LogStatus.PASS,  "Page Open - " +text);
	
	    Thread.sleep(1000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		CertificateOwnerPOM.ExporttoPDF(driver).click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
	}
	
	public static void CertificateOwnerReviewer(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		
		CertificateOwnerPOM.CertificateOwner(driver).click();
		
		CertificateOwnerPOM.View(driver).click();
		
		CertificateOwnerPOM.PeriodView(driver).click();
		
		CertificateOwnerPOM.CompliancePageView(driver).click();
		
		CertificateOwnerPOM.ReviewerPageView(driver).click();
		CertificateOwnerPOM.ReviewerPageViewclose(driver).click();
		test.log(LogStatus.PASS,  "Reviewer - Reviewer User - View Successfully");
		
		
			File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			
			CertificateOwnerPOM.ReviewerPageExport(driver).click(); // Exporting (Downloading) file

			
			File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "  File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL, "  File does not downloaded.");
			}
		
			CertificateOwnerPOM.ReviewerPageLoaction(driver).click();
			
			CertificateOwnerPOM.ReviewerPageClickExpand(driver).click();
			
			CertificateOwnerPOM.ReviewerPageCT(driver).click();
			
			if(CertificateOwnerPOM.ReviewerPageClearfilterMain(driver).isEnabled()) {
				CertificateOwnerPOM.ReviewerPageClearfilterMain(driver).click();
				test.log(LogStatus.PASS,  "  Clear Filter Working successfully.");
			}else {
				test.log(LogStatus.FAIL,  "  Clear Filter not Working successfully.");
			}	
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
	
	}
	
	public static void CertificateOwnerParticularPeriod(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		
		CertificateOwnerPOM.CertificateOwner(driver).click();
		
		CertificateOwnerPOM.View(driver).click();
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.ClickDownloadAll(driver).click(); // Exporting (Downloading) file

		
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Download All - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.ExporttoPDFPe(driver).click(); // Exporting (Downloading) file

		
		File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  "Export to PDF - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		CertificateOwnerPOM.ClickPreview(driver).click(); 
		Thread.sleep(2000);
		CertificateOwnerPOM.ClosePreview(driver).click(); 
		test.log(LogStatus.PASS,  " Preview successfully.");
		
		File dir5 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents2 = dir5.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.DwonloadDoc(driver).click(); // Exporting (Downloading) file

		
		File dir6 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew2 = dir6.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents2.length < allFilesNew2.length) {
			test.log(LogStatus.PASS,  "Dwonload Doc - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		Thread.sleep(2000);
		CertificateOwnerPOM.Back(driver).click(); 
	}
	
}
