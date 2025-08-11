package org.github.bm.resource.web;

import jakarta.annotation.Resource;
import org.github.bm.resource.model.BMFile;
import org.github.bm.resource.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private StorageService storageService;

    @PostMapping("/uploadFile")
    public BMFile uploadFile() {
        BMFile bmFile = storageService.putFile(null);
        return bmFile;
    }
}
