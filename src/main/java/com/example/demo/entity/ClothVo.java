package com.example.demo.entity;

import lombok.Data;

@Data
public class ClothVo extends PageParams{

    /**
     * 布匹名称
     */
    private String clothName;

    /**
     * 布匹重量
     */
    private Integer clothWeight;

    /**
     * 布匹长度（米）
     */
    private Integer clothLength;
}
