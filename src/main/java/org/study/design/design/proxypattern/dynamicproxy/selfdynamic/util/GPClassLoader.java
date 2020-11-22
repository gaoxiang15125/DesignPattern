package org.study.design.design.proxypattern.dynamicproxy.selfdynamic.util;

import java.io.File;
import java.io.FileInputStream;

/**
 * @program: design
 * @description: 代理模式类加载器
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-22 17:08
 **/
// 默认类加载器从JVM中加载，修改为从文件中加载
public class GPClassLoader extends ClassLoader{

    private File classPathFile;

    public GPClassLoader() {
        String classPath = GPClassLoader.class.getResource("").getPath();
        System.out.println("目标目录为：" + classPath);
        this.classPathFile = new File(classPath);
    }

    /**
     * 将 类 按照字节读出，并加载到 JVM 中
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        System.out.println("构造的 class 路径为:" + className);

        if(classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.","/") + ".class");
            if(classFile.exists()) {
                // 获取生成的类字节码
                byte[] classBytes = FileReader.readFile(classFile);
                if(classBytes == null) {
                    return null;
                }
                return defineClass(className, classBytes, 0, classBytes.length);
            }
        }
        return null;
    }

}
