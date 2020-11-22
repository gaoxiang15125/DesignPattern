package org.study.design.design.proxypattern.dynamicproxy.selfdynamic.util;

import java.io.*;

/**
 * @program: design
 * @description: 文件读取工具类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-22 17:20
 **/
public class FileReader {

    public static byte[] readFile(File file) {
        if(file.exists()) {
            FileInputStream in = null;
            // 可变长字节数组
            ByteArrayOutputStream outputStream = null;
            try{
                in = new FileInputStream(file);
                outputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                // 印象中有更优雅的写法，不过不深究了
                while((len = in.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, len);
                }
                return outputStream.toByteArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    if(in != null) {
                        in.close();
                    } 
                    if(outputStream != null) {
                        outputStream.close();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
