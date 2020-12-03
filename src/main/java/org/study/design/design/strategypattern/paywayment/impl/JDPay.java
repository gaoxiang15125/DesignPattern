package org.study.design.design.strategypattern.paywayment.impl;

import org.study.design.design.strategypattern.paywayment.Payment;

/**
 * @program: design
 * @description: 京东支付
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 21:37
 **/
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
