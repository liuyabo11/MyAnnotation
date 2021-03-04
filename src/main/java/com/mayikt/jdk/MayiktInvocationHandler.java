package com.mayikt.jdk;


import com.mayikt.ext.ExtAsync;
import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuyabo
 * @title MayiktInvocationHandler
 * @create 2021/3/4 15:38
 */
public class MayiktInvocationHandler implements InvocationHandler {
    private Object target;

    private ExecutorService executorService;

    public MayiktInvocationHandler(Object target) {
        this.target = target;
        this.executorService = Executors.newFixedThreadPool(10);
    }

    /**
     * @param proxy  代理类
     * @param method 接口方法 并不是真正的目标方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行开始");
        //通过回调拦截到我们的方法之后，然后做增强处理，比如自定义注解的实现

        //method是接口中的方法，获取的目标对象实现的接口方法上的注解
//        ExtAsync declaredAnnotation = method.getDeclaredAnnotation(ExtAsync.class);


        //获取到目标方法
        Method methodImpl = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        ExtAsync declaredAnnotation = methodImpl.getDeclaredAnnotation(ExtAsync.class);
        if (null == declaredAnnotation) {
            //说明方法上没有自定义注解
            System.out.println(method.getName() + "没有注解");
            Object result = method.invoke(target, args);
            return result;
        }

        //通过jdk动态代理回调，拦截到带有自定义注解的方法，然后新启线程执行目标方法
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    method.invoke(target, args);
                } catch (Exception e) {

                }
            }
        });


        /**
         * 使用线程池，执行完毕之后，线程不会停止
         * 不使用线程池会停止
         */


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    method.invoke(target, args);
//                } catch (Exception e) {
//
//                }
//            }
//        }).start();

        System.out.println("代理执行结束");
        return null;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
