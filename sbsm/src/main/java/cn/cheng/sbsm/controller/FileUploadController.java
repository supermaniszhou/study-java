package cn.cheng.sbsm.controller;

import cn.cheng.sbsm.progress.Progress;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 周刘成   2020-1-13
 */
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController extends BaseController {

    @RequestMapping(value = "/toUpload")
    public ModelAndView toUpload() {
        //        不集成jsp使用这种方式
        ModelAndView modelAndView = new ModelAndView(VIEW_PATH + "fileupload/upload");
        modelAndView.addObject("msg", "Thymeleaf 第一个案例");
        modelAndView.addObject("key", new Date());
        modelAndView.addObject("kong", "");
        modelAndView.addObject("sex", "女");
        modelAndView.addObject("id","1");
        return modelAndView;
//        return new ModelAndView("html/fileupload/upload");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> fileUpload(@RequestParam("filename") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        try {
            System.out.println(file.getBytes().length);
            file.transferTo(new File("e:/" + file.getOriginalFilename()));
            map.put("msg", "ok");
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("msg", "error");
            return map;
        }

    }

    @RequestMapping(value = "/multiUpload", method = RequestMethod.POST)
    public Map<String, Object> multiFileUpload(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        List<MultipartFile> multipartFiles = ((MultipartHttpServletRequest) request).getFiles("file");
        BufferedOutputStream bos = null;
        String uploadPath = "D:" + File.separator + "uploads" + File.separator;
        result.put("fileLength", multipartFiles.size());
        for (int i = 0; i < multipartFiles.size(); i++) {

            String originFileName = multipartFiles.get(i).getOriginalFilename();
            validatePath(uploadPath);
            if (!multipartFiles.get(i).isEmpty()) {
                try {
                    byte[] bytes = multipartFiles.get(i).getBytes();
                    bos = new BufferedOutputStream(new FileOutputStream(new File(uploadPath, originFileName)));
                    bos.write(bytes);
                    result.put("file" + i, uploadPath + originFileName);
                    bos.close();
                } catch (IOException e) {
                    result.put("message", originFileName + "You failed to upload  => " + e.getMessage());
                }
            } else {
                result.put("message", originFileName + "You failed to upload  because the file was empty.");
            }
        }
        return null;
    }

    private void validatePath(String path) {
        Map<String, Object> result = new HashMap<>();
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @GetMapping(value = "/size")
    public Progress getProgress(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Progress progress = (Progress) session.getAttribute("status");
        return progress;
    }
}
