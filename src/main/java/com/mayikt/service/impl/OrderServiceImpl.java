package com.mayikt.service.impl;

import com.mayikt.ext.ExtAsync;

/**
 * @ClassName OrderServiceImpl
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class OrderServiceImpl implements OrderService {
    private OrderService orderServiceProxy;

    public String addOrder() {
        System.out.println(Thread.currentThread().getName() + ">>>流程1");
        //如果使用this.addOrderLog();不会走代理，走的是本类
        orderServiceProxy.addOrderLog();
        System.out.println(Thread.currentThread().getName() + ">>>流程3");
        return "addOrder";
    }

    @ExtAsync
    public void addOrderLog() {
        System.out.println(Thread.currentThread().getName() + ">>>流程2");
    }

    public void setOrderServiceProxy(OrderService orderServiceProxy) {
        this.orderServiceProxy = orderServiceProxy;
    }
}
