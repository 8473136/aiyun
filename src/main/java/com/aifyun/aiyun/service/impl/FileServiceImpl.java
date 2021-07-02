package com.aifyun.aiyun.service.impl;

import com.aifyun.aiyun.dto.FileDTO;
import com.aifyun.aiyun.dto.FolderDTO;
import com.aifyun.aiyun.dto.UserDTO;
import com.aifyun.aiyun.mapper.FileMapper;
import com.aifyun.aiyun.mapper.FolderMapper;
import com.aifyun.aiyun.service.FileService;
import com.aifyun.aiyun.service.FolderService;
import com.aifyun.aiyun.utils.TokenUtils;
import com.aifyun.aiyun.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author LiuchangLan
 * @date 2020/6/30 14:17
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileMapper fileMapper;

    @Autowired
    private HttpServletRequest request;

    @Resource
    private FolderService folderService;

    @Override
    public List<FileDTO> getRootFile() {
        String folderId = folderService.getRootFolder().getId();
        List<FileDTO> fileList = getFileList(folderId);
        return fileList;
    }

    @Override
    public List<FileDTO> getFileList(String folderId) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFolderId(folderId);
        fileDTO.setIsDeleteed(0);
        fileDTO.setUserId(TokenUtils.decryptByRequest(request).getId());
        return fileMapper.select(fileDTO);
    }

    @Override
    public Integer insertFile(FileDTO fileDTO){
        UserDTO userDTO = TokenUtils.decryptByRequest(request);
        fileDTO.setId(UUIDUtils.getUUID());
        fileDTO.setUserId(userDTO.getId());
        fileDTO.setCreatedBy(userDTO.getId());
        return fileMapper.insertSelective(fileDTO);
    }
}
