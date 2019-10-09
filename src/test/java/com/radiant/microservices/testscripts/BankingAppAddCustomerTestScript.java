/**
 * @author Subbarao 
 */
package com.radiant.microservices.testscripts;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.radiant.microservices.common.Constants;
import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestCaseDetails;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.exceptions.TAFException;
import com.radiant.microservices.model.WebElementDataDetails;
import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.pageobjects.BankingAppCustomer;
import com.radiant.microservices.pageobjects.Login;
import com.radiant.microservices.util.AppUtil;
import com.radiant.microservices.util.JExcelParser;
import com.radiant.microservices.util.JWebDriver;
import com.radiant.microservices.util.JXMLParser;

@SuppressWarnings("deprecation")
public class BankingAppAddCustomerTestScript {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppAddCustomerWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	private TestCaseDetails testCaseDetails = null;
	BankingAppCustomer bankingAppAddCustomer;
	AppUtil apt = new AppUtil();
	TestSuiteDetails suiteDetails;

	

	// ==========================================================================

	public BankingAppAddCustomerTestScript(TestSuiteDetails testSuiteDetails) {

		this.suiteDetails = testSuiteDetails;
		testCaseDetails = new TestCaseDetails();
		testCaseDetails.setTestSuiteDetailsId(testSuiteDetails.getTestSuiteDetailsId());
	}


	// ==========================================================================

	@BeforeTest
	public void beforeTest() {
		log.info("START of the method beforeTest");
		log.info("END of the method beforeTest");
	}

	// ==========================================================================

	private void setPrerequisites() throws InterruptedException {
		testCaseDetails.setTestCaseName(BankingAppAddCustomerTestScript.class.getSimpleName());
		if (bankingAppAddCustomerWebElementList == null) {
			bankingAppAddCustomerWebElementList = JXMLParser.getInstance().getWebElements(BankingAppCustomer.class.getSimpleName());
		}
		if (webElementsData == null) {
		      webElementsData = JExcelParser.getInstance().getDataSet(BankingAppCustomer.class.getSimpleName(), BankingAppAddCustomerTestScript.class.getSimpleName());
		   }
	}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void addBankingCustomer() throws Exception {
		log.info("START of the method addNewbankingAppAddCustomerRecord");
		bankingAppAddCustomer = new BankingAppCustomer();
		String customMessage = null;
		WebDriver driver = null;
		
		try {
			testCaseDetails.setMethodName(AppUtil.getMethodName());
			setPrerequisites();
			driver = JWebDriver.getInstance().getWebDriver();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
			driver.get(resourceBundle.getString("application.url"));
			Thread.sleep(6000);
			customMessage = "Click on Add button";
			WebElementDetails userMenuobj = bankingAppAddCustomerWebElementList.get(0);
			bankingAppAddCustomer.userMenu(userMenuobj).click();
			Thread.sleep(6000);
			
			if (bankingAppAddCustomerWebElementList != null && bankingAppAddCustomerWebElementList.size() > 0) {
				if (webElementsData!=null) {
					for (WebElementDataDetails webElementDataDetails : webElementsData) {
						if (webElementDataDetails.isExecute()) {
							List<String> dataSet = webElementDataDetails.getDataSet();
							if (dataSet != null && dataSet.size() > 0) {
									Actions act = new Actions(driver);
									
									
									customMessage = "Click on Add button";
									WebElementDetails addBtnobj = bankingAppAddCustomerWebElementList.get(1);
									bankingAppAddCustomer.addUserbtn(addBtnobj).click();
									Thread.sleep(20000);
									
									customMessage = "Create butnm";
									WebElementDetails CreateButnobj = bankingAppAddCustomerWebElementList.get(15);
									bankingAppAddCustomer.streetTxtbox(CreateButnobj).click();
									log.info(" Enter Street ");
									Thread.sleep(1000);
									
									customMessage = "Enter First Name";
									WebElementDetails firstNameTxtobj = bankingAppAddCustomerWebElementList.get(2);
									bankingAppAddCustomer.firstNameTxtbox(firstNameTxtobj).click();
									bankingAppAddCustomer.firstNameTxtbox(firstNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(0));
									log.info(" Enter First Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Last Name";
									WebElementDetails lastNameTxtobj = bankingAppAddCustomerWebElementList.get(3);
									bankingAppAddCustomer.lastNameTxtbox(lastNameTxtobj).click();
									bankingAppAddCustomer.lastNameTxtbox(lastNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(1));
									log.info(" Last Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Middle Name";
									WebElementDetails middleNameTxtobj = bankingAppAddCustomerWebElementList.get(4);
									bankingAppAddCustomer.middleNameTxtbox(middleNameTxtobj).click();
									bankingAppAddCustomer.middleNameTxtbox(middleNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(2));
									log.info(" Enter Middle Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Customer Id";
									WebElementDetails customerIdobj = bankingAppAddCustomerWebElementList.get(5);
									bankingAppAddCustomer.userNameTxtbox(customerIdobj).click();
									bankingAppAddCustomer.userNameTxtbox(customerIdobj).sendKeys(webElementDataDetails.getDataSet().get(3));
									log.info(" Enter User Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Customer DOB";
									WebElementDetails customerDOBobj = bankingAppAddCustomerWebElementList.get(6);
									bankingAppAddCustomer.passwordTxtbox(customerDOBobj).click();
									bankingAppAddCustomer.passwordTxtbox(customerDOBobj).sendKeys(webElementDataDetails.getDataSet().get(4));
									log.info(" Enter Password");
									Thread.sleep(1000);
									
									customMessage = "Enter eMail";
									WebElementDetails eMailobj = bankingAppAddCustomerWebElementList.get(7);
									bankingAppAddCustomer.emailTxtbox(eMailobj).click();
									bankingAppAddCustomer.emailTxtbox(eMailobj).sendKeys(webElementDataDetails.getDataSet().get(5));
									log.info(" Enter eMail ");
									Thread.sleep(1000);
									
									customMessage = "Enter UserName";
									WebElementDetails uSerNameobj = bankingAppAddCustomerWebElementList.get(8);
									bankingAppAddCustomer.phoneTxtbox(uSerNameobj).click();
									bankingAppAddCustomer.phoneTxtbox(uSerNameobj).sendKeys(webElementDataDetails.getDataSet().get(6));
									log.info(" Enter Phone ");
									Thread.sleep(1000);
									
									customMessage = "Enter Password";
									WebElementDetails passWordobj = bankingAppAddCustomerWebElementList.get(9);
									bankingAppAddCustomer.cityTxtbox(passWordobj).click();
									bankingAppAddCustomer.cityTxtbox(passWordobj).sendKeys(webElementDataDetails.getDataSet().get(7));
									log.info(" Enter City ");
									Thread.sleep(1000);
									
									customMessage = "Enter Phone";
									WebElementDetails pHoneobj = bankingAppAddCustomerWebElementList.get(10);
									bankingAppAddCustomer.stateTxtbox(pHoneobj).click();
									bankingAppAddCustomer.stateTxtbox(pHoneobj).sendKeys(webElementDataDetails.getDataSet().get(8));
									log.info(" Enter State ");
									Thread.sleep(1000);
									
									customMessage = "Enter city";
									WebElementDetails Cityobj = bankingAppAddCustomerWebElementList.get(11);
									bankingAppAddCustomer.streetTxtbox(Cityobj).click();
									bankingAppAddCustomer.streetTxtbox(Cityobj).sendKeys(webElementDataDetails.getDataSet().get(9));
									log.info(" Enter Street ");
									Thread.sleep(1000);
									
									customMessage = "Enter state";
									WebElementDetails sTateobj = bankingAppAddCustomerWebElementList.get(12);
									bankingAppAddCustomer.buildingTxtbox(sTateobj).click();
									bankingAppAddCustomer.buildingTxtbox(sTateobj).sendKeys(webElementDataDetails.getDataSet().get(10));
									log.info(" Enter Building ");
									Thread.sleep(1000);
									
									customMessage = "Enter building";
									WebElementDetails Buildingobj = bankingAppAddCustomerWebElementList.get(14);
									bankingAppAddCustomer.buildingTxtbox(Buildingobj).click();
									bankingAppAddCustomer.buildingTxtbox(Buildingobj).sendKeys(webElementDataDetails.getDataSet().get(12));
									log.info(" Enter Building ");
									Thread.sleep(1000);
									
									customMessage = "Enter Street";
									WebElementDetails Streetobj = bankingAppAddCustomerWebElementList.get(13);
									bankingAppAddCustomer.streetTxtbox(Streetobj).click();
									bankingAppAddCustomer.streetTxtbox(Streetobj).sendKeys(webElementDataDetails.getDataSet().get(11));
									log.info(" Enter Street ");
									Thread.sleep(1000);
									
									customMessage = "Create butnm";
									 CreateButnobj = bankingAppAddCustomerWebElementList.get(15);
									 bankingAppAddCustomer.streetTxtbox(CreateButnobj).click();
									 
									//
									log.info(" Enter Street ");
									
									Thread.sleep(20000);
									}
						   }	
						}
					} else {
						log.info(" Unable to execute the script Test data is empty");
					}
					
				} else {
					log.info(" Unable to execute the script as some or all the mandatory objects or values are null");
				}
			} catch (java.lang.AssertionError e) {
				suiteDetails.setTestStatusSuccess(false);
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} catch (Exception e) {
				suiteDetails.setTestStatusSuccess(false);
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
				e.printStackTrace();
			} finally {
				TAFDBManagerHelper.getInstance().saveTestCaseDetails(testCaseDetails);
			}
			log.info("END of the method login");
		}

	// ==========================================================================

	@AfterTest
	public void afterTest() {
		log.info("START of the method afterTest");
		log.info("END of the method afterTest");
	}
	
		
	// ==========================================================================

	public String handleNavigationPageState() {
		
		String customMessage = "PASS";
		
				
		return customMessage;
		
	}

	// ==========================================================================

}
