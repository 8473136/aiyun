package com.aifyun.aiyun.service;

import com.aifyun.aiyun.dto.FolderDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FolderService{

    /**
     * @description 新增文件夹
     * @author LiuChangLan
     * @since 2020/7/9 10:40
     */
    Integer insertFolder(FolderDTO folderDTO);

    /**
     * @description 获取子目录
     * @author LiuChangLan
     * @since 2020/7/9 10:40
     */
    List<FolderDTO> getChilderenFolder(String parentId);

    /**
     * @description 获取当前用户的根目录
     * @author LiuChangLan
     * @since 2020/7/9 10:59
     */
    FolderDTO getRootFolder();
}
