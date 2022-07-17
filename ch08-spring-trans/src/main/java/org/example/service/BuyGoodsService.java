package org.example.service;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;

public interface BuyGoodsService {
    //购买商品的方法    goodsId:购买商品的编号，goodsNums：购买的数量
    void buy(Integer goodsId,Integer goodsNums);
}
