package com.aifyun.aiyun.core;

import com.aifyun.aiyun.utils.DateUtils;
import com.aifyun.aiyun.utils.UUIDUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author LiuchangLan
 * @date 2020/6/27 23:02
 */
@Data
public class BaseDTO {
    /**
     * 主键id
     */
    @Id
    private String id;
    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private String createdTime;
    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private String updatedTime;
    /**
     * 删除标识 0 正常 1删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleteed;
    /**
     * 创建人
     */
    @Column(name = "created_by")
    private String createdBy;
    /**
     * 创建时间
     */
    @Column(name = "updated_by")
    private String updatedBy;
}
