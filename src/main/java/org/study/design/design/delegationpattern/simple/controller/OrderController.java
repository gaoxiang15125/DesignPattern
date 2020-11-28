package org.study.design.design.delegationpattern.simple.controller;

/**
 * @program: design
 * @description: 订单控制器
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 11:12
 **/
public class OrderController {

    // 定义三个不相关的 Controller 作为 被管理者
    public String getOrderIdByClientId(String clientId) {
        System.out.println("苦逼的 OrderController 被调用了");
        return "我命由我 不由天";
    }
}
