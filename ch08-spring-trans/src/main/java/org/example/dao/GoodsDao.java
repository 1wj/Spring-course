package org.example.dao;

import org.example.domain.Goods;

public interface GoodsDao {
    //更新(xx修改)库存
    //goods 表示本次用户购买的商品信息，id，购买数量
    int updateGoods(Goods goods);

    //（作用：更新完之后的查询显示一下）查询商品的信息
    Goods selectGoods(Integer id);
}
