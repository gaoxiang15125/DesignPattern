package org.study.design.design.strategypattern.paywayment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.study.design.design.strategypattern.paywayment.PayStrategy;
import org.study.design.design.strategypattern.paywayment.Payment;
import org.study.design.design.strategypattern.paywayment.bean.PayState;

/**
 * @program: design
 * @description: 订单类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 21:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayOrder {
    private String uid;
    private String orderId;
    private double amount;

    public PayState pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public PayState pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额为：" + amount + ", 开始进行支付。。。");
        return payment.pay(uid, amount);
    }
}
