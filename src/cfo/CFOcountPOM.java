package cfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import performer.OverduePOM;

public class CFOcountPOM
{
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	private static WebElement categories = null;				//WebElement variable created for 'Categories' click
	private static WebElement compliances = null;				//WebElement variable created for 'Compliances' read and click
	private static List<WebElement> compliancesList = null;		//WebElement variable created for 'Compliances' read and click
	private static WebElement compliancesItomsCount = null;		//WebElement variable created for reading Items count after Compliances click
	private static WebElement users = null;						//WebElement variable created for 'Users' read and click
	private static WebElement penalty = null;					//WebElement variable created for 'Penalty' read and click
	private static List<WebElement> interestList = null;		//WebElement variable created for reading each interest.
	private static List<WebElement> penaltyList = null;			//WebElement variable created for reading each interest.
	private static WebElement nextPage = null;					//WebElement variable created for clicking on next page arrow.
	private static WebElement piechart = null;					//WebElement variable created for piechart elements. 
	private static List<WebElement> select = null;				//WebElement variable created for piechart elements.
	private static WebElement bargraph = null;					//WebElement variable created for bargraph elements.
	private static WebElement risksummary = null;				//WebElement variable created for Risk Summary elements.
	private static WebElement refresh = null;					//WebElement variable created for Refreshing web page.
	private static WebElement department = null;				//WebElement variable created for Department Summary elements. 
	private static WebElement penlatysummary = null;			//WebElement variable created for Penalty Summary elements.
	private static WebElement Internal = null;					//WebElement variable created for Internal Compliances Dashboard.
	private static WebElement grading = null;					//WebElement variable created for Grading Report elements.
	private static List<WebElement> totalRecords = null; 		//WebElement variable created for calculating total records displayed in Grading Report 
	private static WebElement calendar = null;					//WebElement variable created for Grading Report elements.
	private static WebElement reports = null;					//WebElement variable created for Reports elements.
	private static WebElement documents = null;					//WebElement variable created for Reports elements.
	private static List<WebElement> menus = null; 				//WebElement variable created for sub menu elements.
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	private static List<WebElement> elementsList2 = null;
	private static WebElement SummaryofOverdueCom = null;
	private static List<WebElement> viewList = null;
	public static WebElement clickCategories(WebDriver driver)		//Method for closing Message Popup
	{
		categories = driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_divFunctionCount']"));
		return categories;
	}
	
	public static WebElement readCompliances(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_divCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement uniqueCompliances(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divUniqueCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement TotalCompliances(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divTotalCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement readCompliancesInternal(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divCompliancesCount']"));
		return compliances;//*[@id="ContentPlaceHolder1_divCompliancesCount"]
	}      
	
	public static WebElement clickLocation(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='example']/div/span/span/span[3]"));
		return compliances;
	} //*[@id="example"]/div[1]/div[1]/div/span[1]
	
	public static WebElement clickLocationIn(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='example']/div[1]/div[1]/div/span[1]"));
		return compliances;                       
	}
	
	public static WebElement clickLocationShow(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='example']/div[1]/div[1]/div"));
		return compliances;                       
	}
	
	public static WebElement clickLocationPe(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='Details']/div[1]/div[1]/div/span[1]"));
		return compliances;                       
	} 
	
	public static WebElement clickCkecjke(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[34]"));
		return compliances;                       
	} 
	
	public static WebElement clickLocationInterest(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='example']/div[2]/div[1]/div/span[1]"));
		return compliances;                       
	} 
	
	public static WebElement YearTodate(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']"));
		return compliances;
	} 
	
	public static WebElement ALL(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']/option[7]"));
		return compliances;
	} 
	
	public static WebElement clickExpand1(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//span[@class='k-icon k-i-expand']"));
		return compliances;
	} 
	
	public static WebElement clickExpand2(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//span[@class='k-icon k-i-collapse']"));
		return compliances;
	} 
	
	public static WebElement clickBita(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[8]"));
		return compliances;
	} 
	
	public static WebElement clickAR(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[10]"));
		return compliances;
	} 
	
	public static WebElement clickABita(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[9]"));
		return compliances;
	} 
	
	public static WebElement EnterRemark(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='txt_Remark']"));
		return compliances;
	} 
	
	public static WebElement ReOpen(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='btn_Remark']"));
		return compliances;
	} 
	

	
	public static WebElement clickAVIPL(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("(//span[@class='k-in'])[10]"));
		return compliances;
	} 
	
	public static WebElement clickBitaAurangabad(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("(//li[@class='k-item k-first'])[2]"));
		return compliances;
	} 
	
	
	public static WebElement clickBPVT(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("(//span[@class='k-in'])[7]"));
		return compliances;
	} 
	
	public static WebElement clickClear(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return compliances;
	} 
	
	
	
	public static List<WebElement> readCompliancesList(WebDriver driver)	//Method for reading list of compliances after clicking Categories. 
	{
		compliancesList = driver.findElements(By.xpath("//*[contains(@onclick,'openpopup')]"));
		return compliancesList;
	}
	
	public static List<WebElement> readUserList(WebDriver driver)	//Method for reading list of compliances after clicking Categories. 
	{
		compliancesList = driver.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[3]/div"));
		return compliancesList;
	}
	
	public static List<WebElement> readUserList1(WebDriver driver)	//Method for reading list of compliances after clicking Categories. 
	{
		compliancesList = driver.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[3]/a"));
		return compliancesList;
	}
	
	public static WebElement closeCategories(WebDriver driver)				//Closing Categories pop up.
	{                                             
		categories = driver.findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
	//	categories = driver.findElement(By.xpath("//body/form/div[@id='example']/div[1]"));
		return categories;//body/form/div[@id='example']/div[1]
	}  
	
	public static WebElement closeCategories1(WebDriver driver)				//Closing Categories pop up.
	{                                             
		categories = driver.findElement(By.xpath("//*[@id='divreportsNewGraph']/div/div/div[1]/button"));
		
		return categories;
	}  
	
	public static WebElement closePopup(WebDriver driver)				//Closing Categories pop up.
	{
		categories = driver.findElement(By.xpath("//*[@id='divGRreports']/div/div/div[1]/button"));
		return categories;
	}
	
	public static WebElement closeView_cal(WebDriver driver)				//Closing Categories pop up.
	{
		categories = driver.findElement(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
		return categories;                        //*[@id="divOverView"]/div/div/div[1]/button
	}
	
	public static WebElement clickAll(WebDriver driver)				//Closing Categories pop up.
	{
		categories = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdbcalender_1']"));
		return categories;
	}
	
	public static WebElement closeCategories_Compliances(WebDriver driver)	//Closing Compliances pop up opened within Categories pup up.
	{
	//	categories = driver.findElement(By.xpath("//div[@id='divApiOverView']/div/div/div[1]/button"));
		categories = driver.findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
		
		return categories;//*[@id="divApiOverView"]/div/div/div[1]/button
	}
	
	public static WebElement readCompliancesItems(WebDriver driver)			//Method for read total items in Compliances.
	{
		compliancesItomsCount = driver.findElement(By.xpath("//*[@id='grid']/div[4]/span"));
		return compliancesItomsCount;
	}
	
	public static WebElement clickUsersCount(WebDriver driver)				//Method to search 'Users' image link to click on 
	{
		users = driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_divUsersCount']"));
		return users;                       
	}//*[@id="ContentPlaceHolder1_divUsersCount"]
	
	public static WebElement readUsersCount(WebDriver driver)				//Method to read total users items in Users.
	{
		users = driver.findElement(By.xpath("//*[@id='grid']/div[5]/span"));
		return users;
	}
	
	public static WebElement readUsersCount1(WebDriver driver)				//Method to read total users items in Users.
	{
		users = driver.findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return users;
	}
	
	public static WebElement ClickShowAll(WebDriver driver)				//Method to read total users items in Users.
	{
		SummaryofOverdueCom = driver.findElement(By.xpath("//*[@id='lnkOverdueCompliance']"));
		return SummaryofOverdueCom;
	}
	
	public static WebElement ClickShowAllIn(WebDriver driver)				//Method to read total users items in Users.
	{
		SummaryofOverdueCom = driver.findElement(By.xpath("//*[@id='lnkInternalOverdueCompliance']"));
		return SummaryofOverdueCom;                   
	}
	
	public static List<WebElement> ActionviewList(WebDriver driver)			//Method to read all interests in Penalty.
	{
		viewList = driver.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td/a[1]"));
		return viewList;
	}
	
	public static WebElement readUsersCount2(WebDriver driver)				//Method to read total users items in Users.
	{
		users = driver.findElement(By.xpath("//*[@class = 'k-pager-info k-label']"));
		return users;
	}
	//*[@id="grid"]/div[4]/span[2]
	public static WebElement readPenaltyCount(WebDriver driver)				//Method to read and click on Penalty.
	{
		penalty = driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_divPenalty']"));
		return penalty;
	}
	
	public static WebElement clickInterest(WebDriver driver)
	{
		penalty = driver.findElement(By.xpath("//*[@id='liGraph']"));
		return penalty;
	}//*[@id="liGraph"]
	
	public static List<WebElement> readInterest(WebDriver driver)			//Method to read all interests in Penalty.
	{
		interestList = driver.findElements(By.xpath("//table[@data-role='selectable']/tbody/tr/td[7]"));
		return interestList;
	}
	
	public static List<WebElement> readPenalty(WebDriver driver)			//Method to read all penalties in Penalty.
	{
		penaltyList = driver.findElements(By.xpath("//table[@data-role='selectable']/tbody/tr/td[7]"));
		return penaltyList;
	}
	
	public static WebElement loadGrid(WebDriver driver)
	{
		penalty = driver.findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']"));
		return penalty;
	}
	
	public static WebElement ClearButton(WebDriver driver)
	{
		penalty = driver.findElement(By.xpath("//*[@id = 'ClearfilterMain']"));
		return penalty;
	}
	
	public static WebElement clickNextPage(WebDriver driver)				//Method to search next page arrow button.
	{
		nextPage = driver.findElement(By.xpath("//*[@id='grid']/div[4]/a[3]/span"));
		return nextPage;
	}
	
	public static List<WebElement> checkTotalIndexes(WebDriver driver)				//Method to search next page arrow button.
	{
		elementsList = driver.findElements(By.xpath("//*[@class = 'k-pager-numbers k-reset']/li"));
		return elementsList;
	}
	
	public static WebElement clickNextPage1(WebDriver driver)				//Method to search next page arrow button.
	{
		nextPage = driver.findElement(By.xpath("//*[@title='Go to the next page']"));
		return nextPage;
	}
	
	public static WebElement readTotalItems(WebDriver driver)				//Method to read all items in Penalty click.
	{
		nextPage = driver.findElement(By.xpath("//*[@id='grid']/div[4]/span"));
		return nextPage;
	}
	
	public static WebElement clickNotCompleted(WebDriver driver)			//Method to search Not Completed count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
	//	piechart = driver.findElement(By.xpath("//*[@id='highcharts-2']/svg/g[3]/g[2]/text/tspan"));

		return piechart;
	}//*[@id="highcharts-2"]/svg/g[3]/g[2]/text/tspan
	
	public static WebElement clickNotCompletedInternal(WebDriver driver)			//Method to search Not Completed count to click on from Pie Chart.
	{
	//	piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));

		return piechart;                        //*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']
	}
	
	public static WebElement clickNotCompletedInternalA(WebDriver driver)			//Method to search Not Completed count to click on from Pie Chart.
	{
		
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		
		return piechart;                        //*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']
	}
	
	public static WebElement clickNotApplInternalA(WebDriver driver)			//Method to search Not Completed count to click on from Pie Chart.
	{
		
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		
		return piechart;                        
	}
	
	public static WebElement clickAfterDueDate(WebDriver driver)			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayed(WebDriver driver)			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayedA(WebDriver driver)			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayedInternal(WebDriver driver)			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;                                   
	}
	
	public static WebElement clickNotCompliedInternal(WebDriver driver)			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])"));
		return piechart;
	}
	
	public static WebElement clickInTime(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedTimely(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;                       
	}
	
	public static WebElement clickClosedTimelyA(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		return piechart;                       
	}
	
	public static WebElement clickClosedTimelyInternal(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
		return piechart;                                                             
	}
	
	public static WebElement clickClosedTimelyInternalP(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
		return piechart;                                   
	}
	
	public static WebElement clickNotApplicable(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickNotApplicableA(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickNotApplicableInternal(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickOverdue(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickOverdueInternal(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickOverdueInternalApp(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
		return piechart;
	}
	
	public static WebElement clickdueToday(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickdueTodayInernal(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	
	public static WebElement clickpendingForReview(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickpendingForReviewDept(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickInProgressDept(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	
	public static WebElement clickpendingForReviewIN(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{                       
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[2]"));
		return piechart;                         
	}
	
	public static WebElement clickpendingForReviewIND(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickinProgress(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])[2]"));
		return piechart;                                       
	}
	
	public static WebElement clickRejected(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}                                           
	
	public static WebElement clickRejectedIn(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickRejectedDept(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickRejectedPe(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickRejectedPe1(WebDriver driver)					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	
	public static WebElement readCritical(WebDriver driver)						//Method to read High risk Value (For all types)
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
		return piechart;
	}
	
	public static WebElement readHigh(WebDriver driver)					//Method to read Medium risk Value (For all types)
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
		return piechart;                        
	}
	
	public static WebElement readHigh1(WebDriver driver)					//Method to read Medium risk Value (For all types)
	{
		piechart = driver.findElement(By.xpath("//*[@id='highcharts-0']/svg/g[3]/g[2]"));
		return piechart;                        
	}
	
	public static WebElement readMedium(WebDriver driver)						//Method to read Low risk Value (For all types)
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
		return piechart;
	}
	
	public static WebElement readLow(WebDriver driver)						//Method to read Low risk Value (For all types)
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
		return piechart;
	}
	
	public static List<WebElement> selectDropdown(WebDriver driver)			//Method to search drop downs in Not Completed click
	{
		select = driver.findElements(By.xpath("//*[@class='k-multiselect-wrap k-floatwrap']"));
		return select;
	}
	
	public static WebElement selectFirst(WebDriver driver)					//Method to select first option in the first drop down
	{
		piechart = driver.findElement(By.xpath("//*[contains(text(),'BITA Consulting Private Limited')][@class='k-in']"));
		return piechart;
	}
	
	public static WebElement SelectLocation(WebDriver driver)					//Method to select first option in the first drop down
	{
		piechart = driver.findElement(By.xpath("//*[@id='example']/div/div/div"));
		return piechart;
	}
	
	public static WebElement ClickIocon(WebDriver driver)					//Method to select first option in the first drop down
	{
		piechart = driver.findElement(By.xpath("//span[@class='k-icon k-i-expand']"));
		return piechart;
	}
	
	public static WebElement ClickABCMall(WebDriver driver)					//Method to select first option in the first drop down
	{
		piechart = driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[3]"));
		return piechart;
	}
	
	public static WebElement ClickAPVT(WebDriver driver)					//Method to select first option in the first drop down
	{
		piechart = driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[15]"));
		return piechart;
	}
	
	
	public static WebElement selectFirst1(WebDriver driver)					//Method to select first option in the first drop down
	{
		piechart = driver.findElement(By.xpath("//*[contains(text(),'ABCD Pvt Ltd')][@class='k-in']"));
		return piechart;
	}
	
	public static WebElement selectfirst(WebDriver driver)
	{
		piechart = driver.findElement(By.xpath("//*[@class='k-in k-state-selected']"));
		return piechart;
	}
	
	public static WebElement readTotalItems1(WebDriver driver)				//Method to read total no of items.
	{
	//	piechart = driver.findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		piechart=driver.findElement(By.xpath("//*[@id='grid']/div[5]/span[2]"));
		return piechart;//*[@id="grid"]/div[4]/span[2]
	}//*[@id="grid1"]/div[4]/span[2]//*[@id="grid"]/div[5]/span[2]
	
	public static WebElement readTotalItems2(WebDriver driver)				//Method to read total no of items.
	{
	
		piechart=driver.findElement(By.xpath("//*[@id='grid1']/div[4]/span[2]"));
		return piechart;
	}
	
	public static WebElement readTotalItems3(WebDriver driver)				//Method to read total no of items.
	{
	
		piechart=driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		return piechart;
	}
	
	public static WebElement readTotalItems4(WebDriver driver)				//Method to read total no of items.
	{
	
		piechart=driver.findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return piechart;
	}
	
	
	public static WebElement readTotalItemsD(WebDriver driver)				//Method to read total no of items.
	{
		piechart = driver.findElement(By.xpath("//*[@class='k-pager-info k-label']"));
	//	piechart = driver.findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return piechart;//*[@id="grid"]/div[5]/span[2]
	}//*[@id="grid"]/div[4]/span[2]
	
	public static WebElement clickBack1(WebDriver driver)
	{
		piechart = driver.findElement(By.xpath("(//*[@class=' highcharts-button-box'])[2]"));
		return piechart;
	}
	
	public static WebElement clickBackPe(WebDriver driver)
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-button highcharts-drillup-button']"));
		return piechart;
	}
	
	public static WebElement clickBackPe1(WebDriver driver)
	{
		piechart = driver.findElement(By.xpath("//*[@class='highcharts-button highcharts-drillup-button highcharts-button-normal']"));
		return piechart;                                  
	}
	
	public static WebElement clickBack2(WebDriver driver)
	{
		piechart = driver.findElement(By.xpath("(//*[@class=' highcharts-button-box'])[4]"));
		return piechart;
	}//*[@id="highcharts-4"]/svg/g[5]
	
	public static WebElement clickBack3(WebDriver driver)
	{
		piechart = driver.findElement(By.xpath("//*[@id='highcharts-4']/svg/g[5]"));
		return piechart;
	}
	
	public static WebElement clickIndustrySpeCritical(WebDriver driver)			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeCriticalM(WebDriver driver)			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[5]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeHigh(WebDriver driver)				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[14]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeHighM(WebDriver driver)				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[12]"));
		return bargraph;
	}
	
	public static WebElement clickBSECritical(WebDriver driver)				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		return bargraph;
	}
	
	public static WebElement clickBSEHigh(WebDriver driver)				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[32]"));
		return bargraph;
	}
	
	public static WebElement clickBSEMedium(WebDriver driver)				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[58]"));
		return bargraph;
	}
	
	public static WebElement clickBSELow(WebDriver driver)				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[84]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeMedium(WebDriver driver)			//"Statutory" Method to search Labour compliance Medium risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[22]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeMediumM(WebDriver driver)			//"Statutory" Method to search Labour compliance Medium risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[19]"));
		return bargraph;
	}
	
	
	public static WebElement clickLabourMedium1(WebDriver driver)			//Method to search Labour compliance Medium risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[15]"));
		return bargraph;
	}
	
	public static WebElement  clickIndustrySpeLow(WebDriver driver)				//"Statutory" Method to search Labour compliance low risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return bargraph;
	}
	
	public static WebElement  clickIndustrySpeLowM(WebDriver driver)				//"Statutory" Method to search Labour compliance low risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[26]"));
		return bargraph;
	}
	
	public static WebElement clickLabourLow1(WebDriver driver)				//Method to search Labour compliance low risk value.
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[25]"));
		return bargraph;
	}
	
	public static WebElement clickBarInTime(WebDriver driver)				//Method to search Labour In Time compliance
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return bargraph;
	}
	
	public static WebElement clickBarClosedTimely(WebDriver driver)				//Method to search Labour In Time compliance
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return bargraph;
	}
	
	public static WebElement clickBarAfterDueDate(WebDriver driver)			//Method to search Labour After Due Date compliance
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return bargraph;
	}
	
	public static WebElement clickBarClosedDelayed(WebDriver driver)			//Method to search Labour After Due Date compliance
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return bargraph;
	}
	
	public static WebElement clickBarNotCompleted(WebDriver driver)			//Method to search Labour Not Completed compliance
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		return bargraph;
	}
	
	public static WebElement clickBarNotApplicable(WebDriver driver)			//Method to search Labour Not Completed compliance
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return bargraph;
	}
	
	public static WebElement clickBack(WebDriver driver)					//Method to search Back button of Completion Status Bar Graph
	{
		bargraph = driver.findElement(By.xpath("(//*[@class=' highcharts-button-box'])[3]"));
		return bargraph;
	}
	
	public static WebElement clickView(WebDriver driver)					//Method to search View button of document to view
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]"));
		return bargraph;
	}
	
	public static WebElement closeDocument(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
		return bargraph;                         //*[@id="divreports"]/div/div/div[1]/button                
	}                                       
	
	public static WebElement closeDocumentA(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
		return bargraph;                                         
	}       
	
	public static WebElement closeDocument1(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
		return bargraph;                        //*[@id="divOverView"]/div/div/div[1]/button                
	}                                  //*[@id="divGRreports"]/div/div/div[1]/button        
	
	public static WebElement closeDocument2(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button"));
		return bargraph;                        //*[@id="divOverView1"]/div/div/div[1]/button                
	}                                           //*[@id="divOverView1"]/div/div/div[1]/button
	
	public static WebElement closeDocumentAS(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
		return bargraph;                                       
	} 
	
	public static WebElement closeViewDoc(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath("//*[@id='divOverViewMain']/div/div/div[1]/button"));
		return bargraph;                           
	}  //*[@id="divOverView"]/div/div/div[1]/button
	
	public static WebElement closeViewDocGR(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath(" //*[@id='divGRreports']/div/div/div[1]/button"));
		return bargraph;                           
	}  
	
	public static WebElement closeOverViewDoc(WebDriver driver)				//Method to search cross of document to close it.
	{
		bargraph = driver.findElement(By.xpath("//*[@id='divOverViewMain1']/div/div/div[1]/button"));
		return bargraph;                            
	}  
	
	public static WebElement downloadDocument(WebDriver driver)				//Method to search download button of first document. 
	{
		bargraph = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-download k-grid-edit2'])[1]"));
		return bargraph;
	}
	
	public static WebElement clickRiskCriticalNotCompleted(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));

		return risksummary;
	}
	
	public static WebElement clickRiskCriticalNotCompletedDept(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[57]"));
		

		return risksummary;
	}
	
	/*[name()='svg'][1]/*[name()='g'][10]/*[name()='g'][1]/*[name()='text'][1]*/
	public static WebElement clickRiskCriticalClosedDelayed(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskCriticalClosedDelayedA(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskCriticalClosedTimely(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotCompleted(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotCompletedD(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[58]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotCompletedDIn(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[65]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighAfterDueDate(WebDriver driver)	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedDelayed(WebDriver driver)	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedDelayedA(WebDriver driver)	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighInTime(WebDriver driver)			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedTimely(WebDriver driver)			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedTimelyIN(WebDriver driver)			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[77]"));
		return risksummary;
	}
	
	
	public static WebElement clickRiskHighClosedTimelyA(WebDriver driver)			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[14]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompleted(WebDriver driver)	//Method to search 'Medium Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		//	risksummary = driver.findElement(By.xpath("//*[@id='highcharts-6']/svg/g[5]/g[1]/rect[1]"));

		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompletedD(WebDriver driver)	//Method to search 'Medium Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[59]"));
		//	risksummary = driver.findElement(By.xpath("//*[@id='highcharts-6']/svg/g[5]/g[1]/rect[1]"));

		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompletedDIn(WebDriver driver)	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[66]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumAfterDueDate(WebDriver driver)	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedDelayed(WebDriver driver)	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedDelayedA(WebDriver driver)	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumInTime(WebDriver driver)		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedTimely(WebDriver driver)		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return risksummary;
	}//*[@id="highcharts-6"]/svg/g[5]/g[1]/rect[1]
	
	public static WebElement clickRiskLowNotCompleted(WebDriver driver)		//Method to search 'Low Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowNotCompletedD(WebDriver driver)		//Method to search 'Low Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[60]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowAfterDueDate(WebDriver driver)		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedDelayed(WebDriver driver)		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedDelayedA(WebDriver driver)		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowInTime(WebDriver driver)			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedTimely(WebDriver driver)			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedTimelyA(WebDriver driver)			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
		return risksummary;
	}
	
	public static WebElement clickRefresh(WebDriver driver)					//Method to search 'Refresh' button on the web page.
	{
		refresh = driver.findElement(By.xpath("//a[@id='ContentPlaceHolder1_btnRefresh1']"));
		return refresh;
	}
	
	public static WebElement clickDepartmentHighHuman(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return department;
	}
	
	public static WebElement clickAdminNotComplInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[53]"));
		return department;
	}
	
	public static WebElement clickFinanceClosedDelayedInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[26]"));
		return department;
	}
	
	
	public static WebElement clickAccountClosedDelayedInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return department;
	}
	
	
	public static WebElement clickFinanceClosedTimelyInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[28]"));
		return department;
	}
	
	public static WebElement clickFinanceOverdueInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return department;
	}
	
	public static WebElement clickAccountOverdueInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[32]"));
		return department;
	}
	
	public static WebElement clickAccountOverdueInternalD(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[22]"));
		return department;
	}
	
	public static WebElement clickFinancePenFReviewInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return department;
	}
	
	public static WebElement clickAccountPenFReviewInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return department;
	}
	
	public static WebElement clickAccountPenFReviewInternalD(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return department;
	}
	
	
	public static WebElement clickFinanceInProgressInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[37]"));
		return department;
	}
	
	public static WebElement clickFinanceRejectedInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[40]"));
		return department;
	}
	
	public static WebElement clickAccountRejectedInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[35]"));
		return department;
	}
	
	public static WebElement clickFinanceNotAppliInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[43]"));
		return department;
	}
	
	
	public static WebElement clickBTRNotComplInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[56]"));
		return department;
	}
	
	public static WebElement clickDSSNotComplInternal(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[57]"));
		return department;
	}
	
	public static WebElement clickHumanClosedDelayed(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[28]"));
		return department;
	}
	
	public static WebElement clickAccountClosedDelayed(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return department;
	}
	
	public static WebElement clickFinanceClosedDelayed(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	
	public static WebElement clickHumanClosedTimely(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[46]"));
		return department;
	}
	
	public static WebElement clickHumanClosedTimelym(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return department;
	}
	
	public static WebElement clickAccountClosedTimely(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[31]"));
		return department;
	}
	
	public static WebElement clickAccountClosedTimelyA(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[30]"));
		return department;
	}
	
	public static WebElement clickFinanceClosedTimely(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[46]"));
		return department;
	}
	
	public static WebElement clickHumanOverdue(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[59]"));
		return department;
	}
	
	public static WebElement clickHumanOverduem(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return department;
	}
	
	public static WebElement clickAccountOverdue(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[32]"));
		return department;
	}
	
	public static WebElement clickAccountOverdueA(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[20]"));
		return department;
	}
	
	public static WebElement clickFinanceOverdue(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[54]"));
		return department;
	}
	
	public static WebElement clickFinanceOverdueDept(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[25]"));
		return department;
	}
	
	public static WebElement clickHumanPendingReview(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[72]"));
		return department;
	}
	
	public static WebElement clickHumanPendingReviewm(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[43]"));
		return department;
	}
	
	public static WebElement clickAccountPendingReview(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return department;
	}
	
	public static WebElement clickAccountPendingReviewA(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[21]"));
		return department;
	}
	
	public static WebElement clickAccountRejected(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return department;
	}
	
	public static WebElement clickFinancePendingReview(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[62]"));
		return department;
	}
	
	public static WebElement clickFinancePendingReviewDept(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[32]"));
		return department;
	}
	
	public static WebElement clickHumanNotApplicable(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[53]"));
		return department;
	}
	
	public static WebElement clickDepartmentHighHuman1(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[32]"));
		return department;
	}
	
	public static WebElement clickDepartmentHighHuman2(WebDriver driver)		//Method to search 'High Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[25]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman(WebDriver driver)	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[26]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman1(WebDriver driver)	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[41]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman2(WebDriver driver)	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[29]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman(WebDriver driver)		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman1(WebDriver driver)		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[50]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman2(WebDriver driver)		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[33]"));
		return department;
	}
	
	public static WebElement clickDepartmentInTime(WebDriver driver)		//Method to search 'In Time' bar under Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return department;
	}
	
	public static WebElement clickDepartmentAfterDueDate(WebDriver driver)	//Method to search 'After Due Date' bar under Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return department;
	}
	
	public static WebElement clickDepartmentNotCompleted(WebDriver driver)	//Method to search 'Not Completed' bar under Department Summary.
	{
		department = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return department;
	}
	
	public static WebElement clickDepartmentBack(WebDriver driver)			//Method to search Back button of Completion Status Bar Graph
	{
		department = driver.findElement(By.xpath("(//*[@class=' highcharts-button-box'])[5]"));
		return department;
	}
	
	public static WebElement clickViewAllDU(WebDriver driver)			//Method to search Back button of Completion Status Bar Graph
	{
		department = driver.findElement(By.xpath("//*[@id='dailyupdates']/div/div/div[4]/a"));
		return department;
	}
	
	
	
	public static WebElement clickView1(WebDriver driver)			//Method to search Back button of Completion Status Bar Graph
	{
		department = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdDailyUpdateList']/tbody/tr[2]/td[4]/a"));
		return department;
	}
	
	public static WebElement closeNewsView(WebDriver driver)			//Method to search Back button of Completion Status Bar Graph
	{
		department = driver.findElement(By.xpath("//*[@id='NewsModal']/div/div/div[1]/button"));
		return department;
	}
	
	public static WebElement clickViewAllNL(WebDriver driver)			//Method to search Back button of Completion Status Bar Graph
	{
		department = driver.findElement(By.xpath("//*[@id='collapseNewsletter']/div[3]/a"));
		return department;
	}
	
	public static WebElement clickView2(WebDriver driver)			//Method to search Back button of Completion Status Bar Graph
	{
		department = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdNewsLetterList']/tbody/tr[2]/td[4]/a"));
		return department;
	}
	
	public static WebElement closeNewsLView(WebDriver driver)			//Method to search Back button of Completion Status Bar Graph
	{
		department = driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[1]/button"));
		return department;
	}
	
	public static WebElement clickPenaltyCritical(WebDriver driver)		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[32]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHigh(WebDriver driver)		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril(WebDriver driver)		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[27]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril1(WebDriver driver)		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[58]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril2(WebDriver driver)		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMedium(WebDriver driver)		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[40]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril(WebDriver driver)		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril1(WebDriver driver)		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[60]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril2(WebDriver driver)		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[39]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLow(WebDriver driver)			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[44]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril(WebDriver driver)			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[39]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril1(WebDriver driver)			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[62]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril2(WebDriver driver)			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[42]"));
		return penlatysummary;
	}
	
	public static WebElement selectInternal(WebDriver driver)				//Method to search Dropdown box to click on Internal in filters
	{
		Internal = driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlStatus']"));
		return Internal;
	}
	
	public static WebElement clickApply(WebDriver driver)					//Method to search Apply button after clicking on Internal in filters dropdown
	{
		Internal = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnTopSearch']"));
		return Internal;
	}//*[@id="ContentPlaceHolder1_btnTopSearch"]
	//*[@id="Applybtn1"]
	public static WebElement clickBSEHighInternal(WebDriver driver)			//Searching 'High' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[2]"));
		return Internal;
	}
	
	public static WebElement clickBSEMediumInternal(WebDriver driver)		//Searching 'Medium' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		return Internal;
	}
	
	public static WebElement clickBSELowInternal(WebDriver driver)			//Searching 'Low' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[10]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccHigh(WebDriver driver)		//Searching 'High' bar of Account compliance in Department Summary (Internal)
	{
		Internal = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[22]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccMedium(WebDriver driver)		//Searching 'Medium' bar of Account compliance in Department Summary (Internal)
	{
		Internal = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[26]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccLow(WebDriver driver)		//Searching 'Medium' bar of Account compliance in Department Summary (Internal)
	{
		Internal = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return Internal;
	}
	
	public static List<WebElement> readCategoriesList(WebDriver driver)		//Method to read all interests in Penalty.
	{
		interestList = driver.findElements(By.xpath("//*[@onclick='window.parent.fCompliancesRahul();']"));
		return interestList;
	}
	
	public static List<WebElement> clickExpandGrading(WebDriver driver)				//Method to search second red box of Grading Report
	{
		interestList = driver.findElements(By.xpath("//*[@class='tree-icon tree-closed']"));
		return interestList;
	}
	
	public static WebElement clickRedGrading(WebDriver driver)				//Method to search second red box of Grading Report
	{
		grading = driver.findElement(By.xpath("(//*[@class='GradingRating3'])[2]"));
		return grading;//*[@id="basic"]/tbody/tr[2]/td[3]
	}//*[@id="basic"]/tbody/tr[2]/td[4]
	
	public static WebElement clickYellowGrading(WebDriver driver)			//Method to search first yellow box of Grading Report
	{
		grading = driver.findElement(By.xpath("(//*[@class='GradingRating2'])[1]"));
		return grading;
	}
	
	public static WebElement clickGreenGrading(WebDriver driver)			//Method to search first green box of Grading Report
	{
		grading = driver.findElement(By.xpath("(//*[@class='GradingRating1'])[1]"));
		return grading;
	}
	
	public static WebElement clickDropdown(WebDriver driver)				//Searching dropdown in Grading Report
	{
		grading = driver.findElement(By.xpath("//select[@name='ddlPageSize']"));
		return grading;
	}
	
	public static WebElement readTotalPagesGrading(WebDriver driver)		//Searching total pages count element
	{
		grading = driver.findElement(By.xpath("//span[@id='lTotalCount']"));
		return grading;
	}
	
	public static WebElement clickNextArrow(WebDriver driver)				//Searching next page arrow button in Grading Report
	{
		grading = driver.findElement(By.xpath("//input[@id='lBNext']"));
		return grading;
	}
	
	public static List<WebElement> countRecordsGrading(WebDriver driver)	//Searching all serial numbers to count total records. 
	{
		totalRecords = driver.findElements(By.xpath("//*[@align='center']"));
		return totalRecords;
	}
	
	public static WebElement clickDetailsGrading(WebDriver driver)			//Searching 'Details' link to click
	{
		grading = driver.findElement(By.xpath("//a[@id='lnkDetails']"));
		return grading;
	}
	
	public static WebElement clickGraphGrading(WebDriver driver)			//Searching all values inside each bar of graph.
	{
		grading = driver.findElement(By.xpath("//li[@id='liGraph']"));
		return grading;
	}
	
	public static List<WebElement> readGraphCount(WebDriver driver)			//Searching all the values inside each bar.
	{
		totalRecords = driver.findElements(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined ']"));
		return totalRecords; 
	}
	
	public static WebElement readDateComliance(WebDriver driver)			//Searching the cornered value of the Red date
	{
		calendar = driver.findElement(By.xpath("(//*[@class='badge badge-warning overdue'])[1]"));
		return calendar;
	}
	
	public static WebElement clickDateCalendar(WebDriver driver)			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = driver.findElement(By.xpath("(//div[@class='day sat past active'])[1]"));
		return calendar;
	}
	
	public static WebElement clickDateCalendar2(WebDriver driver)			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = driver.findElement(By.xpath("(//*[@data-day='1'])[1]"));
		return calendar;
	}
	
	public static WebElement clickCalendarProgress(WebDriver driver)			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = driver.findElement(By.xpath("//*[@id='imgcaldate']"));
		return calendar;
	}
	
	public static List<WebElement> clickDateCalendar1(WebDriver driver)		//CLicking the date on the calendar(first date of Red colour)
	{
		elementsList = driver.findElements(By.xpath("(//*[@style='background-color: rgb(255, 0, 0);'])[1]"));
		return elementsList;
	}
	
	public static WebElement clickAllChecklist(WebDriver driver)			//Searching "All(Including Checklist)" radio button
	{
		calendar = driver.findElement(By.xpath("//label[@for='ContentPlaceHolder1_rdbcalender_1']"));
		return calendar;
	}
	
	public static WebElement clickReports(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='leftdocumentsmenu1']"));
		return reports;
	}
	
	public static WebElement clickStandardReport(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='Kendoreport']"));
		return reports;
	}
	
	public static WebElement clickSRInternal(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_myFunctionShowInternal']"));
		return reports;
	}
	
	
	public static WebElement closeExport(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-button k-bare k-button-icon k-window-action'])[3]"));
		return reports;
	}
	
	public static WebElement ClickDownload(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='grid12']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadLocation(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridLocation']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadUser(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridUser']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadCategory(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridCategory']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadRisk(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridRisk']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadDetaild(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridDetaild']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadCriticalRisk(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridCriticalRisk']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	
	public static WebElement ClickPreview(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='grid12']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewLocation(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridLocation']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewUser(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridUser']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewCategory(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridCategory']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewRisk(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridRisk']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewDetailed(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridDetaild']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewCriticalR(WebDriver driver)					//Searching 'My Reports' element
	{
		reports = driver.findElement(By.xpath("//*[@id='gridCriticalRisk']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement clickDetailedReport(WebDriver driver)			//Searching 'Detailed Report' element under 'My reports'
	{
		reports = driver.findElement(By.xpath("//*[@id='Myreport']"));
		return reports;
	}
	
	public static WebElement clickActRepository(WebDriver driver)			//Searching 'Detailed Report' element under 'My reports'
	{
		reports = driver.findElement(By.xpath("//*[@id='ActReporeport']/a"));
		return reports;
	}
	
	public static WebElement clickComplianceDropDown(WebDriver driver)		//Searching the Compliance drop down
	{
		//reports = driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[2]"));
		reports = driver.findElement(By.xpath("//*[@id='example']/div/div[1]/div[3]/div/div"));
		return reports;
	}
	
	public static List<WebElement> selectComplianceMenus(WebDriver driver)	//Searching all sub menus of Compliance Dropdown
	{
		//menus = driver.findElements(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li"));
		menus = driver.findElements(By.xpath("//*[@id='1b781922-765f-4a56-a9cd-af38f09df1eb']//ul//li"));
		return menus;
	}
	
	public static WebElement clickMonthDropDown(WebDriver driver)			//Searching Month dropdown
	{
		reports = driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[3]"));
		return reports;
	}
	
	public static WebElement clickAllMonths(WebDriver driver)				//Selecting 'All' for  Month Dropdown
	{
		reports = driver.findElement(By.xpath("//*[@id='dropdownlistTypePastdata_listbox']/li[5]"));
		return reports;
	}
	
	public static WebElement clickAdvancedSearch(WebDriver driver)				//Selecting 'All' for  Month Dropdown
	{
		reports = driver.findElement(By.xpath("//*[@id='AdavanceSearch']"));
		return reports;
	}
	
	
	public static WebElement selectDropDownMenu(WebDriver driver)			//Searching Expanding arrow under dropdown box
	{
		reports = driver.findElement(By.xpath("(//span[@class='k-icon k-i-expand'])[1]"));
		return reports;
	}
	
	public static WebElement selectMenu(WebDriver driver)					//Searching the 18th checkbox to select
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[18]"));
		return reports;
	}
	
	public static WebElement selectMenu1(WebDriver driver)					//Searching the 15th checkbox to select
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[15]"));
		return reports;
	}
	
	public static WebElement clickLastPageArrow(WebDriver driver)			//Method to search arrow button to get last page
	{
		reports = driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-end-right']"));
		return reports;
	}
	
	public static WebElement clickExportImage(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='export']"));
		return reports;
	}
	
	
	
	public static WebElement clickStartDate1(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/span[2]/span/span/span"));
		return reports;
	}
	
	public static WebElement clickStartDate11(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='Startdatepicker']"));
		return reports;
	}

	public static WebElement clickLastDate11(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='Lastdatepicker']"));
		return reports;
	}
	
	public static WebElement clickAssignmentReport(WebDriver driver)		//Searching 'Assignment Report' element under 'My reports'
	{
		reports = driver.findElement(By.xpath("//*[@id='Myreport1']"));
		return reports;
	}
	
	
	//button[@id='export']
	public static WebElement clickDropDown1(WebDriver driver)				//Searching Entity DropDown in Assignment Report
	{
		reports = driver.findElement(By.xpath("//*[@class='txtbox']"));
		return reports;
	}
	
	public static WebElement clickEntity(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='example']/div[1]/div/div"));
		return reports;
	}
	
	public static WebElement clickExpand(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@data-role='treeview']/ul/li/div/span[1]"));
		return reports;
	}
	
	public static WebElement selectType(WebDriver driver)				//Searching Entity DropDown in Assignment Report
	{
		reports = driver.findElement(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return reports;
	}
	
	public static WebElement selectType2(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("(//*[@id='example']/div[1]/div/div)[1]"));
		return reports;
	}
	
	public static WebElement Status(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("(//span[@class='k-icon k-i-more-vertical'])[6]"));
		return reports;
	}
	
	public static WebElement Filter(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//li[@class='k-item k-filter-item k-state-default k-last']"));
		return reports;
	}
	
	public static WebElement NotApplicable(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-label']/input)[3]"));
		return reports;
	}
	
	
	public static WebElement ClosedDelayed(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-label']/input)[4]"));
		return reports;
	}
	
	public static WebElement ClosedTimely(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-label']/input)[4]"));
		return reports;
	}
	
	public static WebElement ClosedDelayedA(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-label']/input)[6]"));
		return reports;
	}
	
	public static WebElement NotApplicableA(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("(//*[@class='k-label']/input)[7]"));
		return reports;
	}
	
	
	public static WebElement ClickFilter(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//button[@class='k-button k-primary']"));
		return reports;
	}
	
	public static WebElement clickDocuments(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return documents;
	}
	
	public static WebElement clickComplianceDocuments(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='ComplianceDocumentList']"));
		return documents;
	}
	
	public static WebElement clickActDocuments(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='ActDocumentList']"));
		return documents;
	}
	
	public static WebElement clickMyEscalation(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='leftescalationmenu']/a"));
		return documents;
	}
	
	public static WebElement clickMyNotifications(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='alert_notificatoin_bar']/a/i"));
		return documents;
	}
	
	public static WebElement clickMessageCenter(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//i[@class='icon-envelope-l topmailbox']"));
		return documents;
	}
	
	public static WebElement clickViewBtnNO(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_lnkShowDetails_0']"));
		return documents;
	}
	
	public static WebElement clickViewMsg(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdUserReminder']/tbody/tr[2]/td[6]/a"));
		return documents;
	}
	
	public static WebElement CloseViewNO(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']"));
		return documents;
	}
	
	public static WebElement clickDownloadBtn(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='rptComplianceVersion_btnComplinceVersionDoc_0']"));
		return documents;                      
	}
	
	public static WebElement clickDownloadBtn1(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='rptIComplianceVersion_btnComplinceVersionDoc_0']"));
		return documents;                      
	}
	
	public static WebElement closeDownloadTab(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='divDownloadView']/div/div/div[1]/button"));
		return documents;                      //*[@id="divOverViewMain1"]/div/div/div[1]/button
	}
	//*[@id="divDownloadView"]/div/div/div[1]/button
	public static WebElement closeDownloadTab1(WebDriver driver)					//Searching 'My Reports' element
	{
		documents = driver.findElement(By.xpath("//*[@id='divDownloadView1']/div/div/div[1]/button"));
		return documents;                        //*[@id="divDownloadView1"]/div/div/div[1]/button
	}
	
	public static List<WebElement> clickType2(WebDriver driver)
	{
		menus = driver.findElements(By.xpath("//div[@class = 'k-widget k-treeview']/ul/li"));
		return menus;                        
	}
	
	public static List<WebElement> clickSubMenu(WebDriver driver)			//Searching first menu in Entity DropDown in Assignment Report
	{
		menus = driver.findElements(By.xpath("//*[@class='ContentPlaceHolder1_tvFilterLocation_2']"));
		return menus;
	}
	
	public static List<WebElement> clickDropDown2(WebDriver driver)			//Searching for dropdown of 'No of Records' and 'Compliances'
	{
		menus = driver.findElements(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return menus;
	}
	
	public static WebElement clickShowDropDown(WebDriver driver)		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']"));
		return reports;
	}
	
	public static WebElement clickAllDropDown(WebDriver driver)		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = driver.findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_ddlStatus']"));
		return reports;
	}
	
	public static WebElement clickInternalSubmenu1(WebDriver driver)		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt1']"));
		return reports;
	}
	
	public static WebElement clickInternalSubmenu2(WebDriver driver)		//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt2']"));
		return reports;
	}
	
	public static WebElement clickApply1(WebDriver driver)					//Method to search 'Apply' button
	{
		reports = driver.findElement(By.xpath("//input[@value='Apply']"));
		return reports;
	}
	
	public static WebElement clickApplyAd(WebDriver driver)					//Method to search 'Apply' button
	{
		reports = driver.findElement(By.xpath("//*[@id='Applybtn1']"));
		return reports;
	}
	
	public static WebElement clickApply3(WebDriver driver)					//Method to search 'Apply' button
	{
		reports = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnSearchPenalty']"));
		return reports;
	}
	
	public static WebElement readTotalPages(WebDriver driver) 				//Method to search Total pages count string
	{
		reports = driver.findElement(By.xpath("//span[@id='ContentPlaceHolder1_lTotalCount']"));
		return reports;
	}
	
	public static WebElement readTotalPages1(WebDriver driver) 				//Method to search Total pages count string
	{
		reports = driver.findElement(By.xpath("//span[@class='k-pager-info k-label']"));
		return reports;//*[@id="grid"]/div[4]/span[2]
	}
	
	public static WebElement clickNextButton(WebDriver driver)				//Method to click on 'Next Button' arrow
	{
		reports = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_lBNext']"));
		return reports;
	}
	
	public static WebElement clickExport1(WebDriver driver)					//Searching Export to Excel button 
	{
		reports = driver.findElement(By.xpath("//input[@value='Export to Excel']"));
		return reports;
	}
	
	public static WebElement clickExportExcel(WebDriver driver)					//Searching Export to Excel button 
	{
		reports = driver.findElement(By.xpath("//*[@id='exportAdvanced']"));
		return reports;
	}
	
	public static WebElement clickUsageReport(WebDriver driver)				//Searching 'Usage Report' element under 'My reports'
	{
		reports = driver.findElement(By.xpath("//*[@id='Myreport2']"));
		return reports;
	}
	
	public static WebElement clickStartDate(WebDriver driver)				//Searching Start Date input box
	{
		reports = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtStartDate']"));
		return reports;
	}
	
	public static WebElement clickEndDate(WebDriver driver)					//Searching End Date input box
	{
		reports = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtEndDate']"));
		return reports;
	}
	
	public static WebElement clickExport(WebDriver driver)					//Searching Export to Excel button 
	{
		reports = driver.findElement(By.xpath("//input[@value='Export To Excel']"));
		return reports;
	}
	
	public static WebElement clickAuditReport(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='Auditreport']"));
		return reports;
	}
	
	public static WebElement clickEntityDropdown(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return reports;
	}
	
	public static WebElement clickExportReport(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddNew']"));
		return reports;
	}
	
	public static List<WebElement> getVendorNames(WebDriver driver)
	{
		menus = driver.findElements(By.xpath("//*[@data-placement='bottom']"));
		return menus;
	}
	
	public static WebElement clickInternalSubmenu3(WebDriver driver)	//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt7']"));
		return reports;
	}
	
	public static WebElement clickAllYear(WebDriver driver)			//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_rbFinancialYearFunctionSummery_2']"));
		return reports;
	}
	
	public static WebElement waitProgress(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='grid']/div[4]/div/div[1]"));
		return reports;
	}
	
	public static WebElement selectInternal1(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='dropdownType_listbox']/li[4]"));
		return reports; 
	}
	
	public static WebElement clickType(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return reports; 
	}
	
	public static WebElement selectType1(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='dropdownType_listbox']/li[4]"));
		return reports; 
	}
	
	public static WebElement clickFirstEntity(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[contains(@id,'tv_active')]/div/span[2]/span"));
		return reports; 
	}
	
	public static WebElement clickPenaltyYear(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFinancialYear']"));
		return reports; 
	}
	
	public static WebElement clickYear(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlYearGrading']"));
		return reports; 
	}
	
	public static WebElement clickApply2(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnGradingSearch']"));
		return reports; 
	}
	
	public static WebElement clickComplianceType(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@aria-owns='dropdownlistComplianceType_listbox']"));
		return reports; 
	}
	
	public static WebElement selectTypeInternal(WebDriver driver)
	{
		reports = driver.findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
		return reports; 
	}
	
	public static WebElement selectMonth(WebDriver driver)
	{
		//reports = driver.findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[3]"));
		reports = driver.findElement(By.xpath("//*[@id='example']/div/div[2]/span/span"));
		return reports; //*[@id="divAdvanceSearchModel"]/div[2]/span[2]/span/span[2]
	}
	
	public static WebElement selectMonth1(WebDriver driver)
	{
		
		reports = driver.findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[2]/span/span[2]"));
		return reports; 
	}
	
	public static WebElement selectLastSixMon(WebDriver driver)
	{
		
		reports = driver.findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[3]"));
		return reports; 
	}//li[@class='k-item k-state-hover']
	
	public static WebElement clickTpes1(WebDriver driver)
	{
		reports = driver.findElement(By.xpath(""));
		return reports; 
	}
	
	public static WebElement clickTyeps1(WebDriver driver)
	{
		reports = driver.findElement(By.xpath(""));
		return reports; 
	}
	
	public static WebElement clickMyTask(WebDriver driver)		//Method for reading Compliances value on Dashboard
	{
		compliances = driver.findElement(By.xpath("//*[@id='main-content']/header/div[2]/ul/li[4]/ul/li[4]"));
		return compliances;
	} 
	
	public static void CategoriesCountMatch(WebDriver driver, ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Categories =CFOcountPOM.clickCategories(driver).getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories(driver).click();
		Thread.sleep(4000);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (200));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[3]/a")));
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItems4(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems4(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
	/*	elementsList1 = CFOcountPOM.readCompliancesList(driver);
		elementsList1.get(1).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
		Thread.sleep(2000);
	
		int n1 = elementsList1.size();
		int value = 0;
		int count1 = 0;
	//	for(int i = 0; i < n1; i++)
	//	{		
			Thread.sleep(500);
			elementsList1 = CFOcountPOM.readCompliancesList(driver);
			value = Integer.parseInt(elementsList1.get(1).getText());
			elementsList1.get(1).click();
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress(driver);
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD(driver).click();
			
			Thread.sleep(1000);
			String item1 = CFOcountPOM.readTotalItemsD(driver).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			
			count1 = Integer.parseInt(compliancesCount1);
			js.executeScript("window.scrollBy(0,3000)");
			if(value == count1)
			{
				test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + value+ ", Grid Records = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+value+", Grid Records = "+count1);
			}
			driver.switchTo().parentFrame();								//Switching back to parent frame.
			Thread.sleep(3000);
			CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
			Thread.sleep(2000);
	//	}	*/
		if(CategoriesCountDas == CatcountGrid)
		{
			//test.log(LogStatus.PASS, "Number of Categories grid matches to Dashboard Categories  Count.");
			test.log(LogStatus.PASS, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
			test.log(LogStatus.FAIL, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(4000);
		
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(2000);
		
	}
	
	public static void Compliances(WebDriver driver, ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Compliances =CFOcountPOM.readCompliances(driver).getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.readCompliances(driver).click();
		Thread.sleep(7000);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(10000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		CFOcountPOM.clickLocation(driver).click();
		Thread.sleep(500);
		CFOcountPOM.clickBitaAurangabad(driver).click();
		Thread.sleep(1000);
		CFOcountPOM.clickClear(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Clear Button is working Successfully");	
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			test.log(LogStatus.PASS, "Number of Compliances grid matches to Dashboard Compliances  Count.");
			test.log(LogStatus.PASS, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Compliances Count.");
			test.log(LogStatus.FAIL, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
	}
	
	public static void CountGrading(WebDriver driver, ExtentTest test, String Risk) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, (30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Switching to iFrame.
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='k-grid-content k-auto-scrollable']")));
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,400)");
		Actions action = new Actions(driver);
		action.moveToElement(CFOcountPOM.readTotalItems1(driver)).click().perform();		//clicking on total pages count to scroll window down
		
		Thread.sleep(1000);
		CFOcountPOM.readTotalItems1(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItems1(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		for(int i = 0; i <= 3; i++)
		{
			if(itomsCount.equalsIgnoreCase("to"))							//If not items found
			{
				Thread.sleep(2500);
				s1 = CFOcountPOM.readTotalItems1(driver).getText();
				bits = s1.split(" ");										//Splitting the String
				itomsCount = bits[bits.length - 2];
			}
			else
			{
				break;
			}
		}
		int count = Integer.parseInt(itomsCount);
		js.executeScript("window.scrollBy(0,-300)");
		
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFiles = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage(driver).click();			//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads\\");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(allFiles.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, Risk+" :- File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(500);		
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			workbook.write(fos);
			fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			if(count == SheetRecords)
			{
				test.log(LogStatus.PASS, "Total records count displayed on grid matches with the number of records in the Excel Report.");
				test.log(LogStatus.PASS, "Total records count from grid = "+count+" | Total records count in the Excel Report = "+SheetRecords);
			}
			else
			{
				test.log(LogStatus.FAIL, "Total records count displayed on grid doesn't matches with the number of records in the Excel Report.");
				test.log(LogStatus.FAIL, "Total records count from grid = "+count+" | Total records count in the Excel Report = "+SheetRecords);
			}
		}
		else
		{
			test.log(LogStatus.PASS, Risk+" :- File didn't downloaded successfully.");
		}
		
		driver.switchTo().parentFrame();
		CFOcountPOM.closePopup(driver).click();
	}
	
	public static void CountPenalty(WebDriver driver, ExtentTest test, int valuePenalty) throws InterruptedException
	{
		int interest = 0;					//Variable created for reading Interest
		int penalty1 = 0;						//Variable created for reading Penalty
		
		Thread.sleep(500);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 2000 px.
		CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		CFOcountPOM.readTotalItemsD(driver).click();
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		int count = 0;
		int loop = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If items not found
		{
			for(int i = 0; i < 4; i++)
			{
				Thread.sleep(2000);
				s1 = CFOcountPOM.readTotalItemsD(driver).getText();
				bits = s1.split(" ");									//Splitting the String
				itomsCount = bits[bits.length - 2];
				if(!itomsCount.equalsIgnoreCase("to"))					//If not items found
				{
					break;
				}
			}
		}
		count = Integer.parseInt(itomsCount);
		loop = count / 10;									//Dividing by 10, as total number of items in a list is 10
		
		int n2 = 0;
		for(int no = 0; no < loop+1; no++)
		{
			Thread.sleep(200);
			elementsList2 = CFOcountPOM.readPenalty(driver);			//Searching all values of Penalty
			n2 = elementsList2.size();
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(50);			
			for(int i = 0; i < n2; i++)
			{
				action.moveToElement(elementsList2.get(i)).doubleClick().build().perform();
				Thread.sleep(50);
				int j = Integer.parseInt(elementsList2.get(i).getText());	//Reading each Compliance value.
				penalty1 = penalty1 + j;										//Calculating the read Compliance values.
			}
			
			if(CFOcountPOM.clickNextPage1(driver).isEnabled())
			{
				Thread.sleep(100);
				CFOcountPOM.readTotalItemsD(driver).click();				//Clicking to escape unwanted tooltips
				CFOcountPOM.clickNextPage1(driver).click();
			}
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(1000,0)");						//Scrolling Up window by 2000 px.
		CFOcountPOM.clickInterest(driver).click();						//Clicking on 'Interest' link/menu.
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
		
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.loadGrid(driver)));	//Wait until the Interest Values displays
		Thread.sleep(100);
		CFOcountPOM.ClearButton(driver).sendKeys(Keys.PAGE_DOWN);
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 2000 px.
		
		Thread.sleep(1000);
		for(int no = 0; no < loop+1; no++)
		{
			Thread.sleep(200);
			elementsList1 = CFOcountPOM.readInterest(driver);			//Searching all values of Interest 
			int n1 = elementsList1.size();
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(100);
			for(int i = 0; i < n1; i++)
			{
				action.moveToElement(elementsList1.get(i)).doubleClick().build().perform();
				Thread.sleep(50);
				int j = Integer.parseInt(elementsList1.get(i).getText());	//Reading each Compliance value.
				interest = interest + j;									//Calculating the read Compliance values.
			}
			
			if(CFOcountPOM.clickNextPage1(driver).isEnabled())
			{
				Thread.sleep(100);
				CFOcountPOM.readTotalItemsD(driver).click();				//Clicking to escape unwanted tool tips
				CFOcountPOM.clickNextPage1(driver).click();
			}
		}
		
		CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
		driver.switchTo().parentFrame();								//Switching back to Interest's parent frame.
		driver.switchTo().parentFrame();								//Switching back to main parent frame.
		Thread.sleep(500);
		CFOcountPOM.closeCategories(driver).click();					//Closing the 'Penalty' pop up.
		
		int total = interest + penalty1;
		
		if(total == valuePenalty)
		{
			test.log(LogStatus.PASS, "'Penalty' count matches to sum. Dashboard Value = " + valuePenalty + " | Sum of Penalty from 'Penalty' click = "+ total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Penalty' count doesn't matches. Dashboard Value = " + valuePenalty + " | Sum of Penalty from 'Penalty' click = "+ total);
		}
	}
	
 	public static void GraphCount(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
	//	 CFOcountPOM.clickExportImage(driver).click();
		//	Thread.sleep(4000);
	//		test.log(LogStatus.PASS, "Excel file Export Successfully");
		//	Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
	/*	try
		{
			elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
			elementsList.get(0).click();									//Clicking on first 'Entity Location' Drop down.
			
			Thread.sleep(300);
			Actions action = new Actions(driver);
			if(Compliance.equalsIgnoreCase("Statutory"))
			{
				action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING PVT LTD)
			}
			else
			{
				action.moveToElement(CFOcountPOM.selectFirst1(driver)).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
			}
		}
		catch(Exception e)
		{
			
		}*/
		
		CFOcountPOM.clickExportImage(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
		
		
	}
 	
 	public static void GraphCount3(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
	//	 CFOcountPOM.clickExportImage(driver).click();
		//	Thread.sleep(4000);
	//		test.log(LogStatus.PASS, "Excel file Export Successfully");
		//	Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
	/*	try
		{
			elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
			elementsList.get(0).click();									//Clicking on first 'Entity Location' Drop down.
			
			Thread.sleep(300);
			Actions action = new Actions(driver);
			if(Compliance.equalsIgnoreCase("Statutory"))
			{
				action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING PVT LTD)
			}
			else
			{
				action.moveToElement(CFOcountPOM.selectFirst1(driver)).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
			}
		}
		catch(Exception e)
		{
			
		}*/
		
		CFOcountPOM.clickExportImage(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
		
		
	}
	
	
 	public static void GraphCountM(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(8000);
		}
		catch(Exception e)
		{
			
		}
		
	//	 CFOcountPOM.clickExportImage(driver).click();
		//	Thread.sleep(4000);
	//		test.log(LogStatus.PASS, "Excel file Export Successfully");
		//	Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView success");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
	/*	try
		{
			elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
			elementsList.get(0).click();									//Clicking on first 'Entity Location' Drop down.
			
			Thread.sleep(300);
			Actions action = new Actions(driver);
			if(Compliance.equalsIgnoreCase("Statutory"))
			{
				action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING PVT LTD)
			}
			else
			{
				action.moveToElement(CFOcountPOM.selectFirst1(driver)).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
			}
		}
		catch(Exception e)
		{
			
		}*/
		
		CFOcountPOM.clickExportImage(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	}
	
 	
 	public static void GraphCountIn(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
}else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
 	public static void GraphCountIn1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver,(100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(1000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View Successfully");
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			test.log(LogStatus.PASS, "Doc Download Successfully");
			Thread.sleep(3000);
			ViewButton.get(2).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
			Thread.sleep(1000);
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
}else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
 	public static void GraphCountInPe(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Document downloaded successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(2).click();
		    Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories1(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories1(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
				
		}
	}
 	
 	public static void GraphCountInPe1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories1(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories1(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
 	
 	public static void GraphCountIn2(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]/a");

			Thread.sleep(3000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			test.log(LogStatus.PASS, "View Successfully");
			Thread.sleep(3000);
			ViewButton.get(2).click();
			test.log(LogStatus.PASS, "Doc Download Successfully");
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
			Thread.sleep(1000);
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
			
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					driver.switchTo().parentFrame();
					CFOcountPOM.closeCategories(driver).click();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
 	public static void GraphCountIn3(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(3000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
				
		}
	}
	
 	
 	public static void GraphCount1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver,(160));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = driver.findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocument1(driver).click();
				test.log(LogStatus.PASS, "View successfully");
				Thread.sleep(3000);
				
				ViewButton.get(1).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Download Doc successfully");
				ViewButton.get(2).click();
			//JavascriptExecutor jse=(JavascriptExecutor)driver;
			//jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument(driver).click();
				Thread.sleep(3000);
			/*	ViewButton.get(3).click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
					Thread.sleep(500);
					CFOcountPOM.EnterRemark(driver).sendKeys("remark");
					Thread.sleep(1000);
					CFOcountPOM.ReOpen(driver).click();
					Thread.sleep(8000);
					String msg =driver.switchTo().alert().getText();
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					test.log(LogStatus.PASS, "Message Display " +msg);
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		Thread.sleep(5000);*/
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
 	
 	public static void GraphCount2(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver,(160));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = driver.findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocument1(driver).click();
				test.log(LogStatus.PASS, "View successfully");
				Thread.sleep(3000);
				
				ViewButton.get(1).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Download Doc successfully");
				ViewButton.get(2).click();
			//JavascriptExecutor jse=(JavascriptExecutor)driver;
			//jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument(driver).click();
				Thread.sleep(3000);
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
 	
 	
	public static void BarGraphCount(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException
	{
		Thread.sleep(500);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely(driver).click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed(driver).click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted(driver).click();			//Clicking on Not Completed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable(driver).click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,(200));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
		Thread.sleep(8000);
	
		CFOcountPOM.clickExportImage(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);

			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = driver.findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocument1(driver).click();
				test.log(LogStatus.PASS, "View successfully");
				Thread.sleep(3000);
				
				ViewButton.get(1).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Download Doc successfully");
				ViewButton.get(2).click();
			Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument(driver).click();
				Thread.sleep(3000);
	
		Thread.sleep(1000);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories(driver).click();					//Closing the In Time compliance window.
		
		if(count == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void BarGraphCount1(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException
	{
		Thread.sleep(500);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely(driver).click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed(driver).click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted(driver).click();			//Clicking on Not Completed bar of Labour Category
			
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable(driver).click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
	/*	
		elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
		elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
		action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down.
		*/
		Thread.sleep(1000);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories(driver).click();					//Closing the In Time compliance window.
		
		if(count == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void BarGraphCountIn(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException
	{
		Thread.sleep(500);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely(driver).click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed(driver).click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted(driver).click();			//Clicking on Not Completed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable(driver).click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Actions action = new Actions(driver);
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);

		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories(driver).click();					//Closing the In Time compliance window.
		
		if(count == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
	}else {
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
		
		
		
	}
	}
	
	public static void BarGraphCountIn1(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException
	{
		Thread.sleep(500);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely(driver).click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed(driver).click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted(driver).click();			//Clicking on Not Completed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable(driver).click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
	
		Thread.sleep(1000);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories(driver).click();					//Closing the In Time compliance window.
		
		if(count == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
			
			
		}
	}
	
	
	public static void RiskGraphCount(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (100));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = driver.findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocument1(driver).click();
				test.log(LogStatus.PASS, "View successfully");
				Thread.sleep(3000);
				
				ViewButton.get(1).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Download Doc successfully");
				ViewButton.get(2).click();
			
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument(driver).click();
				Thread.sleep(3000);
				
			/*	ViewButton.get(3).click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
					Thread.sleep(500);
					CFOcountPOM.EnterRemark(driver).sendKeys("remark");
					Thread.sleep(1000);
					CFOcountPOM.ReOpen(driver).click();
					Thread.sleep(8000);
					String msg =driver.switchTo().alert().getText();
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					test.log(LogStatus.PASS, "Message Display " +msg);
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		Thread.sleep(5000);*/
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void RiskGraphCountRe(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (100));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = driver.findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocument1(driver).click();
				test.log(LogStatus.PASS, "View successfully");
				Thread.sleep(3000);
				
				ViewButton.get(1).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Download Doc successfully");
				ViewButton.get(2).click();
			
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument(driver).click();
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
				Thread.sleep(2000);
				CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
				String s1 = CFOcountPOM.readTotalItemsD(driver).getText();
				ViewButton.get(3).click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
					Thread.sleep(500);
					CFOcountPOM.EnterRemark(driver).sendKeys("remark");
					Thread.sleep(1000);
					CFOcountPOM.ReOpen(driver).click();
					Thread.sleep(8000);
					String msg =driver.switchTo().alert().getText();
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					test.log(LogStatus.PASS, "Message Display " +msg);
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
	//	CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
	//	String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void RiskGraphCount1(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (60));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[17]/a");

			//By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[17]/a[3]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		
	//	elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
		//elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
	/*	if(Complaince.equalsIgnoreCase("Internal"))
		{
			action.moveToElement(CFOcountPOM.selectFirst1(driver)).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
		}
		else
		{
			action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING)
		}*/
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void RiskGraphCountIn(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (100));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		     Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView success");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void RiskGraphCountIn1(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (70));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(1000);
		
		
	
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void DetailedReportIn1(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(clickComplianceDropDown(driver)));
		clickComplianceDropDown(driver).click();		//Clicking on Compliance drop down.
		Thread.sleep(500);
	}
	
	public static void StandardReportOverall(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_header1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Overall -Export");
		ClickDownload(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Overall -Download");
		ClickPreview(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, " Overall -Preview");
	      driver.switchTo().window(pw);         // switching parent window
	    performer.OverduePOM.clickDashboard(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportLocation(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Location -Export");
		ClickDownloadLocation(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Location -Download");
		ClickPreviewLocation(driver).click();
		//Thread.sleep(5000);
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, " Location -Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportUser(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton2']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " User -Export");
		ClickDownloadUser(driver).click();
		Thread.sleep(5000);
		 test.log(LogStatus.PASS, " User -Download");
		ClickPreviewUser(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, " User -Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCategory(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton3']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		 test.log(LogStatus.PASS, " Category -Export");
		ClickDownloadCategory(driver).click();
		Thread.sleep(5000);
		 test.log(LogStatus.PASS, " Category -Download");
		ClickPreviewCategory(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, " Category -Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportRisk(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton4']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		 test.log(LogStatus.PASS, " Risk -Export");
		ClickDownloadRisk(driver).click();
		Thread.sleep(5000);
		 test.log(LogStatus.PASS, " Risk -Download");
		ClickPreviewRisk(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, " Risk -Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportDetailed (ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	
		Thread.sleep(4000);
		ClickDownloadDetaild(driver).click();
		Thread.sleep(5000);
		 test.log(LogStatus.PASS, " Detailed -Download");
		ClickPreviewDetailed(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, " Detailed -Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCriticalRisk(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton6']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Critical Risk -Export");
		ClickDownloadCriticalRisk(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Critical Risk -Download");
		ClickPreviewCriticalR(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, "Critical Risk -Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportOverallIn(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		clickSRInternal(driver).click();
		Thread.sleep(4000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_header1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(3000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Overall Internal-Export");
		ClickDownload(driver).click();
		Thread.sleep(5000);
		try {
			String msg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Overall Internal-Download");	
				}
	//	test.log(LogStatus.PASS, "Overall Internal-Download");
		ClickPreview(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, "Overall Internal-Preview");
	      driver.switchTo().window(pw);         // switching parent window
	    performer.OverduePOM.clickDashboard(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportLocationIN(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		clickSRInternal(driver).click();
		Thread.sleep(4000);
	
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Location Internal-Export");
		ClickDownloadLocation(driver).click();
		Thread.sleep(4000);
try {
	String msg = driver.switchTo().alert().getText();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();							//Clicking on OK of alert.
	test.log(LogStatus.PASS, "Message displayed -:- " + msg);
			
		}
		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Location Internal-Download");	
		}
		//test.log(LogStatus.PASS, "Location Internal-Download");
		ClickPreviewLocation(driver).click();
		//Thread.sleep(5000);
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
		    
	      driver.close();
	      test.log(LogStatus.PASS, "Location Internal-Perview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportUserIN(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		clickSRInternal(driver).click();
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton2']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "User Internal-Export");
		ClickDownloadUser(driver).click();
		Thread.sleep(5000);
		try {
			String msg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "User Internal-Download");	
				}
		//test.log(LogStatus.PASS, "User Internal-Download");
		ClickPreviewUser(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, "User Internal-Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCategoryIN(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(8000);
		clickSRInternal(driver).click();
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(4000);
		
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton3']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(2000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Category Internal-Export");
		ClickDownloadCategory(driver).click();
		Thread.sleep(5000);
		try {
			String msg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Category Internal-Download");	
				}
	//	test.log(LogStatus.PASS, "Category Internal-Download");
		ClickPreviewCategory(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, "Category Internal-Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportRiskIN(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		clickSRInternal(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
		
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton4']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		closeExport(driver).click();
		test.log(LogStatus.PASS, "Risk Internal-Export");
		Thread.sleep(4000);
		ClickDownloadRisk(driver).click();
		Thread.sleep(3000);
		try {
			String msg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Risk Internal-Download");	
				}
		//test.log(LogStatus.PASS, "Risk Internal-Download");
		ClickPreviewRisk(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	      test.log(LogStatus.PASS, "Risk Internal-Preview");
	      driver.switchTo().window(pw);  
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportDetailedIN (ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		clickSRInternal(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	
		Thread.sleep(3000);
		ClickDownloadDetaild(driver).click();
		Thread.sleep(3000);
		try {
			String msg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Detailed Internal-Download");	
				}
	//	test.log(LogStatus.PASS, "Detailed Internal-Download");
		Thread.sleep(5000);
		ClickPreviewDetailed(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	     
	      driver.switchTo().window(pw);  
	      test.log(LogStatus.PASS, "Detailed  Internal-Preview");
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCriticalRiskIN(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		clickSRInternal(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton6']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Critical Risk Internal-Export");
		closeExport(driver).click();
		Thread.sleep(4000);
		ClickDownloadCriticalRisk(driver).click();
		Thread.sleep(3000);
		try {
			String msg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Critical Internal-Download");	
				}
		// test.log(LogStatus.PASS, "Critical Risk Internal-Download");
		ClickPreviewCriticalR(driver).click();
		Thread.sleep(8000);
		Set w = driver.getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	    
	      driver.close();
	     
	      driver.switchTo().window(pw); 
	      test.log(LogStatus.PASS, "Critical Risk Internal-Preview");
		performer.OverduePOM.clickDashboard(driver).click();
	//	ClickPreview(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportDepartment(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton7']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Critical Risk Internal-Export");
		closeExport(driver).click();
		Thread.sleep(4000);

		performer.OverduePOM.clickDashboard(driver).click();
	
		Thread.sleep(5000);
		
	}
	
	
	
	public static void StandardReportDepartmentIN(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport(driver).click();
		Thread.sleep(7000);
		clickSRInternal(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg(driver).click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton7']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Critical Risk Internal-Export");
		closeExport(driver).click();
		Thread.sleep(4000);

		performer.OverduePOM.clickDashboard(driver).click();
	
		Thread.sleep(5000);
		
	}
	
	
	
	public static void DetailedReport1(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage(driver).click();			//Exporting (Downloading) file
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Exporting (Downloading) file successfully");
	//	By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument1(driver).click();
		test.log(LogStatus.PASS, "overView successfully");
	//	CFOcountPOM.closeDocument1(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " : -Clear Button Working Successfully ");
		clickAdvancedSearch(driver).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	//	clickExportExcel(driver).click();
		Thread.sleep(3000);//*[@id="grid"]/div[2]/table/tbody/tr[1]/td/a
	//	By locator1 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = driver.findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "AdvancedSearch - overView successfully");
		Thread.sleep(1000);
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = driver.findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2(driver).click();
		Thread.sleep(4000);
		clickExportExcel(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "AdvancedSearch - Exporting (Downloading) file successfully");
		selectMonth1(driver).click();
		Thread.sleep(3000);
		
		selectLastSixMon(driver).click();
		Thread.sleep(2000);
		clickApplyAd(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel(driver).click();
			Thread.sleep(2000);//*[@id="grid1"]/div[2]/table/tbody/tr[1]/td/a
			By locator2 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = driver.findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			//test.log(LogStatus.PASS, "AdvancedSearch - overView successfully");
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(4000);
			clickExportExcel(driver).click();
			Thread.sleep(3000);
			//clickStartDate1(driver).click();
			clickStartDate11(driver).sendKeys("23-Nov-2022");
			clickLastDate11(driver).sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			clickApplyAd(driver).click();
			Thread.sleep(2000);
			closeDocumentAS(driver).click();
			Thread.sleep(2000);
		//	test.log(LogStatus.PASS, "Advanced Search : -Clear Button Working Successfully ");
			performer.OverduePOM.clickDashboard(driver).click();
	}
	
	public static void DetailedReportReOpen(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver,(120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		Status(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		Filter(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		NotApplicable(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		ClosedDelayed(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		ClickFilter(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[2]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews5"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark(driver).sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen(driver).click();
		Thread.sleep(8000);
		String msg =driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
driver.switchTo().parentFrame();


Thread.sleep(2000);
performer.OverduePOM.clickDashboard(driver).click();
Thread.sleep(2000);
	}
	
	
	public static void DetailedReport2(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (120));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		Thread.sleep(2000);
	WebElement select=	driver.findElement(By.xpath("//*[@id='example']/div/div[1]/div[1]/span"));
	select.click();//*[@id="divAdvanceSearchModel"]/div[1]/div[1]/span
		driver.findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='Applybtn']")).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();			//Exporting (Downloading) file
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument1(driver).click();
		test.log(LogStatus.PASS, "overView Successfully");
	//	CFOcountPOM.closeDocument1(driver).click();
		Thread.sleep(4000);
		clickAdvancedSearch(driver).click();
		Thread.sleep(4000);
		WebElement select1=	driver.findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/span"));
		select1.click();//*[@id="divAdvanceSearchModel"]/div[1]/div[1]/span
			driver.findElement(By.xpath("//*[@id='dropdownlistUserRole1_listbox']/li[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='Applybtn1']")).click();
			Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	//	clickExportExcel(driver).click();
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = driver.findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
	//	test.log(LogStatus.INFO, "overView success");
		Thread.sleep(1000);
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = driver.findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "AdvancedSearch - overView successfully");
		Thread.sleep(4000);
		clickExportExcel(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "AdvancedSearch - Exporting (Downloading) file successfully");
		selectMonth1(driver).click();
		Thread.sleep(3000);
		
		selectLastSixMon(driver).click();
		Thread.sleep(2000);
		clickApplyAd(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel(driver).click();
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = driver.findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search : -overView success");
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(4000);
			clickExportExcel(driver).click();
			Thread.sleep(3000);
			//clickStartDate1(driver).click();
			clickStartDate11(driver).sendKeys("23-Nov-2022");
			clickLastDate11(driver).sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			clickApplyAd(driver).click();
			Thread.sleep(2000);
			closeDocumentAS(driver).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='txtSearchComplianceID']")).sendKeys("93635");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='Applybtn']")).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='divLocationMain']/div")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='db873bda-b92d-4edb-91c3-e644f7d4b04d_tv_active']/div/span[1]")).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search : -Clear Button Working Successfully ");
		//	performer.OverduePOM.clickDashboard(driver).click();
	}
	
	
	
	public static void DetailedReport(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (70));
	    
		Thread.sleep(500);
		clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickUserDropDown(driver)));
		OverduePOM.clickUserDropDown(driver).click();		//Clicking on User DropDown
		Thread.sleep(300);
		OverduePOM.clickReviewer(driver).click();			//CLicking on Performer under User DropDown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
	/*	
		Actions action = new Actions(driver);
		Thread.sleep(500);
		action.moveToElement(CFOcountPOM.selectMonth(driver)).click().perform();		//Clicking on Months drop down.
		Thread.sleep(500);
		action.moveToElement(clickAllMonths(driver)).click().perform();		//Select 'All' from drop down.
		*/
		Thread.sleep(3000);
		CFOcountPOM.selectMonth(driver).click();
		clickAllMonths(driver).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(500);
		DetailedCompliances(test,driver,0,"Statutory");
		/*DetailedCompliances(test,driver,1,"Internal");
		DetailedCompliances(test,driver,2,"Event Based");
		DetailedCompliances(test,driver,3,"Statutory Checklist");
		DetailedCompliances(test,driver,4,"Internal Checklist");
		DetailedCompliances(test,driver,5,"Event Based Checklist");
		DetailedCompliances(test,driver,6,"All Types");
		*/
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard(driver).click();
	}
	
	public static void DetailedCompliances(ExtentTest test, WebDriver driver,int i, String Compliance) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, (30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");				//Scrolling window up.
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(clickComplianceDropDown(driver)));
		clickComplianceDropDown(driver).click();		//Clicking on Compliance drop down.
		Thread.sleep(500);
		menus = selectComplianceMenus(driver);			//Getting menus list
    	 menus.indexOf(i);                                           //Selecting ith menu
		//menus.get(i).click();	
		 
		Thread.sleep(500);
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		}
		catch(Exception e)
		{
			
		}
		
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
		Thread.sleep(500);
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		
		if(bits.length - 2 < 2)
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading the total items count in String
			bits = s1.split(" ");								//Splitting the String
			itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		}
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.PASS, "No records found for '"+Compliance+"'.");
			driver.navigate().refresh();
		}
		else
		{
			js.executeScript("window.scrollBy(0,-1000)");					//Scrolling down window by 2600 px.
			
		//	String file = "//home//ashitosh-avantis//Downloads//Detailed Report .xlsx";
			String file = "C:/Users/sandip/Downloads/Detailed Report .xlsx";
			Detailed(driver, file, Compliance, test);
		}
		 
	}
	

	public static void Detailed(WebDriver driver, String file, String compliance, ExtentTest test) throws InterruptedException, IOException
	{
		File dir = new File("C:/Users/sandip/Downloads/");
		File[] allFiles = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();			//Exporting (Downloading) file
		
		Thread.sleep(4000);
		File dir1 = new File("C:/Users/sandip/Downloads/");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(allFiles.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, compliance+" :- File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
		   
			Thread.sleep(500);		
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			workbook.write(fos);
			fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
			
			if(compliance.equalsIgnoreCase("Statutory CheckList"))
				Thread.sleep(1500);
			else
				Thread.sleep(500);
			CFOcountPOM.readTotalItemsD(driver);				//clicking on Total items count to scroll down.
			
			String s1 = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading the total items count in String
			String[] bits = s1.split(" ");								//Splitting the String
			String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
			int count;
			if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
			{
				count = 0;
			}
			else
			{
				count = Integer.parseInt(itomsCount);
			}
			
			if(count == SheetRecords)
			{
				test.log(LogStatus.PASS, compliance + " :- No of Records in sheet matches to the number of items.");
				test.log(LogStatus.PASS, "Number of records in downloaded sheet = " +SheetRecords+ " | No of items in grid = "+count);
			}
			else
			{
				test.log(LogStatus.FAIL, compliance + " :- No of Records in sheet doesn't matches to the number of items.");
				test.log(LogStatus.FAIL, "Number of records in downloaded sheet = " +SheetRecords+ " | No of items in grid = "+count);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, compliance+" :- File does not downloaded.");
		}
	}
	
	public static void ActDocuments(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(driver, (140));
	    
		Thread.sleep(5000);
		CFOcountPOM.clickDocuments(driver).click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickActDocuments(driver).click();			//Clicking on 'Act Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[2]/td[5]/a");
		//*[@id="grid"]/div[4]/table/tbody/tr[1]/td[5]/a[1]
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS,   " Act Documents:-View Successfully ");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			driver.findElement(By.xpath("//*[@id='basic']/tbody/tr[2]/td[2]")).click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS,   " Act Documents:-Download Successfully ");
			performer.OverduePOM.clickDashboard(driver).click();
		
	}
	
	public static void ComplianceDocuments(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(driver,(140));
	    
		Thread.sleep(1000);
		CFOcountPOM.clickDocuments(driver).click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments(driver).click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[14]/a");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, " :- View successfully.");
			CFOcountPOM.closeViewDoc(driver).click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn(driver).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "  File downloaded successfully.");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeOverViewDoc(driver).click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "  OverView successfully.");
			 By locator1 = By.xpath("//*[@id='sel_chkbxMain']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = driver.findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " After Checking Multiple checkbox  File downloaded successfully.");
			/*	elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
					elementsList.get(0).click();									//Clicking on first dropdown
					Thread.sleep(500);
					Actions action = new Actions(driver);
					
					action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down.
					Thread.sleep(500);
					CFOcountPOM.clickClear(driver).click();
					Thread.sleep(1000);*/
					test.log(LogStatus.PASS, "Clear Button Working");
				CFOcountPOM.clickAdvancedSearch(driver).click();
				Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = driver.findElements(locator2);	
			Thread.sleep(3000);
			ViewButton1.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search :- View successfully.");
			ViewButton1.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn(driver).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - File downloaded successfully.");
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search -  OverView successfully.");
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = driver.findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				Thread.sleep(500);
				ChechBoxes1.get(1).click();
				Thread.sleep(500);
				ChechBoxes1.get(2).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocumentAS(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " Advanced Search - After Checking Multiple checkbox  File downloaded successfully.");
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Advanced Search - Clear Button Working");
				OverduePOM.clickDashboard(driver).click();
		
	}
	
	public static void ActRepository(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		
           WebDriverWait wait = new WebDriverWait(driver, (160));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");						//Scrolling down window by 1000 px.
			Thread.sleep(2000);
		CFOcountPOM.clickActRepository(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);//*[@id="divOverView1"]/div/div/div[1]/button
		driver.findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[11]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "OverView Successfully");
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();
		
	}
	
	public static void AuditReport(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver,(30));
		Thread.sleep(500);
		CFOcountPOM.clickReports(driver).click();				//Clicking on 'My Reports'
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(500);
		CFOcountPOM.clickAuditReport(driver).click();			//Clicking on 'Assignment Report'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickShowDropDown(driver)));
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickAllDropDown(driver)));
		
		String vendors = "All Vendors";
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.moveToElement(CFOcountPOM.clickExportReport(driver)).click().build().perform();	//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
		/*	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(3000);		
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			
			elementsList1 = CFOcountPOM.getVendorNames(driver);
			int n = elementsList1.size();
			int flag = 0;
			int noVendors = n - 5;							//Counting displayed vendors to match with sheet count.
			for(int i = 5; i < n; i++)						//i = 5 as first five elements are other than required.
			{
				String vendor = elementsList1.get(i).getText();
				int no = sheet.getLastRowNum();
				for(int j = 3; j < no; j++)					//j = 3 as first three rows of sheet are of no use
				{
					Row r = sheet.getRow(j);				//Here j refers to row no. (Row no varies)
					Cell c1 = r.getCell(1);					//Getting vendor name from column 1 (Column no is static)
					String vendor1 = c1.getStringCellValue();	//Reading vendor name from cell;
					if(vendor.equalsIgnoreCase(vendor1))
					{
						flag = flag + 1;
						break;
					}
				}			
			}
			
			if (flag == noVendors)
			{
				test.log(LogStatus.PASS, vendors + " - Displayed vendor names are present in sheet");	
			}
			else
			{
				test.log(LogStatus.PASS, vendors + " - Displayed vendor names are not present in sheet");
			}*/
		}
		else
		{
			test.log(LogStatus.FAIL, "File does not downloaded.");
		}
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdReviewerComplianceDocument_lbkView_0']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='divViewDocument']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"View Successfully");
		performer.OverduePOM.clickDashboard(driver).click();
		Thread.sleep(3000);
	}
	
	
	public static void AssignmentReport(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, (60));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports(driver)));
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport(driver).click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		selectType2(driver).click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2(driver);
		elementsList.get(1).click();
		
		String file = "C:/Users/sandip/Downloads/StatutoryReport.xlsx";
		String compliance = "Statutory";
		Assignment(driver, test, file, compliance);
		Thread.sleep(1000);
		OverduePOM.clickClearBtn(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS,"Clicking Clear Button - clear Data Succefully");
		Thread.sleep(1000);
		
		//------------------------------------- Event Based ------------------------------------
	/*	
		selectType2(driver).click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2(driver);
		elementsList.get(1).click();					//Unselecting preselected 'Statutory' checkbox
		elementsList.get(3).click();					//Selecting 'Event Based' checkbox.
				
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress(driver);
				
		file = "C://Users//jiya//Downloads//InternalReport.xlsx";
		compliance = "Event Based";
		Assignment(driver, test, file, compliance);
		*/
		//------------------------------------- Internal ------------------------------------
		
		selectType2(driver).click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2(driver);
	//	elementsList.get(1).click();					//Unselecting preselected 'Event Based' checkbox
		elementsList.get(4).click();					//Selecting 'Internal' checkbox.
		
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress(driver);
		
		file = "C:/Users/sandip/Downloads/InternalReport.xlsx";
		compliance = "Internal";
		Assignment(driver, test, file, compliance);
		Thread.sleep(1000);
		/*OverduePOM.clickClearBtn(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS,"Clicking Clear Button - clear Data Succefully");
		Thread.sleep(1000);*/
		OverduePOM.clickDashboard(driver).click();
	}
	
	public static void AssignmentReportIn(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver,(30));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports(driver)));
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport(driver).click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		
		
		//------------------------------------- Internal ------------------------------------
		
		selectType2(driver).click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2(driver);
		//elementsList.get(3).click();					//Unselecting preselected 'Event Based' checkbox
		elementsList.get(4).click();					//Selecting 'Internal' checkbox.
	//	elementsList.get(5).click();
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress(driver);
		
		String	file = "C:/Users/sandip/Downloads//InternalReport.xlsx";
		String	compliance = "Internal";
		Assignment(driver, test, file, compliance);
		Thread.sleep(1000);
		Thread.sleep(1000);
		OverduePOM.clickDashboard(driver).click();
	}
	
	
	
	public static void Assignment(WebDriver driver, ExtentTest test, String file, String compliance) throws InterruptedException, IOException
	{
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress(driver);
		
		Thread.sleep(500);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2600 px.
		
		Thread.sleep(3000);
		CFOcountPOM.readTotalPages1(driver).click();					//CLicking on Total Pages value to scroll down
		Thread.sleep(500);
		String s1 = CFOcountPOM.readTotalPages1(driver).getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		int TotalRecords;
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.PASS, compliance+" does not have any records to download.");
		}
		else
		{
			TotalRecords = Integer.parseInt(itomsCount);				//Reading total number of pages to click next
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2600 px.
			
			File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExportExcel(driver).click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);//C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, compliance +" :- File downloaded successfully.");	
				
			/*	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(500);
				fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
				Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
				c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
				FileOutputStream fos = new FileOutputStream(lastModifiedFile);
				workbook.write(fos);
				fos.close();
				
				int no = sheet.getLastRowNum();
				int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
				
				if(SheetRecords == TotalRecords)
				{
					test.log(LogStatus.PASS, compliance+" :- No of records displayed = " + TotalRecords + " matches to No of records in excel sheet = "+SheetRecords);
				}
				else
				{
					test.log(LogStatus.FAIL, compliance+" :- No of records displayed = " + TotalRecords + " doesn't matches to No of records in excel sheet = "+SheetRecords);
				}*/
			}
			else
			{
				test.log(LogStatus.FAIL, compliance +" :- File does not downloaded.");
			}
		}
	}
	
	public static void DetailedReportIn(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (160));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		OverduePOM.clickcomplianceType(driver).click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceSta(driver).click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceIN(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage(driver).click();			//Exporting (Downloading) file
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Export successfully");
		Thread.sleep(4000);//*[@id="grid"]/div[2]/table/tbody/tr[1]/td/a
		//By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(3000);
		CFOcountPOM.closeDocument1(driver).click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
	/*	OverduePOM.clickRiskD(driver).click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement clickHigh = driver.findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclearBtn(driver).click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);*/
			CFOcountPOM.clickAdvancedSearch(driver).click();
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
/*	OverduePOM.clickcomplianceTypeAS(driver).click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceStaASM(driver).click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceINASM(driver).click();
	*/
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = driver.findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = driver.findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
	test.log(LogStatus.PASS, "Advanced Search-overView successfully");
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportExcel(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search-Export successfully");
	/*	CFOcountPOM.selectMonth1(driver).click();
		Thread.sleep(3000);
		
		CFOcountPOM.selectLastSixMon(driver).click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel(driver).click();
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = driver.findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search-After Apply Month-overView success");
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(4000);
			CFOcountPOM.clickExportExcel(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search-After Apply Month-Export Succefully");
			//clickStartDate1(driver).click();
			CFOcountPOM.clickStartDate11(driver).sendKeys("23-Nov-2022");
			CFOcountPOM.clickLastDate11(driver).sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			CFOcountPOM.clickApplyAd(driver).click();
			Thread.sleep(3000);
	CFOcountPOM.clickExportExcel(driver).click();
        	Thread.sleep(3000);
			OverduePOM.clickRiskDA(driver).click();
			Thread.sleep(1000);
			By locatorRA = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[72]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorRA));
			Thread.sleep(4000);
			
			WebElement clickHighA = driver.findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
			*/
		//	OverduePOM.clickclearBtnA(driver).click();
			Thread.sleep(4000);
		//	test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS(driver).click();
			Thread.sleep(2000);
			OverduePOM.clickDashboard(driver).click();
	}
	
	public static void complianceDocumentIn(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, (140));
	    
		Thread.sleep(2000);
		CFOcountPOM.clickDocuments(driver).click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments(driver).click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		OverduePOM.clickStatus(driver).click();
		Thread.sleep(1000);
		OverduePOM.SelectInternal(driver).click();
		Thread.sleep(7000);
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[14]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeViewDoc(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Internal-View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn1(driver).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Internal-Download Successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeOverViewDoc(driver).click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Internal-OverView Successfully");
			Thread.sleep(500);
			 By locator1 = By.xpath("//*[@id='sel_chkbxMain']");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = driver.findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				
				Thread.sleep(3000);   
				driver.findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Internal-Mutiple checkBox check and download Successfully ");
				Thread.sleep(1000);
				OverduePOM.clickRisk(driver).click();
				Thread.sleep(500);
				OverduePOM.clickRiskCritical(driver).click();
				Thread.sleep(1000);
				OverduePOM.clickClearBtn(driver).click();
				test.log(LogStatus.PASS, "Internal-Clear btn is working");
				Thread.sleep(4000);
				CFOcountPOM.clickAdvancedSearch(driver).click();
				Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			OverduePOM.clickStatusAS(driver).click();
			Thread.sleep(500);
			OverduePOM.SelectInternalAS(driver).click();
			Thread.sleep(5000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = driver.findElements(locator2);	
			Thread.sleep(3000);
			ViewButton1.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Internal-Advanced Search - View Successfully");
		/*	ViewButton1.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn(driver).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - Download Successfully");*/
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2(driver).click();
			test.log(LogStatus.PASS, " Internal-Advanced Search - OverView Successfully");
			Thread.sleep(5000);
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = driver.findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, " Internal-Advanced Search - Mutiple checkBox check and download Successfully ");
				CFOcountPOM.closeDocumentAS(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Internal- Advanced Search  Clear btn is working");
				OverduePOM.clickDashboard(driver).click();		
		
	}
	
	
	
	
}

