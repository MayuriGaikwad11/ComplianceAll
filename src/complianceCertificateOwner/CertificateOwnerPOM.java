package complianceCertificateOwner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CertificateOwnerPOM {
	
private static WebElement owner = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> ownerList = null;		
	

	public static WebElement clickMyCertificate(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='leftworkspacemenuCer']/a"));
		return owner;
	}
	
	public static WebElement CertificateOwner(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='LiCerOwnerlist']"));
		return owner;
	}
	
	public static WebElement ExporttoPDF(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[1]/div/button"));
		return owner;
	}
	
	
}
