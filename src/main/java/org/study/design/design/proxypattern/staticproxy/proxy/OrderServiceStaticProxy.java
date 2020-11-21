package org.study.design.design.proxypattern.staticproxy.proxy;

import org.study.design.design.proxypattern.staticproxy.bean.Order;
import org.study.design.design.proxypattern.staticproxy.service.DynamicDataSourceEntry;
import org.study.design.design.proxypattern.staticproxy.service.OrderService;
import org.study.design.design.proxypattern.staticproxy.service.impl.OrderServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: design
 * @description: 订单服务静态代理类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-21 16:33
 **/
public class OrderServiceStaticProxy implements OrderService {

    /**
     * 等于说有两个订单数据库操作类，一个封装了具体的数据库操作,
     * 另一个通过代理 修改数据库链接目标， 实现分库
      */
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private OrderService orderService;

    private OrderServiceStaticProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int creatOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理自动分配到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.creatOrder(order);
        after();
        return 0;
    }

    public void before() {
        System.out.println("通过代理进行表插入操作");
    }

    public void after() {
        System.out.println("代理表插入操作结束");
    }

    public static void main(String[] args) {
        try{
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            OrderService orderService = new OrderServiceStaticProxy(new OrderServiceImpl());
            orderService.creatOrder(order);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
