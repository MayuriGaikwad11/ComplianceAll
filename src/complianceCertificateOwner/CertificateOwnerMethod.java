package complianceCertificateOwner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
		
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA(driver).click(); // Exporting (Downloading) file

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
	
}
