package com.example.demo.service;

import com.example.demo.entity.Supplier;
import com.example.demo.entity.SupplierVo;
import com.example.demo.entity.PageData;
import com.example.demo.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 进货商表 服务类
 * </p>
 *
 * @author generator
 * @since 2020-06-01
 */
public interface ISupplierService extends IService<Supplier> {

    /**
     * 进货商信息表（分页）
     * @param SupplierVo
     * @return
     */
    PageData<Supplier> pageList(SupplierVo SupplierVo);
    
}
