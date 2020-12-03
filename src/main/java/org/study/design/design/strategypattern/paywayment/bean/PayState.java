package org.study.design.design.strategypattern.paywayment.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: design
 * @description: 支付状态 相关信息 Bean
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 21:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public String toString() {
        return ("支付状态 [" + code + "], " + msg + ",交易详情: " + data);
    }
}
