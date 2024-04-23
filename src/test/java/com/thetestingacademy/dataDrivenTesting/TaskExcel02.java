package com.thetestingacademy.dataDrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TaskExcel02
{
    // File open
    // Read Data
    // Read the Excel File
    // Create cell at Specific Position

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("CTD2.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0); // Main

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == CellType.NUMERIC) {
                    System.out.println(cell.getNumericCellValue());
                }
                if (cell.getCellType() == CellType.STRING) {
                    System.out.println(cell.getStringCellValue());
                }

            }
        }
    }
}
