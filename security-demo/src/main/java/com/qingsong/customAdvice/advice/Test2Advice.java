package com.qingsong.customAdvice.advice;

import com.qingsong.customAdvice.CustomRequestBodyAdvice;
import com.qingsong.customAdvice.ICustomInterface;

/**
 * @author : chenqingsong
 * @date : 2019-12-22 14:35
 */
@ICustomInterface
public class Test2Advice implements CustomRequestBodyAdvice {

    @Override
    public void doSomeThink() {
        System.out.println("Test2Advice: test2 do...");
    }
}
