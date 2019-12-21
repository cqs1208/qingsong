package com.qingsong.controller;

import com.qingsong.annotion.RsaSecurityParameter;
import com.qingsong.domain.Persion;
import org.springframework.web.bind.annotation.*;

/**
 * @author : chenqingsong
 * @date : 2019-12-21 15:07
 */
@RestController
public class TestController {

    @RequestMapping(value="/rsaTest", method= RequestMethod.POST)
    @ResponseBody
    @RsaSecurityParameter
    public Persion rsaTest(@RequestBody Persion info) {
        System.out.println(info.getName());
        String content = info.getName();
        info.setName(content);
        return  info;
    }
}
