package com.qingsong.customAdvice;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.ControllerAdviceBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenqingsong
 * @date : 2019-12-22 14:23
 */
public class CustomAdviceChain {
    public static List<CustomRequestBodyAdvice> beans = new ArrayList<>();

    public CustomAdviceChain (ApplicationContext applicationContext){
        // 获取所有bean的全类名
        String[] var2 = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(applicationContext, Object.class);
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String name = var2[var4];
            //找到含有@ControllerAdvice注解的类
            if (applicationContext.findAnnotationOnBean(name, ICustomInterface.class) != null) {
                beans.add((CustomRequestBodyAdvice)applicationContext.getBean(name));
            }
        }
        System.out.println(beans.size());
    }
}
