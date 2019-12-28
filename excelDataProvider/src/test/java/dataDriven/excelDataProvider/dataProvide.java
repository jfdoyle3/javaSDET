package dataDriven.excelDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {
	
	// Multiple sets of data to our test.
	// Data must be in a an Array and can be a multidim array.
	// 5 Sets of data as 5 arrays from data provider to your tests.
	// the your test will run 5 times with 5 separate sets of data arrays.
	
	@Test(dataProvider="driveTest")
	public void testCaseData(int ID,String textField1, String textField2)
	{
		System.out.println(ID+textField1+textField2);
	}
	
	// top method is the test bench.
	// These 2 methods and annotations @ are the skeleton to create tests.
	// the bottom method is the data set.
	
	@DataProvider(name="driveTest")
	public Object[][] getData()
	{
		Object[][] data= {{3,"Student", "Careerdevs"},{1010,"Resistance","Futile"},{3000,"Stop, wait","Go"}};
		return data;
	}
	
	
	
}
