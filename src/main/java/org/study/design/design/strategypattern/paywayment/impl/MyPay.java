package org.study.design.design.strategypattern.paywayment.impl;

import org.study.design.design.strategypattern.paywayment.Payment;

/**
 * @program: design
 * @description: 默认支付方式
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 21:37
 **/
public class MyPay extends Payment {
    @Override
    public String getName() {
        return "默认的支付方式";
    }

    @Override
    protected double queryBalance(String uid) {
        // 穷到吃土
        return 0;
    }
}
