package org.study.design.design.proxypattern.dynamicproxy.selfdynamic;

import java.lang.reflect.Method;

/**
 * @program: design
 * @description: 自定义代理模式接口
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-22 17:00
 **/
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
