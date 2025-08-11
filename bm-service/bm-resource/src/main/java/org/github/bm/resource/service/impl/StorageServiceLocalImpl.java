package org.github.bm.resource.service.impl;

import lombok.AllArgsConstructor;
import org.github.bm.resource.config.OssProperties;
import org.github.bm.resource.model.BMFile;
import org.github.bm.resource.model.OssFile;
import org.github.bm.resource.rule.OssRule;
import org.github.bm.resource.service.StorageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * 本地存储实现
 */
@AllArgsConstructor
public class StorageServiceLocalImpl implements StorageService {
    private final OssProperties ossProperties;
    private final OssRule ossRule;

    @Override
    public void makeBucket(String bucketName) {

    }

    @Override
    public void removeBucket(String bucketName) {

    }

    @Override
    public boolean bucketExists(String bucketName) {
        return false;
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
        return "";
    }

    @Override
    public String fileLink(String bucketName, String fileName) {
        return "";
    }

    @Override
    public BMFile putFile(MultipartFile file) {
        return null;
    }

    @Override
    public BMFile putFile(String fileName, MultipartFile file) {
        return null;
    }

    @Override
    public BMFile putFile(String bucketName, String fileName, MultipartFile file) {
        return null;
    }

    @Override
    public BMFile putFile(String fileName, InputStream stream) {
        return null;
    }

    @Override
    public BMFile putFile(String bucketName, String fileName, InputStream stream) {
        return null;
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
}
