package com.cpcnet.component.config.context;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author jychen17
 * @version v1.0
 * @Description 用户信息上下文
 * @date 2021/11/18 10:21
 */

public class LoginUserInfoHolder {


    public static LoginUserInfo getCurrentUser() {
        //从Header中获取用户信息
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userId = request.getHeader("userId");
        String gid = request.getHeader("gid");
        String clientCode = request.getHeader("clientCode");
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUserId(userId);
        userInfo.setGid(gid);
        userInfo.setClientCode(clientCode);
        return userInfo;
    }
}
