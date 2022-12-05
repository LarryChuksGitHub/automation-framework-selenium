package utils;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadDataFromExcel {

    @DataProvider(name = "excelData")
    public static Object[][] getData() {
        Object[][] data = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getDataProviderPath());
            XSSFWorkbook book = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = book.getSheet("sheet2");
            if (sheet == null) {
                System.out.println("The sheet or data file cannot be found, please check the name of the sheet or the file. Exiting ...");
                System.exit(0);
            }
            int rownumber = sheet.getLastRowNum();
            System.out.println("Row number: " + rownumber);
            int columnNumber = sheet.getRow(1).getLastCellNum();
            System.out.println("Row column: " + columnNumber);
            data = new Object[rownumber][columnNumber];

            for (int i = 1; i <= rownumber; i++) {
                for (int j = 0; j < columnNumber; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @DataProvider(name = "excelMapData",parallel = true)
    public Object[] getMapData() {
        Object[] data = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getDataProviderPath());
            XSSFWorkbook book = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = book.getSheet("sheet2");
            if (sheet == null) {
                System.out.println("The sheet or data file cannot be found, please check the name of the sheet or the file. Exiting ...");
                System.exit(0);
            }
            int rowNumber = sheet.getLastRowNum();
            int columnNumber = sheet.getRow(0).getLastCellNum();
            data = new Object[rowNumber];
            Map<String, String> map = null;

            for (int i = 1; i <= rowNumber; i ++){
                map = new HashMap<>();
                for (int j = 0; j < columnNumber; j++){
                   String key = sheet.getRow(0).getCell(j).getStringCellValue();
                   String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                    data[i-1] = map;
                }
            }
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
