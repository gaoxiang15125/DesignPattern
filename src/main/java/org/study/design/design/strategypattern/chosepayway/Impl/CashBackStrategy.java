package org.study.design.design.strategypattern.chosepayway.Impl;

import org.study.design.design.strategypattern.chosepayway.PromotionStrategy;

/**
 * @program: design
 * @description: 返现促销优惠策略实现类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 13:54
 **/
public class CashBackStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现促销 折扣策略实现");
    }
}
