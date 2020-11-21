package org.study.design.design.proxypattern.staticproxy.bean;

import lombok.Data;

/**
 * @program: design
 * @description: 静态模式 Order 订单类实现
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-21 15:49
 **/
@Data
public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;
}
