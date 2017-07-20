package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;


public class Rerunfailcase {

	//@Test
	public void retestfailcase() {
		
		TestNG test = new TestNG();
		
		List<String> list = new ArrayList<>();
		
		list.add("D:\\Workplace\\B01_UserDashboardWeb\\test-output\\Suite\\testng-failed.xml");
		
		test.setTestSuites(list);
		
		test.run();
		

	}

}
