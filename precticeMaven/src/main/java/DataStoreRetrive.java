import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import fakerPractice.FakeData;

public class DataStoreRetrive {
	
	static File file = new File("strings.xlsx");
	static Workbook workbook;
	static Sheet sheet;
	static int lastRowNum;
	
	
	public DataStoreRetrive() throws IOException {
		
		
		if (file.exists()) {
			// Read the existing workbook
			FileInputStream fileIn = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileIn);
			sheet = workbook.getSheetAt(0);
			fileIn.close();

			// Get the last row number
			lastRowNum = sheet.getLastRowNum();
		} else {
			// Create a new workbook and a new sheet
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("names");
			lastRowNum = -1;
		}
	}

	
	
	public void addData(List<String> strings) throws IOException {
		
		FileInputStream fileIn = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheetAt(0);
		// Write the strings to the sheet
		Row row = sheet.createRow(lastRowNum + 1);
		for (int i = 0; i < strings.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(strings.get(i));
		}

//		 Write the workbook to a file
		FileOutputStream fileOut = new FileOutputStream(file);
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("sheet updated");
		
	}
	
	public List<String> extractData() throws InvalidFormatException, IOException {
		// Read the strings from the sheet
//		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		List<String> readStrings = new ArrayList<String>();
		Random rand = new Random();
		int randomIndex = rand.nextInt(sheet.getLastRowNum());
		System.out.println(sheet.getLastRowNum());
		System.out.println(randomIndex);

		Row r = sheet.getRow(randomIndex);

		for (Cell cell : r) {
			readStrings.add(cell.getStringCellValue());
		}
		
		sheet.removeRow(r);
		sheet.shiftRows(randomIndex+1, sheet.getLastRowNum(), -1);
		
        // Remove blank rows from the sheet
//        for (int i = 0; i <= lastRowNum; i++) {
//            Row row = sheet.getRow(i);
//            if (isRowBlank(row)) {
//                sheet.removeRow(row);
//                lastRowNum--;
//                i--;
//            }
//        }
		
//		sheet.shiftRows(r.getRowNum() + 1, r.getRowNum() + 1, -1);
		FileOutputStream fileOut = new FileOutputStream(file);
		workbook.write(fileOut);
		fileOut.close();
		
		return readStrings;
		
		
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InvalidFormatException {

//		public class StoreStringsInExcel {
//		    public static void main(String[] args) throws IOException {
		// Create a list of strings to store in the Excel sheet

		FakeData fake = new FakeData();
		List<String> strings = Arrays.asList(fake.FIRST_NAME, fake.LAST_NAME, fake.COMPANY);

		// Check if the file exists
		DataStoreRetrive ds = new DataStoreRetrive();
		ds.addData(strings);
		
		
		List<String> readStrings = ds.extractData();


		System.out.println("random names fn :" + readStrings.get(0));
		System.out.println("random names ln :" + readStrings.get(1));
		System.out.println("random names cn :" + readStrings.get(2));




	}
	
	
    private static boolean isRowBlank(Row row) {
        if (row == null) {
            return true;
        }
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

}
