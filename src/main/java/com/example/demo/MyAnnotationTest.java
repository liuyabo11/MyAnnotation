package com.example.demo;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 自定义注解实现类
 */
@Aspect
@Component
public class MyAnnotationTest {

    @Pointcut("@annotation(com.example.demo.MyAnnotation)" )
    public void addAdvice(){}

    @Before("addAdvice()")
    public void Interceptor(JoinPoint joinPoint){
        System.out.println("====Interceptor====");
        System.out.println("通知之开始");
        Object retmsg=null;

        Signature signature = joinPoint.getSignature();
        System.out.println("signature信息为："+ JSON.toJSONString(signature));
        String s = joinPoint.getTarget().toString();
        System.out.println("s:"+s);
//        try {
//            retmsg = joinPoint.proceed();
//            System.err.println("++++++++"+retmsg);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
        System.out.println("通知之结束 +retmsg+" + retmsg);

        Object result = null;
//        return "xixi";
//        Object[] args = joinPoint.getArgs();
//        if (args != null && args.length > 0) {
//            String deviceId = (String) args[0];
//            if (!"03".equals(deviceId)) {
//                return "no anthorization";
//            }
//        }
//        try {
//            result = joinPoint.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
    }
//    @Before("addAdvice()")
//    public void before(JoinPoint joinPoint){
//        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
//        Method method = sign.getMethod();
//        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
//        System.out.println("打印：" + annotation.value() + " 开始前");
//        //System.out.println("===开始前===");
//    }
//
//    @After("addAdvice()")
//    public void after() {
//        System.out.println("after方法执行后");
//    }

}
