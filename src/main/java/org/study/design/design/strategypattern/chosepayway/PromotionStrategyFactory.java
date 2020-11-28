package org.study.design.design.strategypattern.chosepayway;

import org.study.design.design.strategypattern.chosepayway.Impl.CashBackStrategy;
import org.study.design.design.strategypattern.chosepayway.Impl.CouponStrategy;
import org.study.design.design.strategypattern.chosepayway.Impl.EmptyStartegy;
import org.study.design.design.strategypattern.chosepayway.Impl.GroupBuyStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: design
 * @description: 策略模式，工厂模式 + 单例模式
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 15:58
 **/
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK, new CashBackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY, new GroupBuyStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStartegy();

    private PromotionStrategyFactory() {}

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION:promotionStrategy;
    }

    private interface PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }

    // 一般情况下，传 Class 作为 工程类初始化的方式效果更好
    // 至少我是这样认为的
    public static void main(String[] args) {
        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }
}
