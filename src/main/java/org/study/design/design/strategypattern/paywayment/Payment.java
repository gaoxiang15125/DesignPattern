package org.study.design.design.strategypattern.paywayment;

import org.study.design.design.strategypattern.paywayment.bean.PayState;

/**
 * @program: design
 * @description: 支付接口相关抽象类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 21:26
 **/
public abstract class Payment {

    // 支付类型
    public abstract String getName();

    // 查询余额 不同的支付方式 有不同的查询方式
    protected abstract double queryBalance(String uid);

    // 扣款支付,定义通用的 支付方法
    public PayState pay(String uid, double amount) {
        if(queryBalance(uid) < amount) {
            return new PayState(500, "支付失败", "余额不足");
        }
        return new PayState(200, "支付成功", "支付金额：" + amount);
    }
}
