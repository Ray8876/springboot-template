package com.example.demo.service;

import com.example.demo.entity.Cloth;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.ClothVo;
import com.example.demo.entity.PageData;

/**
 * <p>
 * 布匹商品表 服务类
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
public interface IClothService extends IService<Cloth> {

    /**
     * 查询布匹列表（分页）
     * @param clothVo
     * @return
     */
    PageData<Cloth> pageList(ClothVo clothVo);

}
