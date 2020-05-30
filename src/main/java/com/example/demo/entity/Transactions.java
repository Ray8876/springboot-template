package com.example.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 出库入库表
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 客户名称
     */
    @TableField(exist = false)
    private String customerName;


    /**
     * 布匹id
     */
    private Integer clothId;

    /**
     * 布匹名称
     */
    @TableField(exist = false)
    private String clothName;

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
