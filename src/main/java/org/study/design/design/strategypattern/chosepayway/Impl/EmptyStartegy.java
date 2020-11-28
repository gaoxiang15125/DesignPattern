package org.study.design.design.strategypattern.chosepayway.Impl;

import org.study.design.design.strategypattern.chosepayway.PromotionStrategy;

/**
 * @program: design
 * @description: 没有优惠支付方案
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 14:13
 **/
public class EmptyStartegy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("不使用优惠策略 购买产品");
    }
}
