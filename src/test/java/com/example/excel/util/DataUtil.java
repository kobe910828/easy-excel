package com.example.excel.util;

import com.example.excel.model.ExcelPropertyIndexModel;
import com.example.excel.model.GoodsPurchaseConsignExcelVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/12/13 15:21
 */
public class DataUtil {
    public static List<List<String>> createStringList(){
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<String> item = new ArrayList<>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
        return data;
    }

    public static List<List<String>> createTestListStringHead(){
        //模型上没有注解，表头数据动态传入
        List<List<String>> head = new ArrayList<>();
        List<String> headCoulumn1 = new ArrayList<>();
        List<String> headCoulumn2 = new ArrayList<>();
        List<String> headCoulumn3 = new ArrayList<>();

        headCoulumn1.add("第一列");
        headCoulumn2.add("第二列");
        headCoulumn3.add("第三列");

        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        return head;
    }

    public static List<ExcelPropertyIndexModel> createModelList(){
        List<ExcelPropertyIndexModel> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
            item.setName("name" + i);
            item.setAge("age" + i);
            item.setEmail("email" + i);
            item.setAddress("address" + i);
            item.setSex("sex" + i);
            item.setHeigh("heigh" + i);
            item.setLast("last" + i);
            data.add(item);
        }
        return data;
    }
}
