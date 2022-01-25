package com.yan.spring.mvc.flower;

import com.yan.mall.middleware.flow.Context;
import com.yan.mall.middleware.flow.FlowNodeInterface;
import com.yan.mall.middleware.flow.RunData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by huyan on 2022/1/4.
 * TIME: 15:54
 * DESC:
 */
@Slf4j
@Service("FlowNodeOneInterface")
public class FlowNodeOneInterface implements FlowNodeInterface<String> {

    @Override
    public String invokeNode(RunData data, Context context) {
        log.info("方法[" + data.getParamOne() + "]开始执行");
        return data.getParamOne();
    }

    @Override
    public void afterInvoke(RunData data, Context context) {
        log.info("方法[" + data.getParamOne() + "]执行完毕");
    }

    @Override
    public String resultKey() {
        return "NodeOne";
    }
}
