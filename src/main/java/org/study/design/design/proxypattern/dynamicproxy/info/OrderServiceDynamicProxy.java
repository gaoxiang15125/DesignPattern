package org.study.design.design.proxypattern.dynamicproxy.info;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Data;
import org.study.design.design.proxypattern.dynamicproxy.selfdynamic.test.People;
import org.study.design.design.proxypattern.staticproxy.bean.Item;
import org.study.design.design.proxypattern.staticproxy.bean.Order;
import org.study.design.design.proxypattern.staticproxy.service.DynamicDataSourceEntry;
import org.study.design.design.proxypattern.staticproxy.service.OrderService;
import org.study.design.design.proxypattern.staticproxy.service.impl.OrderServiceImpl;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import sun.misc.ProxyGenerator;

/**
 * @program: design
 * @description: 订单服务动态代理
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-21 19:39
 **/
public class OrderServiceDynamicProxy implements InvocationHandler {

    private static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before(Object target) {
        try{
            System.out.println("Proxy after method.");
//            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
//            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
//            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】 数据源处理数据");
//            DynamicDataSourceEntry.set(dbRouter);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void after() {
        System.out.println("Proxy after method.");
    }

    public static void testProxy() {
        try{
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2018/02/01");
            order.setCreateTime(date.getTime());
            OrderService orderService = (OrderService) new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl());
            orderService.creatOrder(order);
            Item item = new Item();
            item.setCreateTime(date.getTime());
            orderService.creatTime(item);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将 JDK 生成的代码写入到指定路径文件内
     */
    public static void outputProxyClass() {
        try{
            OrderService orderService = (OrderService) new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl());
            // 测试 代理类是否可以正常执行功能
            Order order = new Order();
            Date date = sdf.parse("2018/02/01");
            order.setCreateTime(date.getTime());
            orderService.creatOrder(order);
            // 将对象转化为字节码 猜测如果对象中包含已赋值属性，也会一同转化并赋值
            byte[] bytes = ProxyGenerator.generateProxyClass("$Student", new Class[]{People.class});
            String filePath = OrderServiceDynamicProxy.class.getClassLoader().getResource("./").getPath();
            FileOutputStream os = new FileOutputStream(filePath + "$Student.class");
            os.write(bytes);
            os.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        outputProxyClass();
    }
}