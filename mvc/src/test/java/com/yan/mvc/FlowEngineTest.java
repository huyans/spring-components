package com.yan.mvc;

import com.yan.mall.middleware.flow.*;
import com.yan.spring.mvc.MVCApplication;
import com.yan.spring.mvc.flower.FlowNodeOneInterface;
import com.yan.spring.mvc.flower.FlowNodeTwoInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * Created by huyan on 2022/1/4.
 * TIME: 15:59
 * DESC:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MVCApplication.class)
@Slf4j
public class FlowEngineTest {

    @Autowired
    private FlowEngine flowEngine;

    @Test
    public void test() {
        FlowNode flow = new FlowNode();
        //测试串行
        flow.add(FlowNodeOneInterface.class, new NodeConf());
        flow.add(FlowNodeTwoInterface.class, new NodeConf());

        //测试并行
        flow.add("three", FlowNodeOneInterface.class, new NodeConf());
        flow.add("three", FlowNodeTwoInterface.class, new NodeConf());

        RunData data = new RunData();
        data.setParamOne("NodeOne");
        data.setParamTwo("NodeTwo");

        Context context = new Context();

        //执行
        flowEngine.execute(flow, data, context);
        Map<String, Object> adaptorMap = context.getAdaptorMap();
        for (String key : adaptorMap.keySet()) {
            log.info("key=" + key + ", value=" + adaptorMap.get(key));
        }
    }
}
