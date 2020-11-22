package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy;
import com.gupaoedu.vip.pattern.proxy.Person;
import java.lang.reflect.*;
public class $Proxy0 implements org.study.design.design.proxypattern.staticproxy.service.OrderService{
GPInvocationHandler h;
public $Proxy0(GPInvocationHandler h) { 
this.h = h;}
public int creatOrder(org.study.design.design.proxypattern.staticproxy.bean.Order order) {
try{
Method m = org.study.design.design.proxypattern.staticproxy.service.OrderService.class.getMethod("creatOrder",new Class[]{org.study.design.design.proxypattern.staticproxy.bean.Order.class});
return ((java.lang.Integer)this.h.invoke(this,m,new Object[]{order})).intValue();
}catch(Error _ex) { }catch(Throwable e){
throw new UndeclaredThrowableException(e);
}return 0;}public int creatTime(org.study.design.design.proxypattern.staticproxy.bean.Item item) {
try{
Method m = org.study.design.design.proxypattern.staticproxy.service.OrderService.class.getMethod("creatTime",new Class[]{org.study.design.design.proxypattern.staticproxy.bean.Item.class});
return ((java.lang.Integer)this.h.invoke(this,m,new Object[]{item})).intValue();
}catch(Error _ex) { }catch(Throwable e){
throw new UndeclaredThrowableException(e);
}return 0;}}
