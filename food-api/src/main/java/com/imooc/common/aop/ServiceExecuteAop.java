package com.imooc.common.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/20.
 *
 * @author lihu
 * @date 2020/11/20
 */
@Aspect
@Component
@Log4j2
public class ServiceExecuteAop {

    /**
     * 切面表达式
     * execution 代表要执行的表达式主体
     * 从左到右看起
     * 第一处 * 代表的是返回类型 *表示所有的类型
     * 第二处 包名代表aop监控的类的所在的包
     * 第三处  ..代表该包以及其子包下的所有的类方法
     * 第四处  * 代表类名，*代表所有类
     * 第五处 *(..) *代表类中的方法名，(..)表示方法中的任何参数
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public Object executeTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - beginTime;
        if (executeTime > 3000) {
            log.error("方法{}#{}执行成功，耗时{}毫秒", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), executeTime);
        } else if (executeTime > 2000) {

            log.warn("方法{}#{}执行成功，耗时{}毫秒", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), executeTime);
        } else {
            log.info("方法{}#{}执行成功，耗时{}毫秒", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), executeTime);
        }

        return result;
    }

}
