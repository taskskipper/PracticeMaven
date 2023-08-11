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
	static int randomIndex;

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
			System.out.println("err in data contrustor");
			// TODO: handle exception
		}
	}

	public RetriveAndStoreData(String data) throws InvalidFormatException, IOException {

	}

	public void addCourse(String strings) throws IOException {

		FileInputStream fileIn = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheetAt(0);
		// Write the strings to the sheet

		
		int newRowNum = lastRowNum + 1;
		Row row = sheet.createRow(newRowNum);
		Cell cell = row.createCell(0);
		cell.setCellValue(strings);

		randomIndex = newRowNum;
		
//		 Write the workbook to a file
		FileOutputStream fileOut = new FileOutputStream(file);
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("sheet updated");

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

	public void addModule(String strings) throws IOException {

		FileInputStream fileIn = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheetAt(0);
		// Write the strings to the sheet
//		Row row = sheet.createRow(lastRowNum + 1);

		
		System.out.println(randomIndex);
		Row row = sheet.getRow(randomIndex);

		List<String> d = new ArrayList();
		
		for (Cell cell : row) {
			d.add(cell.getStringCellValue());
			
		}
		
		
		int rowsize = d.size();

		Cell cell = row.createCell(rowsize);
		cell.setCellValue(strings);

//		 Write the workbook to a file
		FileOutputStream fileOut = new FileOutputStream(file);
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("sheet updated with new module");

	}

	private List<String> extractData() throws InvalidFormatException, IOException {
		// Read the strings from the sheet
//		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		List<String> readStrings = new ArrayList<String>();
		Random rand = new Random();

		randomIndex = rand.nextInt(1, lastRowNum);

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

	public String getCourseName() throws InvalidFormatException, IOException {

		return data.get(0);
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

	public String getCourseNameToBeDeleted() throws InvalidFormatException, IOException{
		
		
		Row r = sheet.getRow(randomIndex);
		
		String deletingCourseName = getCourseName();
		
//		System.out.println(deletingCourseName);
		sheet.removeRow(r); 
		sheet.shiftRows(randomIndex+1, sheet.getLastRowNum(), -1);
		
		FileOutputStream fileOut = new FileOutputStream(file);
		workbook.write(fileOut);
		fileOut.close();
		
		return deletingCourseName;
		
	}

	public String getModuleNameToBeDeleted() throws InvalidFormatException, IOException {
		
//		Row row = sheet.getRow(randomIndex);
//		sheet.removeRow(row);
		
		String deletingModuleName = getModule();
		getCourseNameToBeDeleted();
		
		data.remove(deletingModuleName);
//		addData(data);
		
		FileInputStream fileIn = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheetAt(0);
		// Write the strings to the sheet
		Row row = sheet.createRow(lastRowNum + 1);
		for (int i = 0; i < data.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(data.get(i));
		}

//		 Write the workbook to a file
		FileOutputStream fileOut = new FileOutputStream(file);
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("sheet updated with deleted module");
		
		
		
//		for (int i = 0; i < data.size(); i++) {
//			Cell cell = row.createCell(i);
////			cell.setCellValue(deletingModuleName);
//	
//			cell.setCellValue(data.get(i));
//		}
//		
//		FileOutputStream fileOut = new FileOutputStream(file);
//		workbook.write(fileOut);
//		fileOut.close();
		
		return deletingModuleName;
	}
	
	public String getModule() throws InvalidFormatException, IOException {
		Random rnd = new Random();
		
		if(data.size() == 0 || data.size() ==1 ) {
			System.out.println("no modules found");
			return null;
		}else if(data.size() == 2) {
			return data.get(1);
			
		}else {
			return data.get(rnd.nextInt(1, data.size() - 1));
		}
		
	}
	
	public String getCourseWithModules() throws InvalidFormatException, IOException {
		
		if(getModule() ==null) {
			
			while(getModule() ==null) {
				data = extractData();
			}
			
			return getModule();
			
		}else {
			return getModule();
		}
		
		
		
	}
	

}
