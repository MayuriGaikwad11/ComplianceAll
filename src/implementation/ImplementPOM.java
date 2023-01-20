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
	
	public static WebElement clickSubEntity(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer']/tbody/tr[8]/td[10]/a"));
		return implement;
	}
	
	public static WebElement SubEntityAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddCustomerBranch']"));
		return implement;
	}
	
	public static WebElement EnterName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;
	}
	
	public static WebElement SubEntityType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[4]/span[1]/a/span[1]"));
		return implement;
	}
	
	public static WebElement LegalEntity(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Legal Entity (Company)"));
		return implement;
	}//*[@id="ui-id-1661"]
	
	public static WebElement Type(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCompanyType']/span/a/span[1]"));
		return implement;
	}
	
	public static WebElement DeemedPublicCompany(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Deemed Public Company"));
		return implement;
	}
	
	public static WebElement LLP(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Limited Liability Partnership (LLP)"));
		return implement;
	}
	
	public static WebElement Industry(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtIndustry']"));
		return implement;
	}
	
	public static WebElement ClickCheck(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rptIndustry_chkIndustry_2']"));
		return implement;
	}
	
	public static WebElement AddressLine1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxAddressLine1']"));
		return implement;
	}
	
	public static WebElement State(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divState']/span[1]/input"));
		return implement;
	}
	
	public static WebElement Maharashtra(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Maharashtra"));
		return implement;
	}
	
	public static WebElement City(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[12]/span[1]/input"));
		return implement;
	}//*[@id="BodyContent_upCustomerBranches"]/div[1]/div[12]/span[1]/input
	
	public static WebElement Anagar(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Ahmednagar"));
		return implement;
	}
	
	public static WebElement ContactPerson(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxContactPerson']"));
		return implement;
	}
	
	public static WebElement ContactEmail(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxEmail']"));
		return implement;
	}
	
	public static WebElement SaveSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;
	}
	
	public static WebElement FilterSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement ClickEditSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomerBranch_LinkButton1_0']/img"));
		return implement;
	}
	
	public static WebElement ClickDeleteSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomerBranch_LinkButton2_0']/img"));
		return implement;
	}
	
	public static WebElement ClickExport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;
	}                                            
	
	public static WebElement ClickDepartment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[2]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerDept(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return implement;                        
	}
	
	public static WebElement customer123(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("customer123"));
		return implement;                        
	}
	
	public static WebElement AddNewDept(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return implement;                     
	}
	
	public static WebElement DepartmentName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtFName']"));
		return implement;                        
	}
	
	public static WebElement DepartmentSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                        
	}
	
	public static WebElement DepartmentClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                        
	}
	
	public static WebElement DepartmentSaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                        
	}
	
	public static WebElement DepartFilter(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                        
	}
	
	public static WebElement DepartEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton1_0']/img"));
		return implement;                        
	}
	
	public static WebElement DepartUpdateMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                        
	}
	
	public static WebElement DepartDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton2_0']/img"));
		return implement;                        
	}
	
	public static WebElement ClickUserandBrach(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[5]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerUB(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']"));
		return implement;                        
	}
	
	public static WebElement ClickUsers(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rdoBtn_User']"));
		return implement;                        
	}
	
	public static WebElement ClickBranches(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rdoBtn_Branch']"));
		return implement;                        
	}
	
	public static WebElement UploadFile(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                        
	}
	
	public static WebElement clickUpload(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
		return implement;                        
	}
	
	public static WebElement clickUsers(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[3]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return implement;                        
	}
	
	public static WebElement customer123Users(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                        
	}
	
	public static WebElement UsersEmail(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxEmail']"));
		return implement;                        
	}
	
	public static WebElement UsersFirstName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxFirstName']"));
		return implement;                        
	}
	
	public static WebElement UsersLastName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxLastName']"));
		return implement;                        
	}
	
	public static WebElement UsersDesignation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxDesignation']"));
		return implement;                        
	}
	
	
	public static WebElement UsersMobileNo(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxContactNo']"));
		return implement;                        
	}
	
	public static WebElement UsersDepartment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_txtDepartment']"));
		return implement;                        
	}
	
	public static WebElement DepartmentTech(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_rptDepartment_chkDepartment_1']"));
		return implement;                        
	}
	
	public static WebElement UserComplianceRole(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']"));
		return implement;                        
	}
	
	public static WebElement UserCompanyAdmin(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']/option[3]"));
		return implement;                        
	}
	
	public static WebElement UserMGMt(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']/option[5]"));
		return implement;                        
	}
	
	
	public static WebElement SelectHrRole(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']"));
		return implement;                        
	}
	
	public static WebElement HR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']/option[2]"));
		return implement;                        
	}
	
	public static WebElement LoginSSO(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_chkSSOAccess']"));
		return implement;                        
	}
	
	public static WebElement DesktopAccess(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_chkDesktopUserRestricted']"));
		return implement;                        
	}
	
	public static WebElement UserSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_btnSave']"));
		return implement;                        
	}
	
	public static WebElement UserEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEdit_0']/img"));
		return implement;                        
	}
	
	public static WebElement UserDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnDelete_0']/img"));
		return implement;                        
	}
	
	public static WebElement ResetPass(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnReset_0']/img"));
		return implement;                        
	}
	
	public static WebElement SC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlCustomer']"));
		return implement;                        
	}
	
	public static WebElement ABC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlCustomer']/option[3]"));
		return implement;                        
	}
	
	public static WebElement ExportUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
		return implement;                        
	}
	
	public static WebElement SelectLocation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBranch']"));
		return implement;                        
	}
	
	public static WebElement Location1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tvBranchest1']"));
		return implement;                        
	}
	
	public static WebElement UsersUploadMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_vsUploadUtility']/ul/li"));
		return implement;                                     
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
