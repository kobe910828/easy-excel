package com.example.excel.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/12/13 11:36
 */
@Getter
@Setter
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<>();
    public void invoke(Object object, AnalysisContext context) {
        System.out.println("当前行："+context.getCurrentRowNum());
        System.out.println(object);
        if(datas.size() <= 100){
            datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        }else {
            doSomething(object);//根据自己业务做处理
            datas = new ArrayList<>();
        }
    }
    private void doSomething(Object object) {
        for(Object o : datas){
            System.out.println(o);
        }
    }
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("doAfterAllAnalysed...");
        // datas.clear();//解析结束销毁不用的资源
    }
}