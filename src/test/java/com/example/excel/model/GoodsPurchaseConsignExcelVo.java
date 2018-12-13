package com.example.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class GoodsPurchaseConsignExcelVo extends BaseRowModel{

	/** 商品编码 **/
    @ExcelProperty(index = 0)
    private String goodsNo;

    /**供货价**/
    @ExcelProperty(index = 1)
    private java.math.BigDecimal supplyPrice;

    /**分成比例**/
    @ExcelProperty(index = 2)
    private java.math.BigDecimal proportion;
}