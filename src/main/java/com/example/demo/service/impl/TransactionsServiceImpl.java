package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.PageData;
import com.example.demo.entity.Transactions;
import com.example.demo.entity.TransactionsVo;
import com.example.demo.mapper.ClothMapper;
import com.example.demo.mapper.TransactionsMapper;
import com.example.demo.service.ITransactionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 出库入库表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@Service
public class TransactionsServiceImpl extends ServiceImpl<TransactionsMapper, Transactions> implements ITransactionsService {

    @Resource
    private TransactionsMapper transactionsMapper;
//    @Resource
//    private ClothMapper clothMapper;

    /**
     * 查询订单列表（分页）
     * @param transactionsVo
     * @return
     */
    @Override
    public PageData<Transactions> pageListChu(TransactionsVo transactionsVo) {
        PageData<Transactions> data = new PageData<>();
        IPage<Transactions> transactionsIPage = transactionsMapper.selectPageChu(new Page<>(transactionsVo.getCurrent(), transactionsVo.getSize()), null);
        List<Transactions> records = transactionsIPage.getRecords();
        data.setTotalCount(transactionsIPage.getTotal());
        data.setList(records);
        return data;
    }

    @Override
    public PageData<Transactions> pageListRu(TransactionsVo transactionsVo) {
        PageData<Transactions> data = new PageData<>();
        IPage<Transactions> transactionsIPage = transactionsMapper.selectPageRu(new Page<>(transactionsVo.getCurrent(), transactionsVo.getSize()), null);
        List<Transactions> records = transactionsIPage.getRecords();
        data.setTotalCount(transactionsIPage.getTotal());
        data.setList(records);
        return data;
    }

}
