package com.example.demo.entity;

import lombok.Data;

@Data
public class CustomerVo extends PageParams{

    /**
     * 客户名
     */
    private String customerName;

    /**
     * 客户地址
     */
    private String customerAddress;

    /**
     * 客户电话
     */
    private String customerMoblie;

}
