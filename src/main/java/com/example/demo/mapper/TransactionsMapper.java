package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.entity.Transactions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

/**
 * <p>
 * 出库入库表 Mapper 接口
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
public interface TransactionsMapper extends BaseMapper<Transactions> {

    @Select("SELECT tr.*,cu.customer_name,cl.cloth_name FROM db1.transactions tr LEFT JOIN db1.customer cu on tr.customer_id = cu.id LEFT JOIN db1.cloth cl ON cl.id = tr.cloth_id WHERE tr.state = -1")
    IPage<Transactions> selectPageChu(IPage<Transactions> page, @Param(Constants.WRAPPER) Wrapper<Transactions> queryWrapper);

    @Select("SELECT tr.*,cu.customer_name,cl.cloth_name FROM db1.transactions tr LEFT JOIN db1.customer cu on tr.customer_id = cu.id LEFT JOIN db1.cloth cl ON cl.id = tr.cloth_id WHERE tr.state = 1")
    IPage<Transactions> selectPageRu(IPage<Transactions> page, @Param(Constants.WRAPPER) Wrapper<Transactions> queryWrapper);
}
