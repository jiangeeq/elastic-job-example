package com.dangdang.ddframe.job.example.config;

import com.dangdang.ddframe.job.executor.handler.ExecutorServiceHandler;
import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;
import com.dangdang.ddframe.job.util.concurrent.ExecutorServiceObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;


/**
 * @author jiangpeng
 * @date 2020/7/2918:44
 */
public class MyExecutorServiceHandler implements ExecutorServiceHandler {
    private static final Logger log = LoggerFactory.getLogger(MyExecutorServiceHandler.class);

    @Override
    public ExecutorService createExecutorService(String jobName) {
        return new ExecutorServiceObject("jls-job-" + jobName, Runtime.getRuntime().availableProcessors() * 2).createExecutorService();
    }
}
