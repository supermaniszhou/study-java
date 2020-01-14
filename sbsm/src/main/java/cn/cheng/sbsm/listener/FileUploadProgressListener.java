package cn.cheng.sbsm.listener;

import cn.cheng.sbsm.progress.Progress;
import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 周刘成   2020-1-14
 */
@Component
public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        Progress progress = new Progress();
        session.setAttribute("status", progress);
    }

    @Override
    public void update(long read, long length, int items) {
        Progress progress = (Progress) session.getAttribute("status");
        progress.setRead(read);
        progress.setLength(length);
        progress.setItems(items);
    }
}
