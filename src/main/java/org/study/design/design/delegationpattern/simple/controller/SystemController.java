package org.study.design.design.delegationpattern.simple.controller;

/**
 * @program: design
 * @description: 系统控制器
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-28 11:14
 **/
public class SystemController {

    // 具体的系统操作
    public void doSomethingInteresting(String type) {
        System.out.println("外面的入参我不管，我要做自己想做的事");
    }
}
