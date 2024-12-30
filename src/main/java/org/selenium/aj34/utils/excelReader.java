package org.selenium.aj34.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

public class excelReader {

    @DataProvider(name = "demoData")
    public Object[][] getData() {
        return sheetData(System.getProperty("user.dir") + "\\src\\test\\resources\\DemoPlaces.xlsx", "Places");
    }

    public String[][] sheetData(String fileName, String sheet) {
        String[][] data = null;
        try {
            FileInputStream file = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet1 = workbook.getSheet(sheet);

            int rowCount = sheet1.getPhysicalNumberOfRows();  // Get physical row count
            int cellCount = sheet1.getRow(0).getPhysicalNumberOfCells();  // Get physical cell count

            data = new String[rowCount - 1][cellCount];

            for (int row = 1; row < rowCount; row++) {
                for (int col = 0; col < cellCount; col++) {
                    if (sheet1.getRow(row).getCell(col) != null) {
                        Cell cell = sheet1.getRow(row).getCell(col);
                        switch (cell.getCellType()) {
                            case STRING:
                                data[row - 1][col] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                data[row - 1][col] = String.valueOf(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                data[row - 1][col] = String.valueOf(cell.getBooleanCellValue());
                                break;
                            default:
                                data[row - 1][col] = "";  // If the cell is empty or of an unknown type
                        }
                    }
                }
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
