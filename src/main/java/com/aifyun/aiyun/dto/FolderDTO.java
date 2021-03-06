package com.aifyun.aiyun.dto;

import com.aifyun.aiyun.core.BaseDTO;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author LiuchangLan
 * @date 2020/6/30 11:53
 */
@Data
@Table(name = "aiyun_folder")
public class FolderDTO extends BaseDTO {
    // 文件夹名称
    private String folderName;

    // 父文件夹
    private String parentFolderId;

    // 所属用户
    private String userId;
}
