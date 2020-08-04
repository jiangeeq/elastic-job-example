package com.dangdang.ddframe.job.example.config;

import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author jiangpeng
 * @date 2020/7/2918:44
 */
public class MyJobExceptionHandler implements JobExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(MyJobExceptionHandler.class);
    @Override
    public void handleException(final String jobName, final Throwable cause) {
        log.error(String.format("Job '%s' jianglaoshi customer JobExceptionHandler", jobName), cause);
    }
}
