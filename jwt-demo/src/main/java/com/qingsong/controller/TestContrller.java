package com.qingsong.controller;

import com.qingsong.domain.User;
import com.qingsong.response.UserResponse;
import com.qingsong.util.Constants;
import com.qingsong.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author : chenqingsong
 * @date : 2019-09-19 16:45
 */
@RestController
public class TestContrller {

    //注册或登录 生成token
    @RequestMapping("/login")
    public UserResponse login(@RequestBody  User user){

        String username = user.getUsername();
        String password = user.getPassword();

        UserResponse userResponse = new UserResponse();
        User tUser = new User("admin", "admin");
        //检验username是否存在
        user.setLastLoginTime(new Date());
        if(tUser!=null){
            //检验密码是否正确
            if(!tUser.getPassword().equals(password)) {
                userResponse.setErrorNum(Constants.ERR_NUM_PWD_ERR);
                userResponse.setErrorMsg(Constants.ERR_MSG_PWD_ERR);
                return userResponse;
            }

        }else {
            try {
                //保存用户
            } catch (Exception e) {
                userResponse.setErrorNum(Constants.ERR_NUM_SERVER_ERR);
                userResponse.setErrorMsg(Constants.ERR_MSG_SERVER_ERR);
                return userResponse;
            }
        }
        userResponse.setErrorNum(Constants.ERR_NUM_OK);
        userResponse.setErrorMsg(Constants.ERR_MSG_OK);
        userResponse.setUserName(username);
        // 设置token
        userResponse.setToken(JwtUtil.generateToken(username,user.getLastLoginTime()));

        return userResponse;
    }

    @RequestMapping(value="/hello", method= RequestMethod.POST)
    public String  hello (@RequestBody User user) {
        // 解密token
        Map<String,Object> map = JwtUtil.validateToken(user.getToken());
        if(null != map.get("ERR_MSG")){
            return map.get("ERR_MSG").toString();
        }
        String userName = map.get("username").toString();

        return "userName: " + userName;
    }

}
