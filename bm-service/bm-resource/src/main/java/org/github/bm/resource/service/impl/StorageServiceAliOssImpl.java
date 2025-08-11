
package org.github.bm.resource.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyun.oss.model.PutObjectResult;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.github.bm.resource.config.OssProperties;
import org.github.bm.resource.model.BMFile;
import org.github.bm.resource.model.OssFile;
import org.github.bm.resource.rule.OssRule;
import org.github.bm.resource.service.StorageService;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *  对象存储阿里云OSS实现
 */
@AllArgsConstructor
public class StorageServiceAliOssImpl implements StorageService {
    private final OSSClient ossClient;
    private final OssProperties ossProperties;
    private final OssRule ossRule;

    @Override
    @SneakyThrows
    public void makeBucket(String bucketName) {
        if (!bucketExists(bucketName)) {
            ossClient.createBucket(getBucketName(bucketName));
        }
    }

    @Override
    @SneakyThrows
    public void removeBucket(String bucketName) {
        ossClient.deleteBucket(getBucketName(bucketName));
    }

    @Override
    @SneakyThrows
    public boolean bucketExists(String bucketName) {
        return ossClient.doesBucketExist(getBucketName(bucketName));
    }

    @Override
    @SneakyThrows
    public void copyFile(String bucketName, String fileName, String destBucketName) {
        ossClient.copyObject(getBucketName(bucketName), fileName, getBucketName(destBucketName), fileName);
    }

    @Override
    @SneakyThrows
    public void copyFile(String bucketName, String fileName, String destBucketName, String destFileName) {
        ossClient.copyObject(getBucketName(bucketName), fileName, getBucketName(destBucketName), destFileName);
    }

    @Override
    @SneakyThrows
    public OssFile statFile(String fileName) {
        return statFile(ossProperties.getBucketName(), fileName);
    }

    @Override
    @SneakyThrows
    public OssFile statFile(String bucketName, String fileName) {
        ObjectMetadata stat = ossClient.getObjectMetadata(getBucketName(bucketName), fileName);
        OssFile ossFile = new OssFile();
        ossFile.setName(fileName);
        ossFile.setLink(fileLink(ossFile.getName()));
        ossFile.setHash(stat.getContentMD5());
        ossFile.setLength(stat.getContentLength());
        ossFile.setPutTime(stat.getLastModified());
        ossFile.setContentType(stat.getContentType());
        return ossFile;
    }

    @Override
    @SneakyThrows
    public String filePath(String fileName) {
        return getOssHost().concat(StrUtil.SLASH).concat(fileName);
    }

    @Override
    @SneakyThrows
    public String filePath(String bucketName, String fileName) {
        return getOssHost(bucketName).concat(StrUtil.SLASH).concat(fileName);
    }

    @Override
    @SneakyThrows
    public String fileLink(String fileName) {
        return getOssHost().concat(StrUtil.SLASH).concat(fileName);
    }

    @Override
    @SneakyThrows
    public String fileLink(String bucketName, String fileName) {
        return getOssHost(bucketName).concat(StrUtil.SLASH).concat(fileName);
    }

    @Override
    @SneakyThrows
    public BMFile putFile(MultipartFile file) {
        return putFile(ossProperties.getBucketName(), file.getOriginalFilename(), file);
    }

    @Override
    @SneakyThrows
    public BMFile putFile(String fileName, MultipartFile file) {
        return putFile(ossProperties.getBucketName(), fileName, file);
    }

    @Override
    @SneakyThrows
    public BMFile putFile(String bucketName, String fileName, MultipartFile file) {
        return putFile(bucketName, fileName, file.getInputStream());
    }

    @Override
    @SneakyThrows
    public BMFile putFile(String fileName, InputStream stream) {
        return putFile(ossProperties.getBucketName(), fileName, stream);
    }

    @Override
    @SneakyThrows
    public BMFile putFile(String bucketName, String fileName, InputStream stream) {
        return put(bucketName, stream, fileName, false);
    }

    @SneakyThrows
    public BMFile put(String bucketName, InputStream stream, String key, boolean cover) {
        makeBucket(bucketName);
        String originalName = key;
        key = getFileName(key);
        // 覆盖上传
        if (cover) {
            ossClient.putObject(getBucketName(bucketName), key, stream);
        } else {
            PutObjectResult response = ossClient.putObject(getBucketName(bucketName), key, stream);
            int retry = 0;
            int retryCount = 5;
            while (StringUtils.isEmpty(response.getETag()) && retry < retryCount) {
                response = ossClient.putObject(getBucketName(bucketName), key, stream);
                retry++;
            }
        }
        BMFile file = new BMFile();
        file.setOriginalName(originalName);
        file.setName(key);
        file.setDomain(getOssHost(bucketName));
        file.setLink(fileLink(bucketName, key));
        return file;
    }

    @Override
    @SneakyThrows
    public void removeFile(String fileName) {
        ossClient.deleteObject(getBucketName(), fileName);
    }

    @Override
    @SneakyThrows
    public void removeFile(String bucketName, String fileName) {
        ossClient.deleteObject(getBucketName(bucketName), fileName);
    }

    @Override
    @SneakyThrows
    public void removeFiles(List<String> fileNames) {
        fileNames.forEach(this::removeFile);
    }

    @Override
    @SneakyThrows
    public void removeFiles(String bucketName, List<String> fileNames) {
        fileNames.forEach(fileName -> removeFile(getBucketName(bucketName), fileName));
    }

    /**
     * 根据规则生成存储桶名称规则
     *
     * @return String
     */
    private String getBucketName() {
        return getBucketName(ossProperties.getBucketName());
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

    /**
     * 根据规则生成文件名称规则
     *
     * @param originalFilename 原始文件名
     * @return string
     */
    private String getFileName(String originalFilename) {
        return ossRule.fileName(originalFilename);
    }


    public String getUploadToken(String bucketName, long expireTime) {
        String baseDir = "upload";

        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);

        PolicyConditions policyConds = new PolicyConditions();
        // 默认大小限制10M
        String contentLengthRange = ossProperties.getArgs().get("contentLengthRange");
        contentLengthRange = contentLengthRange == null ? "10485760" : contentLengthRange;
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, Long.parseLong(contentLengthRange));
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, baseDir);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        Map<String, String> respMap = new LinkedHashMap<>(16);
        respMap.put("accessid", ossProperties.getAccessKey());
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", baseDir);
        respMap.put("host", getOssHost(bucketName));
        respMap.put("expire", String.valueOf(expireEndTime / 1000));
        return JSON.toJSONString(respMap);
    }

    /**
     * 获取域名
     *
     * @param bucketName 存储桶名称
     * @return String
     */
    public String getOssHost(String bucketName) {
        String prefix = ossProperties.getEndpoint().contains("https://") ? "https://" : "http://";
        return prefix + getBucketName(bucketName) + StrUtil.DOT + ossProperties.getEndpoint().replaceFirst(prefix, StrUtil.EMPTY);
    }

    /**
     * 获取域名
     *
     * @return String
     */
    public String getOssHost() {
        return getOssHost(ossProperties.getBucketName());
    }

}
