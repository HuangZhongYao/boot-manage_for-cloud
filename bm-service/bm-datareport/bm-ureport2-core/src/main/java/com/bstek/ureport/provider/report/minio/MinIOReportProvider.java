package com.bstek.ureport.provider.report.minio;

import com.bstek.ureport.provider.report.ReportFile;
import com.bstek.ureport.provider.report.ReportProvider;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.InputStream;
import java.util.List;

public class MinIOReportProvider implements ReportProvider, ApplicationContextAware {
    @Override
    public InputStream loadReport(String file) {
        return null;
    }

    @Override
    public void deleteReport(String file) {

    }

    @Override
    public List<ReportFile> getReportFiles() {
        return List.of();
    }

    @Override
    public void saveReport(String file, String content) {

    }

    @Override
    public String getName() {
        return "MinIO对象存储";
    }

    @Override
    public boolean disabled() {
        return false;
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
