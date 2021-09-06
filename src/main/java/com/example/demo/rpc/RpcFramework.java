package com.example.demo.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/8/17 15:02
 */
public class RpcFramework {

    public static void export(Object Service, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            try {
                // 反序列化
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                // 读取方法名
                String methodName = input.readLine();
                // 参数类型
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                // 参数
                Object[] arguments = (Object[]) input.readObject();
                // 找到方法
                Method method = Service.getClass().getMethod(methodName, parameterTypes);
                // 调用方法
                Object result = method.invoke(serverSocket, arguments);
                // 返回结果
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(result);
                input.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }

    }

    public static <T> T refer(Class<T> interfaceClass, String host, int port) throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // provider 的 ip 和端⼝
                    Socket socket = new Socket(host, port);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    // 传参类型
                    outputStream.writeObject(method.getParameterTypes());
                    // 方法名
                    outputStream.writeUTF(method.getName());
                    // 传参数值
                    outputStream.writeObject(args);
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    return inputStream.readObject();
                }
            });
    }

}
