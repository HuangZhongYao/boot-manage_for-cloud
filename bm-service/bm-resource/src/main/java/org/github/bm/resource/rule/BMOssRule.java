
package org.github.bm.resource.rule;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.text.CharPool;
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
        return "upload" + CharPool.SLASH + now.getYear() + CharPool.SLASH + now.getMonthValue() + CharPool.SLASH + now.getDayOfMonth() + CharPool.SLASH + System.currentTimeMillis() + "." + FileNameUtil.getSuffix(originalFilename);
    }

}
