package com.example.demo.entity;

import lombok.Data;

@Data
public class SupplierVo extends PageParams{

    /**
     * 客户名
     */
    private String SupplierName;

    /**
     * 客户地址
     */
    private String SupplierAddress;

    /**
     * 客户电话
     */
    private String SupplierMoblie;

}
