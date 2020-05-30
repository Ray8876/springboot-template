package com.example.demo.entity;

import lombok.Data;

/**
 * 列表返回
 */
@Data
public class Output<T> {

    /**
     * 0:成功
     */
    private int code = 0;

    /**
     * msg
     */
    private String msg = "";

    /**
     * data
     */
    private T data = null;

}
