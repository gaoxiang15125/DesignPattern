package org.study.design.design.proxypattern.staticproxy.dao;

import org.study.design.design.proxypattern.staticproxy.bean.Order;

/**
 * @program: design
 * @description: 订单持久层实现类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-21 15:55
 **/
public class OrderDao {
    public int insert(Order order) {
        System.out.println("OrderDao 创建 Order 成功!");
        return 1;
    }
}
