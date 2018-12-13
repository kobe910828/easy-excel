package com.example.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.excel.listen.ExcelListener;
import com.example.excel.listen.ModelExcelListener;
import com.example.excel.model.GoodsPurchaseConsignExcelVo;
import com.example.excel.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyExcelReadTests {

    @Test
    public void testExcelNoModel() {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("Excel-840740629.xls");
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            //ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
//            ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, listener);
//            excelReader.read();
            EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1), listener);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testExcelWithReflectModel() {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("test_easyexcel.xlsx");
        try {
            // 解析每行结果在listener中处理
            AnalysisEventListener listener = new ModelExcelListener();
//            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
//            excelReader.read(new Sheet(1, 2, GoodsPurchaseConsignExcelVo.class));
//            EasyExcelFactory.getReader(inputStream, listener).read(new Sheet(1, 1,
//                    GoodsPurchaseConsignExcelVo.class));
            EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1,
                    GoodsPurchaseConsignExcelVo.class), listener);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

