package org.github.bm.resource.util;

import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public final class LocalStorageUtil {
    public static String getRootPath(String bucketName) throws URISyntaxException {
        // 获取操作系统名
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("windows")) {
            // windows系统在项目所在盘根路径
            URL location = LocalStorageUtil.class.getProtectionDomain().getCodeSource().getLocation();
            // 转换为文件路径
            File file = new File(location.toURI());
            // 获取文件所在的绝对路径
            String filePath = file.getAbsolutePath();
            if (filePath.length() >= 2 && filePath.charAt(1) == ':') {
                // 获取判盘符
                String driveLetter = filePath.substring(0, 2);
                return driveLetter + StrUtil.SLASH + bucketName;
            } else {
                throw new RuntimeException("无法识别的盘符格式: " + filePath);
            }
        } else {
            return StrUtil.SLASH + bucketName;
        }
    }
}
