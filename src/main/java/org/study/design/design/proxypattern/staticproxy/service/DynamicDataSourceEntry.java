package org.study.design.design.proxypattern.staticproxy.service;

/**
 * @program: design
 * @description: 动态修改数据库写入位置，实现分库操作
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-21 16:18
 **/
// 动态切换数据源
public class DynamicDataSourceEntry {

    // 默认数据源
    public final static String DEFAULT_SOURCE = "真正的分库分表也是这样做嘛？";

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry() {}

    // 清空数据源
    public static void clear() {
        local.remove();
    }

    // 获取当前正在使用的数据源名称
    public static String get() {
        return local.get();
    }

    // 还原当前切换的数据源
    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }

    // 设置已知名字的数据源
    public static void set(String source) {
        local.set(source);
    }

    // 根据年份动态设置数据源
    public static void set(int year) {
        local.set("DB_" + year);
    }
}
