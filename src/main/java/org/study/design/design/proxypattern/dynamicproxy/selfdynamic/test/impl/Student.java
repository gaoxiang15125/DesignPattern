package org.study.design.design.proxypattern.dynamicproxy.selfdynamic.test.impl;

import org.study.design.design.proxypattern.dynamicproxy.selfdynamic.test.People;

/**
 * @program: design
 * @description: 简单的功能方法，便于构造代理类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-23 20:25
 **/
public class Student implements People {

    @Override
    public void doSomethingRight() {
        System.out.println("真正的大师，都怀着一颗学徒的心");
    }
}
