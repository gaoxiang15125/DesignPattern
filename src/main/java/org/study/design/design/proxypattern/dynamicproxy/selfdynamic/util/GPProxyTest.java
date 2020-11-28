//package org.study.design.design.proxypattern.dynamicproxy.selfdynamic.util;
//
//import com.sun.org.apache.xpath.internal.operations.Or;
//import org.study.design.design.proxypattern.staticproxy.bean.Order;
//import org.study.design.design.proxypattern.staticproxy.service.OrderService;
//import org.study.design.design.proxypattern.staticproxy.service.impl.OrderServiceImpl;
//
///**
// * @program: design
// * @description: 手写代理模式实例
// * @author: gaoxiang
// * @email: 630268696@qq.com
// * @create: 2020-11-22 18:47
// **/
//public class GPProxyTest {
//
//    public static void main(String[] args) {
//        try {
//
//            //JDK动态代理的实现原理
//            OrderService obj = (OrderService) new GPMeipo().getInstance(new OrderServiceImpl());
//            System.out.println(obj.getClass());
//            Order order = new Order();
//            obj.creatOrder(order);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//}
