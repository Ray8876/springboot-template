package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 进货商表
 * </p>
 *
 * @author generator
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 进货商名
     */
    private String supplierName;

    /**
     * 进货商地址
     */
    private String supplierAddress;

    /**
     * 进货商电话
     */
    private String supplierMoblie;

    /**
     * 备注
     */
    private String supplierMessage;


}
