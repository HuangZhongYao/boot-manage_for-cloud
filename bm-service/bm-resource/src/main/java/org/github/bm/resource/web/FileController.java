package org.github.bm.resource.web;

import jakarta.annotation.Resource;
import org.github.bm.resource.model.BMFile;
import org.github.bm.resource.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private StorageService storageService;

    @PostMapping("/uploadFile")
    public BMFile uploadFile(@RequestParam("file") MultipartFile file) {
        BMFile bmFile = storageService.putFile(file);
        return bmFile;
    }
}
