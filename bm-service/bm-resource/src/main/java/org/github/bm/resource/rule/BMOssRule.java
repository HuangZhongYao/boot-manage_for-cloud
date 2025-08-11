
package org.github.bm.resource.rule;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.text.CharPool;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * 默认存储桶生成规则
 */
@AllArgsConstructor
public class BMOssRule implements OssRule {

    @Override
    public String bucketName(String bucketName) {
        return bucketName;
    }

    @Override
    public String fileName(String originalFilename) {
        LocalDateTime now = LocalDateTime.now();
        // 获取文件后缀
        String suffix = FileNameUtil.getSuffix(originalFilename);
        // 构建路径部分
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("upload").append(CharPool.SLASH)
                .append(now.getYear()).append(CharPool.SLASH)
                .append(now.getMonthValue()).append(CharPool.SLASH)
                .append(now.getDayOfMonth()).append(CharPool.SLASH)
                .append(System.currentTimeMillis());
        // 只有当存在后缀时才添加点和后缀
        if (StrUtil.isNotBlank(suffix)) {
            pathBuilder.append(CharPool.DOT).append(suffix);
        }
        return pathBuilder.toString();
    }

}
