package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils{
    private XSSFWorkbook work_book;
    private XSSFSheet sheet;
    private Cell cell;
    private File s;
    private FileInputStream stream_in;
    private FileOutputStream stream_out;

    public ExcelUtils(String excelfilePath, String excelfileName) throws Exception {
        try {
            String importFilePath = excelfilePath + excelfileName;
                
            s = new File(importFilePath);
            stream_in = new FileInputStream(s);
            work_book = new XSSFWorkbook(stream_in);
        }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
    }

    public String getData(int sheetnumber, int row, int column) throws Exception {
        sheet = work_book.getSheetAt(sheetnumber);
        cell = sheet.getRow(row).getCell(column);
        return cell.getStringCellValue();
    }

    public int getRowCount(int sheetnumber) {
        sheet = work_book.getSheetAt(sheetnumber);
        return sheet.getPhysicalNumberOfRows();
    }

    public int getRowByTCID(int sheetnumber, String tcID) {
        sheet = work_book.getSheetAt(sheetnumber);
        for(Row row : sheet) {
            for(Cell cell : row) {
                if(tcID.equals(cell.getStringCellValue())) {
                    return cell.getRowIndex();
                }
            }
        }
        return 0;
    }
        
    public void setCellData(String result, int sheetnumber, String tcID, int column) throws Exception{
        try{
            int row = getRowByTCID(sheetnumber, tcID);
            System.out.println("Testing row: " + row);
            sheet = work_book.getSheetAt(sheetnumber);
            cell = sheet.getRow(row).getCell(column);
            if (cell == null) {
                cell = sheet.getRow(row).createCell(column);
            }
            cell.setCellValue(result);
        }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
    }

    public void saveData(String excelfilePath, String excelfileName) throws Exception{
        try{
            String fileNameWithOutExt = FilenameUtils.removeExtension(excelfileName);
            String exportFilePath = excelfilePath + fileNameWithOutExt + "_Export.xlsx";
            stream_out = new FileOutputStream(exportFilePath);
            work_book.write(stream_out);
            stream_out.flush();
            stream_out.close();
        }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
    }
}
