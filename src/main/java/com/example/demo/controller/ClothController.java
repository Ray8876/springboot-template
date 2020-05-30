package com.example.demo.controller;


import com.example.demo.entity.Cloth;
import com.example.demo.entity.ClothVo;
import com.example.demo.entity.Output;
import com.example.demo.entity.PageData;
import com.example.demo.service.IClothService;
import com.example.demo.util.OutputUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 布匹商品表 前端控制器
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/cloth")
public class ClothController {

    @Resource
    private IClothService clothService;

    /**
     * 查询布匹列表（分页）
     * @param clothVo
     * @return
     */
    @RequestMapping("/list")
    public Output<PageData<Cloth>> pageList(ClothVo clothVo){
        return OutputUtil.ok(clothService.pageList(clothVo));
    }

    /**
     * 添加或修改布匹信息
     * @param cloth
     * @return
     */
    @RequestMapping("/edit")
    public Output<String> edit(Cloth cloth){
        clothService.saveOrUpdate(cloth);
        return OutputUtil.ok("");
    }

    /**
     * 删除布匹信息
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public  Output<String> delete(@RequestParam("id") Integer id){
        clothService.removeById(id);
        return OutputUtil.ok("");
    }

    /**
     * 布匹详细信息
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    public  Output<Cloth> detail(@RequestParam("id") Integer id){
        return OutputUtil.ok(clothService.getById(id));
    }
}
