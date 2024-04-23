package com.thetestingacademy.dataDrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskExcel03
{
    // File open
    // Read Data
    // Read the Excel File
    // Create cell at Specific Position


    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Row row = sheet.createRow(5);
        Cell cell = row.createCell(5);
        cell.setCellValue("Pramod Dutta");


        FileOutputStream outputStream = new FileOutputStream(new File("SELLSPECIFIC.xlsx"));
        workbook.write(outputStream);
        outputStream.close();
    }
}
