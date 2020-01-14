package cn.cheng.sbsm.progress;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * 周刘成   2020-1-14
 */

@Getter
@Setter
@Component
public class Progress {
    private long read;//到目前為止讀取到的比特數
    private long length;//文件總大小
    private long items;//目前正在读取第几个文件


    @Override
    public String toString() {
        return "Progress{" +
                "read=" + read +
                ", length=" + length +
                ", items=" + items +
                '}';
    }
}
