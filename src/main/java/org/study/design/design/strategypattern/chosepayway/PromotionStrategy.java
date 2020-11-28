package org.study.design.design.strategypattern.chosepayway;

/**
 * @program: design
 * @description: 策略模式自定义接口
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 13:45
 **/
public interface PromotionStrategy {

    // 假设需要实现 不同的促销策略，调用下面方法
    void doPromotion();
}
