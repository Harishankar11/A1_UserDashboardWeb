package excelReader;


import excelReader.ExcelFilereadwrite;


public class Dynamicexcelread extends ExcelFilereadwrite {
	
	
	public String LCFsubmit(String values) throws Exception
	
	{
		String Nextvalue = null;
		ExcelFilereadwrite ex1 = new ExcelFilereadwrite();
		
		//ex1.excelpath("./Files/WebUserdashboard.xlsx");
		ex1.excelpath("./Files/WebUserdashboard.xlsx");
		int []a = ex1.excelcellcount(1);
		
		/*System.out.println(a[0]);
		System.out.println(a[1]);*/
		
		for(int i=0;i<=a[0];i++)
		{
			for(int j=0;j<=a[1];j++)
			{
				//System.out.println(ex1.excelreader(1, i, j));
				String comp = ex1.excelreader(1, i, j);
				if(comp.equalsIgnoreCase(values))
				{
					Nextvalue = (ex1.excelreader(1, i, j+1));
					break;
					
				}
			}
			
		}
		
		return Nextvalue; 
	
	}

}
