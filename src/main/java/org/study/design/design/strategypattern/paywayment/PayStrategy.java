package org.study.design.design.strategypattern.paywayment;

import jdk.nashorn.internal.scripts.JD;
import org.study.design.design.strategypattern.paywayment.impl.AliPay;
import org.study.design.design.strategypattern.paywayment.impl.JDPay;
import org.study.design.design.strategypattern.paywayment.impl.UnionPay;
import org.study.design.design.strategypattern.paywayment.impl.WechatPay;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: design
 * @description: 支付策略实现类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 21:52
 **/
public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = "MyPay";

    private static Map<String,Payment> payStrategy = new HashMap<>();

    static {
        payStrategy.put(ALI_PAY, new AliPay());
        payStrategy.put(WECHAT_PAY, new WechatPay());
        payStrategy.put(UNION_PAY, new UnionPay());
        payStrategy.put(JD_PAY, new JDPay());
    }

    public static Payment get(String payKey) {
        if(!payStrategy.containsKey(payKey)) {
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }
}
