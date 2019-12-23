package com.qingsong.customAdvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author : chenqingsong
 * @date : 2019-12-22 14:25
 */
@Component
public class CustomAdviceConfig {
    @Autowired
   private ApplicationContext applicationContext;

    @PostConstruct
    public void initCustomAdviceChain () {
        new CustomAdviceChain ( applicationContext);
    }
}
