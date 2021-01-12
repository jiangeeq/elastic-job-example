package com.dangdang.ddframe.job.example.listen;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 分布式场景中仅单一节点执行的监听
 * 若作业处理数据库数据，处理完成后只需一个节点完成数据清理任务即可。此类型任务处理复杂，需同步分布式环境下作业的状态同步，提供了超时设置来避免作业不同步导致的死锁，请谨慎使用。
 * @author jiangpeng
 * @date 2020/8/417:42
 */
public class TestDistributeOnceElasticJobListener extends AbstractDistributeOnceElasticJobListener {
    private static final Logger log = LoggerFactory.getLogger(MyElasticJobListener.class);

    public TestDistributeOnceElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }


    /**
     * 分布式环境中最后一个作业执行前的执行的方法.
     *
     * @param shardingContexts 分片上下文
     */
    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        log.info("doBeforeJobExecutedAtLastStarted 分布式环境中最后一个作业执行前的执行的方法");
    }

    /**
     * 分布式环境中最后一个作业执行后的执行的方法.
     *
     * @param shardingContexts 分片上下文
     */
    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        log.info("doAfterJobExecutedAtLastCompleted 分布式环境中最后一个作业执行后的执行的方法");

    }
}
