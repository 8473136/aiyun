package com.aifyun.aiyun.dto;

import com.aifyun.aiyun.core.BaseDTO;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

/**
 * @author LiuchangLan
 * @date 2020/6/30 11:53
 */
@Data
public class FileDTO extends BaseDTO {
    // 文件大小 单位MB
    private Integer fileSize;

    // 所属文件夹
    private String folderId;

    // 原文件名
    private String sourceFileName;

    // 上传文件名
    private String uploadFileName;

    // 所属用户
    private String userId;
}
