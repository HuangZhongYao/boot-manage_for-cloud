package org.github.bm.resource.feign;

import org.github.bm.base.base.fegin.BaseFeign;
import org.github.bm.base.constant.AppConstant;
import org.github.bm.resource.feign.fallback.FileClientFallback;
import org.github.bm.resource.model.BMFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 对内部服务提供上传文件的接口
 */
@FeignClient(value = AppConstant.APPLICATION_RESOURCE_NAME, contextId = "fileFeignClient",fallback = FileClientFallback.class)
public interface IFileClient extends BaseFeign {
    String BASE_PREFIX = BASE_API_PREFIX + "/file";
    String UPLOAD_FILE = BASE_PREFIX + "/uploadFile";
    String UPLOAD_FILE_STREAM = BASE_PREFIX + "/uploadFileByte";

    /**
     * 上传文件
     *
     * @param file MultipartFile对象
     * @return BMFile
     */
    @PostMapping(value = UPLOAD_FILE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    BMFile uploadFile(@RequestPart("file") MultipartFile file);

    /**
     * 上传文件
     *
     * @param fileBytes 文件字节数组
     * @param fileName  文件名
     * @return BMFile
     */
    @PostMapping(UPLOAD_FILE_STREAM)
    BMFile uploadFile(@RequestBody byte[] fileBytes, @RequestParam("fileName") String fileName);
}
