package org.study.design.design.strategypattern.paywayment;

import org.junit.jupiter.api.Test;
import org.study.design.design.strategypattern.paywayment.dto.PayOrder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: design
 * @description:
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 22:00
 **/
class PayStrategyTest {

    @Test
    void get() {
        PayOrder order = new PayOrder("630268696", "2020110225001122", 123.456);
        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }

    @Test
    void testCharSub() {
        char charOne = 'a';
        char charTwo = 'z';
        int distance = charTwo - charOne;
        System.out.println(distance);
    }
}