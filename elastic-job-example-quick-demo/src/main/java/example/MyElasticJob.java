package example;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangpeng
 * @date 2020/7/3012:14
 */
@Slf4j
public class MyElasticJob implements SimpleJob {
    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                log.info("0000");
                break;
            case 1:
                log.info("1111");
                break;
            case 2:
                log.info("2222");
                break;
        }
    }
}
