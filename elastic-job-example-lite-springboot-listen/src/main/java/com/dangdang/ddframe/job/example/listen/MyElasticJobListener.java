package com.dangdang.ddframe.job.example.listen;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 每台作业节点均执行的监听
 * 若作业处理作业服务器的文件，处理完成后删除文件，可考虑使用每个节点均执行清理任务。此类型任务实现简单，且无需考虑全局分布式任务是否完成，请尽量使用此类型监听器。
 * @author jiangpeng
 * @date 2020/8/417:37
 */
public class MyElasticJobListener implements ElasticJobListener {
    private static final Logger log = LoggerFactory.getLogger(MyElasticJobListener.class);
    /**
     * 作业执行前的执行的方法.
     *
     * @param shardingContexts 分片上下文
     */
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        log.info("beforeJobExecuted 作业执行前的执行的方法");
    }

    /**
     * 作业执行后的执行的方法.
     *
     * @param shardingContexts 分片上下文
     */
    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        log.info("afterJobExecuted 作业执行后的执行的方法");
    }
}
