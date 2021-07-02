package com.aifyun.aiyun.service.impl;

import com.aifyun.aiyun.dto.FolderDTO;
import com.aifyun.aiyun.dto.UserDTO;
import com.aifyun.aiyun.mapper.FolderMapper;
import com.aifyun.aiyun.service.FolderService;
import com.aifyun.aiyun.utils.TokenUtils;
import com.aifyun.aiyun.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LiuchangLan
 * @date 2020/7/9 10:35
 */
@Service
public class FolderServiceImpl implements FolderService {

    @Resource
    private FolderMapper folderMapper;

    @Resource
    private HttpServletRequest request;

    @Override
    public Integer insertFolder(FolderDTO folderDTO) {
        UserDTO userDTO = TokenUtils.decryptByRequest(request);
        folderDTO.setUserId(UUIDUtils.getUUID());
        folderDTO.setIsDeleteed(0);
        folderDTO.setUserId(userDTO.getId());
        folderDTO.setCreatedBy(userDTO.getId());
        folderDTO.setUpdatedBy(userDTO.getId());
        return folderMapper.insertSelective(folderDTO);
    }

    @Override
    public List<FolderDTO>  getChilderenFolder(String parentId){
        UserDTO userDTO = TokenUtils.decryptByRequest(request);
        FolderDTO folderDTO = new FolderDTO();
        folderDTO.setParentFolderId(parentId);
        folderDTO.setUserId(userDTO.getId());
        return folderMapper.select(folderDTO);
    }

    @Override
    public FolderDTO getRootFolder() {
        UserDTO userDTO = TokenUtils.decryptByRequest(request);
        FolderDTO folderDTO = new FolderDTO();
        folderDTO.setParentFolderId("-1");
        folderDTO.setUserId(userDTO.getId());
        return folderMapper.selectOne(folderDTO);
    }
}
