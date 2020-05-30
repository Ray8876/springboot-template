package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerVo;
import com.example.demo.entity.PageData;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    private CustomerMapper customerMapper;

    /**
     * 客户信息表（分页）
     * @param customerVo
     * @return
     */
    @Override
    public PageData<Customer> pageList(CustomerVo customerVo) {
        PageData<Customer> data = new PageData<>();
        IPage<Customer> customerIPage = customerMapper.selectPage(new Page<>(customerVo.getCurrent(), customerVo.getSize()), null);
        List<Customer> records = customerIPage.getRecords();
        data.setTotalCount(customerIPage.getTotal());
        data.setList(records);
        return data;
    }
}
