package researchReviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RRLocators {
	
private static WebElement researchReviewer = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> researchReviewerList = null;		
	
	public static WebElement clickManageCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return researchReviewer;                        
	}

	public static WebElement MinistryMaster(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[7]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement MinistryMasterAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return researchReviewer;                                         
	}
	
	public static WebElement MinistryName(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtFName']"));
		return researchReviewer;               
	}
	
	public static WebElement Save(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return researchReviewer;                        
	}
	
	public static WebElement SaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return researchReviewer;                                        
	}
	
	public static WebElement Close(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return researchReviewer;                        
	}
	
	public static WebElement Filter(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return researchReviewer;                        
	}
	
	public static WebElement ClickEdit(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton1_0']/img"));
		return researchReviewer;                     
	}
	
	public static WebElement DeleteMinistryDetails(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton2_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement RegulatorMaster(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[8]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement RegulatorName(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtFName1']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDepartmentMaster(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[9]/a"));
		return researchReviewer;                        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
