package org.github.bm.resource.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.resource.config.StorageProperties;
import org.github.bm.resource.config.WebMvcStaticResourcesConfiguration;
import org.github.bm.resource.model.BMFile;
import org.github.bm.resource.model.OssFile;
import org.github.bm.resource.rule.OssRule;
import org.github.bm.resource.service.IStorageService;
import org.github.bm.resource.util.LocalStorageUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 本地存储实现
 */
@Slf4j
@AllArgsConstructor
public class StorageServiceLocalImpl implements IStorageService {
    private final StorageProperties storageProperties;
    private final OssRule ossRule;


    @SneakyThrows
    @Override
    public void makeBucket(String bucketName) {
        // 储桶目录
        FileUtil.mkdir(this.getBucketName());
    }

    @SneakyThrows
    @Override
    public void removeBucket(String bucketName) {
        // 储桶目录
        File bucketDir = new File(this.getBucketName());
        FileUtil.del(bucketDir);
    }

    @SneakyThrows
    @Override
    public boolean bucketExists(String bucketName) {
        return new File(this.getBucketName()).exists();
    }

    @Override
    public void copyFile(String bucketName, String fileName, String destBucketName) {

    }

    @Override
    public void copyFile(String bucketName, String fileName, String destBucketName, String destFileName) {

    }

    @Override
    public OssFile statFile(String fileName) {
        return null;
    }

    @Override
    public OssFile statFile(String bucketName, String fileName) {
        return null;
    }

    @Override
    public String filePath(String fileName) {
        return "";
    }

    @Override
    public String filePath(String bucketName, String fileName) {
        return "";
    }

    @Override
    public String fileLink(String fileName) {
        return fileLink(storageProperties.getBucketName(), fileName);
    }

    @SneakyThrows
    @Override
    public String fileLink(String bucketName, String fileName) {
        return storageProperties.getEndpoint() + StrUtil.SLASH + ServiceEnum.APPLICATION_RESOURCE.name + WebMvcStaticResourcesConfiguration.LOCAL_STORAGE_RESOURCE_PATH + fileName;
    }

    @Override
    public BMFile putFile(MultipartFile file) {
        return putFile(file.getOriginalFilename(), file);
    }

    @Override
    public BMFile putFile(String fileName, MultipartFile file) {
        return putFile(storageProperties.getBucketName(), fileName, file);
    }

    @SneakyThrows
    @Override
    public BMFile putFile(String bucketName, String fileName, MultipartFile file) {
        return putFile(bucketName, fileName, file.getInputStream());
    }

    @Override
    public BMFile putFile(String fileName, InputStream stream) {
        return putFile(storageProperties.getBucketName(), fileName, stream);
    }

    @SneakyThrows
    @Override
    public BMFile putFile(String bucketName, String fileName, InputStream stream) {
        String filePath = this.getFileName(fileName);
        // 写入本地文件
        FileUtil.writeFromStream(stream, this.getBucketName() + StrUtil.SLASH + filePath);
        BMFile file = new BMFile();
        file.setOriginalName(fileName);
        file.setName(filePath);
        file.setDomain(storageProperties.getEndpoint() + StrUtil.SLASH + ServiceEnum.APPLICATION_RESOURCE.name + WebMvcStaticResourcesConfiguration.LOCAL_STORAGE_RESOURCE_PATH);
        file.setLink(fileLink(filePath));
        return file;
    }

    @Override
    public void removeFile(String fileName) {

    }

    @Override
    public void removeFile(String bucketName, String fileName) {

    }

    @Override
    public void removeFiles(List<String> fileNames) {

    }

    @Override
    public void removeFiles(String bucketName, List<String> fileNames) {

    }

    /**
     * 根据规则生成存储桶名称规则
     *
     * @return String
     */
    private String getBucketName() throws URISyntaxException {
        String bucketName = getBucketName(storageProperties.getBucketName());
        return LocalStorageUtil.getRootPath(bucketName);
    }

    /**
     * 根据规则生成存储桶名称规则
     *
     * @param bucketName 存储桶名称
     * @return String
     */
    private String getBucketName(String bucketName) {
        return ossRule.bucketName(bucketName);
    }

    @SneakyThrows
    private String getFileName(String originalFilename) {
        return ossRule.fileName(originalFilename);
    }
}
