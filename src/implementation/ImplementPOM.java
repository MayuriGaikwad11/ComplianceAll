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
	
	public static WebElement ProductMapping(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[6]/a"));
		return implement;                                     
	}
	
	public static WebElement PMCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCustomer']/span[1]/a"));
		return implement;                                     
	}
	
	public static WebElement PMABCDPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                                     
	}
	
	public static WebElement PMCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Compliance"));
		return implement;                                     
	}
	
	public static WebElement PMAddMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement PMProduct(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divProduct']/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement PMSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement PMClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                     
	}
	
	public static WebElement PMDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnDelete_0']/img"));
		return implement;                                     
	}
	
	public static WebElement ModifyAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[9]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerMA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectABCD(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                                  
	}
	
	public static WebElement SelectBitademopune(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Bitademopune"));
		return implement;                                     
	}
	
	public static WebElement SelectUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"));
		return implement;                                  
	}
	
	public static WebElement SearchUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/input"));
		return implement;                                  
	}
	
	public static WebElement SelectDevanshNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Devansh New"));
		return implement;                                     
	}
	
	
	public static WebElement Selectaaa(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("aaa aaa"));
		return implement;                                     
	}
	
	public static WebElement SelectASs(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("A Ss"));
		return implement;                                     
	}
	
	public static WebElement SelectNewPerformerUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformerabcabd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("abc abd"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformeraaaaa(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("aaa aa"));
		return implement;                                     
	}
	
	
	public static WebElement SelectNewReviewerUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[4]/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Selectaaaaaad(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("aaa aaa"));
		return implement;                                     
	}
	
	public static WebElement SelectASsd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("A Ss"));
		return implement;                                     
	}
	
	public static WebElement CheckBox0(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.id("BodyContent_grdComplianceInstances_chkCompliances_0"));
		return implement;                                                
	}
	
	public static WebElement CheckBox1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.id("BodyContent_grdComplianceInstances_chkCompliances_1"));
		return implement;                                                
	}
	
	public static WebElement CheckBox2(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceInstances_chkCompliances_2']"));
		return implement;                                    
	}
	
	public static WebElement CheckINBox0(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_0']"));
		return implement;                                   
	}
	
	public static WebElement CheckINBox1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_1']"));
		return implement;                                   
	}
	
	public static WebElement CheckINBox2(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_2']"));
		return implement;                                    
	}
	
	public static WebElement ClicksaveBtn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSaveAssignment']"));
		return implement;                                     
	}
	
	public static WebElement ClickStaEventBased(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_chkEvent']"));
		return implement;                                  
	}
	
	public static WebElement ClickStaCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_chkCheckList']"));
		return implement;                                   
	}
	
	public static WebElement ClickInternalRB(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rbtSelectionType_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickExclude(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rbtModifyAction_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickTask(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rbtSelectType_1']"));
		return implement;                                     
	}
	
	public static WebElement ChechBoxInTask0(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdTask_chkTask_0']"));
		return implement;                                           
	}
	
	public static WebElement ChechBoxInTask1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdTask_chkTask_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"));
		return implement;                                     
	}
	
	public static WebElement UsageReportCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[1]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerRe(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_DivCustomer1']/div/div/span[1]"));
		return implement;                                 
	}
	
	public static WebElement SelectABCpvtltd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[2]"));
		return implement;                                     
	}
	
	public static WebElement FromDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Div31']/span/span/span/span"));
		return implement;                                     
	}
	
	public static WebElement January19(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("19"));
		return implement;                                     
	}
	
	public static WebElement ToDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Div41']/span/span/span/span"));
		return implement;                                     
	}
	
	public static WebElement January25(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("25"));
		return implement;                                     
	}
	
	public static WebElement ClickExportRe(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='exportReport']"));
		return implement;                                     
	}
	
	public static WebElement ClickClearBtn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='Clearfilter']"));
		return implement;                                     
	}
	
	public static WebElement ClickUsageReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerUR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']"));
		return implement;                               //*[@id="BodyContent_ddlCustomer"]      
	}
	
	public static WebElement SelectBitademopuneRE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement SelectABitaPharmaCompany(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchest0']"));
		return implement;                                     
	}
	
	public static WebElement FromDateUR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtStartDate']"));
		return implement;                                     
	}
	
	public static WebElement ToDateUR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtEndDate']"));
		return implement;                                     
	}
	
	public static WebElement ExportToExcel(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnExportExcel']"));
		return implement;                                     
	}
	
	public static WebElement StatutoryAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerSA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']"));
		return implement;                                     
	}
	
	public static WebElement SelectBitademopuneSA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement ClickExportSA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;                                     
	}
	
	public static WebElement CheckListAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[4]/a"));
		return implement;                                     
	}
	
	public static WebElement EventBasedAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[5]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[6]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalCheckListAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[7]/a"));
		return implement;                                     
	}
	
	public static WebElement StatutoryLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[8]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[9]/a"));
		return implement;                                     
	}
	
	public static WebElement AllReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[10]/a"));
		return implement;                                     
	}
	
	public static WebElement CompliaceCountReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[12]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlfilterCatagory']"));
		return implement;                                     
	}
	
	public static WebElement Commercial(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlfilterCatagory']/option[4]"));
		return implement;                                     
	}
	
	public static WebElement SelectType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFilterType']"));
		return implement;                                     
	}
	
	public static WebElement Central(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFilterType']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement InternalCompliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement ComplianceActivation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:67']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement AssignCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[1]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformerCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[2]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectLocationCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return implement;                                     
	}
	
	public static WebElement LocationCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn0']/img"));
		return implement;                                   
	}
	
	public static WebElement ALENAVENTURESLIMITED(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt5']"));
		return implement;                                     
	}
	
	public static WebElement ALENAVENTURESLIMITEDCB(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn5CheckBox']"));
		return implement;                                     
	}
	
	
	public static WebElement ComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[2]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement ABCD(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD"));
		return implement;                                     
	}
	
	public static WebElement FEManager(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("FE Manager"));
		return implement;                                     
	}
	
	public static WebElement FMManager(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("FM Manager"));
		return implement;                                     
	}
	
	public static WebElement SelectReviewerCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[4]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement ClickCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkAssign_0']"));
		return implement;                                     
	}
	
	public static WebElement ClickSaveBTn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button1']"));
		return implement;                                     
	}
	
	public static WebElement IntermediateCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement ClickEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnedit_2']"));
		return implement;                                     
	}
	
	public static WebElement EditUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_2']"));
		return implement;                                     
	}
	
	public static WebElement CheckEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_Label2_2']"));
		return implement;                                     
	}
	
	public static WebElement EditUseraaaaa(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_2']/option[111]"));
		return implement;                                     
	}
	
	public static WebElement ClickUpdate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnupdate_2']"));
		return implement;                                     
	}
	
	public static WebElement ClickDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnDelete_2']"));
		return implement;                                     
	}
	
	public static WebElement ActivateCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement select(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnlocation']"));
		return implement;                                     
	}
	
	public static WebElement selectDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return implement;                                     
	}
	

	public static WebElement Date11(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("11"));
		return implement;
	}
	
	public static WebElement ActivateCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkActivate_0']"));
		return implement;                                     
	}
	
	public static WebElement ExportActivate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;                                     
	}
	
	public static WebElement AssignCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[4]/a"));
		return implement;                                     
	}
	
	public static WebElement IntermediateCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[5]/a"));
		return implement;                                     
	}
	
	public static WebElement ActivateCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[6]/a"));
		return implement;                                     
	}
		
	public static WebElement Masters(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:67']/li[1]/a"));
		return implement;                                     
	}
		
	public static WebElement MastersComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:68']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement AddNewCC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddIComplianceCategory']"));
		return implement;                                     
	}
	
	public static WebElement Customer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomernew']"));
		return implement;                                     
	}
	
	public static WebElement Bitademopune(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomernew']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement name(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;                                     
	}
	
	public static WebElement Description(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxDescription']"));
		return implement;                                     
	}
	
	public static WebElement Save(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement FilterM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement NameCheck(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement EditComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdIComplianceCategory_LinkButton1_0']/img"));
		return implement;                                     
	}
	
	public static WebElement DeleteComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdIComplianceCategory_LinkButton2_0']/img"));
		return implement;                                     
	}
	
	public static WebElement Compliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:68']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement AddNewCompliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddCompliance']"));
		return implement;                                     
	}
	
	public static WebElement TypeName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[2]/span[1]/input"));
		return implement;                                     
	}
	
	public static WebElement MaharashtraC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Maharashtra"));
		return implement;                                     
	}
	
	public static WebElement  CategoryName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[3]/span[1]/input"));
		return implement;                                     
	}
	
	public static WebElement AnnualMaintenanceContract(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Annual Maintenance Contract"));
		return implement;                                     
	}
	
	public static WebElement ABCDCom(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD"));
		return implement;                                     
	}
	
	public static WebElement  ShortDescription(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtShortDescription']"));
		return implement;                                     
	}
	
	public static WebElement ShortForm(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtShortForm']"));
		return implement;                                     
	}
	
	public static WebElement DetailedDescription(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtdetaileddescription']"));
		return implement;                                     
	}
	
	public static WebElement Frequency(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divFrequency']/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Annual(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Annual"));
		return implement;                                     
	}
	
	public static WebElement PriorityType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[13]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Low(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Low"));
		return implement;                                     
	}
	
	public static WebElement SaveCom(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement RecordSavemsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement RecordClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                     
	}
	
	public static WebElement SelectCategoryMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplinceCatagory']"));
		return implement;                                     
	}
	
	public static WebElement ABCDMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplinceCatagory']/option[4]"));
		return implement;                                     
	}
	
	public static WebElement FilterType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement EditCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtEdit_0']/img"));
		return implement;                                     
	}
	
	public static WebElement CatName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_Label11_0']"));
		return implement;                                     
	}
	
	public static WebElement DeleteCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtDelete_0']/img"));
		return implement;                                     
	}
	
	public static WebElement DisplayScheduleInformation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_LinkButton3_0']/img"));
		return implement;                                     
	}
	
	public static WebElement close(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                     
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
