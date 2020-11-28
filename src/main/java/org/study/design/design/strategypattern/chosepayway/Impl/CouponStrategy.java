package org.study.design.design.strategypattern.chosepayway.Impl;

import org.study.design.design.strategypattern.chosepayway.PromotionStrategy;

/**
 * @program: design
 * @description: 优惠券折扣策略类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 13:48
 **/
public class CouponStrategy implements PromotionStrategy {

    // 优惠券 折扣策略 实现类

    @Override
    public void doPromotion() {
        System.out.println("使用 优惠券 策略");
    }
}
