package com.example.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 布匹商品表
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Cloth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    /**
     * 价格
     */
    private BigDecimal price;

}
