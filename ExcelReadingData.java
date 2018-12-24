package SoniClassess.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingData {

	static LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>> getsheetData;

	static String sourceFolder;
	public ExcelReadingData(String sourceFolder) {
		this.sourceFolder=sourceFolder;
	}

	public static void readData(String fileName) throws IOException
	{

		String inputfile=sourceFolder+"/TestData/"+fileName;

		FileInputStream fis=new FileInputStream(inputfile);

		Workbook wb=new XSSFWorkbook(fis);

		int sheetcount=wb.getNumberOfSheets();
		System.out.println("no of sheet:"+sheetcount);

		getsheetData=new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>> ();


		for(int i=0;i<sheetcount;i++)
		{
			//System.out.println(wb.getSheetAt(i).getSheetName());

			String sheetname=wb.getSheetAt(i).getSheetName();

			//if(wb.getSheetAt(i).getSheetName().equalsIgnoreCase("GuruDemoExcel"))
			//{
			Sheet st=wb.getSheetAt(i);
			int noOfRowscount=st.getPhysicalNumberOfRows();//get count of used rows
			System.out.println("no of row:"+noOfRowscount);
			Row headerRow=st.getRow(i);

			LinkedHashMap<String,LinkedHashMap<String,String>> sheetmap=new LinkedHashMap<String,LinkedHashMap<String,String>> ();


			//header row is 0th row hence counter starts from 1 row

			for(int j=1;j<noOfRowscount;j++)
			{
				Row rowObj=st.getRow(j);
				int noOfCells=rowObj.getLastCellNum();


				LinkedHashMap<String,String> rowmap=new LinkedHashMap<String,String> ();//created map for each header and row pair to store data on key value pair

				for(int k=0;k<noOfCells;k++)//loop to get data from each cell
				{
					String headerdata;
					if(rowObj.getCell(k)==null)
					{
						headerdata="";//checking if header data is null
					}else{
						headerdata=headerRow.getCell(k).toString();
					}


					//headerdata=headerRow.getCell(k).toString();//creating key value pair for header and row data

					String cellData;

					if(rowObj.getCell(k)==null)
					{
						cellData="";
					}else{
						cellData=rowObj.getCell(k).toString();
					}


					// System.out.println(headerdata+"||"+cellData);
					rowmap.put(headerdata, cellData);//adding values into  map for header and row(cell1) value

				}
				// System.out.println(rowmap);//it always stores last row data in hashmap

				String uniquecol=st.getRow(j).getCell(0).toString();//reading entire row data corresponding to unique col value
				
				System.out.println("data in unique cols:"+uniquecol);
				
				
				sheetmap.put(uniquecol, rowmap);//
				//printing data for entire sheet

			}


			getsheetData.put(sheetname, sheetmap);
			System.out.println(getsheetData);

			//}

		}

	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> getsheetData(String Sheetname)
	{

		return getsheetData.get(Sheetname);

	}

	public LinkedHashMap<String, String> getTestCaseData(String sheetName,String TestCaseID)
	{
		return getsheetData.get(sheetName).get(TestCaseID);

	}

	public String getColumnData(String sheetName,String TestCaseID,String colName)
	{

		return getsheetData.get(sheetName).get(TestCaseID).get(colName);
	}





}
