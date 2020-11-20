package com.imooc.common.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * Created by lihu on 2019/12/24.
 * ServletRequestHandledEvent 的事件处理
 * 可以在这里做controller请求的耗时监控
 *
 * @author lihu
 * @date 2019/12/24
 */
@Component
@Log4j2
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent> {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        long totalTime = event.getProcessingTimeMillis();
        if (totalTime > 3000) {
            log.error("{} 请求处理完成，耗时{}毫秒", event.getRequestUrl(), totalTime);
        } else if (totalTime > 2000) {
            log.warn("{} 请求处理完成，耗时{}毫秒", event.getRequestUrl(), totalTime);
        } else {
            log.info("{} 请求处理完成，耗时{}毫秒", event.getRequestUrl(), totalTime);
        }
    }
}
