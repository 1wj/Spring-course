package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class buyGoodsServiceImpl implements BuyGoodsService {
    GoodsDao goodsDao;
    SaleDao saleDao;
    /**
     * rollbackFor:表示发生指定的异常一定回滚
     *  处理逻辑是：
     *    1）spring框架会首先检查抛出的异常是不是在rollbackFor的属性值中
     *       如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚。
     *    2）如果你抛出的异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException,
     *       如果是一定回滚
     */

   /* @Transactional(
            isolation = Isolation.DEFAULT,
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor =  {
                    NullPointerException.class,
                    NotEnoughException.class
            }
    )*/
    //这两个是一样的上面的是默认值 ，默认的传播行为是REQUIRED，默认的隔离级别是DEFAULT
    //默认抛出运行时异常，回滚事务、
    //一般放在公共方法之上 privat protace 不行 也可以放在类上但很少
    @Transactional
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
