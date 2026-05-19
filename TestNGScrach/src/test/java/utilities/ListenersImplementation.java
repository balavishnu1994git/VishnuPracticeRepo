package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v136.page.model.Screenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplementation extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("Test case Started");
		Reporter.log("Opening browser for text Exexution");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test Case Sucessfull");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		Reporter.log("Test Case Failed -----> Taking Screen Shot");
		TakesScreenshot srcshot = (TakesScreenshot) driver;
		File srcFile = srcshot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(ConstantsData.ConstsntData.FAILED_SCREEN_SHOT_PATH);//path stored in constant data
		try {
			FileUtils.copyFile(srcFile, destFile); //pasting the temp file to target
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Screenshot captured");
		
	}

}
