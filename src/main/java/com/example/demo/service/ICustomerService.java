package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.CustomerVo;
import com.example.demo.entity.PageData;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * 客户信息表（分页）
     * @param customerVo
     * @return
     */
    PageData<Customer> pageList(CustomerVo customerVo);

}
