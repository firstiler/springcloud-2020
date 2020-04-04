package com.firstile.service.impl;

import cn.hutool.core.util.IdUtil;
import com.firstile.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public String getOk(Integer id) {

        return "线程池：" + Thread.currentThread().getName() + " getOk  id=" + id;
    }

    @Override
    // 开启服务降级（运行时异常、超时未返回）
    @HystrixCommand(fallbackMethod = "getTimeoutFallback", commandProperties = {
            // 超过3秒钟为执行完毕，自动调用降级方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String getTimeOut(Integer id) {
        long sleepSec = 5;
        try {
            TimeUnit.SECONDS.sleep(sleepSec);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " getTimeOut  id=" + id + "  耗时（秒）：" + sleepSec;
    }

    public String getTimeoutFallback(Integer id) {

        return "线程池：" + Thread.currentThread().getName() + " getTimeOut  id=" + id + " 系统开小差了";
    }

    @Override
    @HystrixCommand(fallbackMethod = "getCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String getCircuitBreaker(Integer id) throws Exception{
        if(id < 0){
            throw new Exception("负数老子不识别");
        }
        return "id=" + id + ",uuid=" + IdUtil.randomUUID();
    }

    public String getCircuitBreakerFallback(Integer id){
        return "报错了，服务降级了，id=" + id;
    }

}
