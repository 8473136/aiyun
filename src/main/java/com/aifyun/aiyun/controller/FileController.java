package com.aifyun.aiyun.controller;

import com.aifyun.aiyun.dto.FileDTO;
import com.aifyun.aiyun.service.FileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuchangLan
 * @date 2020/6/30 14:14
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("insertFile")
    public Integer insertFile(@RequestBody FileDTO fileDTO){
        return fileService.insertFile(fileDTO);
    }

    @GetMapping("getRootFile")
    public List<FileDTO> getRootFile(){
        return fileService.getRootFile();
    }
}
