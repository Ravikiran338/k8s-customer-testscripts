/**
 * @author Subbarao 
 */
package com.radiant.microservices.testscripts;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestCaseDetails;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.exceptions.TAFException;
import com.radiant.microservices.model.WebElementDataDetails;
import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.pageobjects.BankingAppCustomer;
import com.radiant.microservices.util.AppUtil;
import com.radiant.microservices.util.JExcelParser;
import com.radiant.microservices.util.JWebDriver;
import com.radiant.microservices.util.JXMLParser;

@SuppressWarnings("deprecation")
public class BankingAppModifyCustomerTestScript {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppModifyCustomerWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	private TestCaseDetails testCaseDetails = null;
	BankingAppCustomer bankingAppModifyCustomer;
	AppUtil apt = new AppUtil();
	TestSuiteDetails suiteDetails;

	// ==========================================================================

	public BankingAppModifyCustomerTestScript(TestSuiteDetails testSuiteDetails) {

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
		testCaseDetails.setTestCaseName(BankingAppModifyCustomerTestScript.class.getSimpleName());
		if (bankingAppModifyCustomerWebElementList == null) {
			bankingAppModifyCustomerWebElementList = JXMLParser.getInstance().getWebElements(BankingAppCustomer.class.getSimpleName());
		}

		if (webElementsData == null) {
		      webElementsData = JExcelParser.getInstance().getDataSet(BankingAppCustomer.class.getSimpleName(), BankingAppModifyCustomerTestScript.class.getSimpleName());
		   }
	}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void modifyBankingCustomer() {
		log.info("START of the method addNewbankingAppModifyCustomerRecord");
		bankingAppModifyCustomer = new BankingAppCustomer();
		String customMessage = null;
		WebDriver driver = null;
		try {
			testCaseDetails.setMethodName(AppUtil.getMethodName());
			setPrerequisites();
			driver = JWebDriver.getInstance().getWebDriver();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
			driver.get(resourceBundle.getString("application.url"));
			//Thread.sleep(10000);
			customMessage = "Click on Add button";
			WebElementDetails userMenuobj = bankingAppModifyCustomerWebElementList.get(0);
			bankingAppModifyCustomer.userMenu(userMenuobj).click();
			Thread.sleep(6000);
			
			if (bankingAppModifyCustomerWebElementList != null && bankingAppModifyCustomerWebElementList.size() > 0) {
				if (webElementsData!=null) {
					for (WebElementDataDetails webElementDataDetails : webElementsData) {
						if (webElementDataDetails.isExecute()) {
							List<String> dataSet = webElementDataDetails.getDataSet();
							if (dataSet != null && dataSet.size() > 0) {
									Actions act = new Actions(driver);
									Thread.sleep(6000);

									customMessage = "select all records from look-up";
									WebElementDetails lookupTableObj = bankingAppModifyCustomerWebElementList.get(17);
									WebElement lookupTable = bankingAppModifyCustomer.lookup(lookupTableObj); 
									Thread.sleep(1000);
									
									WebElementDetails rowsObj = bankingAppModifyCustomerWebElementList.get(18);
									int selctedRecordNo = 0;
									List<WebElement> rows = lookupTable
											.findElements(By.cssSelector(rowsObj.getCssSelector()));
								       Thread.sleep(6000);
									String DomainId = null;
									JavascriptExecutor js = (JavascriptExecutor) driver;
									for (int i = 1; i <= rows.size(); i++) {
										  if ((i % 10) == 0)
										  {
											    js.executeScript("window.scrollBy(0,1000)");
											    Thread.sleep(3000);
											   // rows.get(i).click();
										  }		
										  List<WebElement> cols = rows.get(i).findElements(By.cssSelector("td"));
										  DomainId = cols.get(2).getText();
										  if ((DomainId).trim().equalsIgnoreCase(webElementDataDetails.getDataSet().get(0))) {
												rows.get(i).findElement(By.cssSelector(".btn-primary.btn-xs")).click();
												break;
											}
									}

									customMessage = "Enter First Name";
									WebElementDetails firstNameTxtobj = bankingAppModifyCustomerWebElementList.get(22);
									bankingAppModifyCustomer.firstNameTxtbox(firstNameTxtobj).click();
									bankingAppModifyCustomer.firstNameTxtbox(firstNameTxtobj).clear();
									bankingAppModifyCustomer.firstNameTxtbox(firstNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(1));
									log.info(" Enter First Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Last Name";
									WebElementDetails lastNameTxtobj = bankingAppModifyCustomerWebElementList.get(23);
									bankingAppModifyCustomer.lastNameTxtbox(lastNameTxtobj).click();
									bankingAppModifyCustomer.lastNameTxtbox(lastNameTxtobj).clear();
									bankingAppModifyCustomer.lastNameTxtbox(lastNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(2));
									log.info(" Last Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Middle Name";
									WebElementDetails middleNameTxtobj = bankingAppModifyCustomerWebElementList.get(24);
									bankingAppModifyCustomer.middleNameTxtbox(middleNameTxtobj).click();
									bankingAppModifyCustomer.middleNameTxtbox(middleNameTxtobj).clear();
									bankingAppModifyCustomer.middleNameTxtbox(middleNameTxtobj).sendKeys(webElementDataDetails.getDataSet().get(3));
									log.info(" Enter Middle Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Customer Id";
									WebElementDetails customerIdobj = bankingAppModifyCustomerWebElementList.get(25);
									bankingAppModifyCustomer.userNameTxtbox(customerIdobj).click();
									bankingAppModifyCustomer.userNameTxtbox(customerIdobj).clear();
									bankingAppModifyCustomer.userNameTxtbox(customerIdobj).sendKeys(webElementDataDetails.getDataSet().get(4));
									log.info(" Enter User Name");
									Thread.sleep(1000);
									
									customMessage = "Enter Customer DOB";
									WebElementDetails customerDOBobj = bankingAppModifyCustomerWebElementList.get(26);
									bankingAppModifyCustomer.passwordTxtbox(customerDOBobj).click();
									bankingAppModifyCustomer.passwordTxtbox(customerDOBobj).clear();
									bankingAppModifyCustomer.passwordTxtbox(customerDOBobj).sendKeys(webElementDataDetails.getDataSet().get(5));
									log.info(" Enter Password");
									Thread.sleep(1000);
									
									customMessage = "Enter eMail";
									WebElementDetails eMailobj = bankingAppModifyCustomerWebElementList.get(27);
									bankingAppModifyCustomer.emailTxtbox(eMailobj).click();
									bankingAppModifyCustomer.emailTxtbox(eMailobj).clear();
									bankingAppModifyCustomer.emailTxtbox(eMailobj).sendKeys(webElementDataDetails.getDataSet().get(6));
									log.info(" Enter eMail ");
									Thread.sleep(1000);
									
									customMessage = "Enter UserName";
									WebElementDetails uSerNameobj = bankingAppModifyCustomerWebElementList.get(28);
									bankingAppModifyCustomer.phoneTxtbox(uSerNameobj).click();
									bankingAppModifyCustomer.phoneTxtbox(uSerNameobj).clear();
									bankingAppModifyCustomer.phoneTxtbox(uSerNameobj).sendKeys(webElementDataDetails.getDataSet().get(7));
									log.info(" Enter Phone ");
									Thread.sleep(1000);
									
									customMessage = "Enter Password";
									WebElementDetails passWordobj = bankingAppModifyCustomerWebElementList.get(29);
									bankingAppModifyCustomer.cityTxtbox(passWordobj).click();
									bankingAppModifyCustomer.cityTxtbox(passWordobj).clear();
									bankingAppModifyCustomer.cityTxtbox(passWordobj).sendKeys(webElementDataDetails.getDataSet().get(8));
									log.info(" Enter City ");
									Thread.sleep(1000);
									
									customMessage = "Enter Phone";
									WebElementDetails pHoneobj = bankingAppModifyCustomerWebElementList.get(30);
									bankingAppModifyCustomer.stateTxtbox(pHoneobj).click();
									bankingAppModifyCustomer.stateTxtbox(pHoneobj).clear();
									bankingAppModifyCustomer.stateTxtbox(pHoneobj).sendKeys(webElementDataDetails.getDataSet().get(9));
									log.info(" Enter State ");
									Thread.sleep(1000);
									
									customMessage = "Enter city";
									WebElementDetails Cityobj = bankingAppModifyCustomerWebElementList.get(31);
									bankingAppModifyCustomer.streetTxtbox(Cityobj).click();
									bankingAppModifyCustomer.stateTxtbox(Cityobj).clear();
									bankingAppModifyCustomer.streetTxtbox(Cityobj).sendKeys(webElementDataDetails.getDataSet().get(10));
									log.info(" Enter Street ");
									Thread.sleep(1000);
									
									customMessage = "Enter state";
									WebElementDetails sTateobj = bankingAppModifyCustomerWebElementList.get(32);
									bankingAppModifyCustomer.buildingTxtbox(sTateobj).click();
									bankingAppModifyCustomer.buildingTxtbox(sTateobj).clear();
									bankingAppModifyCustomer.buildingTxtbox(sTateobj).sendKeys(webElementDataDetails.getDataSet().get(11));
									log.info(" Enter Building ");
									Thread.sleep(1000);
									
									customMessage = "Enter building";
									WebElementDetails Buildingobj = bankingAppModifyCustomerWebElementList.get(34);
									bankingAppModifyCustomer.buildingTxtbox(Buildingobj).click();
									bankingAppModifyCustomer.buildingTxtbox(Buildingobj).clear();
									bankingAppModifyCustomer.buildingTxtbox(Buildingobj).sendKeys(webElementDataDetails.getDataSet().get(13));
									log.info(" Enter Building ");
									Thread.sleep(1000);
									
									customMessage = "Enter Street";
									WebElementDetails Streetobj = bankingAppModifyCustomerWebElementList.get(33);
									bankingAppModifyCustomer.streetTxtbox(Streetobj).click();
									bankingAppModifyCustomer.streetTxtbox(Streetobj).clear();
									bankingAppModifyCustomer.streetTxtbox(Streetobj).sendKeys(webElementDataDetails.getDataSet().get(12));
									log.info(" Enter Street ");
									Thread.sleep(1000);
									
									customMessage = "Cr3eate butnm";
									 Streetobj = bankingAppModifyCustomerWebElementList.get(35);
									bankingAppModifyCustomer.streetTxtbox(Streetobj).click();
									log.info(" Enter Street ");
									Thread.sleep(12000);
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
