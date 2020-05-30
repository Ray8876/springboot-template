package com.example.demo.service;

import com.example.demo.entity.PageData;
import com.example.demo.entity.Transactions;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.TransactionsVo;

/**
 * <p>
 * 出库入库表 服务类
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
public interface ITransactionsService extends IService<Transactions> {

    /**
     * 查询订单列表（分页）
     * @param transactionsVo
     * @return
     */
    PageData<Transactions> pageListChu(TransactionsVo transactionsVo);
    PageData<Transactions> pageListRu(TransactionsVo transactionsVo);
}
