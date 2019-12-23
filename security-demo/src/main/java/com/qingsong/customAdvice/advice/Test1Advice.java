package com.qingsong.customAdvice.advice;

import com.qingsong.customAdvice.CustomRequestBodyAdvice;
import com.qingsong.customAdvice.ICustomInterface;

/**
 * @author : chenqingsong
 * @date : 2019-12-22 14:33
 */
@ICustomInterface
public class Test1Advice implements CustomRequestBodyAdvice {
    @Override
    public void doSomeThink() {
        System.out.println("Test1Advice: test1 do...");
    }
}
