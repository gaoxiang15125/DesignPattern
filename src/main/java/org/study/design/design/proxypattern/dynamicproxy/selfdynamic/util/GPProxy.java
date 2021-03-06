//package org.study.design.design.proxypattern.dynamicproxy.selfdynamic.util;//package org.study.design.design.proxypattern.dynamicproxy.selfdynamic.util;
//
//import org.study.design.design.proxypattern.dynamicproxy.selfdynamic.GPInvocationHandler;
//
///**
// * @program: design
// * @description: 自定义代理模式工具类
// * @author: gaoxiang
// * @email: 630268696@qq.com
// * @create: 2020-11-22 17:05
// **/
//public class GPProxy {
//
//    public static final String NEW_LINE = System.lineSeparator();
//
//    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[]interfaces, GPInvocationHandler handler) {
//        // 定义代理模式接口 的目的是什么 ？？ 让人好奇
//        try {
//            String src = generateSt
//        }
//    }
//
//    private static String generateSrc(Class<?>[] interfaces, String className) {
//        // 使用 编码 编码，构造自己的 class 类 我认为可以直接从 被代理者 复制代码，毕竟代理者 与 被代理者 并行
//        // 作为练手的项目，使用较为简单类练手，避免太复杂搞不定
//        // 参考 JVM 生成的代理类，编写我的代理类
//        StringBuilder stringBuilder = new StringBuilder();
//        // 包路径不影响结果  |  传入的 interfaces 到底包含了哪些信息 ？
//        stringBuilder.append("package org.study.design.design.proxypattern.dynamicproxy.selfdynamic.util;"+NEW_LINE);
//        stringBuilder.append("import java.lang.reflect.*" + NEW_LINE);
//        stringBuilder.append("import org.study.design.design.proxypattern.dynamicproxy.selfdynamic.test.People;"+NEW_LINE);
//        stringBuilder.append("public final class " + className + " extends "+ interfaces[0].getName() +" implements People {");
//    }
//}
//
////import org.study.design.design.proxypattern.dynamicproxy.selfdynamic.GPInvocationHandler;
////
////import javax.tools.JavaCompiler;
////import javax.tools.StandardJavaFileManager;
////import javax.tools.ToolProvider;
////import java.io.File;
////import java.io.FileWriter;
////import java.lang.reflect.Constructor;
////import java.lang.reflect.Method;
////import java.util.HashMap;
////import java.util.Map;
////
////public class GPProxy {
////
////    public static final String ln = "\r\n";
////
////    public static Object newProxyInstance(GPClassLoader classLoader, Class<?> [] interfaces, GPInvocationHandler h){
////        try {
////            //1、动态生成源代码.java文件
////            String src = generateSrc(interfaces);
////
//////           System.out.println(src);
////            //2、Java文件输出磁盘
////            String filePath = GPProxy.class.getResource("").getPath();
//////           System.out.println(filePath);
////            File f = new File(filePath + "$Proxy0.java");
////            FileWriter fw = new FileWriter(f);
////            fw.write(src);
////            fw.flush();
////            fw.close();
////
////            //3、把生成的.java文件编译成.class文件
////            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
////            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
////            Iterable iterable = manage.getJavaFileObjects(f);
////
////            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
////            task.call();
////            manage.close();
////
////            //4、编译生成的.class文件加载到JVM中来
////            Class proxyClass =  classLoader.findClass("$Proxy0");
////            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
////            f.delete();
////
////            //5、返回字节码重组以后的新的代理对象
////            return c.newInstance(h);
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return null;
////    }
////
////    private static String generateSrc(Class<?>[] interfaces){
////        StringBuffer sb = new StringBuffer();
////        sb.append("package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy;" + ln);
////        sb.append("import com.gupaoedu.vip.pattern.proxy.Person;" + ln);
////        sb.append("import java.lang.reflect.*;" + ln);
////        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
////        sb.append("GPInvocationHandler h;" + ln);
////        sb.append("public $Proxy0(GPInvocationHandler h) { " + ln);
////        sb.append("this.h = h;");
////        sb.append("}" + ln);
////        for (Method m : interfaces[0].getMethods()){
////            Class<?>[] params = m.getParameterTypes();
////
////            StringBuffer paramNames = new StringBuffer();
////            StringBuffer paramValues = new StringBuffer();
////            StringBuffer paramClasses = new StringBuffer();
////
////            for (int i = 0; i < params.length; i++) {
////                Class clazz = params[i];
////                String type = clazz.getName();
////                String paramName = toLowerFirstCase(clazz.getSimpleName());
////                paramNames.append(type + " " +  paramName);
////                paramValues.append(paramName);
////                paramClasses.append(clazz.getName() + ".class");
////                if(i > 0 && i < params.length-1){
////                    paramNames.append(",");
////                    paramClasses.append(",");
////                    paramValues.append(",");
////                }
////            }
////
////            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
////            sb.append("try{" + ln);
////            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
////            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
////            sb.append("}catch(Error _ex) { }");
////            sb.append("catch(Throwable e){" + ln);
////            sb.append("throw new UndeclaredThrowableException(e);" + ln);
////            sb.append("}");
////            sb.append(getReturnEmptyCode(m.getReturnType()));
////            sb.append("}");
////        }
////        sb.append("}" + ln);
////        return sb.toString();
////    }
////
////
////    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
////    static {
////        mappings.put(int.class,Integer.class);
////    }
////
////    private static String getReturnEmptyCode(Class<?> returnClass){
////        if(mappings.containsKey(returnClass)){
////            return "return 0;";
////        }else if(returnClass == void.class){
////            return "";
////        }else {
////            return "return null;";
////        }
////    }
////
////    private static String getCaseCode(String code,Class<?> returnClass){
////        if(mappings.containsKey(returnClass)){
////            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
////        }
////        return code;
////    }
////
////    private static boolean hasReturnValue(Class<?> clazz){
////        return clazz != void.class;
////    }
////
////    private static String toLowerFirstCase(String src){
////        char [] chars = src.toCharArray();
////        chars[0] += 32;
////        return String.valueOf(chars);
////    }
////}