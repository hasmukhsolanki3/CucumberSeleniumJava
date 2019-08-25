package runner;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/features"}, 
	glue={"steps"}, 
	monochrome=true, 
	//tags={"@bvt, @Sanity"},
	plugin={"pretty", "html:target/cucumber", "com.cucumber.listener.ExtentCucumberFormatter"})
public class RunCuke {
	
	@BeforeClass
	public static void setup1(){
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		
		//Loads the extent congif xml to customize on the report
		ExtentCucumberFormatter.loadConfig(new File("src/extent-config.xml"));
		
		//User can add system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
		ExtentCucumberFormatter.addSystemInfo("Browser Version", "Firefox");
		ExtentCucumberFormatter.addSystemInfo("Selenium Version", "Firefox");
		
	
	}

}
