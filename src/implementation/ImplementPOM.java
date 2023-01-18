package implementation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImplementPOM {
	
	private static WebElement implement = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> implementList = null;		
	
	public static WebElement clickManageUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return implement;
	}

	public static WebElement clickCustomers(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[4]/a"));
		return implement;
	}
	
	public static WebElement ClickAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddCustomer']"));
		return implement;
	}
	
	public static WebElement clickServiceProvider(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]"));
		return implement;
	}
	
	public static WebElement SelectAvantis (WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='ui-id-21']"));
		return implement;
	}
	
	public static WebElement CustomerName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxName']"));
		return implement;
	}
	
	public static WebElement BuyerName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerName']"));
		return implement;
	}
	
	public static WebElement BuyerContactNo(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerContactNo']"));
		return implement;
	}
	
	public static WebElement BuyerEmail(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerEmail']"));
		return implement;
	}
	
	public static WebElement ClickSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_btnSave']"));
		return implement;
	}
	
	public static WebElement CustomerAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[1]/a"));
		return implement;
	}
	
	public static WebElement ClickAddNewCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddWidget']"));
		return implement;
	}
	
	public static WebElement SelectCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtComplince']"));
		return implement;
	}
	
	public static WebElement SelectPerformer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlNewUsers']"));
		return implement;
	}
	
	public static WebElement SelectRT(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlNewUsers']/option[2]"));
		return implement;
	}
	
	public static WebElement SelectReviewer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']"));
		return implement;
	}
	
	
	public static WebElement SelectAA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']/option[2]"));
		return implement;
	}
	
	public static WebElement SelectIA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']/option[3]"));
		return implement;
	}
	
	public static WebElement ClickSaveCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;
	}
	
	public static WebElement FilterCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement ClickEditCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_lbtEdit_5']"));
		return implement;
	}
	
	public static WebElement UpdateMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return implement;
	}
	
	public static WebElement CloseCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;
	}
	
	public static WebElement DeleteCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_lbtDelete_5']"));
		return implement;
	}
	
	public static WebElement ClickEditC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton1_5']/img"));
		return implement;
	}
	
	public static WebElement Address(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxAddress']"));
		return implement;
	}
	
	public static WebElement Delete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton2_5']/img"));
		return implement;
	}
	
	public static WebElement Filter(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
