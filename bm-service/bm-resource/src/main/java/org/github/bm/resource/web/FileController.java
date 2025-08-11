package org.github.bm.resource.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.resource.model.BMFile;
import org.github.bm.resource.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "文件接口")
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private StorageService storageService;

    @Operation(summary = "上传文件", description = "公用上传文件接口")
    @PostMapping("/uploadFile")
    public BMFile uploadFile(@RequestParam("file") MultipartFile file) {
        return storageService.putFile(file);
    }
}
