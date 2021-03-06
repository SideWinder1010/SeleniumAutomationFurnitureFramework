package com.mindtree.sdet.test;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.mindtree.sdet.pages.HomePage;
import com.mindtree.sdet.pages.LandingPage;
import com.mindtree.sdet.pages.LoginPage;
import com.mindtree.sdet.pages.PageBase;
import com.mindtree.sdet.util.ConfigReader;
import com.mindtree.sdet.util.Screenshot;
import com.mindtree.sdet.util.TestData;
import com.mindtree.sdet.util.XLSWorker;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends PageBase {

	private static HomePage homePage;
	private static LoginPage loginPage;
	private static LandingPage landingPage;
	private static XLSWorker xlsWorker;
	private static Screenshot screenshot;
	private static String sheetName = "customerinfo";
	private static ConfigReader configReader;
	private static ExtentTest extentReportLogger = null;
	private static String methodName;
	private static String testCategory = "Book My Furniture App";

	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp(Method method) {
		homePage = new HomePage();
		loginPage = homePage.ClickSignUpButton(method);
		log.info("Entering Login Page");
		this.extentReportLogger = PageBase.extentReportLogger;
		extentReportLogger.assignCategory(testCategory);

	}

	@DataProvider
	public Object[][] getFurnitureTestData() {
		return TestData.getSearchData("TestData");
	}

	@Test(dataProvider = "getFurnitureTestData")
	public void registerUserTest(String Name, String MobileNumber, String Email, String Password, Method method) {		
		log.info("Entering" + Name + "to login to application");
		log.info("Entering" + MobileNumber + "to login to application");
		log.info("Entering" + Password + "to login to application");
		loginPage.enterUserDetails(Name, MobileNumber, Email, Password, method);

	}

}
