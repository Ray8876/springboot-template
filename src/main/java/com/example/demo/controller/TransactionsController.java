package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.IClothService;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ITransactionsService;
import com.example.demo.util.OutputUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 出库入库表 前端控制器
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Resource
    private ITransactionsService transactionsService;
    @Resource
    private IClothService clothService;
    @Resource
    private ICustomerService customerService;

    /**
     * 查询订单列表（分页）
     * @param transactionsVo
     * @return
     */
    @RequestMapping("/listChu")
    public Output<PageData<Transactions>> pageListChu(TransactionsVo transactionsVo){
        return OutputUtil.ok(transactionsService.pageListChu(transactionsVo));
    }

    @RequestMapping("/listRu")
    public Output<PageData<Transactions>> pageListRu(TransactionsVo transactionsVo){
        return OutputUtil.ok(transactionsService.pageListRu(transactionsVo));
    }

    /**
     * 添加或编辑订单详情
     * @param transactions
     * @return
     */
    @RequestMapping("/edit")
    public Output<String> edit(Transactions transactions){
        Cloth cloth = clothService.getById(transactions.getClothId());
        BigDecimal totalPrice = new BigDecimal(transactions.getLength()).multiply(cloth.getPrice());
        transactions.setTotalPrice(totalPrice);

        if(transactions.getState() == -1){
            if(transactions.getId() == null){
                Integer length_has = cloth.getClothLength();
                Integer length = transactions.getLength();

                if(length_has < length) return OutputUtil.fail(600,"库存不足");
                else {
                    cloth.setClothLength(length_has - length);
                    clothService.saveOrUpdate(cloth);
                }
            }
        }else{
            if(transactions.getId() == null){
                Integer length_has = cloth.getClothLength();
                Integer length = transactions.getLength();
                cloth.setClothLength(length_has + length);
                clothService.saveOrUpdate(cloth);
            }
        }

        transactionsService.saveOrUpdate(transactions);
        return OutputUtil.ok("");
    }

    @RequestMapping("/delete")
    public Output<String> delete(@RequestParam("id") Integer id){
        transactionsService.removeById(id);
        return OutputUtil.ok("");
    }

    @RequestMapping("/detail")
    public Output<Transactions> detail(@RequestParam("id") Integer id){
        Transactions transactions = transactionsService.getById(id);
        Cloth cloth = clothService.getById(transactions.getClothId());
        transactions.setClothName(cloth.getClothName());
        Customer customer = customerService.getById(transactions.getCustomerId());
        transactions.setCustomerName(customer.getCustomerName());
        return OutputUtil.ok(transactions);
    }
}
