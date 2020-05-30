package com.example.demo.controller;


import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerVo;
import com.example.demo.entity.Output;
import com.example.demo.entity.PageData;
import com.example.demo.service.ICustomerService;
import com.example.demo.util.OutputUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private ICustomerService customerService;

    /**
     * 客户信息表（分页）
     * @param customerVo
     * @return
     */
    @RequestMapping("/list")
    public Output<PageData<Customer>> pageList(CustomerVo customerVo){
        return OutputUtil.ok(customerService.pageList(customerVo));
    }

    /**
     * 添加或修改客户信息
     * @param customer
     * @return
     */
    @RequestMapping("/edit")
    public Output<String> edit(Customer customer){
        customerService.saveOrUpdate(customer);
        return OutputUtil.ok("");
    }

    /**
     * 删除客户信息
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Output<String> delete(@RequestParam("id") Integer id){
        customerService.removeById(id);
        return OutputUtil.ok("");
    }

    @RequestMapping("/detail")
    public Output<Customer> detail(@RequestParam("id") Integer id){
        return OutputUtil.ok(customerService.getById(id));
    }
}
