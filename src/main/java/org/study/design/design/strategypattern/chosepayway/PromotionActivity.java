package org.study.design.design.strategypattern.chosepayway;

import com.sun.xml.internal.ws.util.StringUtils;
import org.study.design.design.strategypattern.chosepayway.Impl.CashBackStrategy;
import org.study.design.design.strategypattern.chosepayway.Impl.CouponStrategy;
import org.study.design.design.strategypattern.chosepayway.Impl.EmptyStartegy;

/**
 * @program: design
 * @description: 促销活动实现类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 14:17
 **/
public class PromotionActivity {
    // 看起来就是简单的使用了 接口 实现多态 仅此而已 呀 ？？
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    // 执行促销方法
    public void execute() {
        promotionStrategy.doPromotion();
    }

    // 策略模式优点在哪里 ？ 后面展示
    public static void simpleUsage() {
        PromotionActivity activity618 = new PromotionActivity(new CashBackStrategy());
        PromotionActivity huoShanActivity = new PromotionActivity(new CouponStrategy());
        activity618.execute();
        huoShanActivity.execute();

        /**
         * 简单的策略模式 缺点：
         * 不实际，每次的 优惠策略是固定的，没有动态选择
         */
    }

    // 初步优化，添加逻辑判断，可以在 不同策略模式间 切换
    public static void middleUsage(String promotionKey) {
        PromotionActivity promotionActivity = null;
        if(promotionKey.equals("COUPON")) {
            promotionActivity = new PromotionActivity(new CouponStrategy());
        } else if(promotionKey.equals("CASHBACK")) {
            promotionActivity = new PromotionActivity(new CashBackStrategy());
        } else if(promotionKey.equals("EMPTY")) {
            promotionActivity = new PromotionActivity(new EmptyStartegy());
        }
        promotionActivity.execute();
    }


}
