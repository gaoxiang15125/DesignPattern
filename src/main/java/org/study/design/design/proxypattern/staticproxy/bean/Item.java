package org.study.design.design.proxypattern.staticproxy.bean;

import lombok.Data;

/**
 * @program: design
 * @description: 子项
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-22 15:02
 **/
@Data
public class Item {
    private Object item;
    private String itemStr;
    private Integer itemID;
    private Long createTime;
}
