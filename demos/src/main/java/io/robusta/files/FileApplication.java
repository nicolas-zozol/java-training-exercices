package io.robusta.files;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by Nicolas Zozol on 01/12/2016.
 */
public class FileApplication {

    String jvmPath = System.getProperty("user.dir");
    String adapterPath = "../java-training-exercices/";
    String excelPath = adapterPath + "demos/src/main/java/io/robusta/files/training.xlsx";

    public static void main(String[] args) throws Exception {


    }

    void readFile() throws Exception {
        System.out.println(jvmPath);
        // Here we absolutely need to adapt, depending on where Java is run


        Files.readAllLines(Paths.get(adapterPath + "demos/src/main/java/io/robusta/files/FileApplication.java"));

        new FileApplication().readExcel();
    }

    void readExcel() throws Exception {
        FileInputStream file = new FileInputStream(new File(excelPath));

        //Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        //Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell + "| ");
            }
            System.out.print("\n");
        }

    }

}
