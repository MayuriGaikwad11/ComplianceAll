package companyadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyPOM {
	

	private static WebElement admin = null;				//WebElement variable created for 'Categories' click
					
	private static List<WebElement> adminList = null;		
	
	public static WebElement clickAdmin(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='leftApprovermenu']"));
		return admin;
	}
	
	public static WebElement clickReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"));
		return admin;
	}

	public static WebElement clickStatutoryAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[1]/a"));
		return admin;
	}
	
	public static WebElement clickCheckListAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[2]/a"));
		return admin;
	}
	
	public static WebElement clickEventBasedAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[3]/a"));
		return admin;
	}
	
	public static WebElement clickInternalAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[4]/a"));
		return admin;
	}
	
	public static WebElement clickInternalCheckListAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[5]/a"));
		return admin;
	}
	
	public static WebElement clickStatutoryLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[6]/a"));
		return admin;
	}
	
	public static WebElement clickInternalLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[7]/a"));
		return admin;
	}
	
	public static WebElement clickAllReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[8]/a"));
		return admin;
	}
	
	public static WebElement clickExport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return admin;
	}
	
	public static WebElement ManageEvents(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[6]"));
		return admin;
	}
	
	public static WebElement EventAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:90']/li[3]"));
		return admin;
	}
	
	public static WebElement SelectLocation(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return admin;
	}
	
	public static WebElement  DPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt2']"));
		return admin;
	}
	
	public static WebElement  ExporttoExcel(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
		return admin;
	}
	
	public static WebElement  SelectOwner(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_divFilterUsers']/span/a/span[1]"));
		return admin;
	}
	
	public static WebElement  abclawyer(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='ui-id-14']/li[3]"));
		return admin;
	}
	
	public static WebElement  Eventassignmentexportimport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:90']/li[6]"));
		return admin;
	}
	
	public static WebElement  Event(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbEvent']"));
		return admin;
	}
	
	public static WebElement  SelectEntity(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_txtEntity']"));
		return admin;
	}
	
	public static WebElement FPvtLTd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_rptEntity_chkEntity_2']"));
		return admin;
	}
	
	public static WebElement  SelectEntityok(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_rptEntity_btnRepeater']"));
		return admin;
	}
	
	public static WebElement  Location(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return admin;
	}
	
	public static WebElement  LocationExpand(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return admin;
	}
	
	
	public static WebElement  ExpandFPvtLTd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn1']/img"));
		return admin;
	}
	
	public static WebElement  MPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn2CheckBox']"));
		return admin;
	}
	
	public static WebElement  Select(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnselect']"));
		return admin;
	}
	
	public static WebElement  Download(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_BtnDownloadEvent']"));
		return admin;
	}
	
	public static WebElement  Import(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_Imp']"));
		return admin;
	}
	
	public static WebElement  ChooseFile(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return admin;
	}
	
	
	public static WebElement  Upload(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnEventUploadFile']"));
		return admin;
	}
	
	public static WebElement  BlankMsg(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return admin;
	}
	
	public static WebElement  InvalidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li/ol"));
		return admin;
	}
	
	public static WebElement  UploadLink(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventUpData_lnkDownload_0']"));
		return admin;
	}
	
	
	
	

	
}
