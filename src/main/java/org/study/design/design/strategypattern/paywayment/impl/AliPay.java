package org.study.design.design.strategypattern.paywayment.impl;

import org.study.design.design.strategypattern.paywayment.Payment;

/**
 * @program: design
 * @description: 支付宝支付
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 21:36
 **/
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 996;
    }
}
