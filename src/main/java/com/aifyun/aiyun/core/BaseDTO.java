package com.aifyun.aiyun.core;

import com.aifyun.aiyun.utils.DateUtils;
import com.aifyun.aiyun.utils.UUIDUtils;
import lombok.Data;

/**
 * @author LiuchangLan
 * @date 2020/6/27 23:02
 */
@Data
public class BaseDTO{
    /** 主键id*/
    private String id = UUIDUtils.getUUID();
    /** 创建时间*/
    private String createTime = DateUtils.currentTime();
    /** 修改时间*/
    private String updateTime = DateUtils.currentTime();
    /** 删除标识 0 正常 1删除*/
    private Integer isDeleteed = 0;

}
