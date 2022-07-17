package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Transactional;

public class buyGoodsServiceImpl implements BuyGoodsService {
    GoodsDao goodsDao;
    SaleDao saleDao;
    @Override
    public void buy(Integer goodsId, Integer goodsNums) {
        //记录销售记录，向sale表添加记录
        System.out.println("===buy方法的开始");
        Sale sale=new Sale(goodsId,goodsNums);
        saleDao.insertSale(sale);


        //更新库存  (这段带码写中间是为了好验证事务回滚之类的 一般写在上面)
          //先查询一下库存
       Goods goods= goodsDao.selectGoods(goodsId);
        if(goods==null){
            //商品不存在
            throw new NullPointerException("商品id:"+goodsId+"的商品不存在");
        }else if (goods.getAmount()<goodsNums){
            //商品库存不足
            throw new NotEnoughException("商品id："+goodsId+"的商品库存不足");
        }



          //再更新库存
        Goods buyGoods=new Goods(goodsId,goodsNums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("===buy方法的完成");
    }





    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }
}
