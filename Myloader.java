package org.mtl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author novy
 * @Date 2021/12/7 15:13
 * @Version 1.0
 */
public class Myloader extends ClassLoader{
    private static String testClassName = "";

    // 生成的字节码内容
    private static byte[] testClassBytes = new byte[]{};
    @Override
    public Class<?> findClass(String name){
        return defineClass(testClassBytes, 0, testClassBytes.length);
        // return super.findClass(name);
    }
    public static void main(String[] args){
        // 创建自定义的类加载器
        Myloader loader = new Myloader();
        try {
            // 使用自定义的类加载器
            Class testClass = loader.loadClass(testClassName);
            Object testInstance = testClass.newInstance();
//                String name = args[0];
            Method method = testInstance.getClass().getMethod("hello");
            method.invoke(testInstance);
            //  System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
