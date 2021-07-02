package com.aifyun.aiyun.controller;

import com.aifyun.aiyun.dto.FolderDTO;
import com.aifyun.aiyun.service.FolderService;
import com.aifyun.aiyun.utils.UUIDUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuchangLan
 * @date 2020/7/9 10:44
 */
@RestController
@RequestMapping("folder")
public class FolderController {

    @Resource
    private FolderService folderService;

    @GetMapping("getChilderenFolder")
    public List<FolderDTO> getChilderenFolder(String parentId){
        return folderService.getChilderenFolder(parentId);
    }

    @GetMapping("getRootFolder")
    public FolderDTO getRootFolder(){
        return folderService.getRootFolder();
    }

    @GetMapping("getRootFolderList")
    public List<FolderDTO> getRootFolderList(){
        String id = folderService.getRootFolder().getId();
        return folderService.getChilderenFolder(id);
    }
}
