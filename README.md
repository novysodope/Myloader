# Myloader
学习Classloader的产物，模拟cs shellcode加载

# 使用
先把恶意的类编译成class，然后使用MyToByte把class转成字节数组
```bash
java -jar MyToByte.jar class文件 > aaa.txt
```
将生成的内容复制到testClassBytes
![image](https://user-images.githubusercontent.com/45167857/144985105-dba15010-eed3-493c-86de-ff9736fe10e9.png)
将反射的方法改成自己对应的
![image](https://user-images.githubusercontent.com/45167857/144985204-40eee174-d873-4471-8489-792c1293c08b.png)
最后打包执行上线
![image](https://user-images.githubusercontent.com/45167857/144985434-18357f2b-f64f-4447-9aca-cc421fc84331.png)
