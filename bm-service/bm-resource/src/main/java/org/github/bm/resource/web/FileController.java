package org.github.bm.resource.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/uploadFile")
    public String uploadFile() {
        return "success";
    }
}
