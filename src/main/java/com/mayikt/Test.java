package com.mayikt;

import com.mayikt.jdk.MayiktInvocationHandler;
import com.mayikt.service.impl.OrderService;
import com.mayikt.service.impl.OrderServiceImpl;

/**
 * @author liuyabo
 * @title Test
 * @create 2021/3/4 15:47
 */
public class Test {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        MayiktInvocationHandler mayiktInvocationHandler = new MayiktInvocationHandler(orderService);
        OrderService proxy = mayiktInvocationHandler.getProxy();

        //将代理对象赋值给目标对象
        orderService.setOrderServiceProxy(proxy);

        String s = proxy.addOrder();
        System.out.println(s);

    }
}
