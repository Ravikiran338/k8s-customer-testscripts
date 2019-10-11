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
public class BankingAppDeleteCustomerTestScript {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppDeleteCustomerWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	private TestCaseDetails testCaseDetails = null;
	BankingAppCustomer bankingAppDeleteCustomer;
	AppUtil apt = new AppUtil();
	TestSuiteDetails suiteDetails;

	// ==========================================================================

	public BankingAppDeleteCustomerTestScript(TestSuiteDetails testSuiteDetails) {

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
		testCaseDetails.setTestCaseName(BankingAppDeleteCustomerTestScript.class.getSimpleName());
		if (bankingAppDeleteCustomerWebElementList == null) {
			bankingAppDeleteCustomerWebElementList = JXMLParser.getInstance().getWebElements(BankingAppCustomer.class.getSimpleName());
		}

		if (webElementsData == null) {
		      webElementsData = JExcelParser.getInstance().getDataSet(BankingAppCustomer.class.getSimpleName(), BankingAppDeleteCustomerTestScript.class.getSimpleName());
		   }
		
	}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void deleteBankingCustomer() {
		log.info("START of the method addNewbankingAppDeleteCustomerRecord");
		bankingAppDeleteCustomer = new BankingAppCustomer();
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
			WebElementDetails userMenuobj = bankingAppDeleteCustomerWebElementList.get(0);
			bankingAppDeleteCustomer.userMenu(userMenuobj).click();
			Thread.sleep(6000);

			if (bankingAppDeleteCustomerWebElementList != null && bankingAppDeleteCustomerWebElementList.size() > 0) {
				if (webElementsData!=null) {
					for (WebElementDataDetails webElementDataDetails : webElementsData) {
						if (webElementDataDetails.isExecute()) {
							List<String> dataSet = webElementDataDetails.getDataSet();
							if (dataSet != null && dataSet.size() > 0) {
									Actions act = new Actions(driver);
									Thread.sleep(10000);

									customMessage = "select all records from look-up";
									WebElementDetails lookupTableObj = bankingAppDeleteCustomerWebElementList.get(17);
									WebElement lookupTable = bankingAppDeleteCustomer.lookup(lookupTableObj); 
									Thread.sleep(1000);
									WebElementDetails rowsObj = bankingAppDeleteCustomerWebElementList.get(18);
									int selctedRecordNo = 0;
									List<WebElement> rows = lookupTable
											.findElements(By.cssSelector(rowsObj.getCssSelector()));
									String DomainId = null;
									JavascriptExecutor js = (JavascriptExecutor) driver;
									for (int i = 1; i <= rows.size(); i++) {
										  if ((i % 10) == 0)
										  {
											    js.executeScript("window.scrollBy(0,1000)");
											    Thread.sleep(3000);
											    //rows.get(i).click();
										  }		
										  List<WebElement> cols = rows.get(i).findElements(By.cssSelector("td"));
										  DomainId = cols.get(2).getText();
										  if ((DomainId).trim().equalsIgnoreCase(webElementDataDetails.getDataSet().get(0))) {
												rows.get(i).findElement(By.cssSelector(".btn.btn-success.btn-xs")).click();
												Thread.sleep(4000);
												customMessage = "Dialog box Delete";
												WebElementDetails deletConfirmobj = bankingAppDeleteCustomerWebElementList.get(38);
												bankingAppDeleteCustomer.deleteUsrBtn(deletConfirmobj).click();
												Thread.sleep(4000);
												rows.get(i).findElement(By.cssSelector(".btn.btn-danger.btn-xs")).click();
												Thread.sleep(4000);
												customMessage = "Dialog box Delete";
												 deletConfirmobj = bankingAppDeleteCustomerWebElementList.get(38);
												 bankingAppDeleteCustomer.deleteUsrBtn(deletConfirmobj).click();
												Thread.sleep(4000);
												
												log.info(" Logout ");
												break;
											}
									}
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
