package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Cloth;
import com.example.demo.entity.ClothVo;
import com.example.demo.entity.PageData;
import com.example.demo.mapper.ClothMapper;
import com.example.demo.service.IClothService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 布匹商品表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@Service
public class ClothServiceImpl extends ServiceImpl<ClothMapper, Cloth> implements IClothService {

    @Resource
    private ClothMapper clothMapper;

    /**
     * 查询布匹列表（分页）
     * @param clothVo
     * @return
     */
    @Override
    public PageData<Cloth> pageList(ClothVo clothVo) {
        PageData<Cloth> data = new PageData<>();
        IPage<Cloth> clothIPage = clothMapper.selectPage(new Page<>(clothVo.getCurrent(), clothVo.getSize()), null);
        List<Cloth> records = clothIPage.getRecords();
        data.setTotalCount(clothIPage.getTotal());
        data.setList(records);
        return data;
    }

}
