package excelReader;

import org.testng.annotations.Test;

public class Teste extends ExcelFilereadwrite{
	
	@Test
	public void add()
	{
		
		excelpath("./Files/WebUserdashboard.xlsx");
		System.out.println(excelreader(1,1,1));
		
		
	}

}
