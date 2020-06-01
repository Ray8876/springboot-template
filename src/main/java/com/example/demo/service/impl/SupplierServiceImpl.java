package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Supplier;
import com.example.demo.entity.SupplierVo;
import com.example.demo.entity.PageData;
import com.example.demo.mapper.SupplierMapper;
import com.example.demo.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 进货商表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-06-01
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Resource
    private SupplierMapper SupplierMapper;

    /**
     * 客户信息表（分页）
     * @param SupplierVo
     * @return
     */
    @Override
    public PageData<Supplier> pageList(SupplierVo SupplierVo) {
        PageData<Supplier> data = new PageData<>();
        IPage<Supplier> SupplierIPage = SupplierMapper.selectPage(new Page<>(SupplierVo.getCurrent(), SupplierVo.getSize()), null);
        List<Supplier> records = SupplierIPage.getRecords();
        data.setTotalCount(SupplierIPage.getTotal());
        data.setList(records);
        return data;
    }
}
