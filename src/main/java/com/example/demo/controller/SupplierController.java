package com.example.demo.controller;


import com.example.demo.entity.Supplier;
import com.example.demo.entity.SupplierVo;
import com.example.demo.entity.Output;
import com.example.demo.entity.PageData;
import com.example.demo.service.ISupplierService;
import com.example.demo.util.OutputUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 进货商表 前端控制器
 * </p>
 *
 * @author generator
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Resource
    private ISupplierService SupplierService;


    /**
     * 进货商信息表（分页）
     * @param SupplierVo
     * @return
     */
    @RequestMapping("/list")
    public Output<PageData<Supplier>> pageList(SupplierVo SupplierVo){
        return OutputUtil.ok(SupplierService.pageList(SupplierVo));
    }

    /**
     * 添加或修改进货商信息
     * @param Supplier
     * @return
     */
    @RequestMapping("/edit")
    public Output<String> edit(Supplier Supplier){
        SupplierService.saveOrUpdate(Supplier);
        return OutputUtil.ok("");
    }

    /**
     * 删除进货商信息
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Output<String> delete(@RequestParam("id") Integer id){
        SupplierService.removeById(id);
        return OutputUtil.ok("");
    }

    @RequestMapping("/detail")
    public Output<Supplier> detail(@RequestParam("id") Integer id){
        return OutputUtil.ok(SupplierService.getById(id));
    }
}
