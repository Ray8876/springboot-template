package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionsVo extends PageParams {

    /**
     * 布匹id
     */
    private Integer clothId;

    /**
     * 交易长度（米）
     */
    private Integer length;

    /**
     * 交易状态 -1为出库 1位入库
     */
    private Integer state;

    /**
     * 交易价格
     */
    private BigDecimal totalPrice;

}
