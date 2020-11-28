package org.study.design.design.strategypattern.chosepayway.Impl;

import org.study.design.design.strategypattern.chosepayway.PromotionStrategy;

/**
 * @program: design
 * @description: 团购优惠策略
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 14:12
 **/
public class GroupBuyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("使用团购 优惠策略 计算优惠率");
    }
}
