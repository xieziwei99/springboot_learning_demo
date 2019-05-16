/**
 * @Description web层的日志切面
 * @author xieziwei99
 * @create 2019-05-16
 */
package com.xzw.aop_logging.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Order(5)
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    // web..* 表示当前包及其子包下所有类，.*(..)表示该类所有参数类型的方法
    @Pointcut("execution(public * com.xzw.aop_logging.web..*.*(..))")   // pointcut表达式
    public void webLog(){}      // pointcut签名


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL: ".concat(request.getRequestURL().toString()));
        logger.info("http_method: ".concat(request.getMethod()));
        logger.info("IP: ".concat(request.getRemoteAddr()));
        logger.info("class_function: ".concat(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()));
        logger.info("args: ".concat(Arrays.toString(joinPoint.getArgs())));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        logger.info("return: ".concat(ret.toString()));
        logger.info("spend_time: ".concat(Long.toString(System.currentTimeMillis() - startTime.get())).concat("ms"));
    }
}
