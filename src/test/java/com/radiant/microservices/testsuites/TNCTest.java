/**
 * @author Jp
 *
 */
package com.radiant.microservices.testsuites;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.reports.ReportsManager;


import com.radiant.microservices.testscripts.BankingAppModifyCustomerTestScript;
import com.radiant.microservices.testscripts.BankingAppAddCustomerTestScript;
import com.radiant.microservices.testscripts.BankingAppDeleteCustomerTestScript;
import com.radiant.microservices.testscripts.LoginTestScript;
import com.radiant.microservices.testscripts.LogoutTestScript;

public class TNCTest {
	protected transient final Log log = LogFactory.getLog(getClass());
	private TestSuiteDetails testSuiteDetails = null;

	
	// ==========================================================================
	@Test
	public void tncTestSuite() throws Exception {
		log.info("START of the method tncTestSuite");
		long testSuiteDetailsId = 0;
		
		LoginTestScript loginTestScript = null;
		
		BankingAppAddCustomerTestScript bankingAppAddCustomerTestScript = null;
		BankingAppModifyCustomerTestScript bankingAppModifyCustomerTestScript = null;
		BankingAppDeleteCustomerTestScript bankingAppDeleteCustomerTestScript = null;
		
		LogoutTestScript logoutTestScript = null;

		
			// Adding test Suite details and getting test suite ID
			testSuiteDetails = TAFDBManagerHelper.getInstance().saveTestSuiteDetails(getClass().getSimpleName());

			if (testSuiteDetails != null && testSuiteDetails.getTestSuiteDetailsId() > 0) {
				testSuiteDetailsId = testSuiteDetails.getTestSuiteDetailsId();
				
			  // Executing the Test script for Login
				 loginTestScript = new LoginTestScript(testSuiteDetails);
				 loginTestScript.login();
			     
		     //  Executing the Test script for Banking Modify User Test Script
		     	 bankingAppAddCustomerTestScript = new BankingAppAddCustomerTestScript(testSuiteDetails);
		     	 bankingAppAddCustomerTestScript.addBankingCustomer();
			     
				 		 
			  // Executing the Test script for Banking Modify User Test Script
			     bankingAppModifyCustomerTestScript = new BankingAppModifyCustomerTestScript(testSuiteDetails);
			     bankingAppModifyCustomerTestScript.modifyBankingCustomer();
			     
			     
		     // Executing the Test script for Banking Modify User Test Script
		     //	bankingAppDeleteCustomerTestScript = new BankingAppDeleteCustomerTestScript(testSuiteDetails);
		     //	bankingAppDeleteCustomerTestScript.deleteBankingCustomer();
		   	
		     	
			  // Executing the Test script for Logout
				 logoutTestScript = new LogoutTestScript(testSuiteDetails);
				 logoutTestScript.logout();
				 
				 if (!testSuiteDetails.isTestStatusSuccess()) {
						throw new Exception("Test case Failed");
					}

				 
			} 
	}

	// ==========================================================================

	@AfterTest
	public void sendReport() {
		ReportsManager.getInstance().sendTestReport(testSuiteDetails);
	}
	
	// ==========================================================================
}
