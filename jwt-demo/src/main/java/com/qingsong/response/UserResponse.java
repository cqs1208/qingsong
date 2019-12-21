package com.qingsong.response;

import lombok.Data;

/**
 * @author : chenqingsong
 * @date : 2019-09-19 17:00
 */
@Data
public class UserResponse {

    private String errorNum;
    private String errorMsg;
    private String userName;
    private Long userId;
    private String token;
}
