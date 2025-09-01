package org.github.bm.resource.feign.fallback;

import org.github.bm.resource.feign.IFileFeignClient;
import org.github.bm.resource.model.BMFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Time 2025-09-01 16:58
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class FileFeignClientFallback implements IFileFeignClient {
    /**
     * 上传文件
     *
     * @param file MultipartFile对象
     * @return BMFile
     */
    @Override
    public BMFile uploadFile(MultipartFile file) {
        return null;
    }

    /**
     * 上传文件
     *
     * @param fileBytes 文件字节数组
     * @param fileName  文件名
     * @return BMFile
     */
    @Override
    public BMFile uploadFile(byte[] fileBytes, String fileName) {
        return null;
    }
}
