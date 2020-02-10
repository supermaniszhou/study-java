package cn.cheng.sbsm.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 周刘成   2020-2-10
 */
@Service
public class SyncService {
    @Async
    public void sync() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中。。。。。");
    }
}
