package com.shop.config;

import com.shop.annos.DSAnno;
import com.shop.util.GetPrivateFieldUtil;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义注解 + AOP的方式实现数据源动态切换。
 */
@Aspect
@Component
public class AspectDynamicDS {

    private Logger logger = LoggerFactory.getLogger(AspectDynamicDS.class);

    @Before("@annotation(com.shop.annos.DSAnno)")
    public void beforeSwitchDS(JoinPoint point) {
        try {
            Object methodInvocation = GetPrivateFieldUtil.getPrivateField(point, "methodInvocation", point.getClass());
            Method method = (Method) GetPrivateFieldUtil.getPrivateField(methodInvocation, "method", methodInvocation.getClass());
            DSAnno annotation = method.getAnnotation(DSAnno.class);
            DataSourceContextHolder.setDB(annotation.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("当前数据源为" + DataSourceContextHolder.getDB());
    }

    @After("@annotation(com.shop.annos.DSAnno)")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDB();
    }
}
