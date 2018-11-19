package com.leshuibao.fragmentTax.util;

import java.io.*;
import java.nio.file.Files;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 根据目标模板Excel生成新的文件，并写入数据
 */
public class ExcelUtil {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
//    private static final String TAMPLATE_PATH = PropertiesUtil.prop("template_path");
//    private static final String FILE_PATH = PropertiesUtil.prop("file_path");

    /**
     * 将值填入Excel模版里，并保存
     *
     * @param workBook 要写入的Excel
     * @param sheetno  要写入的Excel的第sheetno个sheet
     * @param rowno    Excel第rowno列
     * @param cellno   Excel第cellno行
     * @param val      要写入的值
     */
    public static Workbook write(Workbook workBook, Integer sheetno, Integer rowno, Integer cellno, String val) {

        // sheet 对应一个工作页
        Cell cell = workBook.getSheetAt(sheetno).getRow(rowno).getCell(cellno);
        cell.setCellValue(val);

        return workBook;
    }

    public static void save(Workbook workBook, String filePath) throws IOException {
        // 生成输出目标文件
//        File targetXlsxFile = new File(filePath);
//        // 判断文件是否存在，不存在则删除
//        if (targetXlsxFile.exists()) {
//            targetXlsxFile.delete();
//        }
        workBook.write(new FileOutputStream(filePath));
        workBook.close();

    }

    /**
     * 根据模版Excel复制一份新的Excel
     *
     * @param templatePath 模版Excel地址
     * @return 新的文件
     * @throws IOException
     */
    public static Workbook copyFile(String templatePath) throws IOException {

        // 读取Excel模板
        return getWorkbok(new File(templatePath));
    }


    /**
     * 判断Excel的版本,获取Workbook
     */
    private static Workbook getWorkbok(File file) throws IOException {
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }


    public static void main(String[] args) throws IOException {

        Workbook workbook = copyFile(PropertiesUtil.prop("template_path"));

        write(workbook, 0, 13, 1, "test");
//        save(write(workbook, 0, 13, 1, "test"),PropertiesUtil.prop("file_path") + "test.xlsx");
        save(write(workbook, 0, 14, 1, "test"),PropertiesUtil.prop("file_path") + "test.xlsx");
    }
}
