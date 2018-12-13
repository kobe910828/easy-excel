package com.example.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.excel.model.ExcelPropertyIndexModel;
import com.example.excel.util.DataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyExcelWriteTests {

    @Test
    public void testExcel2003NoModel() throws IOException{
        OutputStream out = new FileOutputStream("D:\\test_easyexcel_write\\test1.xls");
        ExcelWriter writer = EasyExcelFactory.getWriter(out, ExcelTypeEnum.XLS, true);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("第一个sheet");
        //设置列宽 设置每列的宽度
        sheet.setHead(DataUtil.createTestListStringHead());
        sheet.setAutoWidth(Boolean.TRUE);
        writer.write0(DataUtil.createStringList(), sheet);
        writer.finish();
        out.close();
    }


    @Test
    public void testExcel2007NoModel() throws IOException{
        OutputStream out = new FileOutputStream("D:\\test_easyexcel_write\\test1.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("第一个sheet");
        //设置列宽 设置每列的宽度
        sheet.setHead(DataUtil.createTestListStringHead());
        sheet.setAutoWidth(Boolean.TRUE);
        writer.write0(DataUtil.createStringList(), sheet);
        writer.finish();
        out.close();
    }


    @Test
    public void testExcel2003WithModel() throws IOException{
        OutputStream out = new FileOutputStream("D:\\test_easyexcel_write\\test2.xls");
        ExcelWriter writer = EasyExcelFactory.getWriter(out, ExcelTypeEnum.XLS, true);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet = new Sheet(1, 0, ExcelPropertyIndexModel.class);
        sheet.setSheetName("第一个sheet");
        //设置列宽 设置每列的宽度
        sheet.setAutoWidth(Boolean.TRUE);
        writer.write(DataUtil.createModelList(), sheet);
        writer.finish();
        out.close();
    }


    @Test
    public void testExcel2007WithModel() throws IOException{
        OutputStream out = new FileOutputStream("D:\\test_easyexcel_write\\test2.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet = new Sheet(1, 0, ExcelPropertyIndexModel.class);
        sheet.setSheetName("第一个sheet");
        //设置列宽 设置每列的宽度
        sheet.setAutoWidth(Boolean.TRUE);
        writer.write(DataUtil.createModelList(), sheet);
        writer.finish();
        out.close();
    }

}

