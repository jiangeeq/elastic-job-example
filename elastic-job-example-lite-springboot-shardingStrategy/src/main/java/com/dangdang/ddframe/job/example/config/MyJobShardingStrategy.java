package com.dangdang.ddframe.job.example.config;

import com.dangdang.ddframe.job.lite.api.strategy.JobInstance;
import com.dangdang.ddframe.job.lite.api.strategy.JobShardingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangpeng
 * @date 2020/8/415:16
 */
public final class MyJobShardingStrategy implements JobShardingStrategy {
    private static final Logger log = LoggerFactory.getLogger(MyJobShardingStrategy.class);

    /**
     * 作业分片.
     *
     * @param jobInstances       所有参与分片的单元列表
     * @param jobName            作业名称
     * @param shardingTotalCount 分片总数
     * @return 分片结果
     */
    @Override
    public Map<JobInstance, List<Integer>> sharding(List<JobInstance> jobInstances, String jobName, int shardingTotalCount) {
        if (jobInstances.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<JobInstance, List<Integer>> result = new LinkedHashMap<>(shardingTotalCount, 1);

        for (JobInstance each : jobInstances) {
            if ("192.168.104.102".equals(each.getIp())) {
                List<Integer> shardingItems = new ArrayList<>(shardingTotalCount);
                for (int i = 0; i < shardingTotalCount; i++) {
                    log.info("给实例{}放入分片{}", each.getIp(), i);
                    shardingItems.add(i);
                }
                result.put(each, shardingItems);
            }
        }
        return result;
    }
}
