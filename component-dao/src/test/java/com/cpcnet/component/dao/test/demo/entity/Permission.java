package com.cpcnet.component.dao.test.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ebon Zheng
 * @since 2023-02-14
 */
@TableName("PERMISSION")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("PERMISSION_ID")
    private String permissionId;

    @TableField("PERMISSION_CODE")
    private String permissionCode;

    @TableField("PERMISSION_NAME")
    private String permissionName;

    @TableField("COMPONENT")
    private String component;

    @TableField("MODEL_NAME")
    private String modelName;

    @TableField("REMARK")
    private String remark;

    @TableField("SOURCE")
    private String source;


    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "permissionId=" + permissionId +
        ", permissionCode=" + permissionCode +
        ", permissionName=" + permissionName +
        ", component=" + component +
        ", modelName=" + modelName +
        ", remark=" + remark +
        ", source=" + source +
        "}";
    }
}
