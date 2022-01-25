package com.yan.spring.mvc;

import com.yan.mall.threadpool.annotation.EnableThreadPool;
import com.yan.mall.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by huyan on 2021/9/14.
 * TIME: 10:03
 * DESC:
 */
@Slf4j
@SpringBootApplication
//@EnableMallRedisson //Redisson
@EnableThreadPool //自定义线程池
@ComponentScan({
        "com.yan.spring.mvc",
       // "com.yan.mall.middleware.redis.aop",
        "com.yan.mall.middleware.flow"
})
@Import({SpringUtil.class})
public class MVCApplication {

    public static void main(String[] args) {
        SpringApplication.run(MVCApplication.class, args);
    }
}
