package dataStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import fakerPractice.FakeData;

public class RetriveAndStoreData {

	static File file = new File("runtimeData.xlsx");
	static Workbook workbook;
	static Sheet sheet;
	static int lastRowNum;
	public List<String> data;

	public RetriveAndStoreData() throws IOException, InvalidFormatException {

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
			sheet = workbook.createSheet("AccOppNames");
			lastRowNum = -1;
			FileOutputStream fileOut = new FileOutputStream(file);
			workbook.write(fileOut);
			fileOut.close();

		}
		
		try {
			this.data = extractData();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public RetriveAndStoreData(String data) throws InvalidFormatException, IOException {

		

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

		/**
		 * use this if you create header in excel file IntStream randomIndexes =
		 * rand.ints(1, sheet.getLastRowNum()); int randomIndex =
		 * randomIndex.findFirst().getAsInt();
		 */

//		System.out.println(sheet.getLastRowNum());
//		System.out.println(randomIndex);

		Row r = sheet.getRow(randomIndex);

		for (Cell cell : r) {
			readStrings.add(cell.getStringCellValue());
		}

		/**
		 * use this code to remove row and shift the remaining cells up
		 * sheet.removeRow(r); sheet.shiftRows(randomIndex+1, sheet.getLastRowNum(),
		 * -1);
		 */

//		sheet.shiftRows(r.getRowNum() + 1, r.getRowNum() + 1, -1);
		FileOutputStream fileOut = new FileOutputStream(file);
		workbook.write(fileOut);
		fileOut.close();

		return readStrings;

	}

	public String getAccName() throws InvalidFormatException, IOException {

		return data.get(0);
	}

	public String getConName() throws InvalidFormatException, IOException {

		return data.get(1);
	}

	public String getOppName() throws InvalidFormatException, IOException {
		return data.get(2);
	}

}
