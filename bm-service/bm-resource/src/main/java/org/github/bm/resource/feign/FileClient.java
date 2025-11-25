package org.github.bm.resource.feign;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.resource.model.BMFile;
import org.github.bm.resource.service.IStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
@Hidden
@RestController
public class FileClient implements IFileClient {

    @Resource
    private IStorageService storageService;

    @Override

    @PostMapping(UPLOAD_FILE)
    public BMFile uploadFile(@RequestParam("file") MultipartFile file) {
        return storageService.putFile(file);
    }

    @Override
    @PostMapping(UPLOAD_FILE_STREAM)
    public BMFile uploadFile(@RequestBody byte[] fileBytes, @RequestParam("fileName") String fileName) {
        return storageService.putFile(fileName, new ByteArrayInputStream(fileBytes));
    }
}
