package com.cpcnet.component.config.context;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jychen17
 * @version v1.0
 * @Description
 * @date 2021/11/18 10:23
 */
@Data
public class LoginUserInfo implements Serializable {

    private static final long serialVersionUID = 7951365520177084485L;

    private String userId;

    private String gid;

    private String clientCode;

}
