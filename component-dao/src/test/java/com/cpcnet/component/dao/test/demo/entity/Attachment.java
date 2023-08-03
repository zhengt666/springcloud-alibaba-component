package com.cpcnet.component.dao.test.demo.entity;

import java.time.LocalDateTime;
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
public class Attachment implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 附件ID
     */
    private String id;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件路径
     */
    private String url;

    /**
     * 文件大小
     */
    private String size;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 文件类型 1、Word 2、Excel 3、PDF 4、图片
     */
    private Integer type;

    /**
     * 附件排序号
     */
    private Integer sortIndex;

    @TableField("ATTACHMENT_TICKET_ASSOCIATED")
    private String attachmentTicketAssociated;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getAttachmentTicketAssociated() {
        return attachmentTicketAssociated;
    }

    public void setAttachmentTicketAssociated(String attachmentTicketAssociated) {
        this.attachmentTicketAssociated = attachmentTicketAssociated;
    }

    @Override
    public String toString() {
        return "Attachment{" +
        "id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", size=" + size +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", type=" + type +
        ", sortIndex=" + sortIndex +
        ", attachmentTicketAssociated=" + attachmentTicketAssociated +
        "}";
    }
}
