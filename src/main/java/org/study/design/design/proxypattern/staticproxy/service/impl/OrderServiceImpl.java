package org.study.design.design.proxypattern.staticproxy.service.impl;

import org.study.design.design.proxypattern.staticproxy.bean.Order;
import org.study.design.design.proxypattern.staticproxy.dao.OrderDao;
import org.study.design.design.proxypattern.staticproxy.service.OrderService;

/**
 * @program: design
 * @description: 订单服务实现类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-21 16:08
 **/
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDao();
    }

    @Override
    public int creatOrder(Order order) {
        System.out.println("OrderServiceImpl 调用 creatOrder 方法成功");
        return orderDao.insert(order);
    }
}

