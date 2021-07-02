package com.aifyun.aiyun.service;

import com.aifyun.aiyun.dto.FileDTO;

import java.util.List;

public interface FileService {

    Integer insertFile(FileDTO fileDTO);

    List<FileDTO> getRootFile();

    List<FileDTO> getFileList(String folderId);

}
